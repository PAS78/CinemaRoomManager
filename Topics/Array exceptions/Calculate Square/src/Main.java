class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {

        if (array != null && index >= 0 && index < array.length - 1) {
            System.out.print(array[index] * array[index]);
        } else {
            System.out.print("Exception!");
        }


    }
}