public class CountupThread extends GracefulThread {
	private long counter = 0;
	
	protected void doWork() throws InterruptedException {
		counter++;
		System.out.println("doWork: counter = " + counter);
		Thread.sleep(500);
	}
	
	protected void doShutdown() {
		long time = System.currentTimeMillis() - requestedTimeMills;
		System.out.println("doShutdown: Latency = " + time + " msec.");
	}
}