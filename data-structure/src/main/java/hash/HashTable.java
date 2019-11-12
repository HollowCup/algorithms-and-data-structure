package hash;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @description:哈希表实现
 * @time: 2019/11/12
 */
public class HashTable {

    private LinkedList[] studentLinkedListArray;
    private int size;

    public HashTable(int size) {
        this.size = size;
        studentLinkedListArray = new LinkedList[size];
    }

    private  int hash(int id) {
        return id % size;
    }

    public void add(Student stu) {
        // 先对id进行hash,找到放入数组的下标位置
        int no = hash(stu.id);
        if(studentLinkedListArray[no]==null){
            LinkedList<Student> linkedList = new LinkedList<>();
            linkedList.add(stu);
            studentLinkedListArray[no] = linkedList;
        }
        else {
            studentLinkedListArray[no].add(stu);
        }
    }


    public void getById(int id){
        // 先对id进行hash,找到数组的下标位置
        int no = hash(id);
        if(studentLinkedListArray[no]==null){
            System.out.printf("没有找到id为%d的学生",id);
        }
        else {
            // 遍历链表中的节点，根据id判断元素是否存在
            Iterator it = studentLinkedListArray[no].iterator();
            while (it.hasNext()){
                Student stu = (Student)it.next();
                if(id == stu.id){
                    System.out.printf("找到id为%d的学生",id);
                    return;
                }
            }
            System.out.printf("没有找到id为%d的学生",id);
        }
    }
    
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        hashTable.add(new Student(1,"小明"));
        hashTable.getById(1);
        System.out.println();
        hashTable.getById(11);
        System.out.println();
        hashTable.getById(2);
    }

}

class Student {
    public int id;
    public String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}