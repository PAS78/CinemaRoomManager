import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int result = 0;

        Scanner scanner = new Scanner(System.in);
        int sizeArray = scanner.nextInt();

        int[] array = new int[sizeArray];
        for (int i = 0; i < sizeArray; i++) {
            array[i] = scanner.nextInt();
        }

        int n = scanner.nextInt();

        for (int ch : array) {
            if (ch > n) {
                result = result + ch;
            }
        }

        System.out.println(result);

    }
}