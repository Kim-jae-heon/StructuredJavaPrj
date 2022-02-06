package part2.ex3.데이터구조화;

import java.util.Scanner;
//프로그램이 거시적인 형태로 만들어졌다고 말할 수 있다. 큰 그림에서 미시적으로 들어갈 수 있으므로 계층형으로 만들어졌다, 구조적인 프로그래밍이다라고 말할 수 있게 된다.
//제어구조의 중첩이 깊어지지 않는다, 함수를 나누었으므로 이름만 불러주면 코드를 2번 작성할 필요가 없어진다, main함수는 재사용이 불가능하지만 함수는 재사용이 가능하다는 장점.
public class StructuredProgram {
	
	
	private static int[] kors;

	public static void main(String[] args) { //main함수에 붙은 static은 전역화의 의미가 아니다. main이 함수라는 의미를 가지고 있음을 의미. 나중에 객체지향가게되면 알게된다.
		
		int[] korList = new int[3];
		int[] engList = new int[3];
		int[] mathList = new int[3];
		
		Exam exam = new Exam(); //국영수를 모으면 시험성적이 된다. 이 시험성적을 한 번에 다룰 수 있는 한 단계 높은 방식의 저장매체를 만드는 것.
		exam.kor = 30;
		exam.eng = 30;
		
		int menu;
		boolean keepLoop = true;
		
		while(keepLoop)
		{
			menu = inputMenu(); //menu를 어떻게해야하는가? 값을 담아주어야 한다. 함수의 기본적인 덕목은 값의 결과를 남겨주는 것. 메인메뉴()도 값을 남길 수 있는 함수이다.
			
			switch(menu)
			{
			case 1:
				inputKors(korList);
				inputKors(engList);
				inputKors(mathList);
				
				break;
			case 2:
				printKors();
				
				break;
			case 3:
				System.out.println("Bye~~");
				
				keepLoop = false;
				break;
				
			default:
				System.out.println("잘못된 값을 입력하셨습니다. 메뉴는 1~3까지입니다.");
			}
		}


	}
	
	static void inputKors() { //지역화되어있는 main함수의 내용물을 마음대로 사용할 수 없다. 전역자원의 형태로 만들어 접근할 수 있도록 하는 1단계 방법이 있다.
		Scanner scan = new Scanner(System.in);
		
		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 입력    │");
		System.out.println("└──────────────────┘");
		System.out.println();
		
		for(int i = 0; i < 3; i++)
		{
			do 
			{
				System.out.printf("국어%d : ", i+1);
				kors[i] = scan.nextInt();
				
				if(kors[i] < 0 || 100 < kors[i])
				{
					System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");
				}
			}while(kors[i]<0 || 100 < kors[i]);
		}
		
		System.out.println("────────────────────────");
	}
	
	static void printKors() {
		int total = 0;
		float avg;
		
		for(int i = 0; i < 3; i++)
		{
			total += kors[i];
		}
		avg = total / 3.0f;
		
		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 출력    │");
		System.out.println("└──────────────────┘");
		System.out.println();
		
		for(int i = 0; i < 3; i++)
		{
			System.out.printf("국어 %d : %3d\n", 3-i, kors[i]);
		}
		System.out.printf("총점 : %3d\n", total);
		System.out.printf("평균 : %6.2f\n", avg);
		System.out.println("────────────────────────");
	}
	
	static int inputMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("┌──────────────────┐");
		System.out.println("│     메인 메뉴            │");
		System.out.println("└──────────────────┘");
		System.out.println("\t1. 성적입력 ");
		System.out.println("\t2. 성적출력 ");
		System.out.println("\t3. 종료 ");
		System.out.println("\t선택> ");
		int menu = scan.nextInt();
		
		return menu;
	}
}
