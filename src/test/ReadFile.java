package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
	public Scanner scan;
	public void openFile(){
		try {
			scan = new Scanner(new File("/Users/zhangluhan/Desktop/triangle.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void closeFile(){
		scan.close();
	}
}
