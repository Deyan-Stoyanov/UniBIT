import java.util.ArrayList;

public class User
{
    //Declaring properties of the User class
    public int UserId;
    public String UserName;
    public ArrayList<Book> ListOfBooks;

    //Creating a constructor for the User class with the 3 properties
    public User(int UserId, String UserName, ArrayList<Book> ListOfBooks)
    {
        this.UserId = UserId;
        this.UserName = UserName;
        this.ListOfBooks = ListOfBooks;
    }

    public User() { }

    //Declaring getter and setter methods for the properties of the User class - UserId, UserName and ListOfBooks
    private void SetUserId(int UserId)
    {
        this.UserId = UserId;
    }
    private int GetUserId()
    {
        return this.UserId;
    }

    private void SetUserName(String UserName)
    {
        this.UserName = UserName;
    }
    private String GetUserName()
    {
        return this.UserName;
    }

    private void SetListOfBooks(ArrayList<Book> ListOfBooks)
    {
        this.ListOfBooks = ListOfBooks;
    }
    private ArrayList<Book> GetListOfBooks()
    {
        return this.ListOfBooks;
    }
}
