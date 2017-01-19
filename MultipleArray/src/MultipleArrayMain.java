
public class MultipleArrayMain {

		public static void main(String[] args){
			/*
			 //1. 명시적으로 선언
			int[][] scoreInClasses = new int[3][3];
			
			scoreInClasses[0][0] = 100;
			scoreInClasses[0][1] = 100;
			scoreInClasses[0][2] = 90;
			
			scoreInClasses[1][0] = 90;
			scoreInClasses[1][1] = 10;
			scoreInClasses[1][2] = 70;

			scoreInClasses[2][0] = 70;
			scoreInClasses[2][1] = 100;
			scoreInClasses[2][2] = 95;
			*/
			/*
			//2. 두번쨰 인자 가변으로 선언
			int[][] scoreInClasses = new int[3][];
			
			scoreInClasses[0] =new int[]{100,100,90};
			scoreInClasses[1] =new int[]{90,10,70};
			scoreInClasses[2] =new int[]{70,100,95};
			*/
			/*
			//3. 전체가변인자로 선언
			int[][] scoreInClasses = new int[][]{
				{100,100,90},
				{90,10,70},
				{70,100,95}
				
			};
			*/
			//권장
			int[][] scoreInClasses = {
				{100,100,90,100},
				{90,10,70},
				{70,100}
				
			};
			
			
			MultipleArray multipleArray = new MultipleArray();
			
			multipleArray.printClassTotalScore(scoreInClasses);
			
		}
}
