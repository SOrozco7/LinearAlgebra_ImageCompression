// Point.java

import java.util.*;
import java.io.*;

public class Point{

	private double x;
	private double y;

	public Point(double x, double y){

		setX(x);
		setY(y);
	}

	public void setX(double x){

		this.x = x;
	}

	public void setY(double y){

		this.y = y;
	}

	public double getX(){

		return x;
	}

	public double getY(){

		return y;
	}

	public String toString(){

		return "(" + x + ", " + y + ")";
	}
}