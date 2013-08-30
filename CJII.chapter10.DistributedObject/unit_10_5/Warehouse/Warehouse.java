package unit_10_5.Warehouse;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import unit_10_6.Product.Product;

public interface Warehouse extends Remote {
	double getPrice(String description) throws RemoteException;
	Product getProduct(List<String> keywords) throws RemoteException;
}
