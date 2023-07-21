package view;

import model.TrainingDay;
import model.Trainings;
import io.DataProcessing;

import java.io.*;

public class Workout{
    private final Trainings trainings = new Trainings();
    private final File file;
    public Workout() {
        String path = "src/io/data.txt";
        file = new File(path);
        if (!(file.length() == 0L)) DataProcessing.fromFileToSet(file, trainings);
    }

    public Trainings getTrainings() {return trainings;}
    public boolean addTrDay(TrainingDay trd){
        return trainings.addTrainingDay(trd);
    }

    public File getFile() {return file;}
}
