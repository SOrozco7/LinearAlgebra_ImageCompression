# LinearAlgebra_ImageCompression

Authors:

Salvador Orozco Villalever - A07104218
        
Luis Francisco Flores Romero - A01328937
        
Sebastián Salgado Sviercovich - A01329245

Version: 05/02/2017

Instructions:

1. Compile all the java classes with the following command:
	
	javac *.java

2. Run the Main class passing the input through a file with the following command:

	java Main < INPUT_FILE.txt

3. The input file must contain the following data in this order:

	n = amount of points in the image
	n lines each with the x, y coordinates of each points
	m = amount of transformations
	m lines each with the 6 values a, b, c, d, e, f corresponding to a single transformation

	This is an example of input file:

	4
	-2 2
	2 2
	2 -2
	-2 -2
	2
	2 -1 1 1 0 0 
	2 -1 1 1 0 0

