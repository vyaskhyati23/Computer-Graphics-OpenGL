
//
//  textureParams.java
//
//  Created by Joe Geigel on 1/23/13.
//
//  Contributor:  KHYATI K.VYAS
//  Referecne: Warren R. Carithers Slides 
//
//  Simple class for setting up the textures for the textures
//  assignment.
//
//  20155 version
//

import java.io.*;
import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.fixedfunc.*;
import com.jogamp.opengl.util.texture.*;

public class textureParams {
	Texture texture_front;
	Texture texture_back;

	// Add any data members you need here.

	/**
	 * constructor
	 */
	public textureParams() {
	}

	/**
	 * This function loads texture data to the GPU.
	 *
	 * You will need to write this function, and maintain all of the values
	 * needed to be sent to the various shaders.
	 *
	 * @param gl3
	 *            - GL3 object on which all OpenGL calls are to be made
	 *
	 */
	public void loadTexture(GL3 gl3) {
		// Add your code here.

		try {
			// READING THE FILE THAT NEEDS TO BE MAPPED ON THE QUAD FRONT.
			InputStream file = new BufferedInputStream(new FileInputStream("smiley2.png"));
			// CREATES A TEXTURE DATA.
			TextureData data = TextureIO.newTextureData(gl3.getGLProfile(), file, false, "png");
			texture_front = TextureIO.newTexture(data);

			// READING THE FILE THAT NEEDS TO BE MAPPED ON THE QUAD BACK.
			file = new BufferedInputStream(new FileInputStream("frowny2.png"));
			// CREATES A TEXTURE DATA.
			data = TextureIO.newTextureData(gl3.getGLProfile(), file, false, "png");
			texture_back = TextureIO.newTexture(data);

		} catch (IOException exc) {
			// TODO Auto-generated catch block
			exc.printStackTrace();
			System.exit(1);
		}

	}

	/**
	 * This function sets up the parameters for texture use.
	 *
	 * You will need to write this function, and maintain all of the values
	 * needed to be sent to the various shaders.
	 *
	 * @param program
	 *            - The ID of an OpenGL (GLSL) program to which parameter values
	 *            are to be sent
	 *
	 * @param gl3
	 *            - GL3 object on which all OpenGL calls are to be made
	 *
	 */
	public void setUpTexture(int program, GL3 gl3) {
		// Add your code here.

		/*
		 * gl3.glActiveTexture(GL.GL_TEXTURE0); tex_id.enable(gl3);
		 * tex_id.bind(gl3); gl3.glEnable(GL.GL_TEXTURE_2D);
		 * gl3.glActiveTexture(0);
		 */

		/////////////////////////////////////////
		// //
		// smiley2.png //
		////////////////////////////////////////

		// SELECTS WHICH TEXTURE IS ACTIVATED. AND BINDS IT.
		gl3.glActiveTexture(gl3.GL_TEXTURE0 + 0);
		this.texture_front.bind(gl3);
		// Used to load uniform variables which are defined as sampler type.
		// in this case texture_front "smiley2.png"
		int location_front = gl3.glGetUniformLocation(program, "texture_front");
		gl3.glUniform1i(location_front, 0);

		/////////////////////////////////////////
		// 										//
		// frowny2.png 							//
		////////////////////////////////////////

		// SELECTS WHICH TEXTURE IS ACTIVATED. AND BINDS IT
		gl3.glActiveTexture(gl3.GL_TEXTURE0 + 1);
		this.texture_back.bind(gl3);
		// Used to load uniform variables which are defined as sampler type.
		// in this case texture_front "frowny2.png"
		int location_back = gl3.glGetUniformLocation(program, "texture_front");
		gl3.glUniform1i(location_back, 1);

	}
}
