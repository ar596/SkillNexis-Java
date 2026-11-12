
import java.util.ArrayList;

// Abstract User class
abstract class User {

    private String name;
    private int userId;

    // Constructor
    User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    // Encapsulation using getters
    public String getName() {
        return name;
    }

    public int getUserId() {
        return userId;
    }

    // Abstract method
    abstract void displayRole();
}

// Inheritance
class LibraryUser extends User {

    LibraryUser(String name, int userId) {
        super(name, userId);
    }

    @Override
    void displayRole() {
        System.out.println("User Role: Library Member");
    }
}

// Book class
class Book {

    private int bookId;
    private String title;
    private String author;
    private boolean available;

    // Constructor
    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    // Getter methods
    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    // Borrow book
    void borrowBook() {
        available = false;
    }

    // Return book
    void returnBook() {
        available = true;
    }

    // Display book details
    void displayBook() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Availability: "
                + (available ? "Available" : "Borrowed"));
        System.out.println("------------------------");
    }
}

// Library class
class Library {

    private ArrayList<Book> books = new ArrayList<>();

    // Add Book
    void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    // Display Books
    void displayBooks() {
        System.out.println("\nLibrary Book List:");

        for (Book book : books) {
            book.displayBook();
        }
    }

    // Borrow Book
    void borrowBook(int bookId, User user) {

        for (Book book : books) {

            if (book.getBookId() == bookId) {

                if (book.isAvailable()) {
                    book.borrowBook();

                    System.out.println(user.getName()
                            + " borrowed " + book.getTitle());
                } else {
                    System.out.println("Book is already borrowed!");
                }

                return;
            }
        }

        System.out.println("Book not found!");
    }

    // Return Book
    void returnBook(int bookId) {

        for (Book book : books) {

            if (book.getBookId() == bookId) {

                if (!book.isAvailable()) {
                    book.returnBook();
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("Book is already available!");
                }

                return;
            }
        }

        System.out.println("Book not found!");
    }
}

// Main class
public class LibraryManagement {

    public static void main(String[] args) {

        // Creating Library object
        Library library = new Library();

        // Creating Book objects
        Book book1 = new Book(101, "Java Programming",
                "James Gosling");

        Book book2 = new Book(102, "Python Basics",
                "Guido van Rossum");

        Book book3 = new Book(103, "Data Structures",
                "Mark Allen");

        // Adding books
        System.out.println("===== ADD BOOKS =====");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Creating User object
        LibraryUser user = new LibraryUser("Arthi", 1);

        System.out.println("\n===== USER DETAILS =====");
        System.out.println("Name: " + user.getName());
        System.out.println("User ID: " + user.getUserId());
        user.displayRole();

        // Display all books
        System.out.println("\n===== BOOK LIST =====");
        library.displayBooks();

        // Borrow a book
        System.out.println("\n===== BORROW BOOK =====");
        library.borrowBook(101, user);

        // Display books after borrowing
        library.displayBooks();

        // Return a book
        System.out.println("\n===== RETURN BOOK =====");
        library.returnBook(101);

        // Display books after returning
        library.displayBooks();
    }
}
