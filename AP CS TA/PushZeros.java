public class PushZeros {
    
    public static void main(String[] args) {
        int[] array = { 1, 0, 30, 9, 0, 0, 26, 15 };
        push(array);
    }

    public static void push(int[] array) {
        int i = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] != 0) {
                array[i] = array[j];
                i++;
            }
        }
        
        while (i < array.length) {
            array[i] = 0;
            i++;
        }

        printArray(array);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1]);
    }

}
