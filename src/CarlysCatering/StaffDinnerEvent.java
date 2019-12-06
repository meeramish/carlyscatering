package CarlysCatering;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StaffDinnerEvent {

    public static Waitstaff getWaitstaff() {
        Scanner in = new Scanner(System.in);
        Waitstaff ws = new Waitstaff();
        System.out.print("Enter the Employee Number of the waitstaff you have selected >> ");
        ws.setEmployeeNumber(in.nextLine());
        System.out.print("Enter waitstaff's first name >> ");
        ws.setFirstName(in.nextLine());
        System.out.print("Enter waitstaff's last name >> ");
        ws.setLastName(in.nextLine());
        System.out.print("Enter waitstaff's pay rate >> ");
        ws.setPayRate(getPayRate());
        ws.setJobTitle();
        return ws;
    }

    public static double getPayRate() {
        double payrate = 0;
        boolean isInvalid = true;
        while (isInvalid) {
            try {
                Scanner in = new Scanner(System.in);
                System.out.println("Enter payrate in integer");
                double payRate = in.nextDouble();
                isInvalid = false;

            } catch (InputMismatchException e) {
                isInvalid = true;
                System.out.println("Invalid amount entered.");

            }

        }
        double payRate = 0;
        return payRate;
    }

    public static Bartender getBartender() {
        Scanner in = new Scanner(System.in);
        Bartender bt = new Bartender();
        System.out.print("Enter the Employee Number for the bartender you have selected >> ");
        bt.setEmployeeNumber(in.nextLine());
        System.out.print("Enter bartender's first name >> ");
        bt.setFirstName(in.nextLine());
        System.out.print("Enter bartender's last name >> ");
        bt.setLastName(in.nextLine());
        System.out.print("Enter bartender's pay rate >> ");
        bt.setPayRate(getPayRate());
        bt.setJobTitle();
        return bt;
    }

    public static Coordinator getCoordinator() {
        Scanner in = new Scanner(System.in);
        Coordinator co = new Coordinator();
        System.out.print("Enter the Employee Number for the coordinator you have selected >> ");
        co.setEmployeeNumber(in.nextLine());
        System.out.print("Enter coordinator's first name >> ");
        co.setFirstName(in.nextLine());
        System.out.print("Enter coordinator's last name >> ");
        co.setLastName(in.nextLine());
        System.out.print("Enter coordinator's pay rate >> ");
        co.setPayRate(getPayRate());
        co.setJobTitle();
        return co;
    }

    public static String getEventNumber() {
        String num;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your event number >> ");
        num = input.nextLine();
        return num;
    }

    public static int getGuests() {

        int guests = 0;
        final int Minimum = 5;
        final int Maximum = 100;
        boolean isInvalid = true;
        while (isInvalid) {

            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Enter the number of guests >> ");
                guests = input.nextInt();
                while (guests < Minimum || guests > Maximum) {
                    System.out.println("The number of guests must be between "
                            + Minimum + " and " + Maximum);
                    System.out.print("Please enter >> ");
                    guests = input.nextInt();
                }
                input.nextLine();
                isInvalid = false;
                return guests;
            } catch (InputMismatchException e) {
                isInvalid = true;
                System.out.println("Invalid entry, please enter the integer");
            }

        }
        return guests;
    }

    public static int getType() {
        int evType;
        Scanner input = new Scanner(System.in);
        System.out.println("Event types are as followed:");
        for (int x = 0; x < Event.EventTypes.length; ++x) {
            System.out.println("    " + x + " " + Event.EventTypes[x]);
        }
        System.out.print("Enter your event type >> ");
        evType = input.nextInt();
        return evType;
    }

    public static void displayDetails(DinnerEvent obj, int count) {
        Employee[] emps = new Employee[15];
        emps = obj.getEmps();
        System.out.println("\nEvent #" + obj.getEventNumber());
        System.out.println("The price your event with " + obj.getGuests()
                + " guests at $" + obj.getPricePerGuest() + " per guest is $" + obj.getPriceForEvent());
        System.out.println("Large event: "
                + (obj.getGuests() >= obj.LargeEvent));
        System.out.println("Your contact phone number is: " + obj.getContactPhNumber());
        System.out.println("This event " + obj.getEventType() + " which is the following type: " + obj.getEventTypeString());
        System.out.println("The menu includes " + obj.getMenu());
        System.out.println("\nThe staff includes:");
        for (int x = 0; x < count; ++x) {
            System.out.println(emps[x].getJobTitle() + emps[x].getEmployeeNumber() + " " + emps[x].getName() + " making " + emps[x].getPayRate() + " dollars an hour. ");
        }
    }

    public static DinnerEvent getLarger(DinnerEvent obj1, DinnerEvent obj2) {
        DinnerEvent larger = obj2;
        if (obj1.getGuests() >= obj2.getGuests()) {
            larger = obj1;
        }
        return larger;
    }

    public static void main(String[] args) {
        Employee[] emps = new Employee[15];
        String eventNum;
        int guests, count;
        DinnerEvent event;
        int y;
        int waitStaff, bartenders;
        int[] menuOption = new int[4];
        eventNum = getEventNumber();
        guests = getGuests();
        for (y = 0; y < menuOption.length; ++y) {
            menuOption[y] = getMenu(y);
        }
        event = new DinnerEvent(eventNum, guests, menuOption[0], menuOption[1], menuOption[2], menuOption[3]);
        event.setContactPhNumber(getPhone());
        event.setEventType(getType());
        waitStaff = guests / 10 + 1;
        for (count = 0; count < waitStaff; ++count) {
            emps[count] = getWaitstaff();
        }
        bartenders = guests / 25 + 1;
        for (; count < waitStaff + bartenders; ++count) {
            emps[count] = getBartender();
        }
        emps[count] = getCoordinator();
        event.setEmps(emps);
        ++count;

        System.out.println("\n****************Event Info********************");
        displayDetails(event, count);

    }
    
    

    public static String getPhone() {
        String phone;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your contact phone number >> ");
        phone = input.nextLine();
        return phone;
    }

    public static int getMenu(int y) {
        int choice;
        if (y == 0) {
            choice = displayEntreeMenu();
        } else if (y == 1 || y == 2) {
            choice = displaySidesMenu();
        } else {
            choice = displayDessertMenu();
        }
        return choice;
    }

    public static int displayEntreeMenu() {
        Scanner keyboard = new Scanner(System.in);
        int x;
        String choiceStr;
        int choice = 0;
        boolean isInvalid = true;
        while (isInvalid) {
            try {
                System.out.println("Please select from the following entrees:");
                for (x = 0; x < DinnerEvent.Entree.length; ++x) {
                    System.out.println(x + "  --  " + DinnerEvent.Entree[x]);
                }
                System.out.print("(Make your selection here)>> ");
                choiceStr = keyboard.nextLine();
                choice = Integer.parseInt(choiceStr);
                isInvalid = choice < 0 || choice > 3;

            } catch (NumberFormatException e) {
                isInvalid = true;
                System.out.println("Please enter valid number for entree menu");

            }
        }
        return choice;
    }

    public static int displaySidesMenu() {
        Scanner keyboard = new Scanner(System.in);
        int x;
        String choiceStr;
        int choice = 0;
        boolean isInvalid = true;
        while (isInvalid) {
            try {
                System.out.println("Please select from the following sides:");
                for (x = 0; x < DinnerEvent.SideDish.length; ++x) {
                    System.out.println(x + "  --  " + DinnerEvent.SideDish[x]);
                }
                System.out.print("(Make your selection here)>> ");
                choiceStr = keyboard.nextLine();
                choice = Integer.parseInt(choiceStr);
                isInvalid = choice < 0 || choice > 3;

            } catch (NumberFormatException e) {
                isInvalid = true;
                System.out.println("Please enter valid number for sidedish menu");

            }
        }
        return choice;
    }

    public static int displayDessertMenu() {
        Scanner keyboard = new Scanner(System.in);
        int x;
        int choice = 0;
        String choiceStr;
        boolean isInvalid = true;
        while (isInvalid) {
            try {
                System.out.println("Please select from the following desserts:");
                for (x = 0; x < DinnerEvent.Dessert.length; ++x) {
                    System.out.println(x + "  --  " + DinnerEvent.Dessert[x]);
                }
                System.out.print("(Make your selection here)>> ");
                choiceStr = keyboard.nextLine();
                choice = Integer.parseInt(choiceStr);
                isInvalid = choice < 0 || choice > 3;
            } catch (NumberFormatException e) {
                isInvalid = true;
                System.out.println("Please enter valid number for sidedish menu");

            }

        }
        return choice;
    }
}
