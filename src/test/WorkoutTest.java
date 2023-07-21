package test;

import io.Exercise;
import model.TrainingDay;
import view.Workout;

public class WorkoutTest {
    private static final Workout w = new Workout();
    private static final boolean[] testsRes = new boolean[5];
    private static final TrainingDay[] testData = new TrainingDay[5];

    private static void createSourceData(){
        String[] dataTest = {"10/10", "hbqwd", "31/02", "30", "1910u013"};
        String[] workoutTypesTest = {"Deadlift", "Squat", "Bench press", "Deadlift", "Squat"};
        String[][] resultsTest = {{"12/3 100", "18/4 50", "1/12 70", "12/3 100", "14/3 40"},
                                  {"12/3100", "qwhjdkqwf", "123131", "12", "14/3 40"},
                                  {"12/3 100", "eqf", "1/12 70", "qwfhuik", "14/3 40"},
                                  {"qefjlhqfe", "18/4 50", "1/12 70", "12/3 100", "14/3 40"},
                                  {"12/3 100", "qffq--fqwf", "1/12 70", "qfwf", "1111"}};

        for(int i = 0; i<5; i++){
            if(TrainingDay.correctTrainingDay(dataTest[i], resultsTest[i])) {
                testData[i] = new TrainingDay(dataTest[i], resultsTest[i], workoutTypesTest[i], Exercise.getExercise(workoutTypesTest[i]));
            } else testData[i] = null;

        }

    }
    public static void runTest(){
        test1();
    }

    public static void getStat(){
        int failed = 0;
        for(boolean b : testsRes) if(!b) failed++;
        System.out.println(failed + " tests of " + testsRes.length + " failed.");
    }

    public static void test1(){
        WorkoutTest.createSourceData();
        for(int i = 0; i<testData.length; i++){
            testsRes[i] = w.addTrDay(testData[i]);
        }
    }

    public static void main(String[] args) {
        WorkoutTest.runTest();
        WorkoutTest.getStat();
    }
}
