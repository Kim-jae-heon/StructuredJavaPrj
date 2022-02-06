package part3.ex5.추상화;

import java.util.Scanner;

public abstract class ExamConsole {
	//스스로 ExamConsole의 멤버임을 자청하면서 사용관계까지 있는 것. 
	//ExamConsole과 ExamList는 HAS A관계에 있음. 
	private ExamList list = new ExamList();
	
	void print() {
		print(list.size());
	}
	
	public void print(int size) {

		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 출력    │");
		System.out.println("└──────────────────┘");
		System.out.println();
		
		//int size = list.current;
		
		for(int i = 0; i < size; i++) {
			Exam exam = list.get(i);//this.exams[i];
			int kor = exam.getKor();//exam.kor; //선언은 준비물. 연산이 아니기 때문에, 반복되는 과정에서 연산이되는 것이 아니다. 준비물은 미리 준비해놓고 동작하는 과정에서는 중복되지 않는다. for문 안에 있던 밖에 있던 한 번만 준비된다.
			int eng = exam.getEng();
			int math = exam.getMath();
			
			int total = exam.total();//kor + eng + math;
			float avg = exam.avg();//total/3.0f;
			
			System.out.printf("국어 : %d\n", kor);
			System.out.printf("영어 : %d\n", eng);
			System.out.printf("수학 : %d\n", math);
			
			onPrint(exam);//print할 때 사용할 수 있는 data를 넘겨주면서 출력하는 것.
			
			System.out.printf("총점 : %3d\n", total);
			System.out.printf("평균 : %6.2f\n", avg);
			System.out.println("────────────────────────");
		}
	}
	
	

	public void input() {
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
			
			onInput(); //특정 사건에 기반하여 사용되는 함수라는 의미에서 event method라고 부른다.
		
			//Exam exam = new Exam(kor, eng, math);//Exam은 추상화되어 있으므로 객체화가 안된다.
			Exam exam = makeExam();
			exam.setKor(kor);
			exam.setEng(eng);
			exam.setMath(math);
			
			onInput(exam);
			list.add(exam);
	}

	protected abstract void onInput(Exam exam);

	protected abstract void onPrint(Exam exam);
	protected abstract void onPrint();//자식이 책임질 method는 추상 메서드로
	
	protected abstract void onInput();

	protected abstract Exam makeExam();
	
}
