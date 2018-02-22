import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FindJS {

	public static void main(String[] args) {
		String filename = "C:\\index.html";
		StringBuffer content = new StringBuffer();
		File f = new File(filename);
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(f));
			String str;
			while((str = reader.readLine()) != null){
				content.append(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(content);
		String regEx = "<script src=\"(.*?) type=\"text/javascript\"></script>";
		Pattern pat = Pattern.compile(regEx);
		Matcher matcher = pat.matcher(content);
		int count = matcher.groupCount();
		System.out.println(count);
		ArrayList<String> list = new ArrayList<String>();
		while(matcher.find()){
			list.add(matcher.group(1));
			//System.out.println(matcher.group(1));
		}
		System.out.println(list);
	}

}
