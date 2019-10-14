package search;

/**
 * Description：线性查找
 * Author:TengLu
 * Date:2019/10/14
 * Time:22:20
 */
public class SeqSearch {

    public static void main(String[] args) {
        int arr[] ={2, 7, -5, 30, 9};
        int index = seqSearch(arr, -5);
        if(index == -1) {
            System.out.println("目标值不在序列中");
        }
        System.out.println("找到目标值，其下标为" + index);
    }

    public static int seqSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

}
