import java.util.Arrays;
import java.util.Comparator;

public class Library {
    private Book[] books;
    private int size;

    public Library(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    // Add a book to the library
    public void addBook(Book book) {
        if (size < books.length) {
            books[size] = book;
            size++;
        } else {
            System.out.println("Library is full.");
        }
    }

    // Linear search to find books by title
    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    // Binary search to find books by title (assuming the list is sorted)
    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);
            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // Sort the books by title (to use binary search)
    public void sortBooksByTitle() {
        Arrays.sort(books, 0, size, Comparator.comparing(Book::getTitle));
    }

    // Main method for testing
    public static void main(String[] args) {
        Library library = new Library(10);

        // Add books to the library
        library.addBook(new Book("B001", "Harry Potter and the Philosopher's Stone", "J.K. Rowling"));
        library.addBook(new Book("B002", "The Hobbit", "J.R.R. Tolkien"));
        library.addBook(new Book("B003", "1984", "George Orwell"));
        library.addBook(new Book("B004", "To Kill a Mockingbird", "Harper Lee"));

        // Linear search by title
        System.out.println("Linear Search:");
        Book book = library.linearSearchByTitle("1984");
        System.out.println(book != null ? book : "Book not found.");

        // Sort books by title for binary search
        library.sortBooksByTitle();

        // Binary search by title
        System.out.println("\nBinary Search:");
        book = library.binarySearchByTitle("The Hobbit");
        System.out.println(book != null ? book : "Book not found.");
    }
}
