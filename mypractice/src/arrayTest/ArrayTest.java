/** 
* Copyright 2016 Hushu Info Tech Co. Ltd.  All rights reserved.
* @author sun
* @date 2016-4-15 ÉÏÎç9:21:17 
* @version V1.0
*/
package arrayTest;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> array = new ArrayList<Integer>();
		for(int i = 0;i<10;i++){
			array.add(i);
		}
		
		List<Integer> result = lruAlgorithm(array,5);
		
		for(int i= 0;i<result.size();i++){
			System.out.println(result.get(i));
		}
	}
	
	public static List<Integer> lruAlgorithm(List<Integer> cache,int element){
		int hitPlace = isHit(element,cache);
		if(hitPlace!=-1){
			changeAtoB(cache,0,hitPlace);
			return cache;
		}else {
			cache.add(element);
			return cache;
		}
	}
	
	public static int isHit(int element,List<Integer> array){
		int i = 0;
		while(array.get(i)!=element||i<array.size()){
			if(array.get(i)==element){
				return i;
			}
			i += 1;
		}
		return -1;
	}
	
	public static void changeAtoB(List<Integer> array,int a,int b){
		int temp = array.get(a);
		array.set(a,array.get(b));
		array.set(b, temp);
	}

}
