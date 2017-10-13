package ajia.auditing;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import ajia.domain.Product;
import ajia.service.InventoryService;

@Aspect
@Configuration
@Order(200)
public class InventoryAuditAspect {

	@Pointcut("execution(* ajia.service.InventoryService.addProduct(ajia.domain.Product, int)) "
			+ "&& this(invService)"
			+ "&& args(product, quantity)")
	public void inventoryUpdate(InventoryService invService, Product product, int quantity) {}
	
//	@Around("inventoryUpdate(invService, product, quantity)")
//	public Object inventoryUpdateAudit(ProceedingJoinPoint pjp, InventoryService invService, Product product, int quantity) throws Throwable {
////		System.out.println( AopContext.currentProxy().getClass() );
//		
//		Object obj =  pjp.proceed();
//		
//		System.out.println("inventoryUpdateAudit, product: " + product.getName() + ", quantity: " + quantity);
//		
//		return obj;
//	}
	
	@After("inventoryUpdate(invService, product, quantity)")
	public void inventoryUpdateAudit(InventoryService invService, Product product, int quantity) throws Throwable {
		System.out.println("inventoryUpdateAudit, product: " + product.getName() + ", quantity: " + quantity);
	}
	
	
}
