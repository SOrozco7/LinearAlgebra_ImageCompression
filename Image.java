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
	
	/**
		Blank constructor
	*/
	public Image() {
		this.setPoints(new ArrayList<Point>());
		this.setWidth(DEFAULT_WIDTH); 
		this.setHeight(DEFAULT_HEIGHT);
	}
	
	/**
		Default image constructor
		
		@param		points		ArrayList of image points
		@param		width		The image witdh
		@param		height		The image height
	*/
	public Image(ArrayList<Point> points) {
		this.setPoints(points);
		this.setWidth(DEFAULT_WIDTH);
		this.setHeight(DEFAULT_HEIGHT);
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
	
	/**
		Plots image to JFrame
	*/
	public void plot() {
		
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(DEFAULT_HEIGHT, DEFAULT_HEIGHT));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setLayout(null);
		JLabel[] labels = new JLabel[this.points.size()];
		
		for(int i = 0; i < this.points.size(); i++) {
			
			labels[i] = new JLabel();
			labels[i].setBackground(Color.BLACK);
			labels[i].setBounds((int) points.get(i).getX(), (int) points.get(i).getY(), 1, 1);
			frame.add(labels[i]);
		}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}