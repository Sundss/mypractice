package isPalindrome;

public class IsPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new IsPalindrome().isPalindrome(0));
	}
	
	public boolean isPalindrome(int x) {
		if(x<0){
			return false;
		}
		if(x/10==0){
			return true;
		}
		int[] stack = new int[10];
		int temp = x;
		int i = 0;
		while(temp!=0){
			stack[i] = temp%10;
			i++;
			temp=temp/10;
		}
		for(int j = 0;j<i/2+1;j++){
			if(stack[j]!=stack[i-j-1]){
//				System.out.println("no");
				return false;
			}else {
//				System.out.println("yap");
			}
		}
        return true;
    }

}
