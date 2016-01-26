package Day16_160119;

public class ThreadEx3 {
	public static void main(String[] args) {
		MyThreadEx3_1 t1 = new MyThreadEx3_1();
		t1.run();
	}
}
class MyThreadEx3_1 extends Thread{
	public void run(){
		thorwException();
	}
	public void thorwException(){
		try{
			throw new Exception();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
