package tw.brad.apis;

import java.io.Serializable;

public class Point implements Serializable{
	private int x, y;
	public Point(int x, int y) {
		this.x = x; this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
}
