import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayX = new int[3];
        for (int i = 0; i < arrayX.length; i++) {
            arrayX[i] = scanner.nextInt();
        }

        int[] arrayY = new int[3];
        for (int i = 0; i < arrayY.length; i++) {
            arrayY[i] = scanner.nextInt();
        }

        Arrays.sort(arrayX);
        Arrays.sort(arrayY);
        System.out.print(checkBox(arrayX, arrayY));

    }

    private static String checkBox(int[] arrayX, int[] arrayY) {

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < arrayX.length; i++) {
            if (arrayX[i] < arrayY[i]) count1++;
            else if (arrayX[i] > arrayY[i]) count2++;
        }


        if (count1 == 3) return "Box 1 < Box 2";
        else if (count2 == 3) return "Box 1 > Box 2";
        else return "Incompatible";

    }

}