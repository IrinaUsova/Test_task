package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        //ввод данных
        read r = new read();
        r.Scan();

        //счетчик обслужившихся людей
        int[] counter_of_serviced = new int[5];
        for (int i = 0; i < 5; i++) counter_of_serviced[i] = 0;

        //получаем общее количество обслуженных студентов
        counter_of_serviced = get_total_number_of_serviced(counter_of_serviced, r.time_all, r.time_dinner, r.time_buffet, r.dinner1, r.dinner2, r.buffet1, r.buffet2, r.buffet3, r.step);

        //вывод данных
        r.Print(counter_of_serviced[0], counter_of_serviced[1], counter_of_serviced[2], counter_of_serviced[3], counter_of_serviced[4], r.dinner1, r.dinner2, r.buffet1, r.buffet2, r.buffet3);
        }

        //моделирование процесса обслуживания студентов в отдельной столовой или буфете
        public static int modeling_queue ( int old_length_queue, ArrayList<Integer > current_queue,int service_time, int i, int number_of_serviced){

            //вычисление время выхода из очереди очередного студента
            if (old_length_queue == 0 && current_queue.size() > old_length_queue) {
                current_queue.set(current_queue.size() - 1, current_queue.get(current_queue.size() - 1) + service_time);
            } else {
                if (current_queue.size() > old_length_queue) {
                    current_queue.set(current_queue.size() - 1, current_queue.get(current_queue.size() - 2) + service_time);
                }
            }
            //удаление студента, которого обслужили
            if (current_queue.size() > 0) {
                if (i >= current_queue.get(0)) {
                    current_queue.remove(0);
                    number_of_serviced += 1;
                }
            }
            return number_of_serviced;
        }

        //получение общего количество обслуженных студентов
        public static int[] get_total_number_of_serviced (int[] counter, int time_all, int time_dinner, int time_buffet, ArrayList<Integer > dinner1, ArrayList < Integer > dinner2, ArrayList < Integer > buffet1, ArrayList < Integer > buffet2, ArrayList < Integer > buffet3,
        int step){

            int i = 0;
            while (i <= time_all) {
                int old_len_dinner1 = dinner1.size();
                int old_len_dinner2 = dinner2.size();
                int old_len_buffet1 = buffet1.size();
                int old_len_buffet2 = buffet2.size();
                int old_len_buffet3 = buffet3.size();
                // нахождение наименьшей очереди
                List<ArrayList> L1 = new ArrayList<>() {
                    { add(dinner1); add(dinner2); add(buffet1); add(buffet2); add(buffet3); }
                };
                L1.sort(Comparator.comparing(ArrayList::size));
                //добавление студента в наименьшую очередь
                L1.get(0).add(i);

                //получение количества обслужившихся студентов по каждому заведению
                counter[0] = modeling_queue(old_len_dinner1, dinner1, time_dinner, i, counter[0]);
                counter[1] = modeling_queue(old_len_dinner2, dinner2, time_dinner, i, counter[1]);
                counter[2] = modeling_queue(old_len_buffet1, buffet1, time_buffet, i, counter[2]);
                counter[3] = modeling_queue(old_len_buffet2, buffet2, time_buffet, i, counter[3]);
                counter[4] = modeling_queue(old_len_buffet3, buffet3, time_buffet, i, counter[4]);
                i += step;
            }
            return counter;
        }


}