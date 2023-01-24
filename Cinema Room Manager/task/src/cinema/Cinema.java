package cinema;

import java.util.Scanner;

public class Cinema {

    public static int numberChoise = 0;
    public static int rowChoice = 0;
    public static int[][] zal;
    public static int rows, lines;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows:\n" +
                "> ");
        rows = scanner.nextInt();
        System.out.print("Enter the number of seats in each row:\n" +
                "> ");
        lines = scanner.nextInt();

        // 0 - empty
        createZal(rows, lines);

        // Menu
        boolean cicle = true;
        while (cicle) {
            switch (showMenu()) {
                case 0:
                    cicle = false;
                    break;
                case 1:
                    printZal();
                    break;
                case 2:
                    buyTicket();
                    break;
                case 3:
                    statistics();
                    break;
            }
        }


    }

    private static void statistics() {

        int countPurch = 0;
        float percentage = 0;
        int currentIncome = 0;
        int totalIncome = 0;

        for (int i = 0; i < zal.length; i++) {
            for (int j = 0; j < zal[i].length; j++) {
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

    private static void createZal(int rows, int lines) {
        zal = new int[rows][lines];
        for (int i = 0; i < zal.length; i++) {
            for (int j = 0; j < zal[i].length; j++) {
                zal[i][j] = 0;
            }
        }
    }

    private static void buyTicket() {
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
            buyTicket();
        } else if (zal[rowChoice - 1][numberChoise - 1] == 1) {
            System.out.println("\nThat ticket has already been purchased!\n");
            buyTicket();
        } else {

            priceTicket = (lines * rows) <= 60 ? 10 : (rows / 2) >= rowChoice ? 10 : 8;
            System.out.println("\nTicket price: $" + priceTicket);

            // set B
            zal[rowChoice - 1][numberChoise - 1] = 1;

            printZal();
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

    private static void printZal() {

        // Print head numbers
        System.out.println("\nCinema:");
        System.out.print(" ");
        for (int i = 1; i < zal[0].length + 1; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        for (int i = 0; i < zal.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < zal[i].length; j++) {
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