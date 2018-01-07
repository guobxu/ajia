package ajia.messaging;

import org.springframework.stereotype.Component;

@Component
public class MessageCommunicator {

	public void deliver(String msg) {
		System.out.println(msg);
	}
	
	public void deliver(String person, String msg) {
		System.out.println(person + ", " + msg);
	}
	
	
}
