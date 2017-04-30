// Main.java

import java.util.*;
import java.io.*;

public class Main{

	private static ArrayList<Point> totalPoints;
	private static Scanner sc = new Scanner(System.in);
	private static int pointsAmount;
	private static Image originalImg;
	
	public static void readPoints(){


	}

	public static void main(String[] args){

		totalPoints = new ArrayList<Point>();
		pointsAmount = sc.nextInt();
		double x, y;

		for(int i = 0; i < pointsAmount; i++){

			x = sc.nextDouble();
			y = sc.nextDouble();

			totalPoints.add(new Point(x, y));
		}

		originalImg = new Image(totalPoints);
		originalImg.plot();
	}
}