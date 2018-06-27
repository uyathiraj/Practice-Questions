import java.util.ArrayList;
import java.util.List;

public class PuzzleTest {

	
	
	static ArrayList<String> permute2(String str){
		ArrayList<String> new_array = new ArrayList<String>();
		int len = str.length();
		if(len == 1) {
			new_array.add(str);
			return new_array;
		}
		
		ArrayList<String> array1 = permute2(str.substring(0,len/2));
		ArrayList<String> array2 = permute2(str.substring((len/2)));		
		for(String iStr: array1) {
			for(String jStr:array2) {			
				new_array.add(iStr+jStr);
			}
		}
		new_array.addAll(array1);
		new_array.addAll(array2);
		return new_array;
	}
	
	
	static ArrayList<String> permute(String str){
		ArrayList<String> list  = new ArrayList<>();
		if(str.length() == 1){
			list.add(str);
			return list;
		}
		char first = str.charAt(0);
		ArrayList<String> new_list =  permute(str.substring(1));
		for(String item:new_list) {
			list.add(first+item);
		}
		list.addAll(new_list);
		return list;
	}
	public static void main(String[] args) {
	
		List<String> list = permute2("abcdef");
		for(String item:list){
			System.out.println(item);
		}
		System.out.println(list.size());
		
	}
}
