import java.util.Date;
public class Account {
	private int  id = 0;
	private double balance = 0;
	private double annualInterestRate;
	private Date dateCreated = new Date();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}
	
	public Account()
	{
	}
	
	public Account(int id, double balance, double annualInterestRate)
	{
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}
	
	public void deposit(double amount)
	{
		balance += amount;
	}
	
	public void withdraw(double amount) throws InsufficientFundsException
	
	{
		if (amount <= balance)
		{
			balance -= amount;
		}
		else
		{
			double required = amount - balance;
			System.out.printf("Not enough money in account. $%6.2f is required to withdraw this much",required);
			throw new InsufficientFundsException(required);
		}
		
	}
	
	public double getMonthlyInterestRate()
	{
		return annualInterestRate/12;
	}
	

}

