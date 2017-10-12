package ajia.main;

import java.lang.reflect.Proxy;

import ajia.domain.Product;
import ajia.proxy.TracingInvocationHandler;
import ajia.service.InventoryService;
import ajia.service.impl.InventoryServiceStubImpl;

public class Main {

	public static void main(String[] args) {
		InventoryService invService = new InventoryServiceStubImpl();
		
		InventoryService invServiceProxy = (InventoryService)Proxy.newProxyInstance(InventoryService.class.getClassLoader(), 
				new Class[] { InventoryService.class }, new TracingInvocationHandler(invService));
		Product ajiaBook = new Product("AJIA", "AspectJ in Action", 44.95);
		invServiceProxy.addProduct(ajiaBook, 1000000);
		invServiceProxy.removeProduct(ajiaBook, 1000000);
	}
	
}
