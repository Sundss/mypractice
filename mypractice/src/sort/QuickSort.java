/** 
* Copyright 2016 Hushu Info Tech Co. Ltd.  All rights reserved.
* @author sun
* @date 2016-4-18 ÏÂÎç3:14:12 
* @version V1.0
*/
package sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuickSort {
	public static void main(String[] arg){
		System.out.println();
		
		List<Integer> arrayList = new ArrayList<Integer>();
		
		long timeStart = System.currentTimeMillis();
//		for(int i =0;i<100;i++){
//			arrayList = testSet();
//			bubbleSortList(arrayList);
//		}
//		System.out.println("bubble:"+(System.currentTimeMillis()-timeStart));
//		timeStart = System.currentTimeMillis();
		for(int i = 0;i<100;i++){
			arrayList = testSet();
			quickSortList(arrayList);
		}
		
		
		System.out.println("quick:"+(System.currentTimeMillis()-timeStart));
		timeStart = System.currentTimeMillis();
		for(int i = 0;i<100;i++){
			arrayList = testSet();
			Collections.sort(arrayList);
		}
		System.out.println("system:"+(System.currentTimeMillis()-timeStart));
	}
	
	public static boolean testArray(List<Integer> arrayList){
		for(int i = 0;i<arrayList.size()-1;i++){
			if(arrayList.get(i)<arrayList.get(i+1)){
				return false;
			}
		}
		return true;
	}
	
	public static List<Integer> bubbleSortList(List<Integer> arrayList){
		for(int i = 0;i<arrayList.size();i++){
			int ptr = i;
			int c = arrayList.get(i);
			for(int j = i;j<arrayList.size();j++){
				if(c>arrayList.get(j)){
					ptr = j;
					c = arrayList.get(j);
				} else {
					//do nothing
				}
			}
			int temp = arrayList.get(i);
			arrayList.set(i, arrayList.get(ptr));
			arrayList.set(ptr, temp);
		}
		return arrayList;
	}
	public static List<Integer> quickSortList(List<Integer> arrayList){
		int startPtr = 0;
		int lastPtr = arrayList.size()-1;
		for(int i =1;i<lastPtr+1;){
			int temp = arrayList.get(i);
			if(arrayList.get(startPtr)<arrayList.get(i)){
				arrayList.set(i, arrayList.get(startPtr));
				arrayList.set(startPtr, temp);
				startPtr = i;
				i++;
			}else {
				arrayList.set(i, arrayList.get(lastPtr));
				arrayList.set(lastPtr, temp);
				lastPtr -= 1; 
			}
		}
		
		if(arrayList.size()>1){
			List<Integer> lastList = new ArrayList<Integer>();
			List<Integer> a = quickSortList(arrayList.subList(0, lastPtr+1));
			List<Integer> b = quickSortList(arrayList.subList(lastPtr+1, arrayList.size()));
			lastList.addAll(a);
			lastList.addAll(b);
			return lastList;
		} else {
			return arrayList;
		}
	}
	
	public static List<Integer> testSet(){
		List<Integer> arrayList = new ArrayList<Integer>();
		Random r = new Random();
		for(int i = 0;i<100000;i++){
			int temp = r.nextInt(10000);
			arrayList.add(temp);
		}
		return arrayList;
	}
	
	public static void printArray(List<Integer> array){
		for(int i=0;i<array.size();i++){
			System.out.print(array.get(i)+" ");
		}
		System.out.println();
	}
	
	public static int[] quickSort(int[] array){
		int first = 0;
		for(int i = 0;i<array.length;i++){
			if(array[first]>array[i]){
				first += 1;
			} else {
				
			}
		}
		int temp2 = array[0];
		array[0] = array[first];
		array[first] = temp2;
		
		return array;
	}
	

}
