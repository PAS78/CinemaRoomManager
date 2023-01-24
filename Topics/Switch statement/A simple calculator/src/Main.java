import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long first = scanner.nextLong();
        String znak = scanner.next();
        long second = scanner.nextLong();

        switch (znak) {
            case "+":
                System.out.print(first + second);
                break;
            case "-":
                System.out.print(first - second);
                break;
            case "*":
                System.out.print(first * second);
                break;
            case "/":
                if (second == 0) {
                    System.out.print("Division by 0!");
                } else {
                    System.out.print(first / second);
                }
                break;
            default:
                System.out.print("Unknown operator");
                break;

        }

    }
}