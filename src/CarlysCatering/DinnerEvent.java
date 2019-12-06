/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarlysCatering;



class DinnerEvent extends Event {
    public final static String[] Entree = {"Baked beans", "Tomato Curry", "Stuffed bread", "Roast eggplant"};
    public final static String[] SideDish = {"Greens", "Corn", "String Beans", "Salad"};
    public final static String[] Dessert = {"Sweet Potato Pie", "Apple Pie", "Bread Pudding"};
    private int entreeChoice, sideChoice1, sideChoice2, dessertChoice;
    Employee[] empArray = new Employee[15];

    public DinnerEvent(String num, int guests, int choice1, int choice2, int choice3, int choice4) {
        super(num, guests);
        if (choice1 < Entree.length) {
            entreeChoice = choice1;
        } else {
            entreeChoice = 0;
        }
        if (choice2 < SideDish.length) {
            sideChoice1 = choice2;
        } else {
            sideChoice1 = 0;
        }
        if (choice3 < Entree.length) {
            sideChoice2 = choice3;
        } else {
            sideChoice2 = 0;
        }
        if (choice4 < Dessert.length) {
            dessertChoice = choice4;
        } else {
            dessertChoice = 0;
        }
    }

    public Employee[] getEmps() {
        return empArray;
    }

    public void setEmps(Employee[] staff) {
        empArray = staff;
    }

    public String getMenu() {
        String menu = Entree[entreeChoice] + ", " + SideDish[sideChoice1] + ", " + SideDish[sideChoice2] + ", and " + Dessert[dessertChoice];
        return menu;
    }

}
