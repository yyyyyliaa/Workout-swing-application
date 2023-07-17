package data;

import java.util.Arrays;
import java.util.List;

public class TrainingDay { //TODO: Добавить хранение вида тренировок и выполненных упражнений
                            //TODO: Добавить считывание/запись в файл
    private Integer day;
    private Integer month;

    private String workoutType;
    private Integer[] weights;
    private List<String> results;


    public TrainingDay(String data){
        String[] tokens = data.split("/");
        day = Integer.parseInt(tokens[0]);
        month = Integer.parseInt(tokens[1]);
    }

    public TrainingDay(Integer d, Integer m, String type, Integer[] w, List<String> res){
        day = d;
        month = m;
        workoutType = type;
        weights = w;
        results = res;
    }
    public TrainingDay(Integer d, Integer m){
        day = d;
        month = m;
    }


    public Integer getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }
    

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }

    public Integer[] getWeights() {
        return weights;
    }

    public void setWeights(Integer[] weights) {
        this.weights = weights;
    }
}
