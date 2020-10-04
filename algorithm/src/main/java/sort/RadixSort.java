package sort;

import java.util.Arrays;

/**
 * @Description: 基数排序
 * @Author: luteng
 * @CreateDate: 2020/9/29 15:50
 */
public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {23, 3, 542, 1748, 15, 423};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        // 获取数组中最大数的位数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = arr[i] > max ? arr[i] : max;
        }
        int maxLength = (max + "").length();

        // 定义一个二维数组，表示十个桶，用作临时存储数据,每个桶的最大值为arr.length
        int[][] bucket = new int[10][arr.length];
        // 记录每个桶中，实际存放了多少个数据
        int[] bucketElementCounts = new int[10];

        // 从个位开始至最高位处理
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                // 取出每个元素位对应的值
                int digitOfElement = arr[j] / n % 10;
                // 放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            // 将桶中的临时数据放入原数组中
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                // 如果桶中有数据，我们才放入原数组中
                if (bucketElementCounts[k] != 0) {
                    // 将每个桶中数据迁入原数组
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index] = bucket[k][l];
                        index++;
                    }
                    // 每个桶中临时数据个数至为0，为下一轮位数排序做准备
                    bucketElementCounts[k] = 0;
                }
            }
        }
    }
}
