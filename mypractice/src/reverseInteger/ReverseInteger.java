package reverseInteger;

public class ReverseInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(new ReverseInteger().reverse(1534236469));
		
//		System.out.println(new ReverseInteger().reverse(1534236469));
		System.out.println(new ReverseInteger().myAtoi("+11e530408314"));

	}
	
	public int reverse(int x) {
		String result = "";
		int resultNum = 0;
		if(x>=0){
			String temp = String.valueOf(x);
			for(int i = 0;i<temp.length();i++){
				result = temp.charAt(i)+result;
			}
		}else {
			String temp = String.valueOf(x);
			for(int i = 1;i<temp.length();i++){
				result = temp.charAt(i)+result;
			}
			result = "-"+result;
		}
		try{
			resultNum = Integer.valueOf(result);
		} catch (NumberFormatException e){
			resultNum = 0;
		}
        return resultNum;
    }
	
	public int myAtoi(String str) {
		Long resultNum = 0l;
		str = str.trim();
		while(str.length()>0&&str.charAt(0)=='0'){
			str = str.substring(1,str.length());
		}
		
		try{
			resultNum = Long.valueOf(str);
		}catch (NumberFormatException e){
			resultNum = 0l;
			try{
				if(str.length()>0){
					if(str.charAt(0)=='-'){
						for(int i = 2;i<str.length();i++){
							resultNum = Long.valueOf(str.substring(0,i));
						}
					}else if(str.charAt(0)=='+'){
						for(int i = 2;i<str.length();i++){
							resultNum = Long.valueOf(str.substring(0,i));
						}
					}else {
						for(int i = 1;i<str.length();i++){
							resultNum = Long.valueOf(str.substring(0,i));
						}
					}
				}
			}catch (NumberFormatException e1){
				
			}
		}
		int result = 0;
		if(resultNum>2147483647){
			result = 2147483647;
		}else if(resultNum<-2147483648){
			result = -2147483648;
		}else {
			result = Integer.valueOf(String.valueOf(resultNum));
		}
        return result;
    }

}
