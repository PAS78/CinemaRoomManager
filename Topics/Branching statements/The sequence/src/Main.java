import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int count = 0;

        boolean goLoop = true;

        // Что печатаем (какую цифру)
        for (int i = 1; i <= input && goLoop; i++) {

            // Сколько раз
            for (int j = 1; j <= i; j++) {

                if (count >= input) {
                    goLoop = false;
                    break;
                } else {
                    count++;
                    System.out.print(i + " ");
                }

            }

        }

    }

}