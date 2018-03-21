import java.util.Arrays;

/**
 * Created by Devaraj Reddy, 3/22/2018 - 12:28 AM
 */
public class RemoveDuplicatesFromSortedArray {
    /*
    * https://www.youtube.com/watch?v=gf7vdIin0dk&index=17&list=PLeIMaH7i8JDjd21ZF6jlRKtChLttls7BG
    *
    * */
    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 7, 8, 9};

        int j = 0;
        for (int i = 0; i < sortedArray.length - 1; i++) {
            if (sortedArray[i] != sortedArray[i + 1]) {
                sortedArray[j] = sortedArray[i];
                j++;
            }
        }
        sortedArray[j] = sortedArray[sortedArray.length - 1];

        for (int i = j+1; i < sortedArray.length; i++) {
            sortedArray[i] = 0;
        }
        System.out.println("Result, duplicates removed : " + Arrays.toString(sortedArray));
    }
}
