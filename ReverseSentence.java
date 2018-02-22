import java.util.ArrayList;
import java.util.List;


public class TestSentence {
	
	public static List<Integer> getSpaceStack(String sentence){
		List<Integer> spaceStack = new ArrayList<Integer>();
		int count =0;
		for(int i=0;i<sentence.length() ; i++){
			if(sentence.charAt(i) == ' '){
				count++;
			}else{
				if(count != 0){
					spaceStack.add(count);
					count = 0;
				}
			}
		}
		return spaceStack;
	}
	
	public static String reverse(String str){
		String output ="";
		String[] words_stack = str.split("(\\s+)");
		List<Integer> space_stack = getSpaceStack(str);		
		int length = words_stack.length;
		for(int i=0 ;i < length;i++){
			
			output += words_stack[length-1-i];
			//System.out.println(i);
			if(i<space_stack.size()){
				int no_space = space_stack.get(i);
				for(int j=0;j<no_space;j++){
					output += ' ';
				}
			}
		}
		return output;
	}
	
	
	
	
	public static void main(String[] args) {
		String input= "This is   very soft. I loved it";		
		String output = reverse(input);
		
		System.out.println("Input : "+input);
		System.out.println("Output: "+output);
		
	
	}
}
