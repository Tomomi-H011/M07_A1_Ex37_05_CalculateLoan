/*
* Assignment: SDEV200_M07_A1_Ex37_05
* File: CalculateLoanPayment.java
* Version: 1.0
* Date: 2/28/2024
* Author: Tomomi Hobara
* Description: This program calculates the monthly and total payments
                based on user input for a loan amount, an annual interest rate,
*               and the number of years.
* Variables: 
    - loanAmount: double, entered by user 
    - annualInterestRate: double, entered by user
    - numberOfYears: int, entered by user
    - monthlyPayment: double, calculated by getMonthlyPayment method from the Loan class
    - totalPayment: double, calculated by getTotalPayment method from the Loan class
* Steps:
    1. Accept user input for the loan amount, annualInterestRate, and numberOfYears
        through the HTML form.
    2. Receive the user input through the servelet's doGet method and process the input
        with the processRequest method.
    3. Create an instance of the Loan class.
    4. Compute the monthly payment and total payments.
    5. Display the calculation results.
*/

package M07_A1_Ex37_05;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CalculateLoanPayment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            // Get parameters as strings
            String loanAmountString = request.getParameter("loanAmount");
            String annualInterestRateString = request.getParameter("annualInterestRate");
            String numberOfYearsString = request.getParameter("numberOfYears");

            // Convert the string to double or int
            double loanAmount = Double.parseDouble(loanAmountString);
            double annualInterestRate = Double.parseDouble(annualInterestRateString);
            int numberOfYears = Integer.parseInt(numberOfYearsString);
            
            // Create an instance of the Loan class
            Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);
            
            // Call the getMonthlyPayment and getTotalPayment methods
            double monthlyPayment = loan.getMonthlyPayment();
            double totalPayment = loan.getTotalPayment();
           
            // Display the output
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            out.println("<h3> Loan Amount: " + loanAmount+ "</h3><br>");
            out.println("<h3> Annual Interest Rate: " + annualInterestRate + "</h3><br>");
            out.println("<h3> Number of Years: " + numberOfYears + "</h3><br>");
            out.println("<h3> Monthly Payment: " + monthlyPayment+ "</h3><br>");
            out.println("<h3> Total Payment: " + totalPayment+ "</h3><br>");
            out.println("</body>");
            out.println("</html>");
        } 
        catch (Exception ex) {
           System.out.println(ex);
        }
    }
}