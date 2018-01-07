package ajia.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ajia.messaging.MessageCommunicator;

@Component
public class AppRunner implements CommandLineRunner {

	@Autowired
	private MessageCommunicator communicator;
	
	@Override
	public void run(String... arg0) throws Exception {
		communicator.deliver("Wanna learn AspectJ?");
		communicator.deliver("guobxu", "AspectJ is funny!");
	}

}
