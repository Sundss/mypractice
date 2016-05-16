package longestPalindrome;


public class LongestPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String max = new LongestPalindrome().longestPalindrome("abb");
		String max = new LongestPalindrome().longestPalindrome("abcbaaaa");
//		String max = new LongestPalindrome().longestPalindrome("a");
//		String max = new LongestPalindrome().longestPalindrome("bb");
//		String max = new LongestPalindrome().longestPalindrome("ccc");
//		String max = new LongestPalindrome().longestPalindrome("abadd");
		System.out.println(max);
	}
	
	public String longestPalindrome(String s) {
		int max = -1;
		String maxStr = "";
		for(int i = 0;i<s.length();i++){
			if(i>=0&&i<s.length()){
				int j = 0;
				int pre = i-j;
				int next = i+j;
				if(s.charAt(pre)==s.charAt(next)){
					if(i+1<s.length()&&s.charAt(i)==s.charAt(i+1)){
						next = i+j +1;
						while(pre>=0&&next<s.length()&&s.charAt(pre)==s.charAt(next)){
							pre = i-j;
							next = i+j+1;
							j++;
						}
						if((next)-(pre+1)>max){
							max = (next)-(pre+1);
							maxStr = s.substring(pre+1,next);
						}
//						System.out.println("pre::"+(pre+1)+"	next:"+(next));
//						System.out.println("::"+s.substring((pre+1),next));
					}
					j = 0;
					pre = i-j;
					next = i+j;
					do{
						pre = i-j;
						next = i+j;
						j++;
					}while(pre>=0&&next<s.length()&&s.charAt(pre)==s.charAt(next));
					
					if((next)-(pre+1)>max){
						max = (next)-(pre+1);
						maxStr = s.substring((pre+1),next);
					}
//					System.out.println("pre:"+(pre+1)+"	next:"+(next));
//					System.out.println(":"+s.substring((pre+1),next));
					
				}
			}
		}
        return maxStr;
    }
	

}
