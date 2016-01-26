package Day17_160120;

import java.awt.*;

public class ListTest {
	public static void main(String[] args) {
		Frame f= new Frame("List - Select");
		f.setSize(300,200);
		f.setLayout(null);
		
		List selectOne = new List(6);//6개 목록을 보여줄 수 있는 크기의 List를 만든다
		selectOne.setLocation(20,40);
		selectOne.setSize(100,120);
		selectOne.add("Student");
		selectOne.add("Teacher");
		selectOne.add("Driver");
		selectOne.add("Computer Programmer");
		selectOne.add("Sales Man");
		selectOne.add("Musician");
		selectOne.add("Director");
		
		//생성자의 두번째 인자값을 true로설정해서 List의 목록에서
		//여러개를 선택할 수 있게 했다.
		List selecMany = new List(6,true);
		selecMany.setLocation(150,40);
		selecMany.setSize(100,120);
		selecMany.add("Student");
		selecMany.add("Teacher");
		selecMany.add("Driver");
		selecMany.add("Computer Programmer");
		selecMany.add("Sales Man");
		selecMany.add("Musician");
		selecMany.add("Director");
		
		f.add(selectOne);
		f.add(selecMany);
		
		f.setVisible(true);
	}
}
