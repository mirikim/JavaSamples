package Day9_160108;

public class ExceptionEx3 {
public static void main(String[] args) {
	int number = 100;
	int result = 0;
	for(int i =0; i<10; i++){
		try{
			result = number/ (int)(Math.random()*10);
			System.out.println(result);
		}catch(ArithmeticException e){
			System.out.println("0으로 나누지마라");//java.lang.ArithmeticException이 발생하면 print문 실행
		}//try-catch의 끝
	}//for의 끝
}
}
