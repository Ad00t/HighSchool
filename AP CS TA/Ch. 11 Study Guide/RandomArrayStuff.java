public class RandomArrayStuff {

    public static void main (String[] args) {
                   int arr[] = { 5, 4, 3 };      
                   arrStuff(arr, 0, arr.length - 1, 0);
            }
    
    public static void arrStuff(int arr[], int l, int r, int sum) {
            if (l > r) {
                System.out.print(sum + " ");
                return;
            }
            arrStuff(arr, l + 1, r, sum + arr[l]);
            arrStuff(arr, l + 1, r, sum);
    }
    
    }
    
