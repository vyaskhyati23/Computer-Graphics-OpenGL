package Midterm_Project;
/**
 * 
 * @author Khyati K.Vyas 
 * 
 * Line number 21-22 : reference Chirag Kular.  
 * 
 */
class Poly {
	float[] x;
	float[] y;
	int n;
	
	/**
	 * 
	 * @param x - array of x coordinates of vertices of polygon to be added.
	 * @param y - array of y coordinates of vertices of polygon to be added.
	 * @param n - number of vertices of polygon.
	 */
	public Poly(float[] x, float[] y, int n) {
		this.x = x.clone();
		this.y = y.clone();
		this.n = n;

		for (int i = 0; i < n; i++) {
			x[i] = (int) x[i];
			y[i] = (int) y[i];
		}
	}
}
