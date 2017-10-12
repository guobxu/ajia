package ajia.auditing;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import ajia.domain.Product;
import ajia.service.InventoryService;

@Aspect
@Configuration
@Order(6)
public class ProductAuditAspect {

	@Pointcut("execution(* ajia.service.InventoryService.addProduct(ajia.domain.Product, int)) "
			+ "&& this(invService)"
			+ "&& args(product, quantity)")
	public void productUpdate(InventoryService invService, Product product, int quantity) {}
	
	@Around("productUpdate(invService, product, quantity)")
	public Object productUpdateAudit(ProceedingJoinPoint pjp, InventoryService invService, Product product, int quantity) throws Throwable {
//		System.out.println( AopContext.currentProxy().getClass() );
		
		Object obj =  pjp.proceed();
		
		System.out.println("productUpdateAudit, product: " + product.getName() + ", quantity: " + quantity);
		
		return obj;
	}
	
}
