package ajia.auditing;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import ajia.domain.Product;

@Aspect
@Configuration
public class InventoryAuditing {

	private static final Logger LOGGER = LoggerFactory.getLogger(InventoryAuditing.class);
	
	@Pointcut("execution(* *(ajia.domain.Product, int)) "
			+ "&& args(product, quantity)")
	public void audited(Product product, int quantity) {}
	
	@Before("audited(product, quantity)")
	public void audit(JoinPoint jp, Product product, int quantity) {
		LOGGER.info("Audit: operation = " + jp.getSignature().getName()
				+ " product = " + product.getName() 
				+ " quantity = " + quantity);
	}
	
}
