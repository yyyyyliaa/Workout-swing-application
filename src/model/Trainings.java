package model;

import io.DataProcessing;
import io.Exercise;
import view.TextFieldWindow;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Trainings {
    private final HashSet<TrainingDay> trDays = new HashSet<>();
    private final HashSet<String> days = new HashSet<>();


    public boolean addTrainingDay(TrainingDay trd){
        if(trd==null) return false;
        int d, m;
        String data = trd.getDayMonth();

        if(data.length()<5) { return false; }
        else{
            if(data.charAt(2) == '/'){
                String[] tokens = data.split("/");
                d = Integer.parseInt(tokens[0]);
                m = Integer.parseInt(tokens[1]);
            } else return false;

            if(checkDataFormat(d, m)){

                String[] res = trd.getResults();

                for(String s : res){
                    if (s==null || !checkCorrectResults(s)){
                        return false;
                    }
                }

                trDays.add(trd);
                days.add(trd.getDayMonth());
                return true;

            } else return false;
        }
    }

    public boolean addTrainingDay(String data){
        int d, m;

        if(data.length()<5) return false;
        else{
            if(data.charAt(2) == '/'){
                String[] tokens = data.split("/");
                d = Integer.parseInt(tokens[0]);
                m = Integer.parseInt(tokens[1]);
            } else return false;

            if(checkDataFormat(d, m)){

                String getWorkoutType = DataProcessing.inputWorkoutType();

                TextFieldWindow textFieldWindow = new TextFieldWindow(Exercise.getExercise(getWorkoutType));

                String[] res = textFieldWindow.getResults();

                for(String s : res)
                    if (s==null || !checkCorrectResults(s)) return false;


                TrainingDay trd = new TrainingDay(data, res, getWorkoutType, Exercise.getExercise(getWorkoutType));
                trDays.add(trd);
                days.add(trd.getDayMonth());
                return true;

            } else return false;
        }
    }


    public void processDataForChart(int[] y, String[] days){
        Comparator<TrainingDay> comp = (o1, o2) -> o2.compareTo(o1);
        List<TrainingDay> list = new ArrayList<>(trDays);
        list.sort(comp);

        for(int i = 0; i<30; i++) {
            y[i] = 700;
            days[i] = "";
        }

        int k = list.size()-1;
        for(TrainingDay t : list){
            y[k] = 700 - t.getWeight();
            days[k] = t.getDayMonth();
            k--;
        }

    }

    public TrainingDay findDay(String day){
        for(TrainingDay trd : trDays){
            if (trd.getDayMonth().equals(day)) return trd;
        }
        return null;
    }

    public HashSet<TrainingDay> getTrDays(){
        return trDays;
    }

    public HashSet<String> getDays(){
        return days;
    }
    public static boolean checkDataFormat(int d, int m){
        return (m != 4 && m != 6 && m != 9 && m != 11 && m != 2 && d>0 && d<32) ||
                (m == 2 && d < 29 && d>0) ||
                ((m == 4 || m == 6 || m == 9 || m == 11) && d < 31 && d > 0);
    }

    public static boolean checkDataFormat(String data){
        int d, m;

        if(data.length()<5) return false;
        else {
            if (data.charAt(2) == '/') {
                String[] tokens = data.split("/");
                d = Integer.parseInt(tokens[0]);
                m = Integer.parseInt(tokens[1]);
            } else return false;
        }
        return checkDataFormat(d, m);
    }

    public static boolean checkCorrectResults(String str){
        if((str.charAt(2)=='/'&&str.charAt(5)==' ')||(str.charAt(1)=='/'&&str.charAt(4)==' ')||
                (str.charAt(2)=='/'&&str.charAt(4)==' ')||(str.charAt(1)=='/'&&str.charAt(3)==' ')){
            String[] tokens = str.split(" ");
            if(isNumber(tokens[1])){
                String[] tokens2 = tokens[0].split("/");
                return isNumber(tokens2[0]) && isNumber(tokens2[1]);
            } else return false;
        } else return false;
    }

    public static boolean checkCorrectResults(String[] res){
        for(String s : res) if(!checkCorrectResults(s)) return false;
        return true;
    }

    public static boolean isNumber(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++)
            if (!Character.isDigit(str.charAt(i))) return false;
        return true;
    }

}
