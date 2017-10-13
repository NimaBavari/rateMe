package com.EnDATA;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {

    private static void addNewRating() throws IOException {
        double newPoint;

        Scanner reader1 = new Scanner(System.in);
        System.out.printf("Point for smart: ");
        double s = reader1.nextDouble();

        Scanner reader2 = new Scanner(System.in);
        System.out.printf("Point for trustworthy: ");
        double t = reader2.nextDouble();

        Scanner reader3 = new Scanner(System.in);
        System.out.printf("Point for attractive: ");
        double a = reader3.nextDouble();

        Rating r = new Rating();
        newPoint = r.getResult(s, t, a);

        FileWriter dataFile = null;
        try {
            dataFile = new FileWriter("results.txt", true);
            dataFile.write(newPoint + "\n");
        }catch(IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }finally {
            assert dataFile != null;
            dataFile.close();
        }

        showRating();
    }

    private static void showRating() throws IOException {
        double average;
        double sum = 0.0;
        ArrayList<Double> points = new ArrayList<>();
        String str;

        BufferedReader dataFile = new BufferedReader(new FileReader("results.txt"));
        while((str = dataFile.readLine()) != null) {
            double point = Double.parseDouble(str);
            points.add(point);
        }

        for(Object point : points) {
            double val = (double) point;
            sum += val;
        }

        average = sum / points.size();
        System.out.printf("The resulting rating is %.3f", average);
    }

    public static void main(String[] args) throws IOException {
        char c;

        do {
            System.out.println("\nType A to add a new rating, S to display rating, Q to exit.");
            Scanner reader = new Scanner(System.in);
            System.out.printf("   >");
            c = Character.toUpperCase(reader.findInLine(".").charAt(0));
            switch(c) {
                case 'A':
                    addNewRating();
                    break;
                case 'S':
                    showRating();
                    break;
                default:
                    System.err.println("Invalid entry!");
                    break;
            }
        }while(c != 'Q');
    }
}