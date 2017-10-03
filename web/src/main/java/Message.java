
import java.util.*;

public class Message {
  public final static ArrayList<Message> messageList =
    new ArrayList<Message>();

  public final String title;
  public final String handle;
  public final String message;
  public final Date date;

  public Message(String title, String handle, String message) {
    this.title = title;
    this.handle = handle;
    this.message = message;
    this.date = new Date();
  }

}

