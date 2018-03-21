import java.util.Arrays;

/**
 * Created by Devaraj Reddy, 3/21/2018 - 9:40 PM
 */
public class ReverseArrayWithoutUsingExtraSpace {

    /*
    *
    * Logic : traverse from beginning to middle of the array and swap the values from end of the array.
    *
    * */
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 5, 6, 7};
        final int length = array.length;
        for (int i = 0; i < (length / 2); i++) {
            //swap
            int temp = array[i];
            array[i] = array[length - i - 1];
            array[length - i - 1] = temp;
        }

        System.out.println("Result Reversed Array : " + Arrays.toString(array));
    }
}
