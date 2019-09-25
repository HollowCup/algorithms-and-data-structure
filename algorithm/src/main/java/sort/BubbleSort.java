package sort;

import java.util.Arrays;

/**
 * Description：冒泡排序
 * Author:TengLu
 * Date:2019/9/25
 * Time:8:57
 */
public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 5, 4};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        bubbleSortIncrease(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        // 用于帮助我们进行数据交换
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSortIncrease(int[] arr) {
        int temp;
        // 标识变量，表示是否进行过交换，如果数组是已经是有序的，则不会发生交换，可以提前终止排序行为
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    // 发生过交换，修改flag为true
                    flag = true;
                }
            }
            if (!flag) {
                // 如果已经排好序，则终止排序操作
                break;
            } else {
                // 重置flag为false,
                flag = false;
            }
        }
    }


}
