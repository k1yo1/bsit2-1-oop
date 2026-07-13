import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {

        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(book.getTitle())) {
                System.out.println("Book already exists in the library.");
                return;
            }
        }

        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void listBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n===== Library Books =====");

        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    public void borrowBook(String title) {

        title = title.trim();

        for (Book book : books) {

            if (book.getTitle().equalsIgnoreCase(title)) {

                if (book.isBorrowed()) {
                    System.out.println("Book is already borrowed.");
                } else {
                    book.borrow();
                    System.out.println("Book borrowed successfully!");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    public void returnBook(String title) {

        title = title.trim();

        for (Book book : books) {

            if (book.getTitle().equalsIgnoreCase(title)) {

                if (!book.isBorrowed()) {
                    System.out.println("Book was not borrowed.");
                } else {
                    book.returnBook();
                    System.out.println("Book returned successfully!");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    public void searchBook(String title) {

        title = title.trim();

        for (Book book : books) {

            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found:");
                System.out.println(book);
                return;
            }
        }

        System.out.println("Book not found.");
    }
}