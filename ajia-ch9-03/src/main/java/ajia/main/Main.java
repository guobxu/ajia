package ajia.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import ajia.domain.Product;
import ajia.service.InventoryService;

@SpringBootApplication
@ComponentScan(basePackages = {
		"ajia.service.impl",
		"ajia.auditing", 
})
@EnableAspectJAutoProxy(exposeProxy = true)
public class Main {

	public static void main(String[] args) throws Exception {
		ApplicationContext appContext = SpringApplication.run(Main.class, args);
		
		InventoryService invService = (InventoryService)appContext.getBean("inventoryService");
		
		Product ajiaBook = new Product(1, "AJIA", "SKU09879035");
		invService.addProduct(ajiaBook, 6000);
	}
	
}
