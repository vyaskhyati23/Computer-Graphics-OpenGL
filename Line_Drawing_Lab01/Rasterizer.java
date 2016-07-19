//
//  Rasterizer.java
//
//  Created by Joe Geigel on 1/21/10.
//  Copyright 2010 Rochester Institute of Technology. All rights reserved.
//
//  Contributor: KHYATI K.VYAS
//

///
// 
// A simple class for performing rasterization algorithms.
//
///

import java.util.*;


public class Rasterizer {
    
    ///
    // number of scanlines
    ///

    int n_scanlines;
    
    ///
    // Constructor
    //
    // @param n number of scanlines
    //
    ///

    Rasterizer (int n)
    {
        n_scanlines = n;
    }
    
    ///
    // Draw a line from (x0,y0) to (x0, y0) on the simpleCanvas C.
    //
    // Implementation should be using the Midpoint Method
    //
    // You are to add the implementation here using only calls
    // to C.setPixel()
    //
    // @param x0 x coord of first endpoint
    // @param y0 y coord of first endpoint
    // @param x0 x coord of second endpoint
    // @param y0 y coord of second endpoint
    // @param C  The canvas on which to apply the draw command.
    ///

    public void drawLine (int x0, int y0, int x1, int y1, simpleCanvas C)
    {
        // YOUR IMPLEMENTATION GOES HERE
   
    	/*
    	 * slope is outside range -1 and 1
    	 * */
    	
    	boolean swap = false;
    	if (Math.abs(y1 - y0) > Math.abs(x1 - x0)) {
    	    swap = true;
    	    int temp = x0;
    	    x0 = y0;
    	    y0 = temp;
    	    temp = x1;
    	    x1 = y1;
    	    y1 = temp;
    	}
        
    	/*
    	 * If line goes from right to left,swapping (x0,y0) with (x1,y1)
    	 */
    	
    	if (x1 - x0 < 0) {
    	    int temp = x0;
    	    x0 = x1;
    	    x1 = temp;
    	    temp = y0;
    	    y0 = y1;
    	    y1 = temp;
    	}
    	
    	int dy = y1-y0;         
	    int dx = x1-x0;  
	    int d = 2*dy-dx;
    	int x=x0;
    	int y=y0;
    	
    	
    	for (x =x0; x<x1; x++) {
    	    if (swap)
    	    	C.setPixel(y,x);
    	    else 
    	    	C.setPixel(x,y);
    	    d=d+dy;
    	    
    	    /*Negative and positive slope*/
    	    if (dy<0){	
    	    	if (d<dx/2) {
    	    		d=d+dx;		//choosing E point		
    	    		y--;}
    	    }
    	    else if (d>dx/2){
    	    	d=d-dx;		//choosing NE point
    	    	y++;}
    	    
    	}
    }
 }