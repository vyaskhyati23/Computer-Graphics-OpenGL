
//

//  cgShape.java
//
//  20155
//
//  Class that includes routines for tessellating a number of basic shapes.
//
//  Students are to supply their implementations for the functions in
//  this file using the function "addTriangle()" to do the tessellation.
//
//  Contributor:  Khyati K.Vyas
//

import java.awt.*;
import java.nio.*;
import java.awt.event.*;
import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import java.io.*;

public class cgShape extends simpleShape {
	///
	// constructor
	///

	public cgShape() {

	}

	/**
	 * makeCube - Create a unit cube, centered at the origin, with a given
	 * number of subdivisions in each direction on each face.
	 * 
	 * @param subdivision
	 *            - number of equal subdivisons to be made in each direction
	 *            along each face
	 * 
	 *            Unit cube gets divided into 6 faces:
	 *            top,bottom,left,right,front,back. Each face is made up of 2
	 *            triangles.With increasing degree of tesselation, the length of
	 *            each triangles forming the cube reduces.Length of each
	 *            triangle in the cube is (1/subDivisions).
	 */
	public void makeCube(int subdivisions) {
		if (subdivisions < 1)
			subdivisions = 1;

		// YOUR IMPLEMENTATION HERE
		/**
		 * Treat the face of the cube as a matrix and iterate over the rows and
		 * columns.
		 */
		for (int i = 0; i < subdivisions; i++) {
			for (int j = 0; j < subdivisions; j++) {
				/**
				 * length of each tesellated cube=cube of unit length/number of
				 * divisions.
				 */

				float p = (float) 1 / subdivisions;
				/**
				 * x,y,z coordinates for current and next level subtracted by a
				 * factor of 0.5f. Every time the cube tesselates the length is
				 * reduced by half of the original size.
				 */

				float a = (p * i - 0.5f);
				float b = (p * j - 0.5f);
				float c = (p * (i + 1) - 0.5f);
				float d = (p * (j + 1) - 0.5f);

				// System.out.println("a= " + a + " b= " + b + " c= " + c + " d=
				// " + d);

				/**
				 * TOP AND BOTTOM FACE. variable x and y coordinates z
				 * coordinate = +0.5f for top face = -0.5f for bottom face
				 */

				addTriangle(a, 0.5f, b, c, 0.5f, b, a, 0.5f, d);
				addTriangle(c, 0.5f, d, a, 0.5f, d, c, 0.5f, b); // top

				addTriangle(a, -0.5f, b, a, -0.5f, d, c, -0.5f, b);
				addTriangle(c, -0.5f, d, c, -0.5f, b, a, -0.5f, d); // bottom

				/**
				 * FRONT AND BACK FACE. variable x and y coordinates z
				 * coordinate = +0.5f for front face = -0.5f for back face
				 */
				addTriangle(a, b, 0.5f, a, d, 0.5f, c, b, 0.5f);
				addTriangle(c, d, 0.5f, c, b, 0.5f, a, d, 0.5f); // front

				addTriangle(a, b, -0.5f, c, b, -0.5f, a, d, -0.5f);
				addTriangle(c, d, -0.5f, a, d, -0.5f, c, b, -0.5f); // back

				/**
				 * LEFT AND RIGHT FACE. variable y and z coordinates x
				 * coordinate = +0.5f for front face = -0.5f for back face
				 */
				addTriangle(0.5f, a, b, 0.5f, a, d, 0.5f, c, b);
				addTriangle(0.5f, c, d, 0.5f, c, b, 0.5f, a, d); // left

				addTriangle(-0.5f, a, b, -0.5f, c, b, -0.5f, a, d);
				addTriangle(-0.5f, c, d, -0.5f, a, d, -0.5f, c, b); // right

			}
		}
	}

	/**
	 * makeCylinder - Create polygons for a cylinder with unit height, centered
	 * at the origin, with separate number of radial subdivisions and height
	 * subdivisions.
	 * 
	 * @param radius
	 *            - Radius of the base of the cylinder
	 * @param radialDivision
	 *            - number of subdivisions on the radial base
	 * @param heightDivisions
	 *            - number of subdivisions along the height
	 * 
	 *            The cylinder is made up of 2 circular bottoms and a body made
	 *            of tesselated rectangles.
	 * 
	 */

	public void makeCylinder(float radius, int radialDivisions, int heightDivisions) {
		if (radialDivisions < 3)
			radialDivisions = 3;

		if (heightDivisions < 1)
			heightDivisions = 1;

		// YOUR IMPLEMENTATION HERE

		for (int i = 0; i < radialDivisions; i++) {
			/**
			 * x and z coordinates for current and next level. Cylinder lies on
			 * the y plane i.e. y=+0.5f or -0.5f.Using equation x^2+z^2=(0.5^2),
			 * x and z are expressed as x=radius*cos@ and z=radius*sin@ .@ is
			 * the angle between radius segments.
			 */
			float a = (float) (radius * Math.cos((i * (2 * Math.PI / radialDivisions))));
			float b = (float) (radius * Math.sin((i * (2 * Math.PI / radialDivisions))));

			float c = (float) (radius * Math.cos(((i + 1) * (2 * Math.PI / radialDivisions))));
			float d = (float) (radius * Math.sin(((i + 1) * (2 * Math.PI / radialDivisions))));

			/**
			 * addTriangle() to form the upper and lower base. Upper base : y=
			 * 0.5f Lower base : y= -0.5f
			 */
			addTriangle(0, -0.5f, 0, a, -0.5f, b, c, -0.5f, d); // lower base
			addTriangle(c, 0.5f, d, a, 0.5f, b, 0, 0.5f, 0); // upper base

			// theta+=theta;

			for (int j = 0; j < heightDivisions; j++) {
				/**
				 * factor by which the height of the cylinder body reduces with
				 * increase in heightDivisions.
				 */
				float h = (float) 1 / heightDivisions;

				/**
				 * y coordinates for current and next level for the circular
				 * base. y coordinate will be +0.5f if point is on upper half of
				 * the origin and -0.5f if point is on the lower half of the
				 * origin
				 */
				float p = (float) j * h - 0.5f;
				float q = (float) (j + 1) * h - 0.5f;

				/*
				 * System.out.println("a= " + a + "b= " + b + "c= " + c + "d= "
				 * + d); System.out.println("p= " + p + "q= " + q);
				 */

				/**
				 * For body of the cylinder, each radialDivision will form equal
				 * number of rectangles between the upper and lower base. Each
				 * rectangle gets tesselated.Like in cube,2 triangles form a
				 * rectangle.Coordinates of these rectangles will be the end
				 * points of the radialDivisions for the upper and lower
				 * base.With the increase in the number of
				 * heightDivisions,coordinates for the rectangles will change
				 * and length of each triangle will changed by a factor of
				 * (1/heightDivisions.)
				 */
				addTriangle(a, q, b, c, q, d, a, p, b); // body of cylinder
				addTriangle(c, q, d, c, p, d, a, p, b); // body of cylinder

			}
		}
	}

	/**
	 * makeCone - Create polygons for a cone with unit height, centered at the
	 * origin, with separate number of radial subdivisions and height
	 * subdivisions.
	 * 
	 * @param radius
	 *            - Radius of the base of the cone
	 * @param radialDivision
	 *            - number of subdivisions on the radial base
	 * @param heightDivisions
	 *            - number of subdivisions along the height
	 * 
	 *            Cone is a cylinder with only 1 circular base.The body of the
	 *            cone comes together at one single point. The cone is around
	 *            the y axis, so the point here at which the body meets is
	 *            (0,0.5f,0).Considering the base of the cone is the lower base
	 *            of the cylinder.
	 */

	public void makeCone(float radius, int radialDivisions, int heightDivisions) {
		if (radialDivisions < 3)
			radialDivisions = 3;

		if (heightDivisions < 1)
			heightDivisions = 1;

		// YOUR IMPLEMENTATION HERE
		for (int i = 0; i < radialDivisions; i++) {
			/**
			 * x and z coordinates for current and next level for the circular
			 * base. Cone lies on the y plane i.e. y=+0.5f or -0.5f.Using
			 * equation x^2+z^2=(0.5^2), x and z are expressed as x=radius*cos@
			 * and z=radius*sin@ .@ is the angle between radius segments.
			 */

			float a = (float) (radius * Math.cos((i * (2 * Math.PI / radialDivisions))));
			float b = (float) (radius * Math.sin((i * (2 * Math.PI / radialDivisions))));

			float c = (float) (radius * Math.cos(((i + 1) * (2 * Math.PI / radialDivisions))));
			float d = (float) (radius * Math.sin(((i + 1) * (2 * Math.PI / radialDivisions))));

			/**
			 * addTriangle() to form the lower base.Lower base : y = -0.5f.
			 */
			addTriangle(0, -0.5f, 0, a, -0.5f, b, c, -0.5f, d); // lower base

			/*
			 * System.out.println("A:" + a); System.out.println("B:" + b);
			 * System.out.println("C:" + c); System.out.println("D:" + d);
			 */

			for (int j = 0; j < heightDivisions; j++) {
				/**
				 * factor by which the height of the cylinder body reduces with
				 * increase in heightDivisions.
				 */
				float h = (float) 1 / heightDivisions;

				/**
				 * y coordinates for current and next level for the circular
				 * base. y coordinate will be +0.5f if point is on upper half of
				 * the origin and -0.5f if point is on the lower half of the
				 * origin
				 */
				float p = (float) j * h - 0.5f;
				float q = (float) (j + 1) * h - 0.5f;

				// float y_ht, s, t, u, v;

				if (j == heightDivisions - 1)
				/**
				 * for drawing the vertical faces of the cone.All the faces meet
				 * at a common point (0,q,0) since the cone lies on the y axis
				 */
				{
					addTriangle(0, q, 0, c, p, d, a, p, b); // body of cone
					// System.out.println("DRAWING FACE");
				}

				else {
					/**
					 * for tesselation in the horizontal direction,a value
					 * constant_factor is calculated.Since the height of the
					 * cone is 1 unit and with increase in the number of
					 * heightDivisions, the coordinates change value by a factor
					 * of (1-(1/subdivisions)) thus moving towards the peak of
					 * the cone.
					 */
					float constant_factor = (float) (1 - h);
					float y_ht = p + h;
					float s = constant_factor * a;
					float t = constant_factor * b;
					float u = constant_factor * c;
					float v = constant_factor * d;

					/**
					 * Each vertical face of the cone,gets divided into 2 parts,
					 * the upper connical part and the lower part is divided
					 * into trapezoids.Each trapezoid can be made with 2
					 * addTriangle().
					 */
					addTriangle(a, p, b, s, y_ht, t, c, p, d); // body of cone
					// System.out.println("DEAWING TESSELATION");
					addTriangle(s, y_ht, t, u, y_ht, v, c, p, d);// body of cone

					/**
					 * With the increase in the number of heigtDivisions, the
					 * respective x and z coordinates change going along the
					 * height.These new coordinates for the coordinated for the
					 * triangles in the next level.
					 */
					p = y_ht;
					a = s;
					b = t;
					c = u;
					d = v;
				}

			}
		}
	}

	/**
	 * makeSphere - Create sphere of a given radius, centered at the origin,
	 * using spherical coordinates with separate number of thetha and phi
	 * subdivisions.
	 * 
	 * @param radius
	 *            - Radius of the sphere
	 * @param slides
	 *            - number of subdivisions in the theta direction
	 * @param stacks
	 *            - Number of subdivisions in the phi direction.
	 * 
	 *            Can only use calls to addTriangle
	 */

	public void makeSphere(float radius, int slices, int stacks) {
		// IF USING RECURSIVE SUBDIVISION, MODIFY THIS TO USE
		// A MINIMUM OF 1 AND A MAXIMUM OF 5 FOR 'slices'

		if (slices < 3)
			slices = 3;

		if (stacks < 3)
			stacks = 3;

		// YOUR IMPLEMENTATION HERE
		/**
		 * calculating theta and phi for slices and stacks for current and next
		 * level
		 */

		float phi = (float) Math.toDegrees((float) ((2 * Math.PI) / stacks));
		float theta = (float) Math.toDegrees((float) ((Math.PI / slices)));

		for (int i = 0; i < slices; i++) {
			for (int j = 0; j < stacks; j++) {

				/**
				 * creating 4 vertices to create 2 triangles.
				 * 
				 */
				// vertex 1
				float a = (float) (radius * Math.cos((i * theta) * Math.sin((j * phi))));
				float b = (float) (radius * Math.sin((i * theta) * Math.sin((j * phi))));
				float c = (float) (radius * Math.cos((j * phi)));

				// vertex 2
				float d = (float) (radius * Math.cos((i * theta) * Math.sin(((j + 1) * phi))));
				float e = (float) (radius * Math.sin((i * theta) * Math.sin((j + 1) * phi)));
				float f = (float) (radius * Math.cos(((j + 1) * phi)));

				// vertex 3
				float p = (float) (radius * Math.cos(((i + 1) * theta) * Math.sin((j + 1) * phi)));
				float q = (float) (radius * Math.sin((i + 1) * theta) * Math.sin(((j + 1) * phi)));
				float r = (float) (radius * Math.cos(((j + 1) * phi)));

				// vertex 4
				float s = (float) (radius * Math.cos((i + 1) * theta) * Math.sin((j * phi)));
				float t = (float) (radius * Math.sin(((i + 1) * theta) * Math.sin((j * phi))));
				float u = (float) (radius * Math.cos((j * phi)));

				addTriangle(a, b, c, s, t, u, d, e, f);
				addTriangle(s, t, u, p, q, r, d, e, f);
			}
		}
	}
}
