public abstract class Account{
    protected String name;
    protected float balance;
    protected  int accAge;
    protected float loanBalance;
    protected float requestedLoan;
    protected float interestRate;
    public Account(String name, float initDeposit){
        this.name = name;
        balance = initDeposit;
        loanBalance = 0;
        requestedLoan = 0;
        interestRate = 10;
    }
    public void setLoanBalance(int loanBalance) {
        this.loanBalance = loanBalance;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public float getRequestedLoan() {
        return requestedLoan;
    }

    public float getLoanBalance() {
        return loanBalance;
    }
    public void setAccAge(int age){
        accAge = age;
    }
    public int getAccAge() {
        return accAge;
    }
    public String getName(){
        return name;
    }
    public void deposit(float amount){
        this.balance += amount;
    }
    public void depositInterest(float amount){
        this.balance += amount;
    }
    public void deductInterest(float amount){
        this.balance -= amount;
    }
    public void depositLoan(float amount){
        this.loanBalance += amount;
        this.requestedLoan -= amount;
    }
    abstract void withdraw(float amount);
    abstract void requestLoan(float amount);
    public float queryDeposit(){
        return balance + loanBalance ;
    }
    abstract float getDepositIntrate();
}
