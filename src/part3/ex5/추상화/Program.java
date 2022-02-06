package part3.ex5.추상화;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		//멤버관계에 있지 않고 사용관계에만 있는 것
		//Dependency 관계에 있음을 의미.
		ExamConsole list = new NewlecExamConsole();
		
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
				list.inputList();
				
				break;
			case 2:
				list.printKors();
				
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
