package ajia.monitoring;

import java.sql.Connection;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ConnectionMonitor {

//	@Before("call(* java.sql.Connection.*(..)) && target(connection)")
//	public void monitorUse(Connection connection) {
//		System.out.println("About to use " + connection);
//	}
	
	@Pointcut("call(* java.sql.Connection.*(..)) && target(connection)")
	public void connectionOperation(Connection connection) {}
	
	@Before("connectionOperation(connection)")
	public void monitorUse(JoinPoint.StaticPart jpsp,
			JoinPoint.EnclosingStaticPart jpesp,
			Connection connection) {
		System.out.println("About to use " + connection
                + " to perform " + jpsp.toShortString()
                + " called from " + jpesp.toShortString());
	}
	
	@AfterReturning(value = "connectionOperation(connection)", returning = "ret")
	public void monitorSuccessfulUse(Connection connection, Object ret) {
		System.out.println("Just used " + connection 
				+ " successfully which returned " + ret);
	}
	
	@AfterThrowing(value = "connectionOperation(connection)", 
			throwing = "ex")
	public void monitorFailure(Connection connection, Exception ex) {
		System.out.println("Just used " + connection 
				+ " but met with a failure of kind " + ex);
	}
	
}















