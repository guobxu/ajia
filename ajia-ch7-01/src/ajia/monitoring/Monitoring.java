package ajia.monitoring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public abstract class Monitoring {

	@Pointcut
	public abstract void monitored();
	
	@Around("monitored()")
	public Object measureTime(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.nanoTime();
		Object ret = pjp.proceed();
		long endTime = System.nanoTime();
		System.out.println("Method " + pjp.getSignature().toShortString() + 
				" tool " + (endTime - startTime));
		
		return ret;
	}
	
}
