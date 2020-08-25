package sort;

import java.util.Arrays;

/**
 * Description：归并排序
 * Author:TengLu
 * Date:2020/7/4
 * Time:17:00
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {8, 6, 3, 2, 1, 7, 4, 5};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.print(Arrays.toString(arr));
    }

    // 分+治的过程
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            // 通过mid将代分的数组分成两部分
            int mid = (left + right) / 2;
            // 从左向mid递归
            mergeSort(arr, left, mid, temp);
            // 从mid向右递归
            mergeSort(arr, mid + 1, right, temp);
            // 合并
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并过程
     *
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  做中转的数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        int i = left; // 初始化i，左边有序序列的初始索引
        int j = mid + 1; // 初始化j，右边有序序列的初始索引
        int t = 0; // 指向temp数组的当前索引

        // （一）先把左右两边（有序）的数组按照规则填充到temp数组，直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            } else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        // （二）把剩余数据的一边数据依次全部填充到temp中
        while (i <= mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }
        // （三）将temp数组的元素拷贝到arr
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }

}
