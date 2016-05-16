package zigZagConversion;

public class ZigZagConversion {

	public static void main(String[] args) {
//		new ZigZagConversion().convert("PAYPALISHIRING", 4);
//		new ZigZagConversion().convert("AB", 1);
//		new ZigZagConversion().convert("ABCD", 1);
//		new ZigZagConversion().convert("ABC", 2);
//		new ZigZagConversion().convert("ABCDE", 2);
		new ZigZagConversion().convert("ABCDE", 4);
//		new ZigZagConversion().convert("A", 2);
	}
	
	public String convert(String s, int numRows) {
		if(s.equals("")){
			return "";
		}
		if(numRows==1){
			return s;
		}
		int col = (s.length()/(numRows*2-2)+1)*numRows;
		char[][] matrix = new char[numRows][col];
		
		int ptr = 0;
		for(int j = 0;j<col;j++){
			for(int i = 0;i<numRows&&ptr<s.length();i++){
				if((j)%(numRows-1)==0){
					matrix[i][j] = s.charAt(ptr);
					ptr++;
				} else if((numRows+1)==(i+2+(j)%(numRows-1))){
					
					matrix[i][j] = s.charAt(ptr);
					ptr++;
				}
			}
		}
		
		String result = "";
		for(int i= 0;i<numRows;i++){
			for(int j = 0;j<col;j++){
				if(matrix[i][j]!=0){
					result += matrix[i][j];
				}
			}
		}
		printChar(matrix);
		System.out.println(result);
//		System.out.println(col);
        return result;
    }
	
	public void printChar(char charSets[][]){
		for(int i = 0;i<charSets.length;i++){
			for(int j = 0;j<charSets[i].length;j++){
				System.out.print(charSets[i][j]);
			}
			System.out.println();
		}
	}

}
