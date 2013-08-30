package unit_10_4.WarehouseClient;

import java.rmi.RemoteException;
import java.util.Enumeration;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingException;

import unit_10_1.Warehouse.Warehouse;

public class WarehouseClient 
{
	public static void main(String[] args) throws NamingException,RemoteException
	{
		Context namingContext = new InitialContext();
		
		System.out.print("RMI registry bindings:");
		Enumeration<NameClassPair> e = namingContext.list("rmi://localhost/");
		while(e.hasMoreElements())
			System.out.println(e.nextElement().getName());
		
		String url = "rmi://localhost/central_warehouse";
		Warehouse centralWarehouse = (Warehouse)namingContext.lookup(url);
		
		String descr = "Blackwell Toaster";
		double price = centralWarehouse.getPrices(descr);
		System.out.println(descr + ": " + price);
	}
}
