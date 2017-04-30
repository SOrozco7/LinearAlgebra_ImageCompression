// Main.java

import java.util.*;
import java.io.*;
import java.awt.Color;

public class Main{

	private static ArrayList<Point> totalPoints;
	private static Scanner sc = new Scanner(System.in);
	private static int pointsAmount;
	private static int transformationsAmount;
	private static Image originalImg;
	private static IteratedFunctionSystem myIFS; 
	private static final int TRANSFORMATION_TOTAL_VALUES = 6;
	private static double[] transformationValues = new double[TRANSFORMATION_TOTAL_VALUES]; //from a to f
	private static Image compressedImage;
	private static Image decompressedImage;
	private static final int SIZE = 5;

	public static void readPoints(){

		double x, y;
		totalPoints = new ArrayList<Point>();

		for(int i = 0; i < pointsAmount; i++){

			x = sc.nextDouble();
			y = sc.nextDouble();

			totalPoints.add(new Point(x, y));
		}
	}

	public static void readTransformations(){

		myIFS = new IteratedFunctionSystem();

		for(int i = 0; i < transformationsAmount; i++){

			for(int j = 0; j < TRANSFORMATION_TOTAL_VALUES; j++)
				transformationValues[j] = sc.nextDouble();

			myIFS.addTransformation(new Transformation(transformationValues, true));
		}
	}

	public static void main(String[] args){

		pointsAmount = sc.nextInt();

		readPoints();

		originalImg = new Image(totalPoints);
		originalImg.plot(Color.BLACK, SIZE);
		originalImg.displayPoints();

		transformationsAmount = sc.nextInt();
		readTransformations();

		compressedImage = myIFS.executeTransformations(originalImg, 1);
		compressedImage.plot(Color.BLUE, SIZE);
		compressedImage.displayPoints();

		decompressedImage = myIFS.executeTransformations(compressedImage, -1);
		decompressedImage.plot(Color.RED, SIZE);
		decompressedImage.displayPoints();
	}
}