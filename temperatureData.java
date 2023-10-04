package abstractionManipulation;

import java.util.Scanner;
import java.text.DecimalFormat;

//Abstract class defining common methods for temperature analysis
abstract class TemperatureAnalysis {
 // Declare an abstract method to calculate and print the average temperature
 public abstract void averageTemperature();

 // Declare an abstract method to calculate and print the maximum temperature
 public abstract void maxTemperature();

 // Declare an abstract method to calculate and print the minimum temperature
 public abstract void minTemperature();

 // Declare an abstract method to get temperature data from the user
 public abstract double[] getUserInputTemperatures();
}

//Concrete class that extends TemperatureAnalysis and implements its methods
class TemperatureAnalyzer extends TemperatureAnalysis {
 private double[] temperatures; // Array to store temperature data

 // Constructor to initialize temperature data array
 public TemperatureAnalyzer(double[] data) {
     this.temperatures = data;
 }

 // Implement the abstract method to calculate and print the average temperature
 public void averageTemperature() {
     DecimalFormat decimalFormat = new DecimalFormat("#.##");

     if (temperatures.length == 0) {
         System.out.println("No temperature data provided.");
         return;
     }

     double sum = 0;

     for (double temperature : temperatures) {
         sum += temperature;
     }

     // Calculate the average temperature
     double average = sum / temperatures.length;

     // Format and print the average temperature
     System.out.println("Average temperature: " + decimalFormat.format(average) + " Celsius");
 }

 // Implement the abstract method to calculate and print the maximum temperature
 public void maxTemperature() {
     if (temperatures.length == 0) {
         System.out.println("No temperature data provided.");
         return;
     }

     double max = temperatures[0];

     for (double temperature : temperatures) {
         if (temperature > max) {
             max = temperature;
         }
     }

     // Print the maximum temperature
     System.out.println("Maximum temperature: " + max + " Celsius");
 }

 // Implement the abstract method to calculate and print the minimum temperature
 public void minTemperature() {
     if (temperatures.length == 0) {
         System.out.println("No temperature data provided.");
         return;
     }

     double min = temperatures[0];

     for (double temperature : temperatures) {
         if (temperature < min) {
             min = temperature;
         }
     }

     // Print the minimum temperature
     System.out.println("Minimum temperature: " + min + " Celsius");
 }

 // Implement the abstract method to get temperature data from the user
 public double[] getUserInputTemperatures() {
     Scanner scanner = new Scanner(System.in);

     System.out.print("Enter the number of temperature values: ");
     int numValues = scanner.nextInt();

     double[] userInputTemperatures = new double[numValues];

     for (int i = 0; i < numValues; i++) {
         System.out.print("Enter temperature " + (i + 1) + " (in Celsius): ");
         userInputTemperatures[i] = scanner.nextDouble();
     }

     return userInputTemperatures;
 }
}

public class temperatureData {
 public static void main(String[] args) {
     // Sample temperature dataset (you can replace this with your own data)
     double[] temperatures = {36.5, 37.2, 36.8, 37.5, 36.9};

     // Create an instance of the TemperatureAnalyzer class
     TemperatureAnalyzer analyzer = new TemperatureAnalyzer(temperatures);

     // Calculate and display statistics for the sample dataset
     analyzer.averageTemperature();
     analyzer.maxTemperature();
     analyzer.minTemperature();

     // Get user input for temperature data
     double[] userInputTemperatures = analyzer.getUserInputTemperatures();

     // Calculate and display statistics for user input data
     TemperatureAnalyzer userInputAnalyzer = new TemperatureAnalyzer(userInputTemperatures);
     userInputAnalyzer.averageTemperature();
     userInputAnalyzer.maxTemperature();
     userInputAnalyzer.minTemperature();
 }
}
