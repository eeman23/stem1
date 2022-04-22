
package stem1;

import java.util.Scanner;

public class stem1_v1 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int currentGlucose = input.nextInt();
		int insulinSensitive = input.nextInt();
		int targetGlucose= input.nextInt();
		
		int doseCorrect = currentGlucose- (targetGlucose/insulinSensitive);

	
	}

}
