import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ����������� �������
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // �������
        int[][] matrica = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                matrica[i][j] = scanner.nextInt();

            }

        }

        // ������� ������
        int index1 = scanner.nextInt();
        int index2 = scanner.nextInt();

        for (int i = 0; i < matrica.length; i++) {
            int tmp = matrica[i][index1];
            matrica[i][index1] = matrica[i][index2];
            matrica[i][index2] = tmp;
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrica[i][j] + " ");
            }
            System.out.println();
        }

    }
}