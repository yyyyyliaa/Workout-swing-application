package data;

public class TrainingDay { //TODO: Добавить хранение вида тренировок и выполненных упражнений
                            //TODO: Добавить считывание/запись в файл
    private int day;
    private int month;

    public TrainingDay(int d, int m){
        day = d;
        month = m;
    }


    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

}
