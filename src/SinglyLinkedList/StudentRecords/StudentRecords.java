package SinglyLinkedList.StudentRecords;

public class StudentRecords {
    public static void main(String[] args) {
        Student studentList = new Student();
        studentList.addNodeAtBeginning(21,"Leo",21,'A');
        studentList.addNodeAtLast(22,"Leo2",21,'B');
        studentList.addNodeAtLast(23,"Leo3",20,'O');
        studentList.addNodeAtPosition(24,"Ayush",20,'A',3);
        studentList.displayNodes();
        studentList.deleteNode(23);
        System.out.println("After deleting a node");
        studentList.displayNodes();
        studentList.updateGrade(22,'O');
        System.out.println("After updating grade");
        studentList.displayNodes();
        studentList.searchStudents(22);

        Student studentList2 = new Student();
        studentList2.addNodeAtBeginning(55,"Ayush",21,'A');
        studentList2.displayNodes();

    }
}

