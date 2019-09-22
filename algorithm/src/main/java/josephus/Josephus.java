package josephus;

/**
 * Description：约瑟夫问题
 * Author:TengLu
 * Date:2019/9/22
 * Time:11:26
 */
public class Josephus {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addPerson(6);
        circleSingleLinkedList.showPersons();

        // 开始报数杀人
        circleSingleLinkedList.startCount(1, 5, 6);
    }

}

// 使用环形的单向链表构建一个圈
class CircleSingleLinkedList {
    // 创建一个first节点,当前没有编号
    private Person first = null;

    // 往环形链表中添加人，persons表示添加的人数
    public void addPerson(int persons) {
        if (persons < 1) {
            System.out.println("persons的值异常");
            return;
        }
        // 辅助指针，帮助构建环形链表
        Person curPerson = null;
        // 往环形链表中添加人
        for (int i = 1; i <= persons; i++) {
            Person person = new Person(i);
            // 如果是第一次添加人
            if (i == 1) {
                first = person;
                first.setNext(first);
                curPerson = first;
            } else {
                curPerson.setNext(person);
                person.setNext(first);
                curPerson = person;
            }
        }
    }

    // 遍历当前的环形链表
    public void showPersons() {
        // 判断链表是否为空
        if (first == null) {
            System.out.println("圈内没有人~~");
            return;
        }
        // 辅助指针，帮助我们遍历链表
        Person curPerson = first;
        while (true) {
            System.out.printf("当前人的编号为： %d \n", curPerson.getNo());
            if (curPerson.getNext() == first) {
                break;
            }
            curPerson = curPerson.getNext();
        }
    }

    /**
     *
     * @param startNo
     *            表示从第几个人开始数数
     * @param countNum
     *            表示每次数几下
     * @param nums
     *            表示圈中的人数
     */
    public void startCount(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }
        // 辅助指针,当我们要退出时的依据，当helper == first时，退出
        Person helper = first;
        // 需求创建一个辅助指针(变量) helper , 事先应该指向环形链表的最后这个节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        // 报数开始前，先让 first 和  helper 移动 k - 1次
        for(int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        // 报数开始时，让first 和 helper 指针同时 的移动  m  - 1 次, 然后first指向人被杀死，出圈
        // 这里是一个循环操作，直至圈中只有一个节点
        while(true) {
            // 当helper == first时，说明圈中只有一个节点
            if(helper == first) {
                break;
            }
            // 让 first 和 helper 指针同时移动 countNum - 1
            for(int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("第%d号人被杀死\n", first.getNo());
            // 出圈操作
            first = first.getNext();
            helper.setNext(first);

        }
        System.out.printf("最后留在圈中的人的编号是：%d \n", first.getNo());
    }
}

class Person {
    // 人的编号
    private int no;
    // 指向下一个人
    private Person next;

    public Person(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Person getNext() {
        return next;
    }

    public void setNext(Person next) {
        this.next = next;
    }

}
