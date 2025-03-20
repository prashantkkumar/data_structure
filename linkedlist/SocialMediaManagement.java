package week3_assignment1;

import java.util.*;

class UserNode {
	int userId;
	String name;
	int age;
	Set<Integer> friendIds;
	UserNode next;
	
	public UserNode(int userId, String name, int age) {
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.friendIds = new HashSet<>();
		this.next = null;
	}
}

class SocialMedia {
	private UserNode head;
	
	public void addUser(int userId, String name, int age) { 
		UserNode newUser = new UserNode(userId,name,age);
		
		if(head == null) {
			head = newUser;
		} else {
			UserNode temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newUser;
		}
	}
	
	
	// find user
	public UserNode findUser(int userId) {
		UserNode temp = head;
		while(temp != null) {
			if(temp.userId == userId) {
				return temp;
			}
			temp = temp.next;
		}
		return null;
	}
	
	
	// add friends
	public void addFriend(int userId1, int userId2) {
		UserNode user1 = findUser(userId1);
		UserNode user2 = findUser(userId2);
		
		if(user1 != null && user2 != null) {
			user1.friendIds.add(userId2);
			user2.friendIds.add(userId2);
		}
	}
	
	
	// remove friends
	public void removeFriend(int userId1, int userId2) {
		UserNode user1 = findUser(userId1);
		UserNode user2 = findUser(userId2);
		
		if(user1 != null && user2 != null) {
			user1.friendIds.remove(userId2);
			user2.friendIds.remove(userId1);
		}
	}
	
	
	// find mutual friends
	public Set<Integer> findMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUser(userId1);
        UserNode user2 = findUser(userId2);
        if (user1 != null && user2 != null) {
            Set<Integer> mutualFriends = new HashSet<>(user1.friendIds);
            mutualFriends.retainAll(user2.friendIds);
            return mutualFriends;
        }
        return Collections.emptySet();
    }
	
	
	
	public Set<Integer> getAllFriends(int userId) {
        UserNode user = findUser(userId);
        return (user != null) ? user.friendIds : Collections.emptySet();
    }
	
	
	// search user
	public UserNode searchUser(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

	
	// count friends
    public int countFriends(int userId) {
        UserNode user = findUser(userId);
        return (user != null) ? user.friendIds.size() : 0;
    }
	
	
	// display all friends
	public void displayAllFriends(int userId) {
        UserNode user = findUser(userId);
        if (user != null) {
            System.out.println("Friends of " + user.name + ": " + user.friendIds);
        } else {
            System.out.println("User not found");
        }
    }
}

public class SocialMediaManagement {
	
	public static void main(String[] args) {
		
		SocialMedia sm = new SocialMedia();
		
		sm.addUser(1, "Nazim Ahmad", 21);
		sm.addUser(2, "Vansh", 20);
		sm.addUser(3, "Akshat", 19);
		
		
		
		sm.addFriend(1, 2);
		sm.addFriend(3,4);
		
		sm.displayAllFriends(1);

        sm.removeFriend(1, 2);

        sm.displayAllFriends(1);

        System.out.println("Mutual Friends: " + sm.findMutualFriends(1, 3));

        UserNode searchResult = sm.searchUser("Charlie");
        if (searchResult != null) {
            System.out.println("Found User: " + searchResult.name);
        }

        System.out.println("Friend Count: " + sm.countFriends(1));
		
	}

}
