// Image.java

import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class Image {

	/*
		Constructor: recibe array list de puntos y dimensiones
		plot: dibuja los puntos
	*/
	private ArrayList<Point> points;
	private int width;
	private int height;
	private final int DEFAULT_HEIGHT = 500;
	private final int DEFAULT_WIDTH = 500;
	private int OFFSET_X; 
	private int OFFSET_Y;
	private JFrame frame;
	
	/**
	*	Blank constructor
	*/
	public Image() {

		this.setPoints(new ArrayList<Point>());
		this.setWidth(DEFAULT_WIDTH); 
		this.setHeight(DEFAULT_HEIGHT);
		OFFSET_X = this.width/2;
		OFFSET_Y = this.height/2;
	}
	
	/**
		Default image constructor
		
		@param		points		ArrayList of image points
		@param		width		The image witdh
		@param		height		The image height
	*/
	public Image(ArrayList<Point> points, JFrame frame) {
		this.setPoints(points);
		this.setWidth(DEFAULT_WIDTH);
		this.setHeight(DEFAULT_HEIGHT);
		this.setFrame(frame);
	}

	public void setFrame(JFrame frame){

		this.frame = frame;
	}
	
	/**
		Accesor for the points ArrayList
		
		@return		The ArrayList of the image points
	*/
	public ArrayList<Point> getPoints() {
		return this.points;
	}
	
	/**
		Accessor for the image width
		
		@return		The width of image
	*/
	public int getWidth() {
		return this.width;
	}
	
	/**
		Accessor for the image height
		
		@return		The height of image
	*/
	public int getHeight() {
		return this.height;
	}
	
	/**
		Mutator for the points ArrayList
		
		@param		pointsArrayList		The new ArrayList of points for the image
	*/
	public void setPoints(ArrayList<Point> pointsArrayList) {
		this.points = pointsArrayList;
	}
	
	/**
		Mutator for the image width
		
		@param		width		The width for the image
	*/
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
		Mutator for the image height
		
		@param		height		The height for the image
	*/
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void addAxes(JLayeredPane layeredPane, int size){
		
		JLabel yAxis = new JLabel();
		yAxis.setBackground(Color.GRAY);
		yAxis.setOpaque(true);
		if(size % 2 == 0)
			yAxis.setBounds(this.width/2 + size/2, 0, 2, /*this.height*/800);
		else
			yAxis.setBounds(this.width/2 + size/2, 0, 1, /*this.height*/800);
		layeredPane.add(yAxis, new Integer(2));

		JLabel xAxis = new JLabel();
		xAxis.setBackground(Color.GRAY);
		xAxis.setOpaque(true);
		if(size % 2 == 0)
			xAxis.setBounds(0, this.height/2 + size/2, /*this.width*/1280, 2);
		else
			xAxis.setBounds(0, this.height/2 + size/2, /*this.width*/1280, 1);
		layeredPane.add(xAxis, new Integer(2));
	}

	/**
		Plots image to JFrame
	*/
	public void plot(Color c, int size) {
		
		JLayeredPane layeredPane = frame.getLayeredPane();
		
		addAxes(layeredPane, size);
		
		JLabel[] labels = new JLabel[this.points.size()];
		for(int i = 0; i < this.points.size(); i++) {
			
			labels[i] = new JLabel();
			labels[i].setBackground(c);
			labels[i].setOpaque(true);
			labels[i].setBounds((int) (points.get(i).getX()*size) + this.width/2, (int) (-points.get(i).getY()*size) + this.height/2, size, size);
			layeredPane.add(labels[i], new Integer(3));
		}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void displayPoints(){

		for(Point p : points)
			System.out.println(p);
	}
}