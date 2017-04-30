// Transformation.java

import java.util.*;
import java.io.*;

public class Transformation{

	private double a;
	private double b;
	private double c;
	private double d;
	private double e;
	private double f;
	private double r;
	private double s;
	private double theta;
	private double phi;

	/*
		Constructor: recibe a, b, c, d, e, f
		Constructor: recibe r, s, theta, phi, e, f
		Sets
		gets
	*/

	/**
	*	Constructor which receives a, b, c, d, e and f.
	*/
	public Transformation(double a, double b, double c, double d, double e, double f, boolean byMatrix){

		if(byMatrix){

			setA(a);
			setB(b);
			setC(c);
			setD(d);
			setE(e);
			setF(f);

			computeTheta();
			computePhi();
			computeR();
			computeS();
		}

		else{

			setR(r);
			setS(s);
			setTheta(theta);
			setPhi(phi);
			setE(e);
			setF(f);

			computeA();
			computeB();
			computeC();
			computeD();
		}
	}

	public Transformation(double[] transformationValues, boolean byMatrix){

		if(byMatrix){

			setA(transformationValues[0]);
			setB(transformationValues[1]);
			setC(transformationValues[2]);
			setD(transformationValues[3]);
			setE(transformationValues[4]);
			setF(transformationValues[5]);

			computeTheta();
			computePhi();
			computeR();
			computeS();
		}

		else{

			setR(transformationValues[0]);
			setS(transformationValues[1]);
			setTheta(transformationValues[2]);
			setPhi(transformationValues[3]);
			setE(transformationValues[4]);
			setF(transformationValues[5]);

			computeA();
			computeB();
			computeC();
			computeD();
		}
	}

	/**	
	*	Set the value of a
	*/
	public void setA(double a){

		this.a = a;
	}

	/**	
	*	Set the value of b
	*/
	public void setB(double b){

		this.b = b;
	}

	/**	
	*	Set the value of c
	*/
	public void setC(double c){

		this.c = c;
	}

	/**	
	*	Set the value of d
	*/
	public void setD(double d){

		this.d = d;
	}

	/**	
	*	Set the value of e
	*/
	public void setE(double e){

		this.e = e;
	}

	/**	
	*	Set the value of f
	*/
	public void setF(double f){

		this.f = f;
	}

	public void setR(double r){

		this.r = r;
	}

	/**	
	*	Set the value of s
	*/
	public void setS(double s){

		this.s = s;
	}

	/**	
	*	Set the value of theta
	*/
	public void setTheta(double theta){

		this.theta = theta;
	}

	/**	
	*	Set the value of phi
	*/
	public void setPhi(double phi){

		this.phi = phi;
	}

	/**	
	*	Compute a given r and theta
	*/
	public void computeA(){

		a = r*Math.cos(theta);
	}

	/**	
	*	Compute b given s and phi
	*/
	public void computeB(){

		b = -s*Math.sin(phi);
	}

	/**	
	*	Compute c given r and theta
	*/
	public void computeC(){

		c = r*Math.sin(theta);
	}

	/**	
	*	Compute d given s and phi
	*/
	public void computeD(){

		d = s*Math.cos(phi);
	}

	/**	
	*	Compute r given a and theta
	*/
	public void computeR(){

		r = a/Math.cos(theta);
	}

	/**	
	*	Compute s given d and phi
	*/
	public void computeS(){

		s = d/Math.cos(phi);
	}

	/**	
	*	Compute theta given a and b
	*/
	public void computeTheta(){

		theta = Math.atan(c/a);
	}

	/**	
	*	Compute phi given c and d
	*/
	public void computePhi(){

		phi = Math.atan(-1.0*b/d);
	}

	/**
	*	Get a
	*/	
	public double getA(){

		return a;
	}

	/**
	*	Get b
	*/
	public double getB(){

		return b;
	}

	/**
	*	Get c
	*/
	public double getC(){

		return c;
	}

	/**
	*	Get d
	*/
	public double getD(){

		return d;
	}

	/**
	*	Get e
	*/
	public double getE(){

		return e;
	}

	/**
	*	Get f
	*/
	public double getF(){

		return f;
	}

	/**
	*	Get r
	*/
	public double getR(){

		return r;
	}

	/**
	*	Get s
	*/
	public double getS(){

		return s;
	}

	/**
	*	Get theta
	*/
	public double getTheta(){

		return theta;
	}

	/**
	*	Get phi
	*/
	public double getPhi(){

		return phi;
	}

	/**
	*	toString to describe the transformation
	*/
	public String toString(){

		return ("a = " + a + "; b = " + b + "; c = " + c + "; d = " + d + "; e = " + e + "; f = " + f 
				+ " \n r = " + r + "; s = " + s + "; theta = " + theta + "; phi = " + phi);
	}
}