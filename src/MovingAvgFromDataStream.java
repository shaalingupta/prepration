
import java.util.*;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * Implement the MovingAverage class:
 *
 * MovingAverage(int size) Initializes the object with the size of the window size.
 * double next(int val) Returns the moving average of the last size values of the stream.
 *
 *
 * Example 1:
 *
 * Input
 * ["MovingAverage", "next", "next", "next", "next"]
 * [[3], [1], [10], [3], [5]]
 * Output
 * [null, 1.0, 5.5, 4.66667, 6.0]
 *
 * Explanation
 * MovingAverage movingAverage = new MovingAverage(3);
 * movingAverage.next(1); // return 1.0 = 1 / 1
 * movingAverage.next(10); // return 5.5 = (1 + 10) / 2
 * movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
 * movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
 *
 *
 * Constraints:
 *
 * 1 <= size <= 1000
 * -105 <= val <= 105
 * At most 104 calls will be made to next.
 */

public class MovingAvgFromDataStream {
    int count = 0;

    int size;
    int sum = 0;

    Deque<Integer> q;
    public MovingAvgFromDataStream(int size) {
        this.size = size;
        this.q = new ArrayDeque<>();
    }

    public double next(int val) {
        ++count;
        q.add(val);

        int to_remove = (count > size) ? (int) q.poll() : 0;

        sum = sum - to_remove + val;

        return (double) sum/Math.min(count, size);
    }

    public static void main(String[] args) {
        MovingAvgFromDataStream mafds = new MovingAvgFromDataStream(3);
        System.out.println(mafds.next(1));
        System.out.println(mafds.next(10));
        System.out.println(mafds.next(3));
        System.out.println(mafds.next(5));
    }
}
