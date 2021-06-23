public class Ch45Test {
    
    public static void main(String[] args) {
        
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        for (int i = 3; i <= Math.sqrt(n) + 1; i += 2) {
            if (n % i == 0) 
                return false;
        }
        return true;
    }

    public static boolean isBalancedPrime(int n) {
        if (!isPrime(n))
            return false;

        int upper = n + 1;
        while (!isPrime(upper)) {
            upper++;
        }

        int lower = n - 1;
        while (!isPrime(upper)) {
            upper--;
        }

        double mean = (lower + upper) / 2.0;
        return (mean == n);
    }

    public static int nthBalancedPrime(int n) {
        int i = 5;
        int count = 1;

        while (count < n) {
            i += 2;
            if (isBalancedPrime(i)) {
                count++;
            }
        }

        return i;
    }

}
