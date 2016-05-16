package reverseVowelsofaString;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ReverseVowelsofaString {

	public static void main(String[] args) {
		String s = "hello";
		ReverseVowelsofaString rvs = new ReverseVowelsofaString();
		System.out.println(rvs.reverseVowels(s));;
	}
	
	public String reverseVowels(String s) {
		int first = findFirstVowel(s,2);
		System.out.println(first);
//		while(true){
//			
//		}
        return "";
    }
	
	public int findFirstVowel(String s,int fromIndex){
		Map<String,Integer> vowelMap = new HashMap<String,Integer>();
		vowelMap.put("a", s.indexOf("a",fromIndex));
		vowelMap.put("A", s.indexOf("A",fromIndex));
		vowelMap.put("e", s.indexOf("e",fromIndex));
		vowelMap.put("E", s.indexOf("E",fromIndex));
		vowelMap.put("i", s.indexOf("i",fromIndex));
		vowelMap.put("I", s.indexOf("I",fromIndex));
		vowelMap.put("o", s.indexOf("o",fromIndex));
		vowelMap.put("O", s.indexOf("O",fromIndex));
		vowelMap.put("u", s.indexOf("u",fromIndex));
		vowelMap.put("U", s.indexOf("U",fromIndex));
		int min = Integer.MAX_VALUE;
		for(Entry<String, Integer> entry : vowelMap.entrySet()){
			if(entry.getValue()<min&&entry.getValue()!=-1){
				min = entry.getValue();
			}
		}
		return min;
	}
	
	public int findLastVowel(String s){
		return 0;
	}

}
