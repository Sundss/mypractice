package medianSortedArrays;

import java.util.Arrays;
import java.util.Random;

public class MedianSortedArrays {

	public static void main(String[] args) {
//		int[] nums1 = {2,3,4,5,6,7,8,9,10};
//		int[] nums2 = {3,4,5,6,7,8,9,11,12,13,14};
		test1();
		
//		System.out.println(findMedianSortedArrays(nums1,nums2,0,nums1.length,0));
		
	}
	public int binarySearch(int A[], int low, int high, int key){
	    while(low<=high){
	        int mid = low + (high - low)/2;
	        if (key == A[mid]) return mid;
	        if (key > A[mid]){
	            low = mid + 1;
	        }else {
	            high = mid -1;
	        }
	    }
	    return low;
	}
	
	public double findMedianSortedFunction(int A[], int m, int B[], int n, int lowA, int highA, int lowB, int highB){
	    int mid = lowA + (highA - lowA)/2;
	    
	    int pos = binarySearch(B, lowB, highB, A[mid]);
	    int num = mid + pos;
	    if (num == (m+n)/2){
	        if ((m+n)%2==1){
	            return A[mid];
	        }
	        int next = 0;
	        if (mid>0 && pos>0){ 
	            next = A[mid-1]>B[pos-1] ? A[mid-1] : B[pos-1];
	        }else if(pos>0){
	            next = B[pos-1];
	        }else if(mid>0){
	            next = A[mid-1];
	        }
	        
	        return (A[mid] + next)/2.0;
	    }else if (num < (m+n)/2){
	        lowA = mid + 1;
	        lowB = pos; 
	        if ( highA - lowA > highB - lowB ) {
	            return findMedianSortedFunction(A, m, B, n, lowA, highA, lowB, highB);
	        }else {
	        	 return findMedianSortedFunction(B, n, A, m, lowB, highB, lowA, highA);
	        }
	    }else if (num > (m+n)/2) {
	        highA = mid - 1;
	        highB = pos-1;
	        if ( highA - lowA > highB - lowB ) {
	            return findMedianSortedFunction(A, m, B, n, lowA, highA, lowB, highB);
	        }else {
	        	return findMedianSortedFunction(B, n, A, m, lowB, highB, lowA, highA);
	        }
	    }else {
	    	return 0;
	    }
	}
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int[] A = nums1;
		int[] B = nums2;
	    if ( m==0 && n==0 ) return 0.0;

	    //if the length of array is odd, return the middle one
	    //if the length of array is even, return the average of the middle two numbers
	    if ( m==0 ) return n%2==1 ? B[n/2] : (B[n/2-1] + B[n/2])/2.0;
	    if ( n==0 ) return m%2==1 ? A[m/2] : (A[m/2-1] + A[m/2])/2.0;
	    
	    
	    //let the longer array be A, and the shoter array be B
	    if ( m > n ){
	        return findMedianSortedFunction(A, m, B, n, 0, m-1, 0, n-1);
	    }
	        
	    return findMedianSortedFunction(B, n, A, m, 0, n-1, 0, m-1);
    }
	
	public static void test1(){
		int size = 20;
		int[] numsTest = new int[size];
		Random r = new Random(101);
		for(int i = 0;i<numsTest.length;i++){
			numsTest[i] = r.nextInt(size*2);
		}
		int temp = r.nextInt(size);
		int[] numsTest1 = Arrays.copyOfRange(numsTest, 0, temp);
		int[] numsTest2 = Arrays.copyOfRange(numsTest, temp, numsTest.length);
		Arrays.sort(numsTest1);
		Arrays.sort(numsTest2);
		printArray(numsTest1);
		printArray(numsTest2);
		Arrays.sort(numsTest);
		printArray(numsTest);
		System.out.println("mid:"+Double.valueOf( numsTest[numsTest.length/2] + numsTest[numsTest.length/2-1] )/2);
		
		System.out.println(new MedianSortedArrays().findMedianSortedArrays(numsTest1,numsTest2));
	}
	
	public static void printArray(int nums[]){
		for(int i = 0;i<nums.length;i++){
			System.out.print(nums[i]+",");
		}
		System.out.println();
	}
	
//	int[] nums1 = {2,3,4,5,6,7,8,9,10};
//	int[] nums2 = {3,4,5,6,7,8,9,10,11};
	public static double findMedianSortedArrays(int[] nums1, int[] nums2,int ptrPre,int ptrLast,int ptr1) {
		if((nums1.length+nums2.length)%2==0){
			int ptr = (ptrPre+ptrLast)/2;
			int temp = Arrays.binarySearch(nums2, nums1[ptr]);
			System.out.println("ptrPre:"+ptrPre+"	ptrLast:"+ptrLast+"	ptr:"+ptr+"	location:"+temp+"	now:"+nums1[ptr]);
			if(ptr-1==temp){
				if(nums1[ptr+1]<=nums2[temp+1]){
					return Double.valueOf((nums1[ptr+1]+nums1[ptr]))/2;
				}else {
					return Double.valueOf((nums2[temp+1]+nums1[ptr]))/2;
				}
			}
			if((ptr+temp+1)==(nums1.length+nums2.length)/2){
				return Double.valueOf((nums1[ptr]+nums2[temp]))/2;
			}else if((ptr+temp+1)>(nums1.length+nums2.length)/2){
				return findMedianSortedArrays(nums1,nums2,ptrPre,ptr,ptr1);
			}else {
				return findMedianSortedArrays(nums1,nums2,ptr,ptrLast,ptr1);
			}
		}else {
			
		}
        return 0;
    }
	
	public static int findPtrInNums(int[] nums,int num,int ptrPre,int ptrLast){
		if(num>nums[nums.length-1]){
			return nums.length-1;
		}else if(num<nums[0]){
			return 0;
		}else {
			int mid = ptrPre + (ptrLast-ptrPre)/2;
			if(nums[mid]>num&&nums[mid-1]<num){
//				System.out.println(":"+ptrLast+"	"+ptrPre);
				return mid;
			}
			if(nums[mid]>num){
//				System.out.println("::"+ptrLast+"	"+ptrPre);
				ptrLast = mid ;
				return findPtrInNums(nums,num,ptrPre,ptrLast);
			}else if(nums[mid]<num){
//				System.out.println(":::"+ptrLast+"	"+ptrPre);
				ptrPre = mid;
				return findPtrInNums(nums,num,ptrPre,ptrLast);
			}else {
//				System.out.println("::::"+ptrLast+"	"+ptrPre);
				return mid;
			}
		}
	}
}
