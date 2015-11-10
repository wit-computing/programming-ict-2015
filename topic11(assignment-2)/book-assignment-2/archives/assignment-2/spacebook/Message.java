
//Task 6
public class Message
{
    Subject   subject;
    String    messageText;
    User      from;
    User      to;

    public Message(Subject subject, User from, User to, String messageText)
    {
        // TODO initialize Subject field
        this.from           = from;
        this.to             = to;
        this.messageText    = messageText;
    } 

    public void displayMessage()
    {
        String nameFrom = from.firstName;
        String nameTo   = to.firstName;
        // TODO System.out.println(... + " says \""+messageText + "\" to " + nameTo);
    }

    public void displayMessageContent()
    {
        System.out.println(messageText);
    }
}