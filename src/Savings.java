public class Savings extends Account{
    private float depositIntrate = 10;
    public Savings(String name, int initDeposit){
            super(name,initDeposit);
    }
    @Override
    public float getDepositIntrate() {
        return depositIntrate;
    }
    @Override
    void withdraw(float amount) {
        if((this.balance - amount) < 1000)
            throw new NullPointerException("Invalid transaction; current balance " + this.balance);
        else
            this.balance -= amount;
    }

    @Override
    void requestLoan(float amount) {
        if(amount<=10000) {
            requestedLoan += amount;
            System.out.println("Loan request successful, sent for approval");
        }
        else
            throw new NullPointerException("The maximum allowable loan for Savings account is 10000$");
    }


}
