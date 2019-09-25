package queen;

/**
 * Description：八皇后问题
 * Author:TengLu
 * Date:2019/9/24
 * Time:14:42
 */
public class EightQueen {

    // 定义皇后的个数，这里取8
    int max = 8;
    // 用于存储皇后的位置,比如 result = {0 , 5, 7, 2, 6, 3, 1, 4}
    // 上述例子result表示，第一行的皇后在第1个位置，第二行的皇后在第6个位置，依次类推
    int[] result = new int[max];
    // 用来记录摆放皇后的解法的数量
    static int count = 0;

    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.placeQueen(0);
        System.out.printf("一共有%d解法", count);
    }

    /**
     * Description：该方法用来放置皇后
     * @param n 表示第n个皇后，也就是第n行的皇后
     * @return
     */
    private void placeQueen(int n) {
        if(n == max) {
            showResult();
            return;
        }
        // 迭代从0-7，即每行都有8种可能性
        // 例如，第一行的皇后可以从第1列放置到第8列
        for(int i = 0; i < max; i++) {
            result[n] = i;
            // 当每放置一行的皇后，需要判断当前皇后是否会与之前的皇后们发生相互攻击的情况
            if(notAttackEachOther(n)) {
                // 如果不会发生相互攻击的情况，那么继续放下一层皇后
                placeQueen(n+1);
            }
        }
    }
    /**
     * Description：该方法用来判断皇后是否会相互攻击
     * @param n 表示第n个皇后，也就是第n行的皇后
     * @return
     */
    private boolean notAttackEachOther(int n) {
        // 说明：假设n=3.我们需要与第1层与第2层的皇后进行攻击判断
        // 判断是否会攻击的原则：
        //      1.同行：不会发生冲突，每次放置n都会+1，即第n层放置完毕后，就会去放置n+1层
        //      2.同列：假设第3层我们放到的是第3个位置，如果第1层与第3层皇后发生冲突
        //              那么有result[0] == result[2]，所以同列冲突的条件是result[i] == result[n]
        //      3.同一斜线：假设第3层我们放到的是第3个位置，如果第1层与第3层皇后发生冲突
        //                  那么有result[0] = 0，result[2] = 2
        //                  所以同一斜线冲突的条件是Math.abs(n-i) == Math.abs(array[n] - array[i])
        for (int i = 0; i < n; i++) {
            if (result[i] == result[n] || Math.abs(n - i) == Math.abs(result[n] - result[i])) {
                return false;
            }
        }
        return true;
    }

    private void showResult() {
        count++;
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
