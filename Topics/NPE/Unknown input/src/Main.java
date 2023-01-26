class Util {
    // correct this method to avoid NPE
    public static void printLength(String name) {
        int nameLength = name != null ? name.length() : 0;
        System.out.println(nameLength);
    }
}
