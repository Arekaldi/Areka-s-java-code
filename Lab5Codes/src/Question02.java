import java.lang.reflect.Array;

class ArrayUtils {
    public static <T> void printArray(T arr) {
        if (arr == null) {
            System.out.println("null");
            return;
        }

        printArrayHelper(arr, 0);
    }

    private static <T> void printArrayHelper(T arr, int indent) {
        if (arr == null) {
            System.out.println("null");
            return;
        }

        int length = Array.getLength(arr);
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            Object element = Array.get(arr, i);
            if (i != 0) {
                System.out.print(", ");
            }
            if (element != null && element.getClass().isArray()) {
                printArrayHelper(element, indent + 1); // 递归处理数组
            } else {
                System.out.print(element);
            }
        }
        System.out.print("]");
        if (indent == 0) {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[][] strArray = {{"Hello", "World"}, {"Java", "Generics"}};
        int[][][] multiArray = {{{1, 2}, {3, 4}}, {{5, 6}, {7, 8}}};

        printArray(intArray);   // 输出: [1, 2, 3, 4, 5]
        printArray(strArray);   // 输出: [[Hello, World], [Java, Generics]]
        printArray(multiArray);  // 输出: [[[1, 2], [3, 4]], [[5, 6], [7, 8]]]
    }
}
