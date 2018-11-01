import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ReadCurrency {

    private String filePath;

    private int dollar;
    private int rub;
    private int euro;

    public static final String API_KEY = "5XPwGVnlanL7m4LKAnMNTJdptuKVyK8Q";


    ReadCurrency(String filePath) {
        this.filePath = filePath;
    }

    public void readCurrency() {
        FileReader file = null;
        BufferedReader bf = null;
        try {
            file = new FileReader(this.filePath);
            bf = new BufferedReader(file);

            String[] line = bf.readLine().trim().split(",");
            this.dollar = Integer.parseInt(line[0]);
            this.rub = Integer.parseInt(line[1]);
            this.euro = Integer.parseInt(line[2]);

        } catch (Exception e) {
            String url = "https://forex.1forge.com/1.0.3/quotes?pairs=USDEUR,USDRUB,AUDUSD&api_key=" + API_KEY;

            try {
                URL obj = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

                connection.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JsonParser parser = new JsonParser();
                JsonElement tradeElement = parser.parse(response.toString());
                JsonArray trade = tradeElement.getAsJsonArray();

                System.out.println("das");
                System.out.println(trade.get(0).getAsJsonObject().get("bid"));

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (bf != null) {
                    bf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int getDollar() {
        return dollar;
    }

    public int getRub() {
        return rub;
    }

    public int getEuro() {
        return euro;
    }
}
