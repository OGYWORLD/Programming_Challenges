/* UVA 10044 Erdos Number */

import java.util.Scanner;

public class ErdosNumber {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int loopCount = input.nextInt();
		int q = 0;
		while(true) {
			if(q == loopCount) {break;}
			int novelNumber = input.nextInt();
			int personNumber = input.nextInt();
			int[] delNumber = new int[novelNumber];
			String trash = input.nextLine();
			String[] names = new String[novelNumber];
			String[] splitNames = null;
			String trainNames = "";
			int[] endCount = new int[novelNumber+1]; 
			String[] spaceEmpty = new String[personNumber];
			String[] nonSpaceEmpty = new String[personNumber];
			String[] printNumber = new String[personNumber];
			
			for(int i = 0; i < novelNumber; i++) {
				names[i] = input.nextLine();
			}
			
			for(int i = 0; i < personNumber; i++) { 
				spaceEmpty[i] = input.nextLine();
			}
			
			
			for(int i = 0; i < novelNumber; i++) {
				delNumber[i] = names[i].indexOf(":");
			}
			
			// 논문 이름 END로 바꾸기
			for(int i = 0; i < novelNumber; i++) {
				names[i] = names[i].substring(0, delNumber[i]+1);
				names[i] = names[i].replaceAll(":",",END.,");
			}
			
			// 배열에 이름하나씩 넣기 작전
			for(int i = 0; i < novelNumber; i++) {
				trainNames += names[i];
			}
			
			splitNames = trainNames.split("\\.,");
			
			int[] answerCount = new int[splitNames.length];
			int[] checkCount = new int[splitNames.length];
			int[] section = new int[splitNames.length];
			
			//배열에 있는 공백제거
			for(int i = 0; i < splitNames.length; i++) {
				splitNames[i] = splitNames[i].replaceAll(" ", "");
			}
			
			// 사람 이름 공백제거
			for(int i = 0; i < personNumber; i++) {
				nonSpaceEmpty[i] = spaceEmpty[i].replaceAll(" ", "");
			}
			
			for(int i = 0; i < splitNames.length; i++) {
				if(splitNames[i].equals("Erdos,P")) {
					answerCount[i] = 100;
					checkCount[i] = 1;
				}
				else if(splitNames[i].equals("END")) {
					answerCount[i] = -10;
					checkCount[i] = 1;
				}
			}
			
			
			//end지점 인덱스 세주기
			int k = 0;
			endCount[0] = 0;
			for(int i = 0; i < splitNames.length; i++) {
				if(answerCount[i] == -10) {
					endCount[k+1] = i;
					k++;
				}
			}
			
			
			//에르도쉬랑 같이 쓴 사람 카운팅
			int id = 0;
			for(int i = endCount[id]; i < splitNames.length; i++) {
				if(answerCount[i] == 100) {
					for(int j = endCount[id]; j < endCount[id+1]; j++) {
						if(checkCount[j] == 0 && answerCount[j] != 100 && answerCount[j] != -10) {
							answerCount[j]++;
							checkCount[j]++;
						}
					}
					id++;
				}
			} 
			
			
			for(int i = 0; i < splitNames.length; i++) {
				for(int j = i+1; j < splitNames.length; j++) {
					if(splitNames[i].equals(splitNames[j])) {
						answerCount[j] = answerCount[i];
						checkCount[j] = checkCount[i];
					}
				}
			}
			
			//section 구분
			int sectionCheck = 1;
			for(int i = 0; i < splitNames.length; i++) {
				section[i] = sectionCheck;
				if(answerCount[i] == -10) {
					sectionCheck++;
				}
			}
			
			int t = 0;
			int number = 1;
			int stop = 0;
			while(true) {
				// while문 종료조건
				if(stop == splitNames.length-1) {
					break;
				}
				stop++;
				// 이름 중복시켜주기
				for(int i = 0; i < splitNames.length; i++) {
						for(int j = i+1; j < splitNames.length; j++) {
							if(splitNames[i].equals(splitNames[j])) {
								answerCount[j] = answerCount[i];
								checkCount[j] = checkCount[i];
							}
						}
					}
				
				
				for(int i = 0; i < splitNames.length; i++) {
					if(answerCount[i] == number) {
						for(int j = 0; j < splitNames.length; j++) {
							if(answerCount[j] == 0  && checkCount[j] == 0 && section[j] == section[i]) {
								answerCount[j] = number+1;
								checkCount[j]++;
							}
						}
					}
				}
				number++;
				
				
			}
			
			for(int i = 0; i < splitNames.length; i++) {
				splitNames[i]=splitNames[i]+".";
			}

			for(int i = 0; i < personNumber; i++) {
				for(int j = 0; j < splitNames.length; j++) {
					if(nonSpaceEmpty[i].equals(splitNames[j])) {
						printNumber[i] = Integer.toString(answerCount[j]);
						if(answerCount[j] == 0) {
							printNumber[i] = "infinity";
						}
						break;
					}
				}
			}
			
			System.out.println("Scenario "+(q+1));
			for(int i = 0; i < personNumber; i++) {
				System.out.println(spaceEmpty[i]+printNumber[i]);
			}
		
			q++;
		}
		
	}

}