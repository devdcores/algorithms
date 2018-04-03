/**
 * Created by Devaraj Reddy, 4/3/2018 - 9:10 PM
 */
// https://www.youtube.com/watch?v=5BI0Rdm9Yhk
public class SearchElementInCircularSortedArray {
    public static void main(String[] args) {
        int[] sortedArray = {55, 57, 58, 2, 4, 6, 8, 9, 10, 34, 36, 44};
        int searchElement = 57;
        System.out.println("Found at : " + searchElement(sortedArray, searchElement));
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
            if (sortedArray[mid] <= sortedArray[high]) {
                if (searchElement>sortedArray[mid] && searchElement<=sortedArray[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (searchElement<sortedArray[mid] && searchElement>=sortedArray[low]) {
                    high=mid-1;
                } else {
                    low=mid+1;
                }
            }
        }
        return position;
    }
}
