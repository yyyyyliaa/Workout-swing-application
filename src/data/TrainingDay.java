package data;

import java.util.Arrays;
import java.util.Vector;



public class TrainingDay { //TODO: Добавить хранение вида тренировок и выполненных упражнений
                            //TODO: Добавить считывание/запись в файл
    private String dayMonth;
    private Integer weight; //для построения графика
    private final Vector<Vector<String>> data = new Vector<>();


    public TrainingDay(String d, String[] res, String workoutType, Object[] exercise){
        Vector<String> columnsHeader = new Vector<>(Arrays.asList("Exercise", "Number of sets/reps", "Weight, kg"));
        dayMonth = d;
//
//        String[] tokens = d.split("/");
//        day = Integer.parseInt(tokens[0]);
//        month = Integer.parseInt(tokens[1]);

        data.add(columnsHeader);


        for(int i = 0; i<res.length; i++){
            String[] tmp = res[i].split(", ");
            if(i==0) weight = Integer.parseInt(tmp[1]);

            Vector<String> row = new Vector<String>();
            row.add((String)exercise[i]);
            row.add(tmp[0]);
            row.add(tmp[1]);

            data.add(row);
        }
    }

    public Vector<Vector<String>> getData(){
        return data;
    }

    public String getDayMonth() {
        return dayMonth;
    }

    public Integer getWeight() {return weight;}
}
