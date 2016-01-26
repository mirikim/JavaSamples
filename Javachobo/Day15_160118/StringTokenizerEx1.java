package Day15_160118;

import java.util.*;

public class StringTokenizerEx1 {
	public static void main(String[] args) {
		String source = "100,200,300,400"; //Token으로 자를 문자열
		StringTokenizer st = new StringTokenizer(source,",");
		
		while(st.hasMoreTokens()){//
			System.out.println(st.nextToken());
		}
	}
}
