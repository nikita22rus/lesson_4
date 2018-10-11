package Massiv;
public class Main {

    public static void main(String[] args) {
        Massive mas = new Massive(5);

        mas.setEl(1, 0);
        mas.setEl(2, 1);
        mas.setEl(3, 2);
        mas.setEl(4, 3);
        mas.setEl(5, 4);



        Massive mass = new Massive(5);

        mass.setEl(5, 0);
        mass.setEl(4, 1);
        mass.setEl(3, 2);
        mass.setEl(2, 3);
        mass.setEl(1, 4);



        mass.sum(mas);


    }




}