public class Log {
	private static final ThreadLocal tsLogCollection = new ThreadLocal();
	
	public static void println(String s) {
		getTSLog().println(s);
	}
	
	/*
	public static void close() {
		getTSLog().close();
	}
	*/
	
	private static TSLog getTSLog() {
		TSLog tsLog = (TSLog)tsLogCollection.get();
		
		if (tsLog == null) {
			tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
			tsLogCollection.set(tsLog);
			starWatcher(tsLog);
		}
		
		return tsLog;
	}
	
	private static void starWatcher(final TSLog tsLog) {
		final Thread target = Thread.currentThread();
		final Thread watcher = new Thread() {
			public void run() {
				System.out.println("startWatcher for " + target.getName() + " BEGIN");
				try {
					target.join();
				} catch (InterruptedException e) {
					
				}
				tsLog.close();
				System.out.println("startWatcher for " + target.getName() + " END");
			}
		};
		
		watcher.start();
	}
}