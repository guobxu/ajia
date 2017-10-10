package ajia.monitoring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemHealthMointor {

	HeartBeatListener hbListener = new HeartBeatListener();
	
	@Pointcut("execution(* *(..)) && !within(ajia.monitoring.*)")
	public void aliveOperation() {} 
	
//	@Before("execution(* *(..)) && !within(ajia.monitoring.*)")
//	public void beatHeart() {
//		hbListener.beat();
//	}
	
	@Before("aliveOperation()")
	public void beatHeart() {
		hbListener.beat();
	}
	
}
