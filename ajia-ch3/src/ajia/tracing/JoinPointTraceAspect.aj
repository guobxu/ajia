package ajia.tracing;

public aspect JoinPointTraceAspect {

	private int callDepth;
	
	pointcut traced(): !within(JoinPointTraceAspect);
	
	before(): traced() {
		print("Before", thisJoinPoint);
		callDepth++;
	}
	
	after(): traced() {
		callDepth--;
		print("After", thisJoinPoint);
	}
	
	private void print(String prefix, Object mesg) {
		for(int i = 0; i < callDepth; i++) {
			System.out.print(" ");
		}
		
		System.out.println(prefix + ": " + mesg);
	}
	
}
