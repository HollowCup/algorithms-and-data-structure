package sort;

import java.util.Arrays;

/**
 * Description：插入排序
 * Author:TengLu
 * Date:2019/9/26
 * Time:11:31
 */
public class InsertSort {
    public static void main(String[] args) {
        int arr[] = {2, 7, -5, 30, 9};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        insertSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        // 定义：insertValue为插入的值
        int insertValue;
        // 定义：insertPreIndex为插入值的前一位下标
        int insertPreIndex;
        for (int i = 1; i < arr.length; i++) {
            insertValue = arr[i];
            insertPreIndex = i - 1;
            // 循环的目的是：找到插入的位置，insertValue < arr[insertPreIndex]为找到插入位置的条件
            while (insertPreIndex >= 0 && insertValue < arr[insertPreIndex]) {
                // 对比之后，将较大的值往后移一位
                arr[insertPreIndex + 1] = arr[insertPreIndex];
                insertPreIndex--;
            }
            // 如果本来插入值就为最大值，是不需要交换的
            if (insertPreIndex + 1 != i) {
                // 将插入的值放到合适的位置中
                arr[insertPreIndex + 1] = insertValue;
            }
        }
    }
}
