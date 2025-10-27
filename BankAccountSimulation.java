import java.util.ArrayList;

class Account {
    protected String accountHolder;
    protected double balance;
    protected ArrayList<String> transactions = new ArrayList<>();

    public Account(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: ₹" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add("Withdrawn: ₹" + amount);
        } else {
            transactions.add("Failed withdrawal attempt: ₹" + amount);
            System.out.println("Insufficient balance!");
        }
    }

    public void showBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void showTransactions() {
        System.out.println("Transaction History:");
        for (String t : transactions) {
            System.out.println(t);
        }
    }
}

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountHolder, double balance, double interestRate) {
        super(accountHolder, balance);
        this.interestRate = interestRate;
    }

    // Overriding method
    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add("Withdrawn from Savings: ₹" + amount);
        } else {
            transactions.add("Failed withdrawal from Savings: ₹" + amount);
            System.out.println("Insufficient funds in Savings Account!");
        }
    }

    public void addInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        transactions.add("Interest added: ₹" + interest);
    }
}

public class BankAccountSimulation {
    public static void main(String[] args) {
        SavingsAccount acc = new SavingsAccount("Kamalpreet Singh", 5000, 5);

        acc.deposit(2000);
        acc.withdraw(1000);
        acc.addInterest();

        acc.showBalance();
        acc.showTransactions();
    }
}
