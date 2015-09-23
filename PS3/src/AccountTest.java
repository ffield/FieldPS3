import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class AccountTest {
	
		Account c;
		
		@Before
		public void setUp() throws Exception 
		{
			c = new Account(1122, 20000.0, .045);
		}
		
		@After
		public void tearDown() throws Exception
		{
			c = null;
		
		}

		@Test
		public final void testWithdraw() throws InsufficientFundsException
		{
			double balanceBeforeWithdraw = c.getBalance();
			c.withdraw(2500);
			double balanceAfterWithdraw = c.getBalance();
			assertEquals(balanceBeforeWithdraw, balanceAfterWithdraw, 20000 - 2500);
		}
		
		@Test
		public final void testDeposit()
		{
			double balanceBeforeDeposit = c.getBalance();
			c.deposit(3000);
			double balanceAfterDeposit = c.getBalance();
			assertEquals(balanceBeforeDeposit, balanceAfterDeposit, 3000);
			
		}
		
		@Test(expected = InsufficientFundsException.class)
		public final void testOverDraw() throws InsufficientFundsException
		{
			c.withdraw(21000);	
		}
		
		@Test
		public final void testMonthlyInterest()
		{
			double monthly = c.getMonthlyInterestRate();
			double annual = c.getAnnualInterestRate();
			assertEquals(monthly==annual/12,annual==monthly*12);
		}
		
		@Test
		public void printInfo()
		{
			System.out.printf("The balance is $%.2f",c.getBalance());
			System.out.printf("\nThe montly interest rate is %f \n",c.getMonthlyInterestRate());
			System.out.println(c.getDateCreated());
		}
		
		
}
