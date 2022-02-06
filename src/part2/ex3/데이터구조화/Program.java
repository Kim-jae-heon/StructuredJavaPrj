package part2.ex3.데이터구조화;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Exam[] exams = new Exam[3];
		int current = 0;
		
//		exams[0] = new Exam();
//		exams[0].kor = 30;
//		
//		System.out.printf("kor:%d", exams[0].kor);
		
		int menu;
		boolean keepLoop = true;
		
		while(keepLoop)
		{
			menu = inputMenu();
			
			switch(menu)
			{
			case 1:
				inputList(exams, current);
				
				break;
			case 2:
				printKors(exams, current);
				
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
	
	private static void printKors(Exam[] exams, int size) {

		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 출력    │");
		System.out.println("└──────────────────┘");
		System.out.println();
		
		//꺼낼 때 유의점. exams[0].kor → 이렇게 꺼내지 말 것. 
		for(int i = 0; i < size; i++) {
			Exam exam = exams[i];
			int kor = exam.kor; //선언은 준비물. 연산이 아니기 때문에, 반복되는 과정에서 연산이되는 것이 아니다. 준비물은 미리 준비해놓고 동작하는 과정에서는 중복되지 않는다. for문 안에 있던 밖에 있던 한 번만 준비된다.
			int eng = exam.eng;
			int math = exam.math;
			
			int total = kor + eng + math;
			float avg = total/3.0f;
			
			System.out.printf("국어 : %d\n", kor);
			System.out.printf("영어 : %d\n", eng);
			System.out.printf("수학 : %d\n", math);
			
			System.out.printf("총점 : %3d\n", total);
			System.out.printf("평균 : %6.2f\n", avg);
			System.out.println("────────────────────────");
		}
	}

	private static void inputList(Exam[] exams, int current) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 입력    │");
		System.out.println("└──────────────────┘");
		System.out.println();
		
			int kor, eng, math;
			
			do 
			{
				System.out.printf("국어");
				kor = scan.nextInt();
				
				if(kor < 0 || 100 < kor)
				{
					System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");
				}
			}while(kor<0 || 100 <kor);

			do 
			{
				System.out.printf("영어 : ");
				eng = scan.nextInt();
				
				if(eng < 0 || 100 < eng)
				{
					System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");
				}
			}while(eng<0 || 100 < eng);
			
			do 
			{
				System.out.printf("수학 : ");
				math = scan.nextInt();
				
				if(math < 0 || 100 < math)
				{
					System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");
				}
			}while(math<0 || 100 < math);
		
			Exam exam = new Exam();
			exam.kor = kor;
			exam.eng = eng;
			exam.math = math;
			
			exams[current] = exam;
			current++;
	}

	static int inputMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("┌──────────────────┐");
		System.out.println("│     메인 메뉴    │");
		System.out.println("└──────────────────┘");
		System.out.println("\t1. 성적입력 ");
		System.out.println("\t2. 성적출력 ");
		System.out.println("\t3. 종료 ");
		System.out.print("\t선택> ");
		int menu = scan.nextInt();
		
		return menu;
	}
}
