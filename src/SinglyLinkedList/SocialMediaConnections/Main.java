package SinglyLinkedList.SocialMediaConnections;

public class Main {
    public static void main(String[] args) {
        SocialMediaConnections smc = new SocialMediaConnections();

        smc.addUser("U1", "Alice", 25);
        smc.addUser("U2", "Bob", 27);
        smc.addUser("U3", "Charlie", 22);

        smc.addFriendConnection("U1", "U2");
        smc.addFriendConnection("U1", "U3");
        smc.addFriendConnection("U2", "U3");

        smc.displayFriends("U1");
        smc.displayFriends("U2");

        smc.findMutualFriends("U1", "U2");
        smc.searchUser("Charlie");
        smc.countFriends();
    }
}
