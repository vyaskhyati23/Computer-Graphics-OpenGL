package Midterm_Project;

import java.util.ArrayList;

import Midterm_Project.Jama.Matrix;

public class cgCanvas extends simpleCanvas {
	
	ArrayList<Poly> P = new ArrayList<Poly>();
	private static int id = 0;
	Matrix transformation_Matrix = Matrix.identity(3, 3);
	Matrix translation_Matrix, rotation_Matrix, scaling_Matrix, viewport_Matrix,current_Matrix;
	float B, T, L, R;
	int x_view, y_view, h_view, w_view;
	Rasterizer r;
	float[] outx = new float[50]; 
	float[] outy = new float[50]; 
	
	
	// Constructor

	/**
	 * 
	 * @param w width of canvas
	 * @param h height of canvas
	 */
	cgCanvas(int w, int h) {
		super(w, h);
		r = new Rasterizer(h);

	}

	
	/**
	 * addPoly - Adds and stores a polygon to the canvas.
	 * Note that this method does not draw the polygon, but merely stores it for
	 * later draw. Drawing is initiated by the draw() method.
	 * 
	 * @param x - Array of x coordinates of the vertices of the polygon to be added
	 * @param y - Array of y coordinates of the vertices of the polygon to be added
	 * @param n - Number of vertices in polygon
	 * @return int id - unique id for each polygon
	 */
	public int addPoly(float x[], float y[], int n) {
		
		P.add(new Poly(x, y, n));
		return id++;

	}
	
	/**
	 *drawPoly - Draw the polygon with the given id. Should draw the
	 *polygon after applying the current transformation on the
	 *vertices of the polygon.
	 *
	 *@param polyID polygon id received from addPoly function.
	 */

	public void drawPoly(int polyID) {

		Poly p = P.get(polyID);				//fetches unique ID for each polygon
		clipper c = new clipper();
		float[] inx = new float[p.n]; 		// original polygon model x coordinates
		float[] iny = new float[p.n]; 		// original polygon model y coordinates

		double[][] v = new double[3][p.n];	//Matrix of size 3x(number of vertices)
		
		//Matrix is filled with x and y values 
		for (int i = 0; i < p.n; i++) {
			v[0][i] = p.x[i];
			v[1][i] = p.y[i];
			v[2][i] = 1;
		}
		Matrix current_Matrix = new Matrix(v);
		
		//performs all the transformations on the matrix
		current_Matrix = transformation_Matrix.times(current_Matrix);
		
		//fills inx and iny with all the x and y values from current_Matrix
		for (int i = 0; i < p.n; i++) {
			inx[i] = (float) current_Matrix.get(0, i);
			iny[i] = (float) current_Matrix.get(1, i);
		}


		//calling the clipPolygon function to clip against the clip edges.
		int outn = c.clipPolygon(p.n, inx, iny, outx, outy, L, B, R, T);

		//calculations for sx,sy,tx,ty.
		
		double sx = w_view / (R - L);
		double sy = h_view / (T - B);
		double tx = ((R * x_view) - (L * (x_view + w_view))) / (R - L);
		double ty = ((T * y_view) - (B * (y_view + h_view))) / (T - B);
		
		//setting the viewport matrix.
		double[][] viewport = { { sx, 0, tx }, 
								{ 0, sy, ty },
								{ 0, 0, 1 } };
		Matrix viewport_Matrix = new Matrix(viewport);

		//updating the current_Matrix with outn value received from clipPolygon function.
		v = new double[3][outn];
		for (int i = 0; i < outn; i++) {
			v[0][i] = outx[i];
			v[1][i] = outy[i];
			v[2][i] = 1;
		}
		current_Matrix = new Matrix(v);
		current_Matrix = viewport_Matrix.times(current_Matrix);
		
		
		//creating arrays outx1 and outy1 to store the final int x and y polygon coordinates.
		int[] outx1 = new int[outn];
		int[] outy1 = new int[outn];

		//System.out.println(outn);
		
		//fills outx1 and outy1 with all the x and y values from current_Matrix.
		for (int i = 0; i < outn; i++) {
			outx1[i] = (int) current_Matrix.get(0, i);
			outy1[i] = (int) current_Matrix.get(1, i);
		}

		// Draw the final coordinates using our earlier polygon filling code
		r.drawPolygon(outn,outx1, outy1,this);

		//drawOutline(outn, outx1, outy1);

	}


	/**
	 * 	clearTransform - Set the current transformation to the identity matrix.
	 */
	public void clearTransform() {
		//set matrix to identity matrix.
		transformation_Matrix = Matrix.identity(3, 3);
	}

	
	/**
	 * translate - Add a translation to the current transformation by
	 * pre-multiplying the appropriate translation matrix to
	 * the current transformation matrix.
	 * 
	 * @param x - Amount of translation in x
	 * @param y - Amount of translation in y
	 */
	public void translate(float x, float y) {
		  
		double[][] translation = { 
								 { 1, 0, x }, 
								 { 0, 1, y }, 
								 { 0, 0, 1 }
					};

		Matrix translation_Matrix = new Matrix(translation);
		transformation_Matrix = translation_Matrix.times(transformation_Matrix);
	}

	/**
	 * rotate - Add a rotation to the current transformation by
	 * pre-multiplying the appropriate rotation matrix to the
	 * current transformation matrix.
	 * 
	 * @param degrees - Amount of rotation in degrees
	 */

	public void rotate(float degrees) {
		
		double cos_theta = Math.cos(degrees * Math.PI / 180);
		double sin_theta = Math.sin(degrees * Math.PI / 180);
		double[][] rotation = {
								{ cos_theta, -(sin_theta), 0 }, 
								{ sin_theta, cos_theta, 0 }, 
								{ 0, 0, 1 }
							};

		Matrix rotation_Matrix = new Matrix(rotation);
		transformation_Matrix = rotation_Matrix.times(transformation_Matrix);
	}


	/**
	 * scale - Add a scale to the current transformation by pre-multiplying
	 * the appropriate scaling matrix to the current transformation matrix.
	 * 
	 * @param x- Amount of scaling in x
	 * @param y- Amount of scaling in y
	 */
	public void scale(float x, float y) {
		
		double[][] scale = { 
							{ x, 0, 0 },
							{ 0, y, 0 }, 
							{ 0, 0, 1 }
						};
		Matrix scaling_Matrix = new Matrix(scale);
		transformation_Matrix = scaling_Matrix.times(transformation_Matrix);

	}
	
	/**
	 * setClipWindow - defines the clip window coordinates.
	 * 
	 * @param bottom  - y coordinate of bottom edge of clip window (in world coordinates)
	 * @param top	  - y coordinate of top edge of clip window (in world coordinates)
	 * @param left	  - x coordinates of left edge of clip window (in world coordinates)
	 * @param right	  - x coordinates of right edge of clip window (in world coordinates)
	 */
	public void setClipWindow(float bottom, float top, float left, float right) {
		
		B = bottom;
		T = top;
		L = left;
		R = right;
	}

	
	/**
	 * setViewport - defines the viewport coordinates.
	 * 
	 * @param x 		- x coordinate of lower left of view window (in screen coordinates)
	 * @param y 		- y coordinate of lower left of view window (in screen coordinates)
	 * @param width 	- width of view window (in world coordinates)
	 * @param height 	- width of view window (in world coordinates)
	 */
	public void setViewport(int x, int y, int width, int height) {
		
		x_view = x;
		y_view = y;
		w_view = width;
		h_view = height;

		/*
		 * double sx=w_view/(R-L); double sy=h_view/(T-B); double
		 * tx=((R*x_view)-(L*(x_view+w_view)))/(R-L); double
		 * ty=((T*y_view)-(B*(y_view+h_view)))/(T-B);
		 * 
		 * double[][]viewport={{sx,0,tx},
		 * 						 {0,sy,ty},
		 * 							 {0,0,1}}; Matrix
		 * viewport_Matrix=new Matrix(viewport);
		 */

	}

}
