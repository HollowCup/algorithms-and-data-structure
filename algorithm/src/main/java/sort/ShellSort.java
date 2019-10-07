package sort;

import java.util.Arrays;

/**
 * Description：希尔排序
 * Author:TengLu
 * Date:2019/9/27
 * Time:10:49
 */
public class ShellSort {
    public static void main(String[] args) {
        int arr[] = {2, 7, -5, 30, 9, -1, 3, 8};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        shellSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        // 取序列的一半为增量，以后每次减半，直到增量为1
        for (int increment = arr.length / 2; increment > 0; increment /= 2) {
            // 从第increment个元素开始，逐个对其所在的组进行直接插入排序
            for (int i = increment; i < arr.length; i++) {
                int insertIndex = i;
                int insertValue = arr[insertIndex];
                // 插入排序实现
                if (arr[insertIndex] < arr[insertIndex - increment]) {
                    while (insertIndex - increment >= 0 && insertValue < arr[insertIndex - increment]) {
                        // 通过对比后，将较大的数后移
                        arr[insertIndex] = arr[insertIndex - increment];
                        insertIndex -= increment;
                    }
                    // 将插入的值放到合适的位置中
                    arr[insertIndex] = insertValue;
                }
            }
        }
    }

}
