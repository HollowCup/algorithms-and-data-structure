package sort;

import java.util.Arrays;

/**
 * Description：快速排序
 * Author:TengLu
 * Date:2019/10/13
 * Time:18:41
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 6, 4, 1, 0, 2, 9, 10, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int pivot = arr[left];    // 选取数组的第一个值作为关键数据
        int l = left;   //左下标
        int r = right;  //右下标

        while (l < r) {
            // 从左边开始找，直至找到大于等于pivot的值
            while (l < r && arr[l] < pivot) {
                l++;
            }
            // 从右边开始找，直至找到小于等于pivot的值
            while (l < r && arr[r] > pivot) {
                r--;
            }
            // 存在相等，直接移动指针
            if(l<r && arr[l]==arr[r]){
                l++;
            }else {
                //否则进行数据交换
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        // 将左侧数据递归处理
        if(l-1>left) quickSort(arr,left,l-1);
        // 将右侧数据递归处理
        if(r+1<right) quickSort(arr,r+1,right);
    }

}
