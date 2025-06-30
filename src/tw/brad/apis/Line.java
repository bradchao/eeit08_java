package tw.brad.apis;

import java.awt.Color;
import java.util.ArrayList;

public class Line {
	private ArrayList<Point> points;
	private Color color;
	
	public Line(Color color) {
		points = new ArrayList<>();
		this.color = color;
	}
	public void addPoint(Point p) {
		points.add(p);
	}
	public Point getPoint(int index) {
		return points.get(index);
	}
	public int numberOfPoint() {return points.size();}
	public Color getColor() {return color;}
}
