package fil7.ru.examples.java.team;

import java.text.DecimalFormat;

/**
 * Java 8 для чайников
 */
public class Player {
    private String name;
    private double average;

    public Player(String name, double average) {
        this.name = name;
        this.average = average;
    }

    public String getName() {
        return name;
    }

    public double getAverage() {
        return average;
    }
    public String getAverageString() {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumIntegerDigits(32); // число обязательных цифр слева
        decimalFormat.setMaximumFractionDigits(3);
        decimalFormat.setMinimumFractionDigits(3); // 3 обязательные цифры после запятой
        return decimalFormat.format(average);
    }

    public static void main(String[] args) {
        System.out.println(new Player("John", 32).getAverageString());
    }
}
