package part2.ex3.데이터구조화;

import java.util.Scanner;

public class ExamProgram {
	
	public static void main(String[] args) { 
		
		Exam exam = new Exam(); //참조형식은 new를 통해 만든 객체를 대입해야한다. new를 통해 만들면 전부 객체라고 부른다.
		//exam이라는 변수는 '참조'변수가 된다. 참조변수는 개념적으로 주소가 존재하지 않는다.객체를 식별하게끔 도와주는 이름이라고 생각하면 좋다.
		//Exam이라고하는 사용자가 정의한 구조형식을 선언하고 공간을 만들어 값을 출력함.
		//참조형태로 사용가능하다의 뜻? 함수의 형태를 쓰더라도 Exam()은 공유가 되는 것. 
//		exam.kor = 30;
//		exam.eng = 40;
//		exam.math = 50;
//		
//		System.out.printf("kor:%d\n", exam.kor);
		
		input(exam);
		
		print(exam);
	}

	private static void print(Exam exam) {
		
		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 출력    │");
		System.out.println("└──────────────────┘");
		System.out.println();
		
		int kor = exam.kor;
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

	private static void input(Exam exam) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 입력    │");
		System.out.println("└──────────────────┘");
		System.out.println();
		
		int kor, eng, math;
		
		do 
		{
			System.out.printf("국어: ");
			kor = scan.nextInt();
			
			if(kor < 0 || 100 < kor)
			{
				System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");
			}
		}while(kor<0 || 100 < kor);
		
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
		
		exam.kor = kor;
		exam.eng = eng;
		exam.math = math;
		scan.close();
	}
}
