/* UVA 10050 Hartals */

import java.util.Scanner;

public class Hartals {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int count = 0;
		int repetNumber = input.nextInt(); // 실행시킬 횟수
		
		while(count < repetNumber) { // count가 실행시킬 횟수가 될 때까지 반복
			count++; // while문 한 번 실행시 1씩 증가
			int dayNumber = input.nextInt(); // 며칠인지 dayNumber에 넣음
			int[] day = new int[dayNumber]; // dayNumber만큼의 크기인 day배열 생성
			int answer = 0; // 정답( 동맹 휴업 일수) 
			int partyNumber = input.nextInt(); // 정당 수
			int[] hartalsNumber = new int[partyNumber]; // 정당 수 만큼의 배열 생성
			
			for(int i = 0; i < partyNumber; i++) { // 정당 배열에 정당마다 파업 주기를 삽입
				hartalsNumber[i] = input.nextInt();
			}
			
			for(int i = 0; i < partyNumber; i++) { // 정당 수 만큼 for문
				
				for(int j = hartalsNumber[i]-1; j < dayNumber; j += hartalsNumber[i]) { // 동맹휴업 하는 날은 day배열에 1을 삽입하는 for문
					
					if(j % 7 != 5 && j % 7 != 6) { // j를 7로 나눈 것이 5가 아니고 6이 아니라면 (금, 토가 아니라면)
						day[j] = 1; // day 배열에 1 넣기
					}
				}
			}
			
			for(int k = 0; k < dayNumber; k++) {	// for문에서 dayNumber만큼 돌릴 때 day배열에서 0보다 크다면 answer을 증가 시킴
				if(day[k] > 0) {
					answer++;
				}
			}
			
				System.out.println(answer); // answer 출력
			
		}

	}

}
