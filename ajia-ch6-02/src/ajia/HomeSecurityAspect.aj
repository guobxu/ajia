package ajia;

public aspect HomeSecurityAspect {

	before(): execution(void Home.exit()) {
		System.out.println("Engaging");
	}
	
	after(): execution(void Home.enter()) {
		System.out.println("Disengaging");
	}
	
}
