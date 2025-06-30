package tw.brad.apis;

import java.util.ArrayList;

public class Line {
	private ArrayList<Point> points;
	public Line() {
		points = new ArrayList<>();
	}
//	public ArrayList<Point> getPoints() {
//		return points;
//	}
	public void addPoint(Point p) {
		points.add(p);
	}
	public Point getPoint(int index) {
		return points.get(index);
	}
	public int numberOfPoint() {return points.size();}
}
