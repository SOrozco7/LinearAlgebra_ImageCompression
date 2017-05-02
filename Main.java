// Main.java

import java.util.*;
import java.io.*;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;

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
	private static final int SIZE = 7;
	private final static int DEFAULT_HEIGHT = 1000;
	private final static int DEFAULT_WIDTH = 1000;

	public static void readPoints(){

		double x, y;
		totalPoints = new ArrayList<Point>();

		for(int i = 0; i < pointsAmount; i++){

			String line = sc.nextLine();
			String[] totN = line.split(" ");
			x = Double.parseDouble(totN[0]);
			y = Double.parseDouble(totN[1]);

			totalPoints.add(new Point(x, y));
		}
	}

	public static void readTransformations(JFrame frame){

		myIFS = new IteratedFunctionSystem(frame);

		for(int i = 0; i < transformationsAmount; i++){

			String line = sc.nextLine();
			String[] totValues = line.split(" ");

			for(int j = 0; j < TRANSFORMATION_TOTAL_VALUES; j++)
				transformationValues[j] = Double.parseDouble(totValues[j]);

			myIFS.addTransformation(new Transformation(transformationValues, true));
		}
	}

	public static void main(String[] args){

		pointsAmount = Integer.parseInt(sc.nextLine());

		readPoints();

		JFrame frame = new JFrame();
		frame.setBounds(0, 0, DEFAULT_HEIGHT, DEFAULT_HEIGHT);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setLayout(null);

		originalImg = new Image(totalPoints, frame);
		originalImg.plot(Color.BLACK, SIZE);
		System.out.println("Coordinates of the original image:");
		originalImg.displayPoints();

		System.out.println();

		transformationsAmount = Integer.parseInt(sc.nextLine());
		readTransformations(frame);

		compressedImage = myIFS.executeTransformations(originalImg, 1);
		compressedImage.plot(Color.BLUE, SIZE);
		System.out.println("Coordinates of the compressed image:");
		compressedImage.displayPoints();

		System.out.println();

		decompressedImage = myIFS.executeTransformations(compressedImage, -1);
		decompressedImage.plot(Color.RED, SIZE);
		System.out.println("Coordinates of the decompressed image:");
		decompressedImage.displayPoints();
	}
}