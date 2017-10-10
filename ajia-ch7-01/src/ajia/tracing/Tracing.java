package ajia.tracing;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Tracing {

	@Pointcut("execution(* *.*(..))")
	public void traced() {}
	
	@Before("traced()") 
	public void trace(JoinPoint jp) {
		System.out.println("Entering " + jp);
	}
	
}
