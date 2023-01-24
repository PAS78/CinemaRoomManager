import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        switch (input) {
            case 1:
                System.out.print("Yes!");
                break;
            case 2:
                System.out.print("No!");
                break;
            case 3:
                System.out.print("No!");
                break;
            case 4:
                System.out.print("No!");
                break;
            default:
                System.out.print("Unknown number");
                break;

        }
    }

}