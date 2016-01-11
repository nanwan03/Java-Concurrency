public class Main {
	public static void main(String[] args) {
		System.out.println("main BEGIN");
		Host host = new Host();
		Data data1 = host.request(10, 'A');
		Data data2 = host.request(20, 'B');
		Data data3 = host.request(30, 'C');
		Data data = host.request(-1, 'N');
		
		System.out.println("main otherJob BEGIN");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		System.out.println("main otherJob END");
		
		try {
			System.out.println("data1 = " + data1.getContent());
			System.out.println("data2 = " + data2.getContent());
			System.out.println("data3 = " + data3.getContent());
			System.out.println("data = " + data.getContent());
			System.out.println("main END");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}