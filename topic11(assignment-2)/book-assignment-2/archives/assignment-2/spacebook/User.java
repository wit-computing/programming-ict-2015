
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class User
{
    String firstName;
    String lastName;
    int age;
    String nationality;
    String email;
    String password;

    Status status;

    ArrayList<Friendship> friendships   = new ArrayList<>();
    ArrayList<Message> inbox            = new ArrayList<>();
    ArrayList<Message> outbox           = new ArrayList<>(); 

    HashMap<String, Group> groups = new HashMap<>();

    /**
     * Constructs an object intended for testing only
     * The firstName determined by caller
     * Remaining fields used default data
     */
    public User(String firstName)
    {
        setState(firstName, "Simpson", firstName+"@simpson.com", "secret");
    }

    public User(String firstName, String lastName, String email, String password)
    {
        setState(firstName, lastName, email, password);
    }  

    public void setState(String firstName, String lastName, String email, String password)
    {
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.email      = email;
        this.password   = password;
        // Task 2 initialize status
    }  
    // Task 2
    public void setStatus(Status status)
    {
         //TODO
    }

    public void broadcastMessage(Subject subject, String messageText)
    {
        for(Friendship f : friendships)
        {
            Message message = new Message(subject, this, f.targetUser, messageText);
            outbox.add(message);
            f.targetUser.inbox.add(message);
        }
    }

    // Task 3
    public void sendMessage(Message message)
    {
        //TODO
    }

    public void sendMessage(Subject subject, User to, String messageText)
    {
        Message message = new Message(subject,this, to, messageText);
        outbox.add(message);
        to.inbox.add(message);
    }

    public void displayOutbox()
    {
        for(Message msg : outbox)
        {
            msg.displayMessage();
        }
    }

    public void displayInbox()
    {
        for(Message msg : inbox)
        {
            msg.displayMessage();
        }
    }
    // Task 1
    public void befriend(User friend)
    {
        if(friend == this)
        {
            System.out.println("Opps! You seem to have made a mistake in attempting to befriend yourself");
        }
        else if(friendshipsContains(friend))
        {
            System.out.println("You attempted to befriend " + friend.firstName +" who is already a friend");
        }
        else
        {
            Friendship friendship = new Friendship(this, friend);
            friendships.add(friendship);
        }
    }

    // Task 1
    private boolean friendshipsContains(User friend)
    {
        return false;
    }

    public void unfriendAll()
    {
        friendships.clear();
    }

    public void unfriend(User friend) 
    {
        for(Friendship friendship : friendships)
        {
            if(friendship.targetUser == friend)
            {
                friendships.remove(friendship);
                return;
            }
        }
    }

    public void displayFriends() 
    {
        if(friendships.isEmpty())
        {
            System.out.println("Unfortunately you have no friends");
        }
        
        System.out.println("I'm " + this.firstName + " " + this.lastName + " and these are my \"friends\" hehe :-)");
        
        for(Friendship friendship : friendships)
        {
            System.out.println("My friend "+friendship.targetUser.firstName + " is " + friendship.targetUser.status);
        }
    }

    // Task 2
    public void displayFriends(Status status) 
    {
        //TODO
    }
    
    public void addGroup(String groupName)
    {
        groups.put(groupName, new Group(groupName));
    }

    public void addGroupMember(String groupName, User user)
    {
        Group group = groups.get(groupName);
        group.addGroupMember(user);
    }

    public void broadcastMessage(String groupName, Message message)
    {
        groups.get(groupName).broadcastMessage(message);
    }

    // Task 7
    public void displayMessages(ArrayList<Message> messages)
    {
        //TODO
    }
    
    // Task 8
    public void displayMessages(Subject subject, ArrayList<Message> messages)
    {
        //TODO
    }
    
    /**
     * 
     * @param content   the content sought
     * @param msg       the array Message objects to be searched
     * @return          returns the first Message containing content, else null
     */
    public Message search(String content, ArrayList<Message> msg)
    {
        int index = 0;
        while(index < msg.size())
        {
            Message thisMsg = msg.get(index);
            if(content.equals(thisMsg.messageText))
            {
                return thisMsg;
            }
            index += 1;
        }
        return null;
    }

    /**
     * 
     * @param subject   seeking a Message object with Subject subject
     * @param msg       the array Message objects to be searched
     * @return          returns the first Message with subject matching param, else null
     */
    public Message search(Subject subject, ArrayList<Message> msg)
    {
        int index = 0;
        while(index < msg.size())
        {
            Message thisMsg = msg.get(index);
            if(subject == thisMsg.subject)
            {
                return thisMsg;
            }
            index += 1;
        }
        return null;        
    }
}