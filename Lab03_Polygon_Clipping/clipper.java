package Lab03;
//

//  Clipper.java
//
//  Created by Joe Geigel on 1/21/10.
//  Copyright 2010 Rochester Institute of Technology. All rights reserved.
//
//  Contributor:  KHYATI K.VYAS
//

///
// Object for performing clipping
//
///

public class clipper {

	///
	// clipPolygon
	//
	// Clip the polygon with vertex count in and vertices inx/iny
	// against the rectangular clipping region specified by lower-left corner
	// (llx,lly) and upper-right corner (urx,ury). The resulting vertices are
	// placed in outx/outy.
	//
	// The routine should return the the vertex count of the polygon
	// resulting from the clipping.
	//
	// @param in the number of vertices in the polygon to be clipped
	// @param inx - x coords of vertices of polygon to be clipped.
	// @param iny - y coords of vertices of polygon to be clipped.
	// @param outx - x coords of vertices of polygon resulting after clipping.
	// @param outy - y coords of vertices of polygon resulting after clipping.
	// @param llx - x coord of lower left of clipping rectangle.
	// @param lly - y coord of lower left of clipping rectangle.
	// @param urx - x coord of upper right of clipping rectangle.
	// @param ury - y coord of upper right of clipping rectangle.
	//
	// @return number of vertices in the polygon resulting after clipping
	//
	///
	public float lx, ly, ux, uy;
	public float x_intersection, y_intersection;
	public int boundry;

	/**
	 * Function to check if point(x,y) is within the polygon or not.
	 * 
	 * @param x
	 *            :x- co:ordinate of point being checked.
	 * @param y
	 *            :y- co:ordinate of point being checked.
	 * @return true :if point is within the clipping window. false:if point is
	 *         outside the clipping window.
	 */
	public boolean insideThePolygon(float x, float y, int boundry, float edge[]) {

		if (boundry == 0 && y > edge[1])
			return true;
		else if (boundry == 1 && x < edge[0])
			return true;
		else if (boundry == 2 && y < edge[1])
			return true;
		else if (boundry == 3 && x > edge[0])
			return true;
		else
			return false;

	}

	/**
	 * Function to find the intersection between the edge of the polygon with
	 * the edge of the clipping window.
	 * 
	 * @param px
	 *            : x co-ordinate of 1 end of the polygon edge.
	 * @param py
	 *            : y co-ordinate of 1 end of the polygon edge.
	 * @param sx
	 *            : x co-ordinate of other end of the polygon edge.
	 * @param sy
	 *            : y co-ordinate of other end of the polygon edge.
	 * @param boundry
	 *            :denotes if the boundry of the clipping window is in what
	 *            direction compared
	 */
	public void intersection(float px, float py, float sx, float sy, int boundry) {
		float slope = ((sy - py) / (sx - px));

		if (boundry == 0) 								// BOTTOM
			{
			x_intersection = px + (ly - py) / slope;
			y_intersection = ly;
			}
		else if (boundry == 1) 							// RIGHT
			{
			x_intersection = ux;
			y_intersection = py + (ux - px) * slope;
			} 
		else if (boundry == 2) 							// TOP
			{
			x_intersection = px + (uy - py) / slope;
			y_intersection = uy;
			} 
		else if (boundry == 3) 							// LEFT
			{
			x_intersection = lx;
			y_intersection = py + (lx - px) * slope;
			}

	}
	
	/**
	 * 
	 * @param in 		: number of vertices in the polygon to be clipped
	 * @param inx		: x coords of vertices of polygon to be clipped.
	 * @param iny       : y coords of vertices of polygon to be clipped.
	 * @param tempX		: x coords of vertices of polygon after clipping
	 * @param tempY		: y coords of vertices of polygon after clipping.
	 * @param edge		: edges stores the four edges of the clipping window.
	 * @param boundry	: denotes the bottom/right/top/left edge of clipping window.
	 * @return			: number of vertices of the clipped polygon.
	 */

	public int SHPC(int in, float[] inx, float[] iny, float[] tempX, float tempY[], float[] edge, int boundry) {

		float px, py, sx, sy;
		int vertex = 0;
		
		//If vertex is 0(green polygon).
		if (in != 0) {
			px = inx[in - 1]; 			// x cordinate of the last vertex of polygon.
			py = iny[in - 1];			// y cordinate of the last vertex of polygon.
		}							 
		else {
			px = inx[0];
			py = iny[0];
		}

		int index = 0;
		for (int i = 0; i < in; i++) {
			sx = inx[i]; 				// x cordinate of the first vertex of polygon.
			sy = iny[i]; 				// y cordinate of the first vertex of polygon.

			if (insideThePolygon(sx, sy, boundry, edge)) { 				// case 1 and 4
				if (insideThePolygon(px, py, boundry, edge)) { 			// case 1
					tempX[index] = sx;
					tempY[index++] = sy;
					vertex++;
				} else {												 // case 4
					intersection(px, py, sx, sy, boundry);
					tempX[index] = x_intersection;
					tempY[index] = y_intersection;
					index++;
					vertex++;
					tempX[index]    = sx;
					tempY[index++]  = sy;
					vertex++;
				}

			} else { 													// case 2
				if (insideThePolygon(px, py, boundry, edge)) {
					intersection(px, py, sx, sy, boundry);
					tempX[index] = x_intersection;
					tempY[index++] = y_intersection;
					vertex++;
				}
			}
			px = sx;
			py = sy;
		}
		return vertex; // should return number of vertices in clipped poly
	}

	
	/**
	 * @param in the number of vertices in the polygon to be clipped
	// @param inx - x coords of vertices of polygon to be clipped.
	// @param iny - y coords of vertices of polygon to be clipped.
	// @param outx - x coords of vertices of polygon resulting after clipping.
	// @param outy - y coords of vertices of polygon resulting after clipping.
	// @param llx - x coord of lower left of clipping rectangle.
	// @param lly - y coord of lower left of clipping rectangle.
	// @param urx - x coord of upper right of clipping rectangle.
	// @param ury - y coord of upper right of clipping rectangle.
	//@return number of vertices in the polygon resulting after clipping
	 
	 */

	public int clipPolygon(int in, float inx[], float iny[], float outx[], float outy[], float llx, float lly,
			float urx, float ury) {
		lx = llx;
		ly = lly;
		ux = urx;
		uy = ury;
		float[][] edge = new float[4][4];

		edge[0][0] = llx;
		edge[0][1] = lly; // bottom edge of clipping window.
		edge[0][2] = urx;
		edge[0][3] = lly;

		edge[1][0] = urx;
		edge[1][1] = lly; // right edge of clipping window.
		edge[1][2] = urx;
		edge[1][3] = ury;

		edge[2][0] = urx;
		edge[2][1] = ury; // top edge of clipping window.
		edge[2][2] = llx;
		edge[2][3] = ury;

		edge[3][0] = llx;
		edge[3][1] = ury; // left edge of clipping window.
		edge[3][2] = llx;
		edge[3][3] = lly;
		
		//Temporarily stores the output vertex.
		float[] tempX = new float[50];
		float[] tempY = new float[50];

		int v = 0;
		//Calls the SHPC function for each clipping edge.
		v = SHPC(in, inx, iny, tempX, tempY, edge[0], 0); 	//bottom
		v = SHPC(v, tempX, tempY, outx, outy, edge[1], 1);	//right
		v = SHPC(v, outx, outy, tempX, tempY, edge[2], 2);	//top
		v = SHPC(v, tempX, tempY, outx, outy, edge[3], 3);	//left

		return v;
	}
}