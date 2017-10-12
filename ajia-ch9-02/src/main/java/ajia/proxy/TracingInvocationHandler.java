package ajia.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TracingInvocationHandler implements InvocationHandler {

	private Object target;

	public TracingInvocationHandler(Object target) {
		this.target = target;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Entering: " + method);
		
		return method.invoke(target, args);
	}
	
}
