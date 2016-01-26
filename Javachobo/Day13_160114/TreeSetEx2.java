package Day13_160114;

import java.util.*;

public class TreeSetEx2 {
	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		int[]score = {85,95,50,35,45,65,10,100};
		
		for(int i = 0; i<score.length;i++){
			set.add(new Integer(score[i]));
		}
		
		System.out.println(set);
		System.out.println("50보다 작은 값 : " + set.headSet(new Integer(50)));//입력 값보다 작은 값 출력 headSet
		System.out.println("50보다 큰 값 : " +set.tailSet(new Integer(50)));//입력 값보다 큰 값 출력(입력값도포함) tailSet
	}
}
