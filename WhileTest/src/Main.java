import java.util.Scanner;

public class Main {

	public static void main(String[] args){

		System.out.println("=======구구단 프로그램=========");
		System.out.println("원하시는 구구단을 입력하세요.( 입력 범위:2~9)");
		System.out.print("원하는 구구단 : ");
		
		Scanner input  = new Scanner(System.in);
		int number1 = input.nextInt();
		
		PrintGugudan gugudan = new PrintGugudan();
		gugudan.printGugudan(number1);

		
	}
}
