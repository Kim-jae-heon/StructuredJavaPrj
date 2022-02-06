package part2.ex2.탑다운예제;

public class Program {

	public static void main(String[] args) {

		int[][] lottos = null;
		int menu;
		boolean running = true;

		while (running) {
			menu = inputMenu();

			switch (menu) {
			case 1:
				lottos = createLottosAuto();
				break;
			case 2:
				lottos = createLottosManual();
				break;
			case 3:
				listLottos(lottos);
				break;
			case 4:
				running = false;
				break;
			default:
			}
			//여기까지는 구조만을 이용하여 만든 것. 
		}
	}

	private static void listLottos(int[][] lottos) {
		// TODO Auto-generated method stub
		
	}

	private static int[][] createLottosManual() {
		// TODO Auto-generated method stub
		return null;
	}

	private static int[][] createLottosAuto() {
		// TODO Auto-generated method stub
		return null;
	}

	private static int inputMenu() {
		
		
		
		return 0;
	}
	//프로그램을 만들 때에는 이정도의 복잡도를 가지고 구조를 만들어간다.
	//처음에 프로그램을 만들때엔 통짜로 만든다. 처음부터 구조를 설계하고 만들어갈 수 없다. 만들어본적이 있어야하기 때문. 

}
