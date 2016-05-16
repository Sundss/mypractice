package volatileTest;

import java.util.Hashtable;


public class VolatileTest implements Runnable {
	
	public volatile static Integer counts = 0;
	public static Hashtable<String,Integer> testT = new Hashtable<String,Integer>();
	public static String str = "";
	public static boolean tag = true;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		VolatileTest vt = new VolatileTest();
		testT.put("1", 0);
		for(int i = 0;i<200;i++){
			new Thread(new VolatileTest(),i+"").start();
		}
		try {
			Thread.sleep(10000);
			System.out.println(counts);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
//		try {
//			Thread.sleep(10);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		synchronized (this) {
//			counts ++;
//			System.out.println(VolatileTest.counts);
//		}
//		int temp = testT.get("1")+1;
//		testT.put("1", temp);
//		System.out.println(temp);
		test();
	}
	
	public synchronized void test(){
		synchronized (VolatileTest.class) {
			counts ++;
			System.out.println(Thread.currentThread().getName() +":"+VolatileTest.counts);
		}
	}
}
