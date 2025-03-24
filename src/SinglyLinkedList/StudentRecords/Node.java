package SinglyLinkedList.StudentRecords;

class Node{

    int rollNumber;
    String name;
    int age;
    char grade;
    Node next;

    Node(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}