package unit_10_1.Warehouse;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Warehouse extends Remote {
	double getPrices(String description)throws RemoteException;
}
