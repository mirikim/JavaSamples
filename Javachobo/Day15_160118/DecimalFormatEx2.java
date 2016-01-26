package Day15_160118;

import java.text.*;

public class DecimalFormatEx2 {
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#,###.##");
		DecimalFormat df2 = new DecimalFormat("#.###E0");

		try {
			Number num = df.parse("1,234,567.89");
			//문자열을 숫자로 parseInt와같은 메서드는
			// ","가들어간 문자열은 parsing할수 없다.
			System.out.print("1,234,567.89" + " -> ");

			double d = num.doubleValue();
			System.out.print(d + " -> ");

			System.out.println(df2.format(num));
		} catch (Exception e) {
		}
	}// main
}
