// IFS.java

import java.util.*;
import java.io.*;

public class IFS{

	/*
		Constructor: 
		Método add para insertar a las transformaciones y las p's (por parejas) en una array list
		método executeTransformations: recibe una imagen y devuelve otra
		método reverseExecuteTransformations: recibe una imagen y devuelve otra
	*/

	private ArrayList<Transformation> totalTransformations;

	public IFS(){

		totalTransformations = new ArrayList<Transformation>();
	}

	public void addTransformation(Transformation t){

		totalTransformations.add(t);
	}
}