package queue;

/**
 * Description：循环队列
 * Author:TengLu
 * Date:2019/9/16
 * Time:19:23
 */
public class Queue {
    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(4);
    }
}
class CircleQueue {
    // 表示队列的长度
    private int maxQueueSize;
    // head表示队列的头指向，初始值 = 0
    private int head;
    // head表示队列的尾指向，初始值 = 0
    private int tail;
    // 该数组用于存放真实的数据
    private int[] dataArr;

    public CircleQueue(int queueSize) {
        maxQueueSize = queueSize + 1;
        dataArr = new int[maxQueueSize];
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return tail == head;
    }

    // 判断队列是否已满
    public boolean isFull() {
        return (tail + 1) % maxQueueSize == head;
    }

    public void addData(int n) {
        if (isFull()) {
            System.out.println("队已列满，不能加入数据！");
            return;
        }

        dataArr[tail] = n;
        tail = (tail + 1) % maxQueueSize;
        System.out.println(tail);
    }

    public int getData() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        // 先把 head 对应的值保留到一个临时变量
        int value = dataArr[head];
        // 将 head 后移, 取模
        head = (head + 1) % maxQueueSize;
        // 将临时保存的变量返回
        return value;
    }

    public int size() {
        return (tail + maxQueueSize - head) % maxQueueSize;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有可展示数据！");
            return;
        }
        for (int i = head; i < head + size(); i++) {
            System.out.printf("dataArr[%d]=%d\n", i % maxQueueSize, dataArr[i % maxQueueSize]);
        }
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        return dataArr[head];
    }

}