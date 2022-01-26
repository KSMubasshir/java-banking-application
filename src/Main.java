import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Boolean isEmployee;
        ArrayList<String> employeeNames = new ArrayList<>();
        employeeNames.add("MD"); employeeNames.add("S1"); employeeNames.add("S2");
        employeeNames.add("C1"); employeeNames.add("C2"); employeeNames.add("C3"); employeeNames.add("C4"); employeeNames.add("C5");
        String input, command, name;
        Bank bank = new Bank();
        Scanner scn = new Scanner(System.in);
        StringTokenizer stringTokenizer;
        while(true){
            input = scn.nextLine();
            stringTokenizer = new StringTokenizer(input);
            command = stringTokenizer.nextToken();
            if(command.equalsIgnoreCase("Create")){
                name = stringTokenizer.nextToken();
                try{
                    bank.createAccount(name , stringTokenizer.nextToken(),
                            Integer.parseInt(stringTokenizer.nextToken()));
                }
                catch (NullPointerException e){
                    System.out.println(e.getMessage());
                    continue;
                }

                while(true) {
                    input = scn.nextLine();
                    stringTokenizer = new StringTokenizer(input);
                    command = stringTokenizer.nextToken();
                    if(command.equalsIgnoreCase("Close")){
                        System.out.println("Transaction Closed for " + name);
                        break;
                    }
                    else if(command.equalsIgnoreCase("Deposit")){
                        try {
                            bank.deposit(name, Integer.parseInt(stringTokenizer.nextToken()));
                        }
                        catch (NullPointerException e){
                            System.out.println(e.getMessage());
                            continue;
                        }

                    }
                    else if(command.equalsIgnoreCase("Withdraw")){
                        try{
                            float amount = Integer.parseInt(stringTokenizer.nextToken());
                            bank.withdraw(name, amount);
                            System.out.println(amount + "$ withdrawn");
                        }
                        catch (NullPointerException e){
                            System.out.println(e.getMessage());
                            continue;
                        }

                    }
                    else if(command.equalsIgnoreCase("Query")){
                        bank.queryDeposit(name);
                    }
                    else if(command.equalsIgnoreCase("Request")){
                        try{
                            bank.requestLoan(name, Integer.parseInt(stringTokenizer.nextToken()) );
                        }
                        catch (NullPointerException e){
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
            else if(command.equalsIgnoreCase("Open")){
                name = stringTokenizer.nextToken();
                isEmployee = employeeNames.contains(name);
                if(isEmployee) {
                    System.out.print(name + " active, ");
                    if(bank.hasLoanRequests())
                        System.out.println("there are loan approvals pending");
                    else
                        System.out.println("No pending loan requests");
                }
                else{
                    if(bank.accExists(name)){
                        System.out.println("Welcome back, " + name);
                    }
                    else {
                        System.out.println("Account doesn't exist");
                        continue;
                    }
                }

                while(true) {
                    input = scn.nextLine();
                    stringTokenizer = new StringTokenizer(input);
                    command = stringTokenizer.nextToken();
                    if(command.equalsIgnoreCase("Close")){
                        if(isEmployee)
                            System.out.println("Operations for " + name + " closed");
                        else
                            System.out.println("Transaction Closed for " + name);
                        break;
                    }

                    else if (command.equalsIgnoreCase("Approve")) {
                        try{
                            bank.approveLoan(name);
                        }
                        catch (NullPointerException e){
                            System.out.println(e.getMessage());
                            continue;
                        }

                    } else if (command.equalsIgnoreCase("Change")) {
                        try{
                            bank.changeInterestRate(name, stringTokenizer.nextToken(), Float.parseFloat(stringTokenizer.nextToken()));
                        }
                        catch (NullPointerException e){
                            System.out.println(e.getMessage());
                            continue;
                        }

                    } else if (command.equalsIgnoreCase("Lookup")) {
                        bank.lookup(name, stringTokenizer.nextToken());
                    } else if (command.equalsIgnoreCase("See")) {
                        try{
                            bank.seeInternalFund(name);
                        }
                        catch (NullPointerException e){
                            System.out.println(e.getMessage());
                            continue;
                        }

                    }
                    else if(command.equalsIgnoreCase("Deposit")){
                        try {
                            bank.deposit(name, Integer.parseInt(stringTokenizer.nextToken()));
                        }
                        catch (NullPointerException e){
                            System.out.println(e.getMessage());
                            continue;
                        }
                    }
                    else if(command.equalsIgnoreCase("Withdraw")){
                        try{
                            float amount = Integer.parseInt(stringTokenizer.nextToken());
                            bank.withdraw(name, amount);
                            System.out.println(amount + "$ withdrawn");
                        }
                        catch (NullPointerException e){
                            System.out.println(e.getMessage());
                            continue;
                        }
                    }
                    else if(command.equalsIgnoreCase("Query")){
                        bank.queryDeposit(name);
                    }
                    else if(command.equalsIgnoreCase("Request")){
                        try{
                            bank.requestLoan(name, Integer.parseInt(stringTokenizer.nextToken()) );
                        }
                        catch(NullPointerException e){
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
            else if(command.equalsIgnoreCase("INC")){
                bank.inc();
            }
        }
    }
}
