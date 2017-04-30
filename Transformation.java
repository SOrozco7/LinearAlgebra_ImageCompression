// Transformation.java

import java.util.*;
import java.io.*;

public class Transformation{

	/*
		Constructor: recibe a, b, c, d, e, f
		Constructor: recibe r, s, theta, phi, e, f
		Sets
		gets
	*/

	/**
	*	Constructor which receives a, b, c, d, e and f.
	*/
	public Transformation(double a, double b, double c, double d, double e, double f){

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

	/**
	*	Constructor which receives r, s, theta, phi, e and f.
	*/
	public Transformation(double r, double s, double theta, double phi, double e, double f){

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

	public void setA(double a){

		this.a = a;
	}

	public void setB(double b){

		this.b = b;
	}

	public void setC(double c){

		this.c = c;
	}

	public void setD(double d){

		this.d = d;
	}

	public void setE(double e){

		this.e = e;
	}

	public void setF(double f){

		this.f = f;
	}

	public void setR(double r){

		this.r = r;
	}

	public void setS(double s){

		this.s = s;
	}

	public void setTheta(double theta){

		this.theta = theta;
	}

	public void setPhi(double phi){

		this.phi = phi;
	}

	public void computeA(){

		a = r*Math.cos(theta);
	}

	public void computeB(){

		b = -s*Math.sin(phi);
	}

	public void computeC(){

		c = r*Math.sin(theta);
	}

	public void computeD(){

		d = s*Math.cos(phi);
	}

	public void computeR(){

		r = a/Math.cos(theta);
	}

	public void computeS(){

		s = d/Math.cos(phi);
	}

	public void computeTheta(){

		theta = Math.atan(b/a);
	}

	public void computePhi(){

		phi = Math.atan(-1.0*c/d);
	}

	public double getA(){

		return a;
	}

	public double getB(){

		return b;
	}

	public double getC(){

		return c;
	}

	public double getD(){

		return d;
	}

	public double getE(){

		return e;
	}

	public double getF(){

		return f;
	}

	public double getR(){

		return r;
	}

	public double getS(){

		return s;
	}

	public double getTheta(){

		return theta;
	}

	public double getPhi(){

		return phi;
	}
	
	public toString(){

		System.out.println("a = " + a + "; b = " + b + "; c = " + c + "; d = " + d + "; e = " + e + "; f = " + f);
		System.out.println("r = " + r + "; s = " + s + "; theta = " + theta + "; phi = " + phi);
	}
}