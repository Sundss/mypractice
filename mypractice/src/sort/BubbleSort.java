package sort;

public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,3,1,5,2,3,7,28,123};
		BubbleSort bs = new BubbleSort();
		bs.bubbleSort(a);
		for(int i = 0;i<a.length;i++){
			System.out.print(a[i]+",");
		}
	}
	
	public void bubbleSort(int[] a ){
		for(int i = 0;i<a.length;i++){
			for(int j= 0;j<a.length-i-1;j++){
				if(a[j+1]<a[j]){
					int temp = a[j];
					a[j] = a[j+1] ;
					a[j+1] = temp ;
				}
			}
		}
	}
}
