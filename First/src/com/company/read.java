package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class read {
    int i, step, time_dinner, time_buffet, time_all;
    //массивы очередей по каждому заведению
    ArrayList<Integer> dinner1 = new ArrayList();
    ArrayList<Integer> dinner2 = new ArrayList();
    ArrayList<Integer> buffet1 = new ArrayList();
    ArrayList<Integer> buffet2 = new ArrayList();
    ArrayList<Integer> buffet3 = new ArrayList();
    public void Scan(){

        Scanner scn = new Scanner(System.in);
        System.out.println("Введите время задержки перед возникновением очередного голодного студента, мин: ");
        step = scn.nextInt();
        System.out.println("Введите время обслуживания в столовой, мин: ");
        time_dinner = scn.nextInt();
        System.out.println("Введите время обслуживания в буфете, мин: ");
        time_buffet = scn.nextInt();
        System.out.println("Введите время, по истечении которого нужно выдать результат, мин: ");
        time_all = scn.nextInt();
        if (step <= 0 || time_dinner <= 0 || time_buffet <= 0 || time_all <= 0){
            System.out.println("Введите данные в правильном диапазоне! Время должно быть больше 0");
            System.exit(0);
        }
    }

    public void Print(int ist1, int ist2, int ibuf1, int ibuf2, int ibuf3, ArrayList<Integer> dinner1, ArrayList<Integer> dinner2, ArrayList<Integer> buffet1, ArrayList<Integer> buffet2, ArrayList<Integer> buffet3){
        System.out.println(
         "Столовая 1: обслужено " + ist1 + " клиентов, осталось в очереди " + dinner1.size() + " человек" + "\n"+
         "Столовая 2: обслужено " + ist2 + " клиентов, осталось в очереди " + dinner2.size() + " человек" + "\n"+
         "Буфет 1: обслужено " + ibuf1 + " клиентов, осталось в очереди " + buffet1.size() + " человек" + "\n"+
         "Буфет 2: обслужено " + ibuf2 + " клиентов, осталось в очереди " + buffet2.size() + " человек" + "\n"+
         "Буфет 3: обслужено " + ibuf3 + " клиентов, осталось в очереди " + buffet3.size() + " человек");
    }
}
