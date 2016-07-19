package Lab05;
//
//  simpleShape.java
//
//  Class that represents a shape to be tessellated; teapot
//  is derived from this class.
//
//  Of note is the protected method addTriangles() which is what students
//  should use to define their tessellations.
//
//  Students are not to modify this file.
//


import java.awt.*;
import java.nio.*;
import java.awt.event.*;
import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import java.util.*;


public class simpleShape
{
    /**
     * our vertex points
     */
    private Vector<Float> points;

    /**
     * our array elements
     */
    private Vector<Short> elements;
    private short nVerts;

    /**
     * constructor
     */
    public simpleShape()
    {
        points = new Vector<Float>();
        elements = new Vector<Short>();
        nVerts = 0;
    }

    /**
     * add a triangle to the shape
     */
    protected void addTriangle (float x0, float y0, float z0,
                                float x1, float y1, float z1,
                                float x2, float y2, float z2)
    {
        points.add (new Float(x0));
        points.add (new Float(y0));
        points.add (new Float(z0));
        points.add (new Float(1.0f));
        elements.add (new Short(nVerts));
        nVerts++;

        points.add (new Float(x1));
        points.add (new Float(y1));
        points.add (new Float(z1));
        points.add (new Float(1.0f));
        elements.add (new Short(nVerts));
        nVerts++;

        points.add (new Float(x2));
        points.add (new Float(y2));
        points.add (new Float(z2));
        points.add (new Float(1.0f));
        elements.add (new Short(nVerts));
        nVerts++;
    }

    /**
     * clear the shape
     */
    public void clear()
    {
        points= new Vector<Float>();
        elements = new Vector<Short>();
        nVerts = 0;
    }

    public Buffer getVertices ()
    {
        float v[] = new float[points.size()];
        for (int i=0; i < points.size(); i++) {
            v[i] = (points.elementAt(i)).floatValue();
        }
        return FloatBuffer.wrap (v);
    }

    public Buffer getElements ()
    {
        short e[] = new short[elements.size()];
        for (int i=0; i < elements.size(); i++) {
            e[i] = (elements.elementAt(i)).shortValue();
        }

        return ShortBuffer.wrap (e);
    }

    public short getNVerts()
    {
        return nVerts;
    }

}
