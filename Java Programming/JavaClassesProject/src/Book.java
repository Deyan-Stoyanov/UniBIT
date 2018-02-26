public class Book
{
    //Declaring properties of the Book class
    public int BookId;
    public String BookTitle;
    public String BookAuthor;

    //Creating a constructor for the Book class with the 3 properties
    public Book(int BookId, String BookTitle, String BookAuthor)
    {
        this.BookId = BookId;
        this.BookTitle = BookTitle;
        this.BookAuthor = BookAuthor;
    }

    public Book() { }

    //Declaring getter and setter methods for the properties of the Book class - BookId, BookTitle and BookAuthor
    private void SetBookId(int BookId)
    {
        this.BookId = BookId;
    }
    private int GetBookId()
    {
        return this.BookId;
    }

    private void SetBookTitle(String BookTitle)
    {
        this.BookTitle = BookTitle;
    }
    private String GetBookTitle()
    {
        return this.BookTitle;
    }

    private void SetBookAuthor(String BookAuthor)
    {
        this.BookAuthor = BookAuthor;
    }
    private String GetBookAuthor()
    {
        return this.BookAuthor;
    }
}