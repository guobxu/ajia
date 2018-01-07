package ajia.remoting;

import org.springframework.remoting.RemoteAccessException;

import ajia.faulttolerance.Idempotent;

public class RemoteService {

	@Idempotent
	public int getReply() {
		if(Math.random() > 0.25) {
			throw new RemoteAccessException("Simulated failure occurred");
		}
		
		System.out.println("Replying");
		
		return 5;
	}
	
}
