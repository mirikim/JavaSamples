package Day9_160108;

public class ExceptionEx8 {
	public static void main(String[] args) {
		
		try{
			throw new Exception();// Exception을 강제로 발생시킨다.
		}catch(Exception e)	{
			System.out.println("Exception이 발생했습니다.");
		}
	}//main메서드의 끝
}
