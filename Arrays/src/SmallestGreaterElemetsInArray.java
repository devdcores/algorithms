import java.util.Arrays;

/**
 * Created by Devaraj Reddy, 3/29/2018 - 10:39 AM
 */
public class SmallestGreaterElemetsInArray {
    public static void main(String[] args) {

        int[] array = {6, 3, 9, 8, 10, 2, 1, 15, 7};
        int[] res = new int[array.length];
        //6, 3, 9, 8, 10, 2, 1, 15, 7
        //Result : 7 6 10 9 15 3 2 _ 8

        int k=0;
        for (int i = 0; i < array.length; i++) {
            int temp=0;
            for (int j = 0; j < array.length; j++) {
                if(temp==0) {
                    if (array[j] > array[i]) {
                        temp = array[j];
                    }
                }
                if(array[j]<temp && array[j] > array[i]){
                    temp=array[j];
                }

            }
            res[k]=temp;
            k++;
        }

        System.out.println("result :"+ Arrays.toString(res));
    }
}
