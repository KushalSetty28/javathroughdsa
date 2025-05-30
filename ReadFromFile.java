package dsa;

import java.io.FileReader;
import java.io.IOException;
public class ReadFromFile {

	public static void main(String[] args) {
		try {
			FileReader reader = new FileReader("D:\\eclipesjava\\kushal.txt");

			int ch;
			while((ch = reader.read()) != -1) {
				System.out.print((char)ch);
			}
			reader.close();
		}catch(IOException e) {
			System.out.println("error:"+ e.getMessage());
		}

	}

}
