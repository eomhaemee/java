
public class Arrays {

	public static void main(String[] args){
		
		// 배열안에 있는 모든 원소를 출력한다.
		
		// 1. 배열을 정의하고 값을 할당한다.
		String[] names = {"비","김태희","싸이"};
		int[] numbers = {1,2,3,4,5,6,7,8,9,10};
		
		// 2. 배열의 갯수를 변수에 담아 보관한다.
		int nameCount = names.length;
		int numbersCount = numbers.length;
		// 3. 배열의 원소갯수만큼 반복하며, 각 원소를 출력한다.
		// 3-1. 반복값을 정의하고, 0 으로 초기화한다.
		int i = 0;
		// 3.2  while이용
		// 3.3  조건은 반복값이  name(ount 보다 작을떄까지만 한다.
		while(i < nameCount){
		// 3.4  반복구문 : names 배열의 원소를 꺼내 출력한다.
		System.out.println(names[i]);
		i++;
		}
		
		System.out.println("=================");
		
		int sum = 0;
		int j= 0;
		while(j < numbersCount){
			sum +=numbers[j];
			j++;
			}
		System.out.println(sum);
	}
}
