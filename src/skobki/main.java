package skobki;

public class main {
    public static void main(String[] args){
        String [] a={"(",")","(","(",")"};
        System.out.println(correctness(a));
    }

    public static boolean correctness(String [] arr){
        int sum = 0;
        for (int i=0; i<arr.length; i++){
            if (arr[i].equals("(")){
                sum++;
            }
            else{
                sum--;
            }
            if (sum<0){
                return  false;
            }
        }
        if (sum!=0){
            return false;
        }
        return true;
    }
}
