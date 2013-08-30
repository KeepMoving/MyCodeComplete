package unit_10_3.WarehouseServer;

import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import unit_10_2.WarehouseImpl.WarehouseImpl;

public class WarehouseServer 
{
	public static void main(String[] args) throws RemoteException,NamingException
	{
		System.out.println("Constructing server implementation...");
		WarehouseImpl centralWarehouse = new WarehouseImpl();
		
		System.out.println("Binding server implementation to registry...");
		Context namingContext = new InitialContext();
		namingContext.bind("rmi:central_warehouse", centralWarehouse);
		
		System.out.println("Waiting for invocation from clients...");
	}

}
