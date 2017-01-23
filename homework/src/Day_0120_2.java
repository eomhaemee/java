import java.util.Scanner;

/**
 * 1을 입력하면 점수 5개의 총점, 평균을 계산하는 프로그램 2를 입력하면 섭씨를 화씨로 변경하는 프로그램 3을 입력하면 BMI를 게산하는
 * 프로그램 4를 입력하면 프로그램이 종료되도록 코딩하세요.
 *
 * 
 */
public class Day_0120_2 {

	public static void main(String[] args) {
		// 실행할 case숫자 입력
		Scanner input = new Scanner(System.in);

		// 변수선언
		int sum = 0;
		int caseNum = 0;
		int[] score = new int[5];
		double temperate = 0;
		double clcFah = 0;
		double height = 0;
		double weight = 0;

		while (true) {
			System.out.println("숫자 1~4를 입력하세요: ");
			caseNum = input.nextInt();

			// 1. 총점과 평균 계산
			if (caseNum == 1) {
				System.out.println("점수 5개를 입력하세요: ");
				sum = 0;
				for (int i = 0; i < score.length; i++) {
					score[i] = input.nextInt();
					sum += score[i];
				}
				String msg = String.format("총점은 %d,평균은 %.2f점입니다.", sum, sum / (double) score.length);
				System.out.println(msg);
				// 2. 섭씨를 화씨로 변경
			} else if (caseNum == 2) {
				System.out.println("온도를 입력하세요:");
				temperate = input.nextDouble();

				clcFah = temperate * 1.8 + 32;
				String msg = String.format("입력한 섭씨:  %.2f  화씨로 변환시: %.2f", temperate, clcFah);
				System.out.println(msg);
				// 3. BMI를 계산
			} else if (caseNum == 3) {
				System.out.println("BMI를 계산 합니다 키와 체중을 입력하세요");
				System.out.println("키(cm):");
				height = input.nextDouble() / 100;

				System.out.println("체중(kg):");
				weight = input.nextDouble();

				// BMI지수 = 키m /(체중kg*체중kg)
				String msg = String.format("당신의 키는:   %.1f (cm) 체중은: %.2f(kg) BMI는 %.2f입니다.", height * 100, weight,
						(double) weight / (height * height));
				System.out.println(msg);
				// 4. 프로그램 종료
			} else if (caseNum == 4) {
				break;
				// 1~4 외의 숫자 입력시 재입력 요구
			} else {
				System.out.println("1~4의 숫자로 다시 입력하세요");
			}

		}
		System.out.println("끝!");
	}
}
