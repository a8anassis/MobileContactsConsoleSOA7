package gr.aueb.cf.mobilecontacts;

import gr.aueb.cf.mobilecontacts.controller.MobileContactController;
import gr.aueb.cf.mobilecontacts.dto.MobileContactInsertDTO;
import gr.aueb.cf.mobilecontacts.dto.MobileContactUpdateDTO;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner in = new Scanner(System.in);
    private static final MobileContactController controller = new MobileContactController();

    public static void main(String[] args) {
        String choice;

        while (true) {
            printMenu();
            choice = getToken();

            if (choice.equals("q") || (choice.equals("Q"))) {
                break;
            }

            handleChoice(choice);
        }

        System.out.println("Thank you for using Mobile Contacts App");
    }

    public static void handleChoice(String choice) {
        String firstname;
        String lastname;
        String phoneNumber;
        String response;
        long id;

        switch (choice) {
            case "1":
                System.out.println("Παρακαλώ εισάγετε Όνομα, Επώνυμο, Αρ. Τηλεφώνου");
                firstname = getToken();
                lastname = getToken();
                phoneNumber = getToken();
                MobileContactInsertDTO insertDTO = new MobileContactInsertDTO(firstname, lastname, phoneNumber);
                response = controller.insertContact(insertDTO);

                if (response.startsWith("OK")) {
                    System.out.println("Επιτυχής Εισαγωγή");
                    System.out.println(response.substring(3));
                } else {
                    System.out.println("Ανεπιτυχής Εισαγωγή");
                    System.out.println(response.substring(7));
                }
                break;
            case "2":
                System.out.println("Εισάγετε Αριθμό Τηλεφώνου");
                phoneNumber = getToken();
                response = controller.getContactByPhoneNumber(phoneNumber);
                if (response.startsWith("Error")) {
                    System.out.println("Η επαφή δεν βρέθηκε.");
                    System.out.println(response.substring(3));
                    return;
                }
                System.out.println("Ανεπιτυχής Εισαγωγή");
                System.out.println(response.substring(6));
                System.out.println("Εισάγετε το υπάρχον ID");
                long oldId = Long.parseLong(getToken());
                System.out.println("Παρακαλώ εισάγετε νέο όνομα");
                firstname = getToken();
                System.out.println("Παρακαλώ εισάγετε νέο επώνυμο");
                lastname = getToken();
                System.out.println("Παρακαλώ εισάγετε νέο τηλεφωνικό αριθμό");
                phoneNumber = getToken();
                MobileContactUpdateDTO mobileContactUpdateDTO = new MobileContactUpdateDTO(oldId, firstname, lastname, phoneNumber);
                response = controller.updateContact(mobileContactUpdateDTO);
                System.out.println(response);
                break;
            case "3":
                System.out.println("Εισάγετε Κωδικό Επαφής");
                id = Long.parseLong(getToken());
                response = controller.deleteContactById(id);
                if (response.startsWith("OK")) {
                    System.out.println("Επιτυχής Διαγραφή");
                    System.out.println(response.substring(3));
                } else {
                    System.out.println("Ανεπιτυχής Διαγραφή");
                    System.out.println(response.substring(6));
                }
                break;
            case "4":
                System.out.println("Εισάγετε Κωδικό Επαφής");
                id =  Long.parseLong(getToken());
                response = controller.getContactById(id);
                if (response.startsWith("OK")) {
                    System.out.println("Επιτυχής Αναζήτηση");
                    System.out.println(response.substring(3));
                } else {
                    System.out.println("Ανεπιτυχής Αναζήτηση");
                    System.out.println(response.substring(6));
                }
                break;
            case "5":
                List<String > mobileContacts = controller.getAllContacts();
                if (mobileContacts.isEmpty()) System.out.println("Κενή λίστα επαφών");
                mobileContacts.forEach(System.out::println);
                break;
            default:
                System.out.println("Λάθος επιλογή");
                break;
        }

    }

    public static void printMenu() {
        System.out.println("Επιλέξτε ένα από τα παρακάτω:");
        System.out.println("1. Εισαγωγή επαφής");
        System.out.println("2. Ενημέρωση επαφής");
        System.out.println("3. Διαγραφή επαφής");
        System.out.println("4. Αναζήτηση επαφής");
        System.out.println("5. Προβολή επαφών");
        System.out.println("Q/q. Έξοδος");
    }

    public static String getToken() {
        return in.nextLine().trim();
    }
}
