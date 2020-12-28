/* UVA 100 The 3n + 1 Problem */

import java.util.Scanner;

public class P2_3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int min, max = 0;
		int count= 0;
		int originMax, originMin = 0;
		
		while(input.hasNext()) {
			originMin = input.nextInt();
			originMax = input.nextInt();
		
			min = originMin;
			max = originMax;
		
			if(max < min) { // 최대 최소 구분
				int temp = 0;
				temp = min;
				min = max;
				max = temp;
			}
			int lenght = (max-min) + 1; 
			
			long[] numbers = new long[lenght]; // 최대 - 최소 값
			int[] cycle = new int[lenght];
			
			for(int i = 0; i < lenght; i++) { // numbers에 다 넣기
				numbers[i] = min+i;
			}
			
			
			int j = 0;
			while(j < lenght) {
				
				if(numbers[j] == 1) { // 만약 정수가 1이라면
					count++;
					cycle[j] = count;
					j++;
					count = 0;
				}
				
				else if ((numbers[j] % 2) == 0) { // 만약 정수가 짝수라면
					numbers[j] = numbers[j] / 2;
					count++;
				}
				
				else {									// 만약 정수가 홀수라면
					numbers[j] = numbers[j] * 3 + 1;
					count++;
				}
			}

			int answer = cycle[0];
			for(int i = 1; i < lenght; i++) {
				if(answer < cycle[i]) {
					int temp;
					temp = cycle[i];
					cycle[i] = answer;
					answer = temp;
				}
			}
			
			System.out.println(originMin + " " + originMax + " " + answer);
			}

		}
	}