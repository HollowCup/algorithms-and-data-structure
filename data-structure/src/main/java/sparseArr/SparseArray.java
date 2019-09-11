package sparseArr;

/**
 * Description：稀疏数组与二维数组
 * Author:TengLu
 * Date:2019/9/10
 * Time:18:00
 */
public class SparseArray {
    public static void main(String[] args) {
        System.out.println("原始二维数组:");
        int originalArr[][] = new int[3][4];
        originalArr[1][2] = 1;
        originalArr[2][3] = 2;
        printArr(originalArr);
        System.out.println("原始二维数组转换为稀疏数组:");
        int sparseArr[][] = twoDimensionalArrToSparseArr(originalArr);
        printArr(sparseArr);
        System.out.println("再将稀疏数组转为二维数组:");
        int twoDimensionalArr[][] = sparseArrToTwoDimensionalArr(sparseArr);
        printArr(twoDimensionalArr);
    }

    public static int[][] twoDimensionalArrToSparseArr(int[][] twoDimensionalArr){
        // 第一步：先遍历二维数组,得到有效数字的个数
        int sum = getTwoDimensionalArrEffectiveNumber(twoDimensionalArr);
        // 第二步：根据二维数组及有效数字的个数创建稀疏数组
        int [][] sparseArr = createSparseArr(twoDimensionalArr,sum);
        // 第三步：为稀疏数组赋值
        assignForSparseArr(twoDimensionalArr,sparseArr);
        return sparseArr;
    }

    private static int getTwoDimensionalArrEffectiveNumber(int[][] twoDimensionalArr){
        int sum = 0;
        for (int i = 0; i < twoDimensionalArr.length; i++) {
            for (int j = 0; j < twoDimensionalArr[i].length; j++) {
                if (twoDimensionalArr[i][j] != 0) {
                    sum++;
                }
            }
        }
        return sum;
    }

    private static int[][] createSparseArr(int[][] twoDimensionalArr,int sum){
        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = twoDimensionalArr.length;
        sparseArr[0][1] = twoDimensionalArr[0].length;
        sparseArr[0][2] = sum;
        return sparseArr;
    }

    private static void assignForSparseArr(int[][] twoDimensionalArr,int [][] sparseArr){
        // count用于记录是第几个非0数据
        int count = 0;
        for (int i = 0; i < twoDimensionalArr.length;i++) {
            for (int j = 0; j < twoDimensionalArr[i].length; j++) {
                if(count == sparseArr[0][2]){
                    return ;
                }
                if (twoDimensionalArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = twoDimensionalArr[i][j];
                }
            }
        }
    }

    public static void printArr(int[][] arr){
        for (int[] row : arr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    public static int[][] sparseArrToTwoDimensionalArr(int[][] sparseArr){
        // 第一步：根据稀疏数组创建二维数组
        int twoDimensionalArr[][] = createTwoDimensionalArr(sparseArr);
        // 第二步：为二维数组赋值
        assignForTwoDimensionalArr(sparseArr,twoDimensionalArr);
        return twoDimensionalArr;
    }

    private static int[][] createTwoDimensionalArr(int[][] sparseArr){
        return new int[sparseArr[0][0]][sparseArr[0][1]];
    }

    private static void assignForTwoDimensionalArr(int[][] sparseArr,int[][] twoDimensionalArr){
        for(int i = 1; i < sparseArr.length; i++) {
            twoDimensionalArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
    }
}
