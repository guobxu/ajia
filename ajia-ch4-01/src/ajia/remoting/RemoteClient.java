package ajia.remoting;

public class RemoteClient {

	public static void main(String[] args) {
		RemoteService service = new RemoteService();
		int retVal = service.getReply();
		
		System.out.println("Reply is " + retVal);
	}
	
}
