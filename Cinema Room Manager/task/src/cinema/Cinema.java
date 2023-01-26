package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows:\n" +
                "> ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of seats in each row:\n" +
                "> ");
        int lines = scanner.nextInt();

        // 0 - empty
        int[][] zal = createZal(rows, lines);

        // Menu
        boolean cicle = true;
        while (cicle) {
            switch (showMenu()) {
                case 0:
                    cicle = false;
                    break;
                case 1:
                    printZal(zal);
                    break;
                case 2:
                    buyTicket(zal, lines, rows);
                    break;
                case 3:
                    statistics(zal, lines, rows);
                    break;
            }
        }


    }

    private static void statistics(int[][] zal, int lines, int rows) {

        int countPurch = 0;
        float percentage = 0;
        int currentIncome = 0;
        int totalIncome = 0;

        int sizeArray = zal == null ? 0 : zal.length;

        for (int i = 0; i < sizeArray; i++) {
            int sizeArrayIn = zal[i] == null ? 0 : zal[i].length;
            for (int j = 0; j < sizeArrayIn; j++) {
                if (zal[i][j] == 1) {
                    countPurch++;
                    currentIncome += (lines * rows) <= 60 ? 10 : (rows / 2) > i ? 10 : 8;
                }
            }
        }
        System.out.println("Number of purchased tickets: " + countPurch);

        if (countPurch == 0) {
            percentage = 0;
        } else {
            percentage = (float) countPurch * 100 / (rows * lines);
        }
        System.out.printf("Percentage: %.2f%%\n", percentage);

        System.out.println("Current income: $" + currentIncome);

        totalIncome = (lines * rows) <= 60 ? 10 * (lines * rows) : (rows / 2) * lines * 10 + (rows - rows / 2) * lines * 8;
        System.out.println("Total income: $" + totalIncome);
    }

    private static int[][] createZal(int rows, int lines) {
        int[][] zal = new int[rows][lines];

        int sizeArray = zal == null ? 0 : zal.length;

        for (int i = 0; i < sizeArray; i++) {
            int sizeArrayIn = zal[i] == null ? 0 : zal[i].length;
            for (int j = 0; j < sizeArrayIn; j++) {
                zal[i][j] = 0;
            }
        }
        return zal;
    }

    private static void buyTicket(int[][] zal, int lines, int rows) {

        int numberChoise;
        int rowChoice;

        Scanner scanner = new Scanner(System.in);

        int priceTicket;

        System.out.print("\nEnter a row number:\n" +
                "> ");
        rowChoice = scanner.nextInt();

        System.out.print("Enter a seat number in that row:\n" +
                "> ");
        numberChoise = scanner.nextInt();

        if (rows < rowChoice || lines < numberChoise) {
            System.out.println("\nWrong input!\n");
            buyTicket(zal, lines, rows);
        } else if (zal[rowChoice - 1][numberChoise - 1] == 1) {
            System.out.println("\nThat ticket has already been purchased!\n");
            buyTicket(zal, lines, rows);
        } else {

            priceTicket = (lines * rows) <= 60 ? 10 : (rows / 2) >= rowChoice ? 10 : 8;
            System.out.println("\nTicket price: $" + priceTicket);

            // set B
            zal[rowChoice - 1][numberChoise - 1] = 1;

            printZal(zal);
        }
    }

    private static int showMenu() {
        System.out.print("""
                \n1. Show the seats
                2. Buy a ticket
                3. Statistics
                0. Exit
                >\s""");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void printZal(int[][] zal) {

        // Print head numbers
        System.out.println("\nCinema:");
        System.out.print(" ");
        int sizeArray0 = zal[0] == null ? 0 : zal[0].length;
        for (int i = 1; i < sizeArray0 + 1; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        int sizeArray = zal == null ? 0 : zal.length;
        for (int i = 0; i < sizeArray; i++) {
            System.out.print(i + 1);
            int sizeArrayIn = zal[i] == null ? 0 : zal[i].length;
            for (int j = 0; j < sizeArrayIn; j++) {
                if (zal[i][j] == 1) {
//                if (rowChoice > 0 && i == (rowChoice - 1) && j == numberChoise - 1) {
                    System.out.print(" " + "B");
                } else {
                    System.out.print(" " + "S");
                }
            }
            System.out.println();
        }

    }

    private static int priceCalc(int lines, int rows) {

        int firstRows = rows / 2;
        int secondRows = rows - firstRows;

        return (lines * firstRows) * 10 + (lines * secondRows) * 8;
    }


}