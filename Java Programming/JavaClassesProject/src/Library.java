import java.util.ArrayList;
import java.util.Scanner;


class Library
{
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
        PrintInstructions();
        ArrayList<Book> Library = new ArrayList<Book>();
        ArrayList<User> Users = new ArrayList<User>();
        while (true)
        {
            String command = scanner.nextLine();
            if (command.equals("END"))
            {
                break;
            }
            ExecuteCommand(Library, Users, command);
        }
    }

    //This method iterates through the possible commands and calls one of the other methods below
    static void ExecuteCommand(ArrayList<Book> Library, ArrayList<User> Users, String command)
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
                System.out.println("Command not recognized, please enter again");
                break;
        }
    }

    //This method lists all books taken by a given user
    static void ListBooksOfUser(ArrayList<Book> library, ArrayList<User> users)
    {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        boolean userExists = false;
        int counter = 0;
        for (User u : users)
        {
            if (u.UserName.equals(username))
            {
                userExists = true;
                if (u.ListOfBooks.size() > 0)
                {
                    System.out.printf("Books taken by user %s: \n", u.UserName);
                }
                for (Book b : u.ListOfBooks)
                {
                    System.out.printf("Book ID: %d | Title: %s | Author: %s\n", b.BookId, b.BookTitle, b.BookAuthor);
                    counter++;
                }
                if (counter == 0)
                {
                    System.out.printf("User %s has not taken any books yet\n", u.UserName);
                }
            }
        }
        if (!userExists)
        {
            System.out.printf("User with username %s does not exist\n", username);
        }
    }

    //This method lists all users currently entered into the database
    static void ListUsers(ArrayList<User> users)
    {
        int counter = 0;
        if (users.size() > 0)
        {
            System.out.println("Users currently in database: ");
        }
        for (User u : users)
        {
            System.out.printf("User ID: %s | Username: %s\n", u.UserId, u.UserName);
            counter++;
        }
        if (counter == 0)
        {
            System.out.println("There are no users in the database");
        }
    }

    //This method lists all books currently entered into the database
    static void ListBooks(ArrayList<Book> library)
    {
        int counter = 0;
        if (library.size() > 0)
        {
            System.out.println("Books currently in library: ");
        }
        for (Book b : library)
        {
            System.out.printf("Book ID: %d | Title: %s | Author: %s\n", b.BookId, b.BookTitle, b.BookAuthor);
            counter++;
        }
        if (counter == 0)
        {
            System.out.println("There are no books in the library");
        }
    }

    //This method removes a given user from the database
    static void RemoveUser(ArrayList<User> users)
    {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        boolean userExists = false;
        for (User u : users)
        {
            if (u.UserName.equals(username))
            {
                System.out.printf("User with username %s successfully removed from database\n", u.UserName);
                userExists = true;
                users.remove(u);
                break;
            }
        }
        if (!userExists)
        {
            System.out.printf("User with username %s does not exist\n", username);
        }
    }

    //This method removes a given book from the database
    static void RemoveBook(ArrayList<Book> library)
    {
        System.out.println("Enter book title: ");
        String bookTitle =  scanner.nextLine();
        boolean bookExists = false;
        for (Book b : library)
        {
            if (b.BookTitle.equals(bookTitle))
            {
                System.out.printf("Book with title %s successfully removed from library\n", b.BookTitle);
                bookExists = true;
                library.remove(b);
                break;
            }
        }
        if (!bookExists)
        {
            System.out.printf("Book with title %s is taken or does not exist\n", bookTitle);
        }
    }

    //This method allows an user to return a book he has previously taken
    static void UserReturnBook(ArrayList<Book> library, ArrayList<User> users)
    {
        System.out.println("Enter username: ");
        String  username = scanner.nextLine();
        boolean userExists = false;
        for (User u : users)
        {
            if (u.UserName.equals(username))
            {
                userExists = true;
                System.out.println("Enter book title: ");
                String bookTitle = scanner.nextLine();
                boolean bookExists = false;
                for (Book b : library)
                {
                    if (b.BookTitle.equals(bookTitle))
                    {
                        System.out.printf("Book with title %s successfully returned by user %s\n", b.BookTitle, u.UserName);
                        bookExists = true;
                        u.ListOfBooks.remove(b);
                        library.add(b);
                        break;
                    }
                }
                if (!bookExists)
                {
                    System.out.printf("Book with title %s is taken or does not exist\n", bookTitle);
                }
                break;
            }
        }
        if (!userExists)
        {
            System.out.printf("User with username %s does not exist\n", username);
        }
    }

    //This method allows an user to take a book from the database
    static void UserGetBook(ArrayList<Book> library, ArrayList<User> users)
    {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        boolean userExists = false;
        for (User u : users)
        {
            if (u.UserName.equals(username))
            {
                userExists = true;
                System.out.println("Enter book title: ");
                String bookTitle = scanner.nextLine();
                boolean bookExists = false;
                for (Book b : library)
                {
                    if (b.BookTitle.equals(bookTitle))
                    {
                        System.out.printf("Book with title %s successfully taken by user %s\n", b.BookTitle, u.UserName);
                        bookExists = true;
                        u.ListOfBooks.add(b);
                        library.remove(b);
                        break;
                    }
                }
                if (!bookExists)
                {
                    System.out.printf("Book with title %s is taken or does not exist\n", bookTitle);
                }
                break;
            }
        }
        if (!userExists)
        {
            System.out.printf("User with username %s does not exist\n", username);
        }
    }

    //This method adds a new user to the database
    static void AddUser(ArrayList<User> users)
    {
        System.out.println("Enter user ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        User user = new User(id, username, new ArrayList<Book>());
        boolean userAlreadyAdded = false;
        for (User u : users)
        {
            if (u.UserName.equals(user.UserName))
            {
                userAlreadyAdded = true;
                System.out.println("User with this username already exists");
                break;
            }
        }
        if (!userAlreadyAdded)
        {
            users.add(user);
            System.out.printf("User with id %d and username %s successfully added to database\n", user.UserId, user.UserName);
        }
    }

    //This method adds a new book to the database
    static void AddBook(ArrayList<Book> library)
    {
        System.out.println("Enter book ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter book title: ");
        String title = scanner.nextLine();
        System.out.println("Enter book author: ");
        String author = scanner.nextLine();
        Book book = new Book(id, title, author);
        boolean bookAlreadyAdded = false;
        for (Book b : library)
        {
            if (b.BookTitle.equals(book.BookTitle))
            {
                bookAlreadyAdded = true;
                System.out.println("Book already added to library");
                break;
            }
        }
        if (!bookAlreadyAdded)
        {
            library.add(book);
            System.out.printf("Book with id %d, title %s and author %s successfully added", book.BookId, book.BookTitle, book.BookAuthor);
        }
    }

    //This method prints the possible commands, used in this program
    static void PrintInstructions()
    {
        System.out.println("Enter one of the following commands: ");
        System.out.println("ADD_BOOK,  ADD_USER,  USER_GET_BOOK,  USER_RETURN_BOOK,  REMOVE_BOOK,  REMOVE_USER,  " +
                "LIST_BOOKS,  LIST_USERS,  LIST_BOOKS_OF_USER,  END");
    }
}

