public class Student extends Account{
    private float depositIntrate = 5;
    public Student(String name, int initDeposit){
        super(name,initDeposit);
    }

    @Override
    public float getDepositIntrate() {
        return depositIntrate;
    }

    @Override
    void withdraw(float amount) {
        if((this.balance - amount) < 0)
            throw new NullPointerException("Invalid transaction; current balance " + this.balance);
        else if(amount>10000)
            throw new NullPointerException("Invalid transaction; can not withdraw more than 10000$");
        else
            this.balance -= amount;
    }

    @Override
    void requestLoan(float amount) {
        if(amount<=1000){
            requestedLoan += amount;
            System.out.println("Loan request successful, sent for approval");
        }
        else
            throw new NullPointerException("The maximum allowable loan for Student account is 1000$");
    }


}
