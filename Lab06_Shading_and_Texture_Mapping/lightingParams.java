//
// lightingParams.java
//
// Created by Joe Geigel on 1/23/13.

//  Contributor:  KHYATI K.VYAS
//  Referecne: Warren R. Carithers Slides
//
// 20155 version
//

import javax.media.opengl.*;
import javax.media.opengl.fixedfunc.*;

public class lightingParams
{
    // Add any data members you need here.
    /**
     * constructor
     */
    public lightingParams()
    {
    }

    /**
     * This function sets up the lighting, material, and shading parameters
     * for the Phong shader.
     *
     * You will need to write this function, and maintain all of the values
     * needed to be sent to the vertex shader.
     *
     * @param program - The ID of an OpenGL (GLSL) shader program to which
     *    parameter values are to be sent
     *
     * @param gl3 - GL3 object on which all OpenGL calls are to be made
     *
     */
    public void setUpPhong (int program, GL3 gl3)
    {	
    	//Material properties of the teapot.
    	int ambient_id=gl3.glGetUniformLocation(program, "ambient_color");
    	gl3.glUniform4f(ambient_id, 0.5f, 0.1f, 0.9f, 1.0f);
    	
    	int diffuse_id=gl3.glGetUniformLocation(program, "diffused_color");
    	gl3.glUniform4f(diffuse_id, 0.89f, 0.0f, 0.0f, 1.0f);
    	
    	int specular_id=gl3.glGetUniformLocation(program, "specular_color");
    	gl3.glUniform4f(specular_id, 1.0f, 1.0f, 1.0f, 1.0f);
    	
    	int exp_id=gl3.glGetUniformLocation(program, "shininess");
    	gl3.glUniform1f(exp_id,10.0f);
    	
    	//Light properties
    	int color_id=gl3.glGetUniformLocation(program, "light_color");
    	gl3.glUniform4f(color_id, 1.0f, 1.0f, 0.0f, 1.0f);
    	
    	int pos_id=gl3.glGetUniformLocation(program, "pos");
    	gl3.glUniform4f(pos_id, 0.0f, 5.0f, 2.0f, 1.0f);
    	
    	
    	
    	
    }
}
