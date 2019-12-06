package CarlysCatering;

import java.util.Arrays;
import java.util.Scanner;

public class DinnerEventdemo {

    public static void main(String[] args) {
        Event[] eventArray = new Event[8];
        String eventNum;
        String phoneNumber;
        int eventType;
        int guests;
        int entree;
        int sideDish1;
        int sideDish2;
        int dessert;

        // reading inputs for event details for dinner event
        for (int x = 0; x < eventArray.length; x++) {
            System.out.println("Enter event details for event# " + (x + 1));
            eventNum = getEventNumber();
            guests = getGuests();
            phoneNumber = getPhoneNumber();
            eventType = getEventType();
            eventArray[x] = new Event(eventNum, guests, phoneNumber, eventType);
            System.out.print("enter dinner choice for event");
            Scanner input = new Scanner(System.in);
            entree = input.nextInt();
            System.out.print("please enter entree choice :");
            sideDish1 = input.nextInt();
            System.out.print("please enter sidedish1 choice :");
            sideDish2 = input.nextInt();
            System.out.print("please enter sidedish2 choice :");
            dessert = input.nextInt();
            System.out.print("please enter dessert choice :");

            DinnerEvent adinnerEvent = new DinnerEvent(eventNum, guests, entree, sideDish1, sideDish2, dessert);

        }

        int options = 0;
        do {
            options = sortOption();
            while (options < 0 || options
                    > 3) {
                sortOption();
            }
            if (options
                    != 0) {

                if (options == 1) {
                    sortByEventNumber(eventArray);
                }
                if (options == 2) {
                    sortByeventType(eventArray);
                }
                if (options == 3) {
                    sortByguests(eventArray);
                }
                for (int x = 0; x < eventArray.length; x++) {
                    displayDetails(eventArray[x]);

                }
            }//methods to bubble sort array using 3 parameter
        } while (options != 0);

    }

    public static void sortByEventNumber(Event[] eventArray) {
        int a, b;
        Event temp;
        for (a = 0; a < eventArray.length - 1; a++) {
            for (b = 0; b < eventArray.length - 1; b++) {
                int results = eventArray[b].getEventNumber().compareTo(eventArray[b + 1].getEventNumber());
                if (results > 0) {
                    temp = eventArray[b];
                    eventArray[b] = eventArray[b + 1];
                    eventArray[b + 1] = temp;

                }
            }
        }
    }

    public static void sortByguests(Event[] eventArray) {
        int a, b;
        Event temp;
        for (a = 0; a < eventArray.length - 1; a++) {
            for (b = 0; b < eventArray.length - 1; b++) {
                if (eventArray[b].getGuests() > (eventArray[b + 1].getGuests())) {
                    temp = eventArray[b];
                    eventArray[b] = eventArray[b + 1];
                    eventArray[b + 1] = temp;

                }
            }
        }

    }

    public static void sortByeventType(Event[] eventArray) {
        int a, b;
        Event temp;
        for (a = 0; a < eventArray.length - 1; a++) {
            for (b = 0; b < eventArray.length - 1; b++) {
                int results = eventArray[b].getEventType().compareTo(eventArray[b + 1].getEventType());
                if (results > 0) {
                    temp = eventArray[b];
                    eventArray[b] = eventArray[b + 1];
                    eventArray[b + 1] = temp;

                }
            }
        }

    }

    public static int sortOption() {
        int options;
        Scanner input = new Scanner(System.in);
        System.out.print("\n enter Options 1= event number , 2= guests , 3= event type  or type QUIT ");
        options = input.nextInt();
        return options;
    }

    public static int getEventType() {
        int eventType;
        Scanner input = new Scanner(System.in);
        System.out.println("Select the type of event: " + "wedding(1), baptism(2), birthday(3), corporate(4), and other(5).>>");
        eventType = input.nextInt();
        return eventType;
    }

    public static String getPhoneNumber() {
        String phoneNumber;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter phone number >> ");
        phoneNumber = input.nextLine();
        return phoneNumber;
    }

    public static String getEventNumber() {
        String num;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter event number >> ");
        num = input.nextLine();
        return num;
    }

    public static int getGuests() {
        int guests;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of guests >> ");
        guests = input.nextInt();
        input.nextLine();
        return guests;
    }

    public static void displayDetails(Event e) {  //Change the constant price with the method
        System.out.println("\nEvent #" + e.getEventNumber());
        System.out.println("The price for an event with " + e.getGuests()
                + " guests at $" + e.getPricePerGuest() + " per guest is $" + e.getPrice());
        System.out.println("Phone number: " + e.getPhoneNumber());
        System.out.println("Event type: " + e.getEventType());
        System.out.println("Whether this is a large event is "
                + e.isLargeEvent()); //A new method using isLargeEvent.

    }
}
