package search;

/**
 * Description：插值查找
 * Author:TengLu
 * Date:2019/10/30
 * Time:08:54
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        System.out.println("二分查找：");
        int arr[] = {1, 3, 5, 7, 9, 10, 13, 18};
        int index = binarySearch(arr, 0, arr.length - 1, 1);
        if (index == -1) {
            System.out.println("目标值不在序列中");
        }
        System.out.println("找到目标值，其下标为" + index);
        System.out.println("==========================");
        System.out.println("插值查找：");
        int indexInsert = insertValueSearch(arr, 0, arr.length - 1, 1);
        if (indexInsert == -1) {
            System.out.println("目标值不在序列中");
        }
        System.out.println("找到目标值，其下标为" + indexInsert);
    }

    public static int binarySearch(int[] arr, int start, int end, int findValue) {
        System.out.println("二分查找被调用了！");
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

    public static int insertValueSearch(int[] arr, int start, int end, int findValue) {
        System.out.println("插值查找被调用了！");
        if (end > start || findValue < arr[0] || findValue > arr[arr.length - 1]) {
            return -1;
        }

        // 动态获取中值及其下标
        int mid = start + (end - start) * (findValue - arr[start]) / (arr[end] - arr[start]);
        int midValue = arr[mid];

        // 比较中值：右递归的情况
        if (findValue > midValue) {
            return insertValueSearch(arr, mid + 1, end, findValue);
            // 比较中值：左递归的情况
        } else if (findValue < midValue) {
            return insertValueSearch(arr, start, mid - 1, findValue);
        } else {
            return mid;
        }
    }
}
