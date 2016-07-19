package Lab02;

//
//  Created by Joe Geigel on 1/21/10.
//  Copyright 2010 Rochester Institute of Technology. All rights reserved.
//
//  Contributor:  KHYATI K.VYAS
//

///
//
// This is a class that performas rasterization algorithms
//
///

import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public class Rasterizer {



	/**
	 * number of scanlines
	 */

	double n_scanlines;

	/**
	 * Constructor
	 * 
	 * @param n
	 *            - number of scanlines
	 */

	Rasterizer(int n) {
		n_scanlines = n;
	}
  
 	private ArrayList<double[]> activeEdge;
	private ArrayList<ArrayList<double[]>> globalEdgeTable;
 
 
 
 	/**
	 * Creates the global edge table and fill its with buckets. buckets contain
	 * the minimum y value , maximum y value , x value of the minimum y value
	 * vertex and (1/slope) value.
	 * 
	 * @param n
	 *            - number of vertices of polygon
	 * @param x
	 *            - array containing x coordinates of polygon.
	 * @param y
	 *            - array containing y coordinates of polygon.
	 */
	private void globalET(int n, int[] x, int[] y) {

		for (int i = 0; i < n_scanlines; i++) {
			globalEdgeTable.add(new ArrayList<double[]>());
		}

		// System.out.println(globalEdgeTable.size());

		int nextVertex = 0;

		for (int currentVertex = 0; currentVertex < n; currentVertex++) {

			double[] bucket = new double[4];

			nextVertex = (currentVertex + 1) % n; 					// keeps the value within the range 0 to n
			if (y[currentVertex] != y[nextVertex]) {
				if (y[currentVertex] >= y[nextVertex]) {

					// bucket[0]=y[nextVertex];			//minimum y value
					bucket[1] = y[currentVertex];				//maximum y value
					bucket[2] = x[nextVertex];			//x value of vertex with minimum y value.

					if (y[currentVertex] != y[nextVertex]) {
						bucket[3] = ((double) (x[currentVertex] - x[nextVertex])) / ((double) (y[currentVertex] - y[nextVertex]));
					} else {
						bucket[3] = (int) Double.POSITIVE_INFINITY;
					}
				} 
				else {

					// bucket[0]=y[nextVertex];			//minimum y value
					bucket[1] = y[nextVertex];			//maximum y value
					bucket[2] = x[currentVertex];				//x value of vertex with minimum y value.

					if (y[currentVertex] != y[nextVertex]) {
						bucket[3] = ((double) (x[nextVertex] - x[currentVertex])) / ((double) (y[nextVertex] - y[currentVertex]));
					} else {
						bucket[3] = (int) Double.POSITIVE_INFINITY;
					}
				}

				int min = Math.min(y[currentVertex], y[nextVertex]);

				/**
				 * Adding the bucket to the global edge table based on minimum y
				 * value.
				 * 
				 */
            
      if(y[currentVertex] - y[nextVertex] != 0)
				{globalEdgeTable.get(min).add(bucket);}
			}
		}

	}

	/**
	 * Sorting the active edge table based on the minimum x value. 
	 * If x values are the same, sort based on the (1/m) value.
	 * 
	 */

	private void sort() {
		for (int m = 0; m < (activeEdge.size()); m++) {
			for (int k = 1; k < (activeEdge.size() - m); k++) {

				// sorting based on x value.
				if (activeEdge.get(k - 1)[2] > activeEdge.get(k)[2]) {
					Collections.swap(activeEdge, k - 1, k);
				}

				// sorting based on(1/m) value when x is same.
				else if (activeEdge.get(k - 1)[2] == activeEdge.get(k)[2]) {

					if (activeEdge.get(k - 1)[3] < activeEdge.get(k)[3]) {
						Collections.swap(activeEdge, k - 1, k);
					}
				}
			}
		}
	}

	/**
	 * Draw a filled polygon in the simpleCanvas C. The polygon has n distinct
	 * vertices. The coordinates of the vertices making up the polygon are
	 * stored in the x and y arrays. The ith v will have coordinate (x[i], y[i])
	 * You are to add the implementation here using only calls to C.setPixel()
	 * 
	 * @param n
	 *            - number of vertices of polygon
	 * @param x
	 *            - array containing x coordinates of polygon.
	 * @param y
	 *            - array containing y coordinates of polygon.
	 */

	public void drawPolygon(int n, int x[], int y[], simpleCanvas C) {

		globalEdgeTable = new ArrayList<ArrayList<double[]>>();
		activeEdge = new ArrayList<double[]>();

		/**
		 * Builds the global edge table.
		 */
		globalET(n, x, y);

		for (int i = 0; i < n_scanlines; i++) {

			/**
			 * Adding edges to the Active edge table from Global edge table
			 * whose minimum y value is equal to the scanline. table.
			 */
			activeEdge.addAll(globalEdgeTable.get(i));

			if (activeEdge.size() > 1) {
				/**
				 * And sorts them in the active edge table based on x value.
				 */
				sort();

				/**
				 * Removing edges from the active edge table whose maximum y
				 * value is equal to the scanline.
				 */
				for (int j = 0; j < activeEdge.size(); j++) {

					if (activeEdge.get(j)[1] <= i) {
						activeEdge.remove(j);
						j--;

					}
				}

				/**
				 * Printing pixels from currentVertex x value to nextVertex value of x.
				 */
        //int parity =0;
				for (int k = 0; k < activeEdge.size() - 1; k += 2) {
					for (int p = (int) activeEdge.get(k)[2]; p < activeEdge.get(k + 1)[2]; p++) {
					// if (parity == 0)
						try {
							C.setPixel(p, i);
            //   parity=1;
						} catch (Exception e) {
							System.out.println("scanline:" + i + "," + p);
						}
					}
					
				}

				/**
				 * If 1/slope is not infinity, after printing pixels, Updating x
				 * with (x+(1/m))
				 */

				for (int j = 0; j < activeEdge.size(); j++) {
					if (activeEdge.get(j)[3] != Double.POSITIVE_INFINITY) {
						activeEdge.get(j)[2] = activeEdge.get(j)[2] + activeEdge.get(j)[3];
					}
				}

			}
		}

	}


}