package io;

import model.TrainingDay;
import model.Trainings;

import javax.swing.*;
import java.io.*;
import java.util.HashSet;

public class DataProcessing {
    public static void fromFileToSet(File f, Trainings trainings){
        String line  = "";
        try(FileReader fr = new FileReader(f)){
            BufferedReader reader = new BufferedReader(fr);
            line = reader.readLine();
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        String[] trDaysData = line.split("&");
        for(String trDayRow : trDaysData){
            String[] trDayRowData = trDayRow.split("%");
            String dayMonth = trDayRowData[0];
            String workoutType = trDayRowData[1];
            String dayResults = trDayRowData[2].substring(1,trDayRowData[2].length()-1 );

            String[] dayResultsMass = dayResults.split(", ");

            trainings.addTrainingDay(new TrainingDay(dayMonth, dayResultsMass, workoutType, Exercise.getExercise(workoutType)));
        }
    }

    public static void fromSetToFile(File f, HashSet<TrainingDay> trDays){
        try(FileWriter fw = new FileWriter(f, false);){
            for(TrainingDay trd : trDays){
                fw.write(trd.toString());
            }
            fw.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String inputWorkoutType(){
        return (String) JOptionPane.showInputDialog(
                null,
                "Choose the type of workout:",
                "Workout type",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Exercise.WORKOUT_TYPES,
                " ");
    }
}
