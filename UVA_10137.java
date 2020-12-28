/* UVA 10137 The Trip */

import java.util.Scanner;

public class P5 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while(true) {
			
			int peopleNumber = 1;
			double minusTotal = 0;
			double total = 0;
			double answer = 0;
			double answer_1 = 0;
			double answer_2 = 0;
			double[] cost = new double[1000];
			
			peopleNumber = input.nextInt();
			if(peopleNumber == 0) {break;}
			
			for(int i = 0; i < peopleNumber; i++) {
				cost[i] = input.nextDouble();
				total += cost[i];
			}
			
			double average = total / peopleNumber;
			
			average = Math.round(average*1000)/1000.0;
			average = Math.round(average*100)/100.0;

		}

	}

}