using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BookLibraryApp
{
    class Book
    {
        //Declaring properties of the Book class
        private int BookId;
        private string BookTitle;
        private string BookAuthor;

        //Creating a constructor for the Book class with the 3 properties
        public Book(int BookId, string BookTitle, string BookAuthor)
        {
            this.BookId = BookId;
            this.BookTitle = BookTitle;
            this.BookAuthor = BookAuthor;
        }

        //Declaring getter and setter methods for the properties of the Book class - BookId, BookTitle and BookAuthor
        public void SetBookId(int BookId)
        {
            this.BookId = BookId;
        }
        public int GetBookId()
        {
            return this.BookId;
        }

        public void SetBookTitle(string BookTitle)
        {
            this.BookTitle = BookTitle;
        }
        public string GetBookTitle()
        {
            return this.BookTitle;
        }

        public void SetBookAuthor(string BookAuthor)
        {
            this.BookAuthor = BookAuthor;
        }
        public string GetBookAuthor()
        {
            return this.BookAuthor;
        }
    }
    class User
    {
        //Declaring properties of the User class 
        private int UserId { get; set; }
        private string UserName { get; set; }
        private List<Book> ListOfBooks { get; set; }

        //Creating a constructor for the User class with the 3 properties
        public User(int UserId, string UserName, List<Book> ListOfBooks)
        {
            this.UserId = UserId;
            this.UserName = UserName;
            this.ListOfBooks = ListOfBooks;
        }

        //Declaring getter and setter methods for the properties of the User class - UserId, UserName and ListOfBooks
        public void SetUserId(int UserId)
        {
            this.UserId = UserId;
        }
        public int GetUserId()
        {
            return this.UserId;
        }

        public void SetUserName(string UserName)
        {
            this.UserName = UserName;
        }
        public string GetUserName()
        {
            return this.UserName;
        }

        public void SetListOfBooks(List<Book> ListOfBooks)
        {
            this.ListOfBooks = ListOfBooks;
        }
        public List<Book> GetListOfBooks()
        {
            return this.ListOfBooks;
        }
    }
    class Library
    {
        static void Main(string[] args)
        {
            PrintInstructions();
            List<Book> Library = new List<Book>();
            List<User> Users = new List<User>();
            while (true)
            {
                string command = Console.ReadLine().ToUpper();
                if (command.Equals("END"))
                {
                    break;
                }
                ExecuteCommand(Library, Users, command);
            }
        }

        //This method iterates through the possible commands and calls one of the other methods below
        static void ExecuteCommand(List<Book> Library, List<User> Users, string command)
        {
            switch (command)
            {
                case "ADD_BOOK":
                    AddBook(Library);
                    break;
                case "ADD_USER":
                    AddUser(Users);
                    break;
                case "USER_GET_BOOK":
                    UserGetBook(Library, Users);
                    break;
                case "USER_RETURN_BOOK":
                    UserReturnBook(Library, Users);
                    break;
                case "REMOVE_BOOK":
                    RemoveBook(Library);
                    break;
                case "REMOVE_USER":
                    RemoveUser(Users);
                    break;
                case "LIST_BOOKS":
                    ListBooks(Library);
                    break;
                case "LIST_USERS":
                    ListUsers(Users);
                    break;
                case "LIST_BOOKS_OF_USER":
                    ListBooksOfUser(Library, Users);
                    break;
                default:
                    Console.WriteLine("Command not recognized, please enter again");
                    break;
            }
        }

        //This method lists all books taken by a given user
        static void ListBooksOfUser(List<Book> library, List<User> users)
        {
            Console.WriteLine("Enter username: ");
            string username = Console.ReadLine();
            bool userExists = false;
            int counter = 0;
            foreach (User u in users)
            {
                if (u.GetUserName().ToUpper() == username.ToUpper())
                {
                    userExists = true;
                    if (u.GetListOfBooks().Count() > 0)
                    {
                        Console.WriteLine("Books taken by user {0}: ", u.GetUserName());
                        foreach (Book b in u.GetListOfBooks())
                        {
                            Console.WriteLine($"Book ID: {b.GetBookId()} | Title: {b.GetBookTitle()} | Author: {b.GetBookAuthor()}");
                            counter++;
                        }
                    }
                    else
                    {
                        Console.WriteLine("User {0} has not taken any books yet", u.GetUserName());
                    }
                }
            }
            if (!userExists)
            {
                Console.WriteLine($"User with username {username} does not exist");
            }
        }

        //This method lists all users currently entered into the database
        static void ListUsers(List<User> users)
        {
            if (users.Count() > 0)
            {
                Console.WriteLine("Users currently in database: ");
                foreach (User u in users)
                {
                    Console.WriteLine($"User ID: {u.GetUserId()} | Username: {u.GetUserName()}");
                }
            }
            else
            {
                Console.WriteLine("There are no users in the database");
            }
        }

        //This method lists all books currently entered into the database
        static void ListBooks(List<Book> library)
        {
            if (library.Count() > 0)
            {
                Console.WriteLine("Books currently in library: ");
                foreach (Book b in library)
                {
                    Console.WriteLine($"Book ID: {b.GetBookId()} | Title: {b.GetBookTitle()} | Author: {b.GetBookAuthor()}");
                }
            }
            else
            {
                Console.WriteLine("There are no books in the library");
            }
        }

        //This method removes a given user from the database
        static void RemoveUser(List<User> users)
        {
            Console.WriteLine("Enter username: ");
            string username = Console.ReadLine();
            bool userExists = false;
            foreach (User u in users)
            {
                if (u.GetUserName().ToUpper() == username.ToUpper())
                {
                    Console.WriteLine($"User with username {u.GetUserName()} successfully removed from database");
                    userExists = true;
                    users.Remove(u);
                    break;
                }
            }
            if (!userExists)
            {
                Console.WriteLine($"User with username {username} does not exist");
            }
        }

        //This method removes a given book from the database
        static void RemoveBook(List<Book> library)
        {
            Console.WriteLine("Enter book title: ");
            string bookTitle = Console.ReadLine();
            bool bookExists = false;
            foreach (Book b in library)
            {
                if (b.GetBookTitle().ToUpper() == bookTitle.ToUpper())
                {
                    Console.WriteLine($"Book with title {b.GetBookTitle()} successfully removed from library");
                    bookExists = true;
                    library.Remove(b);
                    break;
                }
            }
            if (!bookExists)
            {
                Console.WriteLine($"Book with title {bookTitle} is taken or does not exist");
            }
        }

        //This method allows an user to return a book he has previously taken
        static void UserReturnBook(List<Book> library, List<User> users)
        {
            Console.WriteLine("Enter username: ");
            string username = Console.ReadLine();
            bool userExists = false;
            foreach (User u in users)
            {
                if (u.GetUserName().ToUpper() == username.ToUpper())
                {
                    userExists = true;
                    Console.WriteLine("Enter book title: ");
                    string bookTitle = Console.ReadLine();
                    bool bookExists = false;
                    foreach (Book b in library)
                    {
                        if (b.GetBookTitle().ToUpper() == bookTitle.ToUpper())
                        {
                            Console.WriteLine($"Book with title {b.GetBookTitle()} successfully returned by user {u.GetUserName()}");
                            bookExists = true;
                            u.GetListOfBooks().Remove(b);
                            library.Add(b);
                            break;
                        }
                    }
                    if (!bookExists)
                    {
                        Console.WriteLine($"Book with title {bookTitle} is taken or does not exist");
                    }
                    break;
                }
            }
            if (!userExists)
            {
                Console.WriteLine($"User with username {username} does not exist");
            }
        }

        //This method allows an user to take a book from the database
        static void UserGetBook(List<Book> library, List<User> users)
        {
            Console.WriteLine("Enter username: ");
            string username = Console.ReadLine();
            bool userExists = false;
            foreach (User u in users)
            {
                if (u.GetUserName().ToUpper() == username.ToUpper())
                {
                    userExists = true;
                    Console.WriteLine("Enter book title: ");
                    string bookTitle = Console.ReadLine();
                    bool bookExists = false;
                    foreach (Book b in library)
                    {
                        if (b.GetBookTitle().ToUpper() == bookTitle.ToUpper())
                        {
                            Console.WriteLine($"Book with title {b.GetBookTitle()} successfully taken by user {u.GetUserName()}");
                            bookExists = true;
                            u.GetListOfBooks().Add(b);
                            library.Remove(b);
                            break;
                        }
                    }
                    if (!bookExists)
                    {
                        Console.WriteLine($"Book with title {bookTitle} is taken or does not exist");
                    }
                    break;
                }
            }
            if (!userExists)
            {
                Console.WriteLine($"User with username {username} does not exist");
            }
        }

        //This method adds a new user to the database
        static void AddUser(List<User> users)
        {
            Console.WriteLine("Enter user ID: ");
            int id = int.Parse(Console.ReadLine());
            Console.WriteLine("Enter username: ");
            string username = Console.ReadLine();
            User user = new User(id, username, new List<Book>());
            if (users.FindIndex(x => x.GetUserName().ToUpper() == user.GetUserName().ToUpper()) != -1)
            {
                Console.WriteLine("User with this username already exists");
            }
            else
            {
                users.Add(user);
                Console.WriteLine($"User with id {user.GetUserId()} and username {user.GetUserName()} successfully added to database");
            }
        }

        //This method adds a new book to the database
        static void AddBook(List<Book> library)
        {
            Console.WriteLine("Enter book ID: ");
            int id = int.Parse(Console.ReadLine());
            Console.WriteLine("Enter book title: ");
            string title = Console.ReadLine();
            Console.WriteLine("Enter book author: ");
            string author = Console.ReadLine();
            Book book = new Book(id, title, author);
            if (library.FindIndex(x => x.GetBookTitle().ToUpper() == book.GetBookTitle().ToUpper()) != -1)
            {
                Console.WriteLine("Book already added to library");
            }
            else
            {
                library.Add(book);
                Console.WriteLine($"Book with id {book.GetBookId()}, title {book.GetBookTitle()} and author {book.GetBookAuthor()} successfully added");
            }
        }

        //This method prints the possible commands, used in this program
        static void PrintInstructions()
        {
            Console.WriteLine("Enter one of the following commands: ");
            Console.WriteLine("ADD_BOOK,  ADD_USER,  USER_GET_BOOK,  USER_RETURN_BOOK,  REMOVE_BOOK,  REMOVE_USER,  " +
                "LIST_BOOKS,  LIST_USERS,  LIST_BOOKS_OF_USER,  END");
        }
    }
}