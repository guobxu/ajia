package ajia.service.impl;

import org.springframework.stereotype.Service;

import ajia.domain.Product;
import ajia.service.InventoryService;

@Service("inventoryService")
public class InventoryServiceImpl implements InventoryService {

	@Override
	public void addProduct(Product product, int quantity) {
		System.out.println("addProduct, product: " + product.getName() + ", quantity: " + quantity);
	}

}
