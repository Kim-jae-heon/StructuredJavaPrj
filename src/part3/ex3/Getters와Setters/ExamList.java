package part3.ex3.Getters와Setters;

import java.util.Scanner;

public class ExamList { //아직까지는 과도기에 있는 캡슐의 형태
	private Exam[] exams; //오류범위가 이 안쪽에서만 발생한다는 것을 확인할 수 있음
	private int current;
	
	void printKors() {
		printKors(this.current);
	}
	
	public void printKors(int size) {

		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 출력    │");
		System.out.println("└──────────────────┘");
		System.out.println();
		
		//int size = list.current;
		Exam[] exams = this.exams;
		
		//꺼낼 때 유의점. exams[0].kor → 이렇게 꺼내지 말 것. 
		for(int i = 0; i < size; i++) {
			Exam exam = exams[i];
			int kor = exam.getKor();//exam.kor; //선언은 준비물. 연산이 아니기 때문에, 반복되는 과정에서 연산이되는 것이 아니다. 준비물은 미리 준비해놓고 동작하는 과정에서는 중복되지 않는다. for문 안에 있던 밖에 있던 한 번만 준비된다.
			int eng = exam.getEng();
			int math = exam.getMath();
			
			int total = exam.total();//kor + eng + math;
			float avg = exam.avg();//total/3.0f;
			
			System.out.printf("국어 : %d\n", kor);
			System.out.printf("영어 : %d\n", eng);
			System.out.printf("수학 : %d\n", math);
			
			System.out.printf("총점 : %3d\n", total);
			System.out.printf("평균 : %6.2f\n", avg);
			System.out.println("────────────────────────");
		}
	}
	

	public void inputList() {
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
		
			Exam exam = new Exam(kor, eng, math);
			
			/*
			Exam exam = new Exam();
			exam.setKor(kor);
			exam.setEng(eng);
			exam.setMath(math);
			*/
			
//			if(!exams의 공간이 있는지) {
//				공간 늘려주기
//			}
			
			Exam[] exams = this.exams;
			int size = this.current;
			
			if(exams.length == size) {
				//1. 크기가 5개정도 더 큰 새로운 배열을 생성하시오.
				Exam[] temp = new Exam[size + 5];
				//2. 값을 이주시키기
				for(int i = 0; i < size; i++) {
					temp[i] = exams[i];
				}
				//3. exams의 참조값 변경해주기. list.exams가 새로만든 temp 배열을 참조할 수 있도록 한다.
				this.exams = temp;
				
			}
			
			this.exams[this.current] = exam;
			this.current++; //list로 객체화를 해줌으로써 이제 공유가되기 시작함.
	}
	
	public ExamList() {
		this.exams = new Exam[3]; //this라는 것은 지울 수 있다면 지워서 쓰는 것이 좋다.
		this.current = 0;
	}
}
