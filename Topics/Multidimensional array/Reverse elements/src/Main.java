class ArrayOperations {
    public static void reverseElements(int[][] twoDimArray) {

        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0, x = twoDimArray[i].length - 1; j <= x; j++, x--) {

                int tmp = twoDimArray[i][j];
                twoDimArray[i][j] = twoDimArray[i][x];
                twoDimArray[i][x] = tmp;

            }

        }

    }

}