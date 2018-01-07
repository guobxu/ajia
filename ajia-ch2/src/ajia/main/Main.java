package ajia.main;

import ajia.messaging.MessageCommunicator;

public class Main {

	public static void main(String[] args) {
		MessageCommunicator communicator = new MessageCommunicator();
		communicator.deliver("Wanna learn AspectJ?");
		communicator.deliver("guobxu", "AspectJ is funny!");
		
		System.out.println("Last accessed time for messageCommunicator " +
				communicator.getLastAccessedTime());
	}
	
}
