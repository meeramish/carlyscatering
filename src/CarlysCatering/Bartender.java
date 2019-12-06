/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarlysCatering;



public class Bartender extends Employee {
    public final static double PAY_RATE = 14.00;

    public void setPayRate(double pay) {
        if (pay > PAY_RATE) {
            payRate = PAY_RATE;
        } else {
            payRate = pay;
        }
    }

    public void setJobTitle() {
        jobTitle = "bartender";
    }
}

