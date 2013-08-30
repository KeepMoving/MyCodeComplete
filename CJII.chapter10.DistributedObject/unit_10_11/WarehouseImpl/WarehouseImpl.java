package unit_10_11.WarehouseImpl;

import java.io.IOException;
import java.rmi.MarshalledObject;
import java.rmi.RemoteException;
import java.rmi.activation.Activatable;
import java.rmi.activation.ActivationID;
import java.util.List;
import java.util.Map;

import unit_10_5.Warehouse.Warehouse;
import unit_10_6.Product.Product;

public class WarehouseImpl extends Activatable implements Warehouse 
{
	public WarehouseImpl(ActivationID id,MarshalledObject<Map<String,Double>>param) throws RemoteException,ClassNotFoundException,IOException
	{
		super(id,0);
		prices = param.get();
		System.out.println("Warehouse implementation constrcted.");
	}
	
	public double getPrice(String description) throws RemoteException {
		Double price = prices.get(description);
		return price == null?0:price;
	}

	public Product getProduct(List<String> keywords) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	private Map<String,Double> prices;
}
