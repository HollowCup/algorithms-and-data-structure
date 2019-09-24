package map;

/**
 * Description：迷宫回溯问题
 * Author:TengLu
 * Date:2019/9/24
 * Time:9:00
 */
public class Map {
    public static void main(String[] args) {
        // 初始化地图
        int[][] map = buildMap();
        // 打印初始化地图
        showMap(map);
        System.out.println("================");
        // 执行走迷宫的方法
        walk(map, 1, 1);
        // 打印走迷宫过后地图
        showMap(map);

    }

    public static int[][] buildMap() {
        // 使用二维数组模拟迷宫
        int[][] map = new int[8][7];
        // 使用1表示墙，上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        // 设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        return map;
    }

    public static void showMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * @param map 表示地图
     * @param i,j 表示起始位置
     * @return 如果能接着往下走，就返回true, 否则返回false
     */
    public static boolean walk(int[][] map, int i, int j) {
        // 已经走到目标点位
        if (map[6][5] == 2) {
            return true;
        } else {
            // 先保障我们所在点位上是我们没有走过的点
            if (map[i][j] == 0) {
                // 当我们踏足这个点的瞬间，标记该点位为2，说明改点我们已经走过
                map[i][j] = 2;
                // 执行我们走迷宫的策略：下→右→上→左
                if (walk(map, i + 1, j)) { //向下
                    return true;
                } else if (walk(map, i, j + 1)) { //向右
                    return true;
                } else if (walk(map, i - 1, j)) { //向上
                    return true;
                } else if (walk(map, i, j - 1)) { // 向左
                    return true;
                } else {
                    // 当所有策略都走不通的情况下，说明该路为死路
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
