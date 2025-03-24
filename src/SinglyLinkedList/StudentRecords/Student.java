package SinglyLinkedList.StudentRecords;

class Student{
    private Node head;

    public void addNodeAtBeginning(int rollNumber, String name, int age, char grade ){
        Node newNode = new Node(rollNumber,name,age,grade);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
    }

    public void addNodeAtLast(int rollNumber, String name, int age, char grade ){
        Node newNode = new Node(rollNumber,name,age,grade);
        if(head == null){
            head = newNode;
        }
        else {
            Node curr = head;
            while (curr.next != null){
                curr =curr.next;
            }

            curr.next = newNode;
        }
    }

    public void addNodeAtPosition(int rollNumber, String name, int age, char grade , int position){
        if(position==0){
            addNodeAtBeginning(rollNumber,name,age,grade);
            return;
        }

        Node curr = head;
        for (int i = 0; i < position - 1 && curr != null; i++) {
            curr = curr.next;
        }

        if (curr == null) {
            System.out.println("Position out of bounds");
            return;
        }
        Node newNode = new Node(rollNumber,name,age,grade);
        newNode.next = curr.next;
        curr.next = newNode;

    }

    public void deleteNode(int rollNumber){
        if(head == null){
            System.out.println("List is empty.");
            return;
        }

        if(head.rollNumber == rollNumber){
            head = head.next;
            return;
        }

        Node curr = head;

        while (curr.next != null && curr.next.rollNumber != rollNumber){
            curr = curr.next;
        }

        if(curr.next != null) {
            curr.next = curr.next.next;
        }
        else {
            System.out.println("No student with given roll number.");
        }

    }

    public void displayNodes(){
        Node curr = head;
        while (curr !=null){
            System.out.println(curr.rollNumber+ " " + curr.name + " " + curr.grade);
            curr = curr.next;
        }
    }

    public void searchStudents(int rollNumber){
        Node curr = head;
        while (curr != null && curr.rollNumber != rollNumber){
            curr = curr.next;
        }
        if(curr != null)
            System.out.println(curr.rollNumber + " " + curr.name + " " + curr.age + " " + curr.grade );
        else
            System.out.println("No student with given roll number");
    }

    public void updateGrade(int rollNumber, char grade){
        Node curr = head;
        while (curr != null && curr.rollNumber != rollNumber){
            curr = curr.next;
        }
        if(curr != null)
            curr.grade = grade;
        else
            System.out.println("No student with given roll number.");
    }
}