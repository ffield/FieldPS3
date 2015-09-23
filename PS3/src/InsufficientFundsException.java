
public class InsufficientFundsException extends Exception
{
	private double amount;
public double getAmount() 
	{
		return amount;
	}
	
	
public InsufficientFundsException(double amount)
	{
		this.amount = amount;
		
	}
}
