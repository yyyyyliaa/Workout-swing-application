package data;

import java.util.Arrays;
import java.util.List;

public class TrainingDay { //TODO: Добавить хранение вида тренировок и выполненных упражнений
                            //TODO: Добавить считывание/запись в файл
    private Integer day;
    private Integer month;

    private String workoutType;
    private Integer weight;
    private List<String> results;


    public TrainingDay(Integer d, Integer m, String type, Integer w, List<String> res){
        day = d;
        month = m;
        workoutType = type;
        weight = w;
        results = res;
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }
}
