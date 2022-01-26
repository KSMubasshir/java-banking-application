import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class Bank {
    private Account temp;
    private int Balance;
    private int year;
    private Employee MD, O1, O2, C1, C2, C3, C4, C5;
    private ArrayList<Account> accounts;
    private ArrayList<Account> loanRequests;
    public Bank(){
        accounts = new ArrayList<Account>();
        loanRequests = new ArrayList<Account>();
        MD = new ManagingDirector();
        O1 = new Officer(); O2 = new Officer();
        C1 = new Cashier(); C2 = new Cashier(); C3 = new Cashier();
        C4 = new Cashier(); C5 = new Cashier();
        Balance = 1000000;
        year = 0;
        System.out.println("Bank Created; MD, S1 , S2 , C1 , C2 , C3 , C4 , C5 created");
    }
    public void createAccount(String name, String type, int initDeposit){
        for(Account d : accounts){
            if(d.getName() != null && d.getName().contains(name)) {
                throw new NullPointerException(name + " already exists");
            }
        }
        if(type.equalsIgnoreCase("Student")) {
            temp = new Student(name,initDeposit);
        }
        else if(type.equalsIgnoreCase("Savings")) {
            temp = new Savings(name,initDeposit);
        }
        else if(type.equalsIgnoreCase("FixedDeposit")) {
            temp = new FixedDeposit(name,initDeposit);
        }
        if(temp != null) {
            temp.setAccAge(0);
            accounts.add(temp);
            Balance += initDeposit;
            System.out.println(type + " account for " + name + " Created; initial balance " + initDeposit + "$");
        }
    }
    public void deposit(String name, int amount){
        for(Account d : accounts){
            if(d.getName() != null && d.getName().contains(name)) {
                d.deposit(amount);
                Balance += amount;
                System.out.println(amount + "$ deposited; current balance" + d.queryDeposit() +  "$");
            }
        }
    }
    public void withdraw(String name, float amount){
        for(Account d : accounts){
            if(d.getName() != null && d.getName().contains(name))
                try{
                    d.withdraw(amount);
                    Balance -= amount;
                }
            catch (NullPointerException e){
                throw e;
            }

        }
    }
    public void requestLoan(String name, int amount){
        for(Account d : accounts){
            if(d.getName() != null && d.getName().contains(name))
                try {
                    d.requestLoan(amount);
                    loanRequests.add(d);
                }
            catch (NullPointerException e){
                throw e;
            }
        }
    }
    public void queryDeposit(String name){
        for(Account d : accounts){
            if(d.getName() != null && d.getName().contains(name))
                System.out.println("Current balance " + d.queryDeposit() + "$, loan " + d.getLoanBalance() + "$");
        }
    }
    public void lookup(String empName, String accName){
        for(Account d : accounts){
            if(d.getName() != null && d.getName().contains(accName)) {
                System.out.println(accName + "'s Current balance is " + d.queryDeposit() + "$");
                return;
            }
        }
        System.out.println("Account doesn't exist");
    }
    public void loanApprovalRoutine(){
        if(hasLoanRequests()){
            for(Account d : loanRequests) {
                if (d.getName() != null) {
                    d.depositLoan(d.getRequestedLoan());
                    Balance -= d.getRequestedLoan();
                    System.out.println("Loan for " + d.getName() + " approved");
                }
            }
        }
        else
            System.out.println("No Loans to Approve");
    }
    public void approveLoan(String name){
        switch (name){
            case "MD":
                MD.approveLoan();
                loanApprovalRoutine();
                break;
            case "S1":
                O1.approveLoan();
                loanApprovalRoutine();
                break;
            case "S2":
                O2.approveLoan();
                loanApprovalRoutine();
                break;
            case "C1":
                C1.approveLoan();
                loanApprovalRoutine();
                break;
            case "C2":
                C2.approveLoan();
                loanApprovalRoutine();
                break;
            case "C3":
                C3.approveLoan();
                loanApprovalRoutine();
                break;
            case "C4":
                C4.approveLoan();
                loanApprovalRoutine();
                break;
            case "C5":
                C5.approveLoan();
                loanApprovalRoutine();
                break;
        }
    }
    public void intRateSetRoutine(String accType, float intRate){
        for(Account d : accounts){
            if(accType.equalsIgnoreCase("Student")) {
                if(d.getName() != null && Student.class.isInstance(d)) {
                    d.setInterestRate(intRate);
                }
            }
            else if(accType.equalsIgnoreCase("Savings")) {
                if(d.getName() != null && Savings.class.isInstance(d)) {
                    d.setInterestRate(intRate);
                }
            }
            else if(accType.equalsIgnoreCase("FixedDeposit")) {
                if(d.getName() != null && FixedDeposit.class.isInstance(d)) {
                    d.setInterestRate(intRate);
                }
            }
        }
    }
    public void changeInterestRate(String name, String accType, Float intRate){
        switch (name){
            case "MD":
                MD.changeInterestRate();
                intRateSetRoutine(accType,intRate);
                System.out.println("Interst Rate Changed for all " + accType + " accounts");
                break;
            case "S1":
                O1.changeInterestRate();
                intRateSetRoutine(accType,intRate);
                System.out.println("Interst Rate Changed for all " + accType + " accounts");
                break;
            case "S2":
                O2.changeInterestRate();
                intRateSetRoutine(accType,intRate);
                System.out.println("Interst Rate Changed for all " + accType + " accounts");
                break;
            case "C1":
                C1.changeInterestRate();
                intRateSetRoutine(accType,intRate);
                System.out.println("Interst Rate Changed for all " + accType + " accounts");
                break;
            case "C2":
                C2.changeInterestRate();
                intRateSetRoutine(accType,intRate);
                System.out.println("Interst Rate Changed for all " + accType + " accounts");
                break;
            case "C3":
                C3.changeInterestRate();
                intRateSetRoutine(accType,intRate);
                System.out.println("Interst Rate Changed for all " + accType + " accounts");
                break;
            case "C4":
                C4.changeInterestRate();
                intRateSetRoutine(accType,intRate);
                System.out.println("Interst Rate Changed for all " + accType + " accounts");
                break;
            case "C5":
                C5.changeInterestRate();
                intRateSetRoutine(accType,intRate);
                System.out.println("Interst Rate Changed for all " + accType + " accounts");
                break;
        }
    }
    public void seeInternalFund(String name){
        switch (name){
            case "MD":
                MD.seeInternalFund();
                System.out.println("Current Internal Fund " + Balance + "$");
                break;
            case "S1":
                O1.seeInternalFund();
                System.out.println("Current Internal Fund " + Balance + "$");
                break;
            case "S2":
                O2.seeInternalFund();
                System.out.println("Current Internal Fund " + Balance + "$");
                break;
            case "C1":
                C1.seeInternalFund();
                System.out.println("Current Internal Fund " + Balance + "$");
                break;
            case "C2":
                C2.seeInternalFund();
                System.out.println("Current Internal Fund " + Balance + "$");
                break;
            case "C3":
                C3.seeInternalFund();
                System.out.println("Current Internal Fund " + Balance + "$");
                break;
            case "C4":
                C4.seeInternalFund();
                System.out.println("Current Internal Fund " + Balance + "$");
                break;
            case "C5":
                C5.seeInternalFund();
                System.out.println("Current Internal Fund " + Balance + "$");
                break;
        }
    }
    public void inc(){
        year++;
        for(Account d : accounts){
            if(d.getName() != null ) {
                d.setAccAge(d.getAccAge() + 1);
                d.depositInterest(d.queryDeposit()*(d.getDepositIntrate()/100));
                d.deductInterest(d.getLoanBalance()*(d.getInterestRate()/100));
                Balance -= d.queryDeposit()*(d.getDepositIntrate()/100);
                Balance += d.getLoanBalance()*(d.getInterestRate()/100);
            }
        }
        System.out.println("1 year passed");
    }
    public boolean accExists(String name){
        for(Account d : accounts){
            if(d.getName() != null && d.getName().contains(name))
                return true;
        }
        return false;
    }
    public boolean hasLoanRequests(){
        return loanRequests.size() > 0;
    }
}
