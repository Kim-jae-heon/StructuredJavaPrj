package part3.ex5.추상화;

public class ExamList { 
	private Exam[] exams;
	private int current;
	
	public Exam get(int i) {
		// TODO Auto-generated method stub
		return this.exams[i];
	}

	public void add(Exam exam) {
		// TODO Auto-generated method stub
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

	public int size() { //current의 원의미에 따라 함수명을 정한다.
		// TODO Auto-generated method stub
		return current;
	}
}
