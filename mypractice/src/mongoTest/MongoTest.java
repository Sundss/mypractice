/** 
* Copyright 2016 Hushu Info Tech Co. Ltd.  All rights reserved.
* @author sun
* @date 2016-3-31 обнГ4:51:51 
* @version V1.0
*/
package mongoTest;

public class MongoTest {
	public static void main(String[] arg){
		System.out.println(123);
		MongoTestThread r = new MongoTestThread();
	    for(int i=0;i<10;i++){
	      Thread t = new Thread(r);
	      t.start();
	    }
	}
}
