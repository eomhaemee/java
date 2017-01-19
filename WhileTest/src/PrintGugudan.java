
public class PrintGugudan {

		void printGugudan(int input){
			
			System.out.println("구구단 " + input + "단을 출력합니다");
			System.out.println("==========================");
			int i= 0;
			while(i < 9){
				i++;
				System.out.println( input + "*"+ i+ " = "+ input*i);
				
			}

		}
}
