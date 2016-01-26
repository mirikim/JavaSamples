package Day8_160107;

public class RepairableTest {
	public static void main(String[] args) {
		Tank tank = new Tank();
		Dropship dropship = new Dropship();

		Marine marine = new Marine();
		SCV scv = new SCV();

		scv.repair(tank);// SCV가 Tank를 수리하도록한다.
		scv.repair(dropship);
		// scv.repair(marine);
		// 에러! repair(Repairable) int SCV cannot be applied to (Marine)

	}
}

interface Repairable {
}

class GroundUnit extends Unit2 {
	GroundUnit(int hp) {
		super(hp);
	}
}

class AirUnit extends Unit2 {
	AirUnit(int hp) {
		super(hp);
	}
}

class Unit2 {
	int hitPoint;
	final int MAX_HP;

	Unit2(int hp) {
		MAX_HP = hp;
	}
}

class Tank extends GroundUnit implements Repairable {
	public Tank() {
		// TODO Auto-generated constructor stub
		super(150);// Tank의 HP는 150이다.
		hitPoint = MAX_HP;

	}

	public String toString() {
		return "Tank";
	}
}

class Dropship extends AirUnit implements Repairable {
	public Dropship() {
		// TODO Auto-generated constructor stub
		super(125);// Dropship의 HP는 125이다.
		hitPoint = MAX_HP;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Dropship";
	}
}

class Marine extends GroundUnit {
	public Marine() {
		// TODO Auto-generated constructor stub
		super(40);
		hitPoint = MAX_HP;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Marine";
	}
}

class SCV extends GroundUnit implements Repairable {
	public SCV() {
		// TODO Auto-generated constructor stub
		super(60);
		hitPoint = MAX_HP;
	}

	void repair(Repairable r) {
		if (r instanceof Unit2) {
			Unit2 u = (Unit2) r;
			while (u.hitPoint != u.MAX_HP) {
				// Unit2의 HP를 증가시킨다.
				u.hitPoint++;
			}
			System.out.println(u.toString() + "의 수리가 끝났습니다.");
		}
	}
}
