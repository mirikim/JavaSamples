package Day15_160118;

import java.util.*;

public class StringTokenizerEx3 {
	public static void main(String[] args) {
		String source = "1,김천재,100,100,100|2,박수재,95,80,90|3,이자바,80,90,90";
		
		StringTokenizer st= new StringTokenizer(source, "|");
		//("|")를 기준으로 토큰을 만들고
		while(st.hasMoreTokens()){
			String token = st.nextToken();
			//위에서 생성된 토큰을 ","을 기준으로 잘른다.
			StringTokenizer st2 = new StringTokenizer(token, ",");
			while(st2.hasMoreTokens()){
				System.out.println(st2.nextToken());
			}
			System.out.println("--------");
		}
	}
}
