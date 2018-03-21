import java.util.Arrays;

/**
 * Created by Devaraj Reddy, 3/21/2018 - 9:20 PM
 */
public class SelectionSort {

    /*
    *
    * https://www.youtube.com/watch?v=p2lN3HnekB0&list=PLeIMaH7i8JDjd21ZF6jlRKtChLttls7BG&index=5
    * Logic : select the least element as traversing in the array and swap in the array.
    *
    * */
    public static void main(String[] args) {

        int[] array = {4, 2, 6, 9, 7, 1, 23};

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    //swap
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.println("Result Sorted Array : " + Arrays.toString(array));
    }
}
