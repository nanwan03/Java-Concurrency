import java.util.Date;

public class MySystem {
	private static MySystem instance = new MySystem();
	private Date date = new Date();
	private MySystem() {
		System.out.println("Initializing...");
	}
	
	public Date getDate() {
		return date;
	}
	
	public static MySystem getInstance() {
		return instance;
	}
}