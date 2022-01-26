public class Cashier extends Employee{


    @Override
    void approveLoan() {
        throw new NullPointerException("You don’t have permission for this operation");
    }

    @Override
    void changeInterestRate() {
        throw new NullPointerException("You don’t have permission for this operation");
    }

    @Override
    void seeInternalFund() {
        throw new NullPointerException("You don’t have permission for this operation");
    }
}
