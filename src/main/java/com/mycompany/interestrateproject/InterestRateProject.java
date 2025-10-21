/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.interestrateproject;

/**
 *
 * @author llujan2027
 */
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
public class InterestRateProject {

    public static void main(String[] args) {
        //Money formatter
        NumberFormat $fmt = NumberFormat.getCurrencyInstance(Locale.US);
        //Scanner
        Scanner scan = new Scanner(System.in);
        
        //Recieving the principal and the months
        System.out.println("Welcome. Please input loan amount in $ (only numbers"
                + ", no commas).");
        double loanAmount = scan.nextDouble();
        System.out.println("Please input number of months for repayment.");
        int monthsLeft = scan.nextInt();
        
        //Object creation
        InterestRateCalculator Loan1 = 
                new InterestRateCalculator(loanAmount, monthsLeft);
        
        /*running the program that defines how much debt there is and how much
        of it is repaid per month*/
        Loan1.paymentPerMonth();
        
        //Displaying the info for the banker
        System.out.println("You are borrowing "+$fmt.format(Loan1.getPrincipal())+"."
                + "\nYou will be repaying "+$fmt.format(Loan1.getMonthly())+" each"
                + " month for "+Loan1.getMonths()+" months." + "\nYou will be "
                + "repaying "+$fmt.format(Loan1.getDebt())+" total.");
    }
}
/*NOTE: Compound interest is P(1+(r/n))^nt
P = principal (starting money
r = RATE (annual interest rate)
n = times per year interest is compounded 
        (monthly compound, so 12)
t = years passed*/

class InterestRateCalculator{
    //Publicly visible constant rate of 8% (+1 for easier calculations)
    public final double RATE = 1.08;
    //Base amount the user inputs
    private double principal = 0;
    //amount of months to repay loan
    private int months = 0;
    //Amount of money to be paid back
    private double debt = 0;
    //amount of money to pay back each month
    private double perMonth = 0;
    
    //Object constructor
    public InterestRateCalculator(double loanAmount, int monthsLeft){
        this.principal = loanAmount;
        this.months = monthsLeft;
    }
    
    //our primary method
    public double paymentPerMonth(){
        double monthly = (principal/months);
        perMonth = monthly*RATE;
        debt = perMonth*months;
        return monthly;
    }
    
    //Getters, nothing special
    public double getPrincipal(){
        return principal;
    }
    
    public int getMonths(){
        return months;
    }
    
    public double getDebt(){
        return debt;
    }
    
    public double getMonthly(){
        return perMonth;
    }
    
    //toString 
    @Override
    public String toString(){
        NumberFormat $fmt = NumberFormat.getCurrencyInstance(Locale.US);
        return "Rate: "+RATE+" Principal: "+$fmt.format(principal)+" Months: "
                +months+" Debt:"+debt;
    }
}