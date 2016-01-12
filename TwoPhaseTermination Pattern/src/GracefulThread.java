public class GracefulThread extends Thread {
	private volatile boolean shutdownRequested = false;
	protected volatile long requestedTimeMills = 0;
	
	public void shutdownRequest() {
		requestedTimeMills = System.currentTimeMillis();
		shutdownRequested = true;
		interrupt();
	}
	
	public boolean isShutdownRequested() {
		return shutdownRequested;
	}
	
	public final void run() {
		try {
			while (!shutdownRequested) {
				doWork();
			}
		} catch (InterruptedException e) {
			
		} finally {
			doShutdown();
		}
	}
	
	protected void doWork() throws InterruptedException {
		
	}
	
	protected void doShutdown() {
		
	}
}