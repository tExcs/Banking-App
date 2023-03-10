import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // List of Persons
        ArrayList<Person> person_list = new ArrayList<>();
        person_list.add(new Person(9, "Joe Mama", -2));
        person_list.add(new Person(7, "Nils Schell", 2));
        person_list.add(new Person(2, "David Trüb", 1));
        person_list.add(new Person(6, "Patrick", 100));
        person_list.add(new Person(4, "Daddy George", 69));

        // Welcome message
        System.out.println("Welcome back to the ATM at Saphir-Bank: ");
        System.out.println("------------------------------------------------");

        while (true) {

            // Option 2
            System.out.println("Which person would you like to select?: ");
            for (Person person : person_list) {
                System.out.println(person.person_id + " " + person.name);
            }
            Scanner choose_person_id = new Scanner(System.in);
            int chose_person_id = Integer.parseInt(choose_person_id.nextLine());

            Person selected_person = person_list.stream().filter(person -> person.person_id == chose_person_id).findFirst().get();
            balance_control(selected_person);
        }
    }

    private static void balance_control(Person selected_person) {

        while (true) {
            System.out.println("1. Add Money\n" +
                    "2. Withdraw Money \n" +
                    "3. Look up current bank balance \n" +
                    "4. Exit");

            // Categories to chose from
            int balance_control_category = 0;

            // Options
            int option_01 = 0;
            int option_02 = 0;
            int option_03 = 0;

            Scanner scanner = new Scanner(System.in);
            System.out.printf("Enter a number of the above listed categories: ");
            balance_control_category = Integer.parseInt(scanner.nextLine());

            // ADD
            if (balance_control_category == 1) {
                System.out.printf("How much money do you want to ADD? Enter an amount in CHF: ");
                Scanner scanner1 = new Scanner(System.in);
                option_01 = Integer.parseInt(scanner1.nextLine());
                selected_person.balance += option_01;
                System.out.println(selected_person.balance);
            }

            // SUBTRACT
            if (balance_control_category == 2) {
                System.out.printf("How much money do you want WITHDRAW? Enter an amount in CHF: ");
                Scanner scanner2 = new Scanner(System.in);
                option_02 = Integer.parseInt(scanner2.nextLine());
                selected_person.balance -= option_02;
                System.out.println(selected_person.balance);
            }

            // CURRENT BALANCE
            if (balance_control_category == 3) {
                System.out.println("Here is your current balance: " + selected_person.balance);
            }

            // Exit balance control
            if (balance_control_category == 4) {
                break;
            }

        }
    }

}