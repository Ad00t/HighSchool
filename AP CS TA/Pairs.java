public class Pairs {
    
    public static void main(String[] args) { 
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8}; 
        int[] nums2 = {2, 7, 4, -5, 11, 5, 20}; 
        pairs(nums, 8); // Pairs of sum 8 
        pairs(nums2, 15); // Pairs of sum 15 
    }

    public static void pairs(int[] array, int sum) { 
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    System.out.println(array[i] + " + " + array[j] + " = " + sum);
                }
            }
        }
    } 

}
