/** 
* Copyright 2016 Hushu Info Tech Co. Ltd.  All rights reserved.
* @author sun
* @date 2016-3-31 下午4:54:33 
* @version V1.0
*/
package mongoTest;

//import com.mongodb.DBCollection;
//import com.mongodb.DBCursor;
//import com.mongodb.Mongo;

public class MongoTestThread implements Runnable{

	@Override
	public void run() {
//		Mongo mg = new Mongo();
//        //查询所有的Database
//        for (String name : mg.getDatabaseNames()) {
//            System.out.println("dbName: " + name);
//        }
//        
//        DB db = mg.getDB("test");
//        //查询所有的聚集集合
//        for (String name : db.getCollectionNames()) {
//            System.out.println("collectionName: " + name);
//        }
//        
//        DBCollection users = db.getCollection("users");
//        
//        //查询所有的数据
//        DBCursor cur = users.find();
//        while (cur.hasNext()) {
//            System.out.println(cur.next());
//        }
//        System.out.println(cur.count());
//        System.out.println(cur.getCursorId());
//        System.out.println(JSON.serialize(cur));
	}

}
