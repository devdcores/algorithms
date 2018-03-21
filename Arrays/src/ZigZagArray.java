import java.util.Arrays;

/**
 * Created by Devaraj Reddy, 3/22/2018 - 12:03 AM
 */
public class ZigZagArray {

    /*
    * https://www.youtube.com/watch?v=bgx1eAgBgaQ&list=PLeIMaH7i8JDjd21ZF6jlRKtChLttls7BG&index=16
    *
    * */
    public static void main(String[] args) {

        int[] array = {3, 6, 9, 8, 5, 4, 1};
        boolean flag = false;

        int i = 0;
        while (i < array.length-1) {

            if (flag) {
                if (array[i] < array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            } else {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            flag=!flag;
            i++;
        }

        System.out.println("Result, ZigZag Array : "+ Arrays.toString(array));
    }
}
