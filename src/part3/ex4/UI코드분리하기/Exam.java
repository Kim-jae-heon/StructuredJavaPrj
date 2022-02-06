package part3.ex4.UI코드분리하기;

public class Exam { //data속성을 외부로 노출할 때엔 getter, setter를 이용할 것
	int kor;
	int eng;
	int math;
	
	public Exam() {
		// TODO Auto-generated constructor stub
		this(0,0,0);
	}
	
	public Exam(int kor, int eng, int math) {
		// TODO Auto-generated constructor stub
		this.kor = kor; //우선순위가 지역변수의 변수가 더 높다. 따라서 묵시적 this는 지역변수와 이름이 같은 경우 써주어야 한다.
		this.eng = eng;
		this.math = math;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int total() {
		// TODO Auto-generated method stub
		return kor+eng+math;
	}
	public float avg() {
		// TODO Auto-generated method stub
		return total()/3.0f;
	}
}
