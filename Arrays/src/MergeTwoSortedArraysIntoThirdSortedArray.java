import java.util.Arrays;

/**
 * Created by Devaraj Reddy, 3/21/2018 - 8:22 PM
 */
public class MergeTwoSortedArraysIntoThirdSortedArray {

    /*
    * https://www.youtube.com/watch?v=xF3TU-QlhJQ&list=PLeIMaH7i8JDjd21ZF6jlRKtChLttls7BG&index=25
    * Logic: traverse through both the arrays at same time, compare the values which ever value is lesser put into new resultant array.
    * for remaining elements traverse through remaining elements and copy to resultant array.
    *
    * */
    public static void main(String[] args) {

        int[] sortedArray1 = {2, 4, 7, 8, 11};
        int[] sortedArray2 = {3, 6, 9, 13, 17, 19, 23, 34, 45};
        final int s1length = sortedArray1.length;
        final int s2length = sortedArray2.length;

        int[] resultMergedSortedArray = new int[s1length + s2length];
        int i = 0, j = 0, k = 0;

        while (i < s1length && j < s2length) {

            if (sortedArray1[i] < sortedArray2[j]) {
                resultMergedSortedArray[k] = sortedArray1[i];
                i++;
                k++;
            } else {
                resultMergedSortedArray[k] = sortedArray2[j];
                j++;
                k++;
            }

        }

        while (i < s1length) {
            resultMergedSortedArray[k] = sortedArray1[i];
            i++;
            k++;
        }

        while (j < s2length) {
            resultMergedSortedArray[k] = sortedArray2[j];
            j++;
            k++;
        }

        System.out.println("Resultant Array : "+ Arrays.toString(resultMergedSortedArray));
    }

}
