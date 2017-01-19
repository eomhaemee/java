import javax.swing.plaf.synth.SynthSeparatorUI;

public class MultipleArray {

	void printClassTotalScore(int[][] scoreInClasses){
		
		int totalScore1 = scoreInClasses[0][0] +scoreInClasses[0][1]+scoreInClasses[0][2]+scoreInClasses[0][3] ;
		int totalScore2 = scoreInClasses[1][0] +scoreInClasses[1][1]+scoreInClasses[1][2] ;
		int totalScore3 = scoreInClasses[2][0] +scoreInClasses[2][1] ;
				
		//int totalScore = totalScore1 + totalScore2 + totalScore3;

		double a = totalScore1/scoreInClasses[0].length;
		double b = totalScore1/(scoreInClasses[0].length * 1.0);
		System.out.println(a);
		System.out.println(b);
		
		System.out.println((double)totalScore1/scoreInClasses[0].length);
		System.out.println((double)totalScore2/scoreInClasses[1].length);
		System.out.println((double)totalScore3/scoreInClasses[2].length);
	
	}
}
