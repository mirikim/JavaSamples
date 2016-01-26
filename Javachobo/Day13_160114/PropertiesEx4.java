package Day13_160114;

import java.util.*;

public class PropertiesEx4 {
	public static void main(String[] args) {
		Properties sysProp = System.getProperties();//java System의 속성정보.
		System.out.println("java.version : " + sysProp.getProperty("java.version"));
		System.out.println("user.language : " + sysProp.getProperty("user.language"));
		sysProp.list(System.out);
	}
}
