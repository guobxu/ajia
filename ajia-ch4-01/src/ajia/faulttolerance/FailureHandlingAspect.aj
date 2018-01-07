package ajia.faulttolerance;

import org.springframework.remoting.RemoteAccessException;

public aspect FailureHandlingAspect {

	private final int MAX_RETIRES = 3;
	
	Object around() : call(@Idempotent * *(..)) {
		int retry = 0;
		
		while(true) {
			try {
				return proceed();
			} catch(RemoteAccessException ex) {
				System.out.println("Encountered " + ex);
				if(++retry > MAX_RETIRES) {
					throw ex;
				}
				
				System.out.println("\tRetrying...");
			}
		}
	}
	
}
