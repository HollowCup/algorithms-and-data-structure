package linkedList;

/**
 * Description：链表实现
 * Author:TengLu
 * Date:2019/9/17
 * Time:19:48
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        // 初始化链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(new Node("A"));
        doubleLinkedList.add(new Node("B"));
        doubleLinkedList.add(new Node("C"));
        doubleLinkedList.add(new Node("D"));
        doubleLinkedList.showList();
        // 删除链表
        doubleLinkedList.delete(new Node("A"));
        System.out.println("删除后的链表为:");
        doubleLinkedList.showList();
    }
}

class DoubleLinkedList {
    private Node head;

    public void add(Node addNode) {
        // 在这里，我们使用curNode来帮助我们记录当前遍历到的元素
        Node curNode = head;
        // 如果链表为空，则添加的元素变为头结点
        if (curNode == null) {
            head = addNode;
            return;
        }
        // 如果不为空，我们的目的是走到链表的末端，所以这里使用while循环
        // 当退出while循环时，curNode则为链表的最末端
        while (true) {
            // 只有链表最末端节点的next为null
            if (curNode.next == null) {
                break;
            }
            // 如果没有找到最后, 将将temp后移
            curNode = curNode.next;
        }
        // 这里对链表的最后一个节点进行操作
        curNode.next = addNode;
        addNode.previous = curNode;
    }

    public void delete(Node delNode) {
        // 判断当前链表是否为空,如果为空，肯定无法杀出
        if (head == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        // 同样的，在这里，我们使用curNode来帮助我们记录当前遍历到的元素
        Node curNode = head;
        // 标志是否找到待删除的节点
        boolean flag = false;
        while (true) {
            // 已经到链表的最后，这是退出while循环的一种情况
            if (curNode == null) {
                break;
            }
            // 已经找到待删除的节点目标，可以退出while循环了
            if (curNode.name.equals(delNode.name)) {
                flag = true;
                break;
            }
            curNode = curNode.next;
        }
        // 如果找到删除的目标节点，则进行以下操作
        if (flag) {
            // 所谓的删除，就是把找到的节点的前置节点的后置节点变为删除节点的后置节点
            // 如果待删除的节点为第一节点
            if(curNode.previous == null){
                if(curNode.next!=null){
                    curNode.next.previous = null;
                    head = curNode.next;
                }else {
                    head = null;
                }
                return;
            }
            curNode.previous.next = curNode.next;
            // 如果删除的目标节点是最后一个，则没有这步操作
            if (curNode.next != null) {
                curNode.next.previous = curNode.previous;
            }
            return;
        }
        System.out.printf("要删除的 %s 节点不存在\n", delNode.name);
    }

    public void showList() {

        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        Node curNode = head;
        while (true) {
            if (curNode == null) {
                break;
            }
            System.out.println(curNode.name);
            curNode = curNode.next;
        }
    }
}

class Node {
    // 当前节点名称
    public String name;
    // 上一节点
    public Node next;
    // 下一节点
    public Node previous;

    public Node(String name) {
        this.name = name;
    }
}