abstract class Employee{
    public float lookup(Account acc){
        return acc.queryDeposit();
    }
    abstract void approveLoan();
    abstract void changeInterestRate();
    abstract void seeInternalFund();
}
