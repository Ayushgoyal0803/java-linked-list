package SinglyLinkedList.SocialMediaConnections;

import java.util.HashSet;

public class SocialMediaConnections {
    private Node head;

    public void addUser(String userId, String name, int age) {
        Node newUser = new Node(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newUser;
        }
    }

    public void addFriendConnection(String userId1, String userId2) {
        Node user1 = findUserById(userId1);
        Node user2 = findUserById(userId2);
        if (user1 != null && user2 != null && !user1.friendIds.contains(userId2)) {
            user1.friendIds.add(userId2);
            user2.friendIds.add(userId1);
        }
    }

    public void removeFriendConnection(String userId1, String userId2) {
        Node user1 = findUserById(userId1);
        Node user2 = findUserById(userId2);
        if (user1 != null && user2 != null) {
            user1.friendIds.remove(userId2);
            user2.friendIds.remove(userId1);
        }
    }

    public void displayFriends(String userId) {
        Node user = findUserById(userId);
        if (user != null) {
            System.out.println("Friends of " + user.name + ": " + user.friendIds);
        } else {
            System.out.println("User not found.");
        }
    }

    public void findMutualFriends(String userId1, String userId2) {
        Node user1 = findUserById(userId1);
        Node user2 = findUserById(userId2);
        if (user1 != null && user2 != null) {
            HashSet<String> mutualFriends = new HashSet<>(user1.friendIds);
            mutualFriends.retainAll(user2.friendIds);
            System.out.println("Mutual friends: " + mutualFriends);
        }
    }

    public void searchUser(String query) {
        Node curr = head;
        while (curr != null) {
            if (curr.userId.equals(query) || curr.name.equalsIgnoreCase(query)) {
                System.out.println("User found: " + curr.name + " (ID: " + curr.userId + ")");
                return;
            }
            curr = curr.next;
        }
        System.out.println("User not found.");
    }

    public void countFriends() {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.name + " has " + curr.friendIds.size() + " friends.");
            curr = curr.next;
        }
    }

    private Node findUserById(String userId) {
        Node curr = head;
        while (curr != null) {
            if (curr.userId.equals(userId)) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }
}
