public class FixedDeposit extends Account{
    private float depositIntrate = 15;
    public FixedDeposit(String name, float initDeposit){
        super(name, initDeposit);
        if(initDeposit<100000)
            throw new NullPointerException("Initial Deposit for a Fixed Deposit Account must be greater or equal to 100000$");
    }
    @Override
    public float getDepositIntrate() {
        return depositIntrate;
    }
    @Override
    public void deposit(float amount) {
        if(amount>=50000)
            super.deposit(amount);
        else
            throw new NullPointerException("Deposit for a Fixed Deposit Account must be greater or equal to 50000$");
    }

    @Override
    void withdraw(float amount) {
        if(accAge<1){
            throw new NullPointerException("Invalid transaction; Account maturity less than 1 year");
        }
        else if((this.balance - amount) < 0)
            throw new NullPointerException("Invalid transaction; current balance " + this.balance);
        else
            this.balance -= amount;
    }

    @Override
    void requestLoan(float amount) {
        if(amount<=100000){
            requestedLoan += amount;
            System.out.println("Loan request successful, sent for approval");
        }
        else
            throw new NullPointerException("The maximum allowable loan for Fixed Deposit account is 100000$");
    }


}
