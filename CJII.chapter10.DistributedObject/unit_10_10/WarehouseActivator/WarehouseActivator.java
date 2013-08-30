package unit_10_10.WarehouseActivator;

import java.io.File;
import java.io.IOException;
import java.rmi.MarshalledObject;
import java.rmi.RemoteException;
import java.rmi.activation.Activatable;
import java.rmi.activation.ActivationDesc;
import java.rmi.activation.ActivationException;
import java.rmi.activation.ActivationGroup;
import java.rmi.activation.ActivationGroupDesc;
import java.rmi.activation.ActivationGroupID;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import unit_10_5.Warehouse.Warehouse;

public class WarehouseActivator 
{
	public static void main(String[] args) throws RemoteException,NamingException,ActivationException,IOException
	{
		System.out.println("Constructing activation descriptors...");
		Properties props = new Properties();
        //use the server.policy file in the current directory
		props.put("java.security.policy", new File("server.policy").getCanonicalPath());
		ActivationGroupDesc group = new ActivationGroupDesc(props,null);
		ActivationGroupID id = ActivationGroup.getSystem().registerGroup(group);
		
		Map<String,Double>prices = new HashMap<String,Double>();
		prices.put("Blackwell Toaster", 24.59);
		prices.put("ZapXpress Microwave Oven", 49.95);
		
		MarshalledObject<Map<String,Double>> param = new MarshalledObject<Map<String,Double>>(prices);
		
		String codebase = "http://localhost:8080/";
		
		ActivationDesc desc = new ActivationDesc(id,"WarehouseImpl",codebase,param);
		
		Warehouse centralWarehouse = (Warehouse)Activatable.register(desc);
		
		System.out.println("Binding activable implementation to registry...");
		Context namingContext = new InitialContext();
		namingContext.bind("rmi:central_warehouse", centralWarehouse);
		System.out.println("Exiting...");
	}
}
