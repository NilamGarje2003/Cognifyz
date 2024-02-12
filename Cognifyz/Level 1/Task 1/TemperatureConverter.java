import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a temperature value: ");
        double temperature = input.nextDouble();

        System.out.println("Please enter the unit of measurement (C for Celsius, F for Fahrenheit): ");
        String unit = input.next();

        if (unit.equalsIgnoreCase("C")) {
            double fahrenheit = temperature * 9 / 5 + 32;
            System.out.println("The temperature in Fahrenheit is: " + fahrenheit);
        } else if (unit.equalsIgnoreCase("F")) {
            double celsius = (temperature - 32) * 5 / 9;
            System.out.println("The temperature in Celsius is: " + celsius);
        } else {
            System.out.println("Invalid unit of measurement.");
        }

        input.close();
    }
}
