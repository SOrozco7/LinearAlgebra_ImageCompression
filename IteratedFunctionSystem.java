// IteratedFunctionSystem.java

import java.util.*;
import java.io.*;

public class IteratedFunctionSystem{

	/*
		Constructor: 
		Método add para insertar a las transformaciones y las p's (por parejas) en una array list
		método executeTransformations: recibe una imagen y devuelve otra
		método reverseExecuteTransformations: recibe una imagen y devuelve otra
	*/

	private ArrayList<Transformation> totalTransformations;
	// private ArrayList<Double> totalProbabilities;

	public IteratedFunctionSystem(){

		totalTransformations = new ArrayList<Transformation>();
	}

	//p = probability
	// public void addTransformation(Transformation t, double p){
	public void addTransformation(Transformation t){

		totalTransformations.add(t);
		// totalProbabilities.add(p);
	}

	public Image executeTransformations(Image img, int direction){

		Image transformedImg = img;

		if(direction > 0){ //Forward execution

			for(Transformation t : totalTransformations)
				transformedImg = compressImage(transformedImg, t);
		}

		else{ //Reverse execution

			for(int i = totalTransformations.size() - 1; i >= 0; i--)
				transformedImg = decompressImage(img, totalTransformations.get(i));
		}

		return transformedImg;
	}	

	public Image compressImage(Image img, Transformation t){

		ArrayList<Point> newPoints = new ArrayList<Point>();	

		for(Point p : img.getPoints()){

			double newX = t.getA()*p.getX() + t.getB()*p.getY() + t.getE();
			double newY = t.getC()*p.getX() + t.getD()*p.getY() + t.getF();
			newPoints.add(new Point(newX, newY));
		}

		return new Image(newPoints);
	}

	public Image decompressImage(Image img, Transformation t){

		ArrayList<Point> newPoints = new ArrayList<Point>();	

		double a = t.getA();
		double b = t.getB();
		double c = t.getC();
		double d = t.getD();
		double e = t.getE();
		double f = t.getF();

		double revA = d/(a*d - b*c);
		double revB = b/(b*c - a*d);
		double revC = c/(b*c - a*d);
		double revD = a/(a*d - b*c);

		for(Point p : img.getPoints()){

			double newX = revA*(p.getX() - e) + revB*(p.getY() - f);
			double newY = revC*(p.getX() - e) + revD*(p.getY() - f);
			newPoints.add(new Point(newX, newY));
		}

		return new Image(newPoints);
	}
}