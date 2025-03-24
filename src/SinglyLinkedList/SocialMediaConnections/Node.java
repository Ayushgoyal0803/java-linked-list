package SinglyLinkedList.SocialMediaConnections;


import java.util.ArrayList;
import java.util.List;

public class Node {
    String userId;
    String name;
    int age;
    List<String> friendIds;
    Node next;

    Node(String userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}
