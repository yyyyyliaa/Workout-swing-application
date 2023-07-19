package data;

import java.util.Arrays;
import java.util.Vector;



public class TrainingDay {
    private String dayMonth;
    private Integer weight; //для построения графика
    private String workoutType;
    private  Vector<Vector<String>> data = new Vector<>();
    private String[] results;


    public TrainingDay(String d, String[] res, String workoutType, Object[] exercise){
        Vector<String> columnsHeader = new Vector<>(Arrays.asList("Exercise", "Number of sets/reps", "Weight, kg"));
        dayMonth = d;
        results = res;
        this.workoutType = workoutType;
        data.add(columnsHeader);


        for(int i = 0; i<res.length; i++){
            String[] tmp = res[i].split(" ");
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

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(dayMonth).append("%").append(workoutType).append("%");
        sb.append(Arrays.toString(results)).append("&");

        return sb.toString();
    }
}
