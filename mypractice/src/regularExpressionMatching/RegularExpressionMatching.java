package regularExpressionMatching;

public class RegularExpressionMatching {

	public static void main(String[] args) {
		RegularExpressionMatching rem = new RegularExpressionMatching();
//		System.out.println(rem.isMatch("aa","a"));
//		System.out.println(rem.isMatch("aa","aa"));
//		System.out.println(rem.isMatch("aaa","aa")) ;
//		System.out.println(rem.isMatch("aa", "a*")) ;
//		System.out.println(rem.isMatch("aa", ".*"));
//		System.out.println(rem.isMatch("ab", ".*")) ;
		System.out.println(rem.isMatch("aab", "c*a*b")) ;
//		System.out.println(rem.isMatch("aa", "a"));
	}
	
	public boolean isMatch(String s, String p) {
		char[][] parse = parseSet( p);
		printCharSet(parse);
		if(parse[0][0]=='.'&&parse[0][1]=='*'){
			return true;
		}
		
		int j=0;
		boolean result = false;
		boolean trueResult = false;
//		boolean repeat = false;
		for(int i = 0;i<s.length()&&parse[j][0]!=0;){
			if(parse[j][0]=='.'){
				j++;
				i++;
				result = true;
			} else if(parse[j][1]=='*'){
				if(parse[j+1][0]==s.charAt(i)||parse[j+1][0]=='.'){
					j++;
					result = true;
				}else {
					result = false;
					j= 0;
				}
				i++;
			}else if(s.charAt(i)==parse[j][0]){
				if(parse[j][1]=='*'){
//					repeat = true;
					result = true;
					i++;
				}else {
					j++;
					i++;
//					repeat = false;
				}
			}
			
			if(parse[j][0]=='0'&&result== true){
				return true;
			}else {
				trueResult = false;
			}
		}
        return trueResult;
    }
	
	public char[][] parseSet(String p){
		char[][] parse = new char[p.length()+1][2];
		int j = 0;
		for(int i = 0;i<p.length();i++){
			if(i+1<p.length()){
				if(p.charAt(i+1)=='*'){
					parse[j][0] = p.charAt(i);
					parse[j][1] = '*';
					i++;
					j++;
				}else {
					parse[j][0] = p.charAt(i);
					j++;
				}
			}else {
				parse[j][0] = p.charAt(i);
			}
		}
		return parse;
	}
	
	public void printCharSet(char charSet[][]){
		for(int i = 0;i<charSet.length;i++){
			for(int j = 0;j<charSet[i].length;j++){
				System.out.print(charSet[i][j]);
			}
			System.out.println();
		}
	}
}
