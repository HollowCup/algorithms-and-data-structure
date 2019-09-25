package sort;

import java.util.Arrays;

/**
 * Description：选择排序
 * Author:TengLu
 * Date:2019/9/25
 * Time:15:40
 */
public class SelectSort {
    public static void main(String[] args) {
        int arr[] = {2, 7, -5, 30, 9};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        selectSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        // 遍历从数组的第一位开始
        for (int i = 0; i < arr.length - 1; i++) {
            // 每轮遍历开始前，默认第一个数为最小值
            int min = arr[i];
            // 同时记住最小值的下标
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 通过对比找出最小值
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                // 每轮结束后，将头结点与最小值进行交换
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
