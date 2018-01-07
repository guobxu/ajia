package ajia.security;

import ajia.messaging.MessageCommunicator;

public aspect SecureAspect {

	declare warning
		: call(void Authenticator.authenticate()) && !within(SecureAspect) 
		: "Authentication should be performed only by SecurityAspect";
	
	private Authenticator authenticator = new Authenticator();
	
	pointcut secureAccess() : execution(* MessageCommunicator.deliver(..));
	
	before() : secureAccess() {
		System.out.println("Checkingn and authenticating user.");
		authenticator.authenticate();
	}
	
}
