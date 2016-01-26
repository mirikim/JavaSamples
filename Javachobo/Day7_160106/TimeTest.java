package Day7_160106;

public class TimeTest {
	public static void main(String[] args) {
		Time t = new Time(12, 35, 30);
		System.out.println(t);// t = t.toString()과 같다.
		// t.hour = 13;//Time클래스와 TimeTest클래스는 각각 다른 클래스이므로 직접 설정할수없다.
		t.setHour(t.getHour() + 1);
		System.out.println(t);// 현재시간보다 1시간 후로변경
	}
}

class Time {
	private int hour;
	private int minute;
	private int second;

	Time(int hour, int minute, int second) {
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if (hour < 0 || hour > 23)
			return;
		this.hour = hour;
	}

	public int getMinute() {
		return minute;

	}

	public void setMinute(int minute) {
		if (minute < 0 || minute > 59)
			return;
		this.minute = minute;
	}

	public int getSecond() {
		return second;

	}

	public void setSecond(int second) {
		if (second < 0 || second > 59)
			return;
		this.second = second;
	}

	public String toString() {
		return hour + ":" + minute + ":" + second;
	}

}