import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Library library = new Library();

        int choice = -1;

        do {

            System.out.println("\n===== Library Information System =====");
            System.out.println("1. Add Book");
            System.out.println("2. List Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            if (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine();
                continue;
            }

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:

                    String title;
                    String author;

                    do {
                        System.out.print("Enter Title: ");
                        title = input.nextLine().trim();

                        if (title.isEmpty()) {
                            System.out.println("Title cannot be empty.");
                        }

                    } while (title.isEmpty());

                    do {
                        System.out.print("Enter Author: ");
                        author = input.nextLine().trim();

                        if (author.isEmpty()) {
                            System.out.println("Author cannot be empty.");
                        }

                    } while (author.isEmpty());

                    library.addBook(new Book(title, author));
                    break;

                case 2:
                    library.listBooks();
                    break;

                case 3:

                    System.out.print("Enter title to borrow: ");
                    title = input.nextLine().trim();

                    if (title.isEmpty()) {
                        System.out.println("Title cannot be empty.");
                    } else {
                        library.borrowBook(title);
                    }

                    break;

                case 4:

                    System.out.print("Enter title to return: ");
                    title = input.nextLine().trim();

                    if (title.isEmpty()) {
                        System.out.println("Title cannot be empty.");
                    } else {
                        library.returnBook(title);
                    }

                    break;

                case 5:

                    System.out.print("Enter title to search: ");
                    title = input.nextLine().trim();

                    if (title.isEmpty()) {
                        System.out.println("Title cannot be empty.");
                    } else {
                        library.searchBook(title);
                    }

                    break;

                case 0:
                    System.out.println("Thank you for using the Library Information System!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select from 0 to 5.");
            }

        } while (choice != 0);

        input.close();
    }
}