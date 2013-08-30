package unit_14_8.synchBankTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank 
{
	public Bank(int n,double initialBalance)
	{
		accounts = new double[n];
		for(int i = 0;i<accounts.length;i++)
			accounts[i] = initialBalance;
		bankLock = new ReentrantLock();
		sufficientFunds = bankLock.newCondition();
	}
	
	public void transfer(int from,int to,double amount)throws InterruptedException
	{
		try {
			bankLock.lock();
			while(accounts[from]<amount)
				sufficientFunds.await();
			System.out.println(Thread.currentThread());
			accounts[from] -= amount;
			System.out.printf(" %10.2f from %d to %d",amount,from,to);
			accounts[to] += amount;
			System.out.printf(" Total Balance:%10.2f%n",getTotalBalance());
			sufficientFunds.signalAll();
		} finally {
			bankLock.unlock();
		}
	}
	
	public double getTotalBalance()
	{
		try {
			bankLock.lock();
			double sum = 0;
			for(double a : accounts)
				sum += a;
			
			return sum;
		} finally {
			bankLock.unlock();
		}
	}
	
	public int size()
	{
		return accounts.length;
	}
	
	private final double[] accounts;
	private Lock bankLock;
	private Condition sufficientFunds;
}
