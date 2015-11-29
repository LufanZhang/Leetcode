package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ReadFileApp {
	public static  void readFile(File fin) throws IOException {
		FileInputStream fis = new FileInputStream(fin);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	 
	 File fout = new File("/Users/zhangluhan/Desktop/extract.txt");
	FileOutputStream fos = new FileOutputStream(fout);
 
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	  
		String line = null;
		while ((line = br.readLine()) != null) {
			if(startWithNumber(line)){
				int length = line.length();
				int index = 0;
				ArrayList<String> list = new ArrayList<String>();
				for(int i=0;i<length;i++){
					if(line.charAt(i) == '|'){
						String sub = line.substring(index,i);
						list.add(sub);
						index = i + 1;
					}
				}
				list.add(line.substring(index));
				if(list.size() == 8){
					String thirdSection = list.get(2).trim();
					String lastSection = list.get(list.size()-1).trim();
					if(startWithNumber(thirdSection) && lastSection.startsWith("Executing")){
						System.out.println(line);
						String res = "";
						for(int i=0;i<list.size();i++){
							String cur = list.get(i).trim();
							res = res + cur  + ",";
						}
						res = res.substring(0,res.length()-1);
						bw.write(res);
						bw.newLine();
					}
				}
			}
		}
	 
		br.close();
		bw.close();
	}
	
	public static boolean startWithNumber(String s){
		if(s == null || s.length() == 0){
			return false;
		}
		char c = s.charAt(0);
		if(c >= '0' && c <= '9'){
			return true;
		}
		return false;
	}
	public static void main(String args[]) throws IOException{
		
		final String FILENAME = "/Users/zhangluhan/Desktop/app.log";
		File file = new File(FILENAME);
		readFile(file);
	}

}
