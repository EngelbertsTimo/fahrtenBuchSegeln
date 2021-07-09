package fahrtenbuch.segeln.entity;

public class Fahrt {

	private Boot boot;
	private long start;
	
	public void startFahrt() {
		start = System.currentTimeMillis();
		System.out.println(start);
	}
	
}
