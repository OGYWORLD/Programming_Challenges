/* UVA 10082 Wertyu */

import java.util.Scanner;

public class Wertyu {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
			// 문장들 받기
			String a = "";
			String[] number = new String[1000];
			int m = 0;
			while(input.hasNextLine()) {
				a = input.nextLine();
				if(a.equals("") && a.length() == 0 && m > 0) {
					break;
				}
				number[m] = a;
				m++;
			}
			
		char[] line = {'`','1','2','3','4','5','6','7','8','9','0','-','=',
						'Q','W','E','R','T','Y','U','I','O','P','[',']','\\',
						'A','S','D','F','G','H','J','K','L',';','\'',
						'Z','X','C','V','B','N','M',',','.','/'};
		
		int stop = 0;
		while(stop != m) {
			char[] split = new char[number[stop].length()];
			
			for(int i = 0; i < number[stop].length(); i++) {
				split[i] = number[stop].charAt(i);
			}
			
			for(int i = 0; i < number[stop].length(); i++) {
				for(int j = 0; j < line.length; j++) {
					if(split[i] == line[j]) {
						split[i] = line[j-1];
					}
				}
			}
			
			for(int i = 0; i < split.length; i++) {
				System.out.print(split[i]);
			}
			System.out.println("");
			
			stop++;
		}
		
	}

}