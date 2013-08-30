package unit_10_2.WarehouseImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import unit_10_1.Warehouse.Warehouse;

public class WarehouseImpl extends UnicastRemoteObject implements Warehouse {

	public WarehouseImpl()throws RemoteException 
	{
		prices = new HashMap<String,Double>();
		prices.put("Blackwell Toaster", 24.95);
		prices.put("ZapXpress Microwave Oven", 49.95);
	}
	
	public double getPrices(String description)throws RemoteException
	{
		Double price = prices.get(description);
		return price == null?0:price;
	}
	
	private Map<String,Double>prices;
}
