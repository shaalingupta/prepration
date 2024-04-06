package dsa;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 *
 *
 * Constraints:
 *
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * n is an integer.
 * Either x is not zero or n > 0.
 * -104 <= xn <= 104
 */

/**
 *  it follows the concept of binary search, if you want to calculate for n = 4 you first calculate for n = 2
 *  and before calculating n = 2, you calculate n =1, so that you can obtain the solution in log(n) instead of calculating for 4 times it will take O(N)
 */
public class Pow {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(n < 0){
            n = -n;
            x = 1/x;
        }
        double res = 1.0;

        while(n != 0){
            if(n%2 == 1){ //agar odd h toh res me ek bar multiply kr do x ko
                res = res * x;
                n -= 1;
            }
            x = x*x; // multiply kr do x ko x se and n ko half kr do,
            // dhyan rakho hum res ko nhe multiply kr rhe balki x ko kr rhe h toh hum x ko bada rhe h jab tak power even h
            // and jab bhi power odd hoti h hum usko res k saath multiply kr dete h


//            n = n/2;
            n >>>= 1; // 8 -> 4 -> 2 -> 1
            // n = n/2 is not working when n is signed integer i.e. negative -2147483648 which is upper limit on integer so we are using this unsigned right shift which is equivalent of n n/2 but handles this ove use case;

        }
        return res;
    }

    public static void main(String[] args) {
        Pow pow = new Pow();
        System.out.println(pow.myPow(2.00000, 10));
        System.out.println(pow.myPow(-1, 2147483647));
        System.out.println(pow.myPow(2.00000, -2147483648));
        System.out.println(pow.myPow(8.84372, -5));
    }
}
