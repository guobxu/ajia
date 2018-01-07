package ajia;

public aspect SaveEnegryAspect {

	before() : execution(void Home.exit()) {
		System.out.println("Switching off lights");
	}
	
	after() : execution(void Home.enter()) {
		System.out.println("Switching on lights");
	}
	
}
