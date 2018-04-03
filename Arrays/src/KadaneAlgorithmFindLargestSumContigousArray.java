/**
 * Created by Devaraj Reddy, 4/3/2018 - 11:18 PM
 */
//https://www.youtube.com/watch?v=kekmCQXYwQ0
public class KadaneAlgorithmFindLargestSumContigousArray {

    public static void main(String[] args) {
        int[] array = {4, -3, -2, 2, 3, 1, -2, -3, 4, 2, -6, -3 - 1, 3, 1, 2};

        int max_so_far = array[0];
        int max_ending_here = 0;
        int start = 0, end = 0, s = 0;

        for (int i = 0; i < array.length; i++) {
            max_ending_here = max_ending_here + array[i];
            if (max_ending_here > max_so_far) {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }
            if (max_ending_here < 0) {
                max_ending_here = 0;
                s = i + 1;
            }
        }

        System.out.println("Max Sum : " + max_so_far);
        System.out.println("Start Index : " + start + ", End Index : " + end);
    }
}
