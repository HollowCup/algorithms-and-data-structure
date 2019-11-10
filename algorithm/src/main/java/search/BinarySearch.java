package search;

/**
 * Description：二分查找
 * Author:TengLu
 * Date:2019/10/15
 * Time:23:32
 */
public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 7, 9, 10, 13, 18};
        int index = binarySearch(arr, 0, arr.length - 1, 5);
        if (index == -1) {
            System.out.println("目标值不在序列中");
        }
        System.out.println("找到目标值，其下标为" + index);
    }

    public static int binarySearch(int[] arr, int start, int end, int findValue) {
        if (start > end) {
            return -1;
        }

        // 获取中值及其下标
        int mid = (start + end) / 2;
        int midValue = arr[mid];

        // 比较中值：右递归的情况
        if (findValue > midValue) {
            return binarySearch(arr, mid + 1, end, findValue);
            // 比较中值：左递归的情况
        } else if (findValue < midValue) {
            return binarySearch(arr, start, mid - 1, findValue);
        } else {
            return mid;
        }
    }
}
