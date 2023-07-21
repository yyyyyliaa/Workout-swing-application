package io;

public class Exercise {
    public static final String[] WORKOUT_TYPES = {"Deadlift", "Squat", "Bench press"};

    public static final Object[] DEADLIFT = new String[] {"Deadlift", "Hyperextension", "Pull-ups", "Block thrust", "Biceps"};
    public static final Object[] SQUAT = new String[] {"Squat", "Hyperextension", "Quadriceps", "Foot press", "Сalf muscle"};
    public static final Object[] BENCH_PRESS = new String[] {"Bench press", "Pec deck", "Triceps", "Bars", "Shoulder press"};

    public static Object[] getExercise(String workoutType){
        if(workoutType.equals("Deadlift")) return Exercise.DEADLIFT;
        else if(workoutType.equals("Squat")) return  Exercise.SQUAT;
        else return Exercise.BENCH_PRESS;
    }

}
