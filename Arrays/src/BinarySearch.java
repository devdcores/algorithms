/**
 * Created by Devaraj Reddy, 4/3/2018 - 8:53 PM
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] sortedArray = {2, 4, 6, 8, 9, 10, 34, 36, 44};
        int searchElement = 37;
        System.out.println("Found at : "+ searchElement(sortedArray, searchElement));
    }

    private static int searchElement(int[] sortedArray, int searchElement) {
        int low = 0;
        int high = sortedArray.length - 1;
        int position = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] == searchElement) {
                position = mid;
            }
            if (searchElement > sortedArray[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return position;
    }
}


