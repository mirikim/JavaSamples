package Day7_160106;

class Card9 {
	final int NUMBER;
	final String KIND;
	static int width = 100;
	static int height = 250;
	
	// 생성자 안에서 final 변수를 초기화 해줄수도 있다. 객체마다 다르게 가질 수 있음.
	Card9(String kind, int num){
		KIND = kind;
		NUMBER = num;
	}
	
	Card9() {
		this("HEART",1);
	}
	
	public String toStirng(){ // toString - Object 클래스에 있는 것 오버라이드 해서 씀
		return ""+ KIND + " " + NUMBER;
	}
}
public class FinalCardTest {
	public static void main(String[] args) {
		Card9 c = new Card9("HEART", 10);
		
		//c.NUMBER = 5; // 에러!
		System.out.println(c.KIND);
		System.out.println(c.NUMBER);
	}

}
