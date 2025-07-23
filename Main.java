import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    boolean isIssued;

    Book(String title) {
        this.title = title;
        this.isIssued = false;
    }
}

public class Main{
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nLibrary System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> issueBook();
                case 4 -> { System.out.println("Exiting..."); return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addBook() {
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        books.add(new Book(title));
        System.out.println("Book added successfully.");
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i).title +
                    (books.get(i).isIssued ? " (Issued)" : ""));
        }
    }

    static void issueBook() {
        viewBooks();
        System.out.print("Enter book number to issue: ");
        int index = sc.nextInt() - 1;
        if (index >= 0 && index < books.size() && !books.get(index).isIssued) {
            books.get(index).isIssued = true;
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Invalid choice or book already issued.");
        }
    }
}
