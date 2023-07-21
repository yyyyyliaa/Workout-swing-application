package model;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;



public class TrainingDay implements Comparable {
    private final String dayMonth;
    private Integer weight;
    private final String workoutType;
    private final Vector<Vector<String>> data = new Vector<>();
    private final String[] results;




    public TrainingDay(String d, String[] res, String workoutType, Object[] exercise){
        if(correctTrainingDay(d, res, workoutType, exercise)) {
            Vector<String> columnsHeader = new Vector<>(Arrays.asList("Exercise", "Number of sets/reps", "Weight, kg"));
            dayMonth = d;
            results = res;
            this.workoutType = workoutType;
            data.add(columnsHeader);


            for (int i = 0; i < res.length; i++) {
                String[] tmp = res[i].split(" ");
                if (i == 0) weight = Integer.parseInt(tmp[1]);

                Vector<String> row = new Vector<String>();
                row.add((String) exercise[i]);
                row.add(tmp[0]);
                row.add(tmp[1]);

                data.add(row);
            }
        } else throw new RuntimeException("Incorrect data");
    }

    public static boolean correctTrainingDay(String d, String[] res, String workoutType, Object[] exercise){
        return Trainings.checkDataFormat(d) && Trainings.checkCorrectResults(res);
    }

    public Vector<Vector<String>> getData(){
        return data;
    }

    public String getDayMonth() {
        return dayMonth;
    }

    public Integer getWeight() {return weight;}

    public String getWorkoutType(){ return workoutType;}

    public String[] getResults(){ return results;}

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(dayMonth).append("%").append(workoutType).append("%");
        sb.append(Arrays.toString(results)).append("&");

        return sb.toString();
    }

    @Override
    public int compareTo(Object o) {
        TrainingDay trd = (TrainingDay) o;

        String[] tokens1 = dayMonth.split("/");
        int thisDay = Integer.parseInt(tokens1[0]);
        int thisMonth = Integer.parseInt(tokens1[1]);

        String[] tokens2 = trd.getDayMonth().split("/");
        int day = Integer.parseInt(tokens2[0]);
        int month = Integer.parseInt(tokens2[1]);

        if(thisDay==day && thisMonth==month) return 0;
        else if(thisMonth==month) return thisDay-day;
        else return thisMonth-month;
    }
}
