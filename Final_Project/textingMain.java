
//
// textingMain.java
//
// Main class for lighting/shading/texturing assignment.
//
// Students should not be modifying this file.
//

import java.awt.*;
import java.nio.*;
import java.awt.event.*;
import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.fixedfunc.*;
import com.jogamp.opengl.util.Animator;

public class textingMain implements GLEventListener, KeyListener {

	/**
	 * We need two vertex buffers and four element buffers: one set for the sun
	 * (texture mapped), and one set for the Cone (Phong shaded)
	 *
	 * Array layout: element 0: sun element 1: Cone
	 */
	private int vbuffer[];
	private int ebuffer[];
	private int numVerts[];

	/**
	 * Animation control
	 */
	Animator anime;
	boolean animating;

	/**
	 * Initial animation rotation angles
	 */
	float angles[];

	/**
	 * Program IDs - current, and all variants
	 */
	public int pshader;
	public int tshader;

	/**
	 * Shape info
	 */
	shapes myShape;

	/**
	 * Lighting information
	 */
	lightingParams myPhong;

	/**
	 * Viewing information
	 */
	viewParams myView;

	/**
	 * Texturing information
	 */
	textureParams myTexture;

	/**
	 * My canvas
	 */
	GLCanvas myCanvas;
	private static Frame frame;

	/**
	 * Constructor
	 */
	public textingMain(GLCanvas G) {
		vbuffer = new int[7];
		ebuffer = new int[7];
		numVerts = new int[7];

		angles = new float[7];

		animating = false;

		angles[0] = 0.0f; // sun
		angles[1] = 0.0f; // earth
		angles[2] = 0.0f; // inner ring
		angles[3] = 0.0f; // outer ring
		angles[4] = 0.0f; // cone
		angles[5] = 0.0f; // isosphere

		myCanvas = G;

		// Initialize lighting and view
		myPhong = new lightingParams();
		myView = new viewParams();
		myTexture = new textureParams();

		// Set up event listeners
		G.addGLEventListener(this);
		G.addKeyListener(this);
	}

	private void errorCheck(GL3 gl3) {
		int code = gl3.glGetError();
		if (code == GL.GL_NO_ERROR)
			System.err.println("All is well");
		else
			System.err.println("Problem - error code : " + code);

	}

	/**
	 * Simple animate function
	 */
	public void animate() {
		angles[shapes.OBJ_SUN] += 0.0;
		angles[shapes.OBJ_CONE] += 0.0;
		angles[shapes.OBJ_DONUT] += 0.4;
		angles[shapes.OBJ_EARTH] += 0.3;
		angles[shapes.OBJ_RING] += 0.6;
		angles[shapes.OBJ_ISO] += 0.4;

	}

	/**
	 * Called by the drawable to initiate OpenGL rendering by the client.
	 */
	public void display(GLAutoDrawable drawable) {
		// get GL
		GL3 gl3 = (drawable.getGL()).getGL3();

		// clear and draw params..
		gl3.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

		// first, the sun
		gl3.glUseProgram(tshader);

		// set up viewing and projection parameters
		myView.setUpFrustum(tshader, gl3);

		// set up the texture information
		myTexture.setUpTexture(tshader, gl3);

		// set up the camera
		myView.setUpCamera(tshader, gl3, 0.2f, 3.0f, 6.5f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f);

		/*************************************
		 * SUN ********************
		 *************************/
		// set up transformations for the sun
		myView.setUpTransforms(tshader, gl3,
				2.2f,1.2f, 0.2f, // For zooming
				angles[shapes.OBJ_SUN], 
				angles[shapes.OBJ_SUN],
				angles[shapes.OBJ_SUN], 
				2.0f, 2.5f, -2.5f // Placement.
			
		);

		// draw it
		selectBuffers(tshader, shapes.OBJ_SUN, gl3);
		gl3.glDrawElements(GL.GL_TRIANGLES, numVerts[shapes.OBJ_SUN], GL.GL_UNSIGNED_SHORT, 0l);

		/************************************* EARTH *****************************************/
		// set up transformations for the sphere
		myView.setUpTransforms(tshader, gl3, 
				0.8f, 0.8f, 0.8f, // FR ZOOMING
				// angles[shapes.OBJ_EARTH],
				0, angles[shapes.OBJ_EARTH], 0,
				// angles[shapes.OBJ_EARTH],
				0.2f, 1.0f, -1.5f // placement
		);

		// draw it
		selectBuffers(tshader, shapes.OBJ_EARTH, gl3);
		gl3.glDrawElements(GL.GL_TRIANGLES, numVerts[shapes.OBJ_EARTH], GL.GL_UNSIGNED_SHORT, 0l);

		/************************************* CONE *****************************************/
		// now, draw the Cone
		gl3.glUseProgram(pshader);

		// set up viewing and projection parameters
		myView.setUpFrustum(pshader, gl3);

		// set up the Phong shading information
		myPhong.setUpPhong3(pshader, gl3);

		// set up the camera
		myView.setUpCamera(pshader, gl3, 0.2f, 3.0f, 6.5f, 0.0f, 2.0f, 0.0f, 0.0f, 1.0f, 0.0f);

		myView.setUpTransforms(pshader, gl3,
0.47f, 0.47f, 0.47f, 
				angles[shapes.OBJ_CONE],
				angles[shapes.OBJ_CONE],
				angles[shapes.OBJ_CONE],
				-1.12f, -1.0f, -2.5f);

		// draw it
		selectBuffers(pshader, shapes.OBJ_CONE, gl3);
		gl3.glDrawElements(GL.GL_TRIANGLES, numVerts[shapes.OBJ_CONE], GL.GL_UNSIGNED_SHORT, 0l);
		

		/*************************************
		 * INNER RING
		 *****************************************/

		// now, draw the Inner ring
		gl3.glUseProgram(pshader);

		// set up viewing and projection parameters
		myView.setUpFrustum(pshader, gl3);

		// set up the Phong shading information
		myPhong.setUpPhong1(pshader, gl3);

		// set up the camera
		myView.setUpCamera(pshader, gl3, 0.2f, 3.0f, 6.5f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f);

		myView.setUpTransforms(pshader, gl3, 2.4f, 2.4f, 2.4f,
				// angles[shapes.OBJ_DONUT],
				0, -angles[shapes.OBJ_DONUT], 0,
				// angles[shapes.OBJ_DONUT],
				-1.38f, -1.0f, -1.5f);

		// draw it
		selectBuffers(pshader, shapes.OBJ_DONUT, gl3);
		gl3.glDrawElements(GL.GL_TRIANGLES, numVerts[shapes.OBJ_DONUT], GL.GL_UNSIGNED_SHORT, 0l);

		/*************************************
		 * OUTER RING
		 *****************************************/
		// now, draw the Outer ring
		gl3.glUseProgram(pshader);

		// set up viewing and projection parameters
		myView.setUpFrustum(pshader, gl3);

		// set up the Phong shading information
		myPhong.setUpPhong(pshader, gl3);

		// set up the camera
		myView.setUpCamera(pshader, gl3, 0.2f, 3.0f, 6.5f, 0.0f, 2.0f, 0.0f, 0.0f, 1.0f, 0.0f);

		myView.setUpTransforms(pshader, gl3,
				3.2f, 3.2f, 3.2f,
				// angles[shapes.OBJ_RING],
				0, angles[shapes.OBJ_RING], 0,
				// angles[shapes.OBJ_RING],
				-1.38f, -0.0f, -1.79f);

		// draw it
		selectBuffers(pshader, shapes.OBJ_RING, gl3);
		gl3.glDrawElements(GL.GL_TRIANGLES, numVerts[shapes.OBJ_RING], GL.GL_UNSIGNED_SHORT, 0l);

		/*************************************
		 * ISO-SPHERE
		 *****************************************/ 
		
		// now, draw the iso-sphere
		gl3.glUseProgram(pshader);

		// set up viewing and projection parameters
		myView.setUpFrustum(pshader, gl3);

		// set up the Phong shading information
		myPhong.setUpPhong2(pshader, gl3);

		// set up the camera
		myView.setUpCamera(pshader, gl3, 0.2f, 3.0f, 6.5f, 0.2f, 2.0f, 0.0f, 0.2f, 1.0f, 0.0f);

		myView.setUpTransforms(pshader, gl3, 
				0.25f, 0.25f, 0.25f,
				//angles[shapes.OBJ_ISO],
				45,angles[shapes.OBJ_ISO],0,
				// angles[shapes.OBJ_ISO],
				1.0f, 0.1f, -0.5f);

		// draw it
		selectBuffers(pshader, shapes.OBJ_ISO, gl3);
		gl3.glDrawElements(GL.GL_TRIANGLES, numVerts[shapes.OBJ_ISO], GL.GL_UNSIGNED_SHORT, 0l);

		// perform any required animation for the next time
		if (animating) {
			animate();
		}
	}

	/**
	 * Notifies the listener to perform the release of all OpenGL resources per
	 * GLContext, such as memory buffers and GLSL programs.
	 */
	public void dispose(GLAutoDrawable drawable) {
	}

	/**
	 * Verify shader creation
	 */
	private void checkShaderError(shaderSetup myShaders, int program, String which) {
		if (program == 0) {
			System.err.println(
					"Error setting " + which + " shader - " + myShaders.errorString(myShaders.shaderErrorCode));
			System.exit(1);
		}
	}

	/**
	 * Called by the drawable immediately after the OpenGL context is
	 * initialized.
	 */
	public void init(GLAutoDrawable drawable) {
		// get the gl object
		GL3 gl3 = drawable.getGL().getGL3();

		// create the Animator now that we have the drawable
		anime = new Animator(drawable);

		// Load texture image(s)
		myTexture.loadTexture(gl3);

		// Load shaders, verifying each
		shaderSetup myShaders = new shaderSetup();

		tshader = myShaders.readAndCompile(gl3, "texture.vert", "texture.frag");
		checkShaderError(myShaders, tshader, "texture");

		pshader = myShaders.readAndCompile(gl3, "phong.vert", "phong.frag");
		checkShaderError(myShaders, pshader, "phong");

		// Create all our objects
		createShape(gl3, shapes.OBJ_SUN);
		createShape(gl3, shapes.OBJ_CONE);
		createShape(gl3, shapes.OBJ_DONUT);
		createShape(gl3, shapes.OBJ_EARTH);
		createShape(gl3, shapes.OBJ_RING);
		createShape(gl3, shapes.OBJ_ISO);

		// add code here

		// Other GL initialization
		gl3.glEnable(GL.GL_DEPTH_TEST);
		gl3.glFrontFace(GL.GL_CCW);
		gl3.glPolygonMode(GL.GL_FRONT_AND_BACK, GL2GL3.GL_FILL);
		gl3.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		gl3.glDepthFunc(GL.GL_LEQUAL);
		gl3.glClearDepth(1.0f);
	}

	/**
	 * Called by the drawable during the first repaint after the component has
	 * been resized.
	 */
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
	}

	/**
	 * Create a vertex or element array buffer
	 *
	 * @param target
	 *            - which type of buffer to create
	 * @param data
	 *            - source of data for buffer (or null)
	 * @param size
	 *            - desired length of buffer
	 */
	int makeBuffer(int target, Buffer data, long size, GL3 gl3) {
		int buffer[] = new int[1];

		gl3.glGenBuffers(1, buffer, 0);
		gl3.glBindBuffer(target, buffer[0]);
		gl3.glBufferData(target, size, data, GL.GL_STATIC_DRAW);

		return (buffer[0]);
	}

	/**
	 * Create vertex and element buffers for a shape
	 */
	public void createShape(GL3 gl3, int obj) {
		// clear the old shape
		myShape = new shapes();

		// make the shape
		myShape.makeShape(obj);

		// save the vertex count
		numVerts[obj] = myShape.nVertices();

		// get the vertices for the shape
		Buffer points = myShape.getVertices();
		long dataSize = numVerts[obj] * 4l * 4l;

		// get the normals for the shape
		Buffer normals = myShape.getNormals();
		long ndataSize = numVerts[obj] * 3l * 4l;

		// there may or may not be (u,v) information
		Buffer uv = myShape.getUV();
		long uvdataSize = 0;
		if (obj == shapes.OBJ_SUN) {
			uvdataSize = numVerts[obj] * 2l * 4l;
		} else if (obj == shapes.OBJ_EARTH) {
			uvdataSize = numVerts[obj] * 2l * 4l;
		}

		// get the element data
		Buffer elements = myShape.getElements();
		long edataSize = numVerts[obj] * 2l;

		long totalSize = dataSize + ndataSize + uvdataSize;

		vbuffer[obj] = makeBuffer(GL.GL_ARRAY_BUFFER, null, totalSize, gl3);
		gl3.glBufferSubData(GL.GL_ARRAY_BUFFER, 0, dataSize, points);
		gl3.glBufferSubData(GL.GL_ARRAY_BUFFER, dataSize, ndataSize, normals);
		if (obj == shapes.OBJ_SUN) {
			gl3.glBufferSubData(GL.GL_ARRAY_BUFFER, dataSize + ndataSize, uvdataSize, uv);
		} else if (obj == shapes.OBJ_EARTH) {
			gl3.glBufferSubData(GL.GL_ARRAY_BUFFER, dataSize + ndataSize, uvdataSize, uv);
		}

		// generate the element buffer
		ebuffer[obj] = makeBuffer(GL.GL_ELEMENT_ARRAY_BUFFER, elements, edataSize, gl3);

	}

	/**
	 * Bind the correct vertex and element buffers
	 *
	 * Assumes the correct shader program has already been enabled
	 */
	private void selectBuffers(int program, int obj, GL3 gl3) {
		// bind the buffers
		gl3.glBindBuffer(GL.GL_ARRAY_BUFFER, vbuffer[obj]);
		gl3.glBindBuffer(GL.GL_ELEMENT_ARRAY_BUFFER, ebuffer[obj]);

		// calculate the number of bytes of vertex and normal data
		long dataSize = numVerts[obj] * 4l * 4l;
		long ndataSize = numVerts[obj] * 3l * 4l;

		// set up the vertex attribute variables
		int vPosition = gl3.glGetAttribLocation(program, "vPosition");
		gl3.glEnableVertexAttribArray(vPosition);
		gl3.glVertexAttribPointer(vPosition, 4, GL.GL_FLOAT, false, 0, 0l);

		int vNormal = gl3.glGetAttribLocation(program, "vNormal");
		gl3.glEnableVertexAttribArray(vNormal);
		gl3.glVertexAttribPointer(vNormal, 3, GL.GL_FLOAT, false, 0, dataSize);

		if (obj == shapes.OBJ_SUN) {
			int vTexCoord = gl3.glGetAttribLocation(program, "vTexCoord");
			gl3.glEnableVertexAttribArray(vTexCoord);
			gl3.glVertexAttribPointer(vTexCoord, 2, GL.GL_FLOAT, false, 0, dataSize + ndataSize);

		} else if (obj == shapes.OBJ_EARTH) {
			int vTexCoord = gl3.glGetAttribLocation(program, "vTexCoord");
			gl3.glEnableVertexAttribArray(vTexCoord);
			gl3.glVertexAttribPointer(vTexCoord, 2, GL.GL_FLOAT, false, 0, dataSize + ndataSize);

		}

	}

	/**
	 * Because I am a Key Listener...we'll only respond to key presses
	 */
	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	/**
	 * Invoked when a key has been pressed.
	 */
	public void keyPressed(KeyEvent e) {
		// Get the key that was pressed
		char key = e.getKeyChar();

		// Respond appropriately
		switch (key) {

		case 'a': // animate
			animating = true;
			anime.start();
			break;

		case 'r': // reset rotations
			angles[0] = 0.0f;
			angles[1] = 0.0f;
			angles[2] = 0.0f;
			angles[3] = 0.0f;
			angles[4] = 0.0f;
			angles[5] = 0.0f;
			angles[6] = 0.0f;

			break;

		case 's': // stop animating
			animating = false;
			anime.stop();
			break;

		case 'q':
		case 'Q':
			frame.dispose();
			System.exit(0);
			break;
		}

		// do a redraw
		myCanvas.display();
	}

	/**
	 * main program
	 */
	public static void main(String[] args) {
		// GL setup
		GLProfile glp = GLProfile.get(GLProfile.GL3);
		GLCapabilities caps = new GLCapabilities(glp);
		GLCanvas canvas = new GLCanvas(caps);

		// create your tessMain
		textingMain myMain = new textingMain(canvas);

		frame = new Frame("CG - Shading and Texture Mapping Assignment");
		frame.setSize(1000, 1000);
		frame.add(canvas);
		frame.setVisible(true);

		// by default, an AWT Frame doesn't do anything when you click
		// the close button; this bit of code will terminate the program when
		// the window is asked to close
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
	}
}
