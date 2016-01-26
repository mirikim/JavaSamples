package Day15_160118;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx3 {
	public static void main(String[] args) {
		String source = "HP:011-1111-1111, HOME:02-999-9999";
		String pattern = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";
		// \d = digit  (0\\d{1,2}) : 0으로시작하면서 최소2자리에서 최대3자리까지의 숫자
		// -(\\d{3,4}) : -로 구분후 최소3자리에서4자리의 숫자
		//-(\\d{4}): -로 구분후 4자리의 숫자.
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);
		
		int i=0;
		while(m.find()){//m.find() : iterator의 객체와 비슷하다 hasNext()와 비슷 =>다음아이템이 있는지?
			System.out.println(++i + ": " +m.group() +" -> " + m.group(1) +", " + m.group(2)+", " +m.group(3));
			//m.group() :정규식의 일부를 grouping을해서사용해서 값을 얻고자 할 때 사용함.
		}
	}
}
