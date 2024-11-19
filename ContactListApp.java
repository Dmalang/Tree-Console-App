import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String toString() {
        return "Name: " + name + ", Phone: " + phone;
    }
}

public class ContactListApp {
    private static ArrayList<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nContact List Manager");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    addContact(scanner);
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    searchContact(scanner);
                    break;
                case 4:
                    deleteContact(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addContact(Scanner scanner) {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        String phone;
        while (true) {
            System.out.print("Phone number: ");
            phone = scanner.nextLine();
            if (phone.length() == 11) {
                break;
            } else {
                System.out.println("Invalid phone number. ");
            }
        }

        contacts.add(new Contact(name, phone));
        System.out.println("Contact added successfully.");
    }

    private static void viewContacts() {
        System.out.println("\nContacts:");
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i));
            }
        }
    }

    private static void searchContact(Scanner scanner) {
        if (contacts.isEmpty()) {
            System.out.println("No contacts to search.");
            return;
        }

        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.name.equalsIgnoreCase(name)) {
                System.out.println(contact);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No contact found with that name.");
        }
    }

    private static void deleteContact(Scanner scanner) {
        if (contacts.isEmpty()) {
            System.out.println("No contacts to delete.");
            return;
        }

        System.out.print("Enter name to delete: ");
        String name = scanner.nextLine();
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).name.equalsIgnoreCase(name)) {
                contacts.remove(i);
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("No contact found with that name.");
    }
}
