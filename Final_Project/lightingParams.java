//
// lightingParams.java
//
// Created by Joe Geigel on 1/23/13.

//  Contributor:  KHYATI K.VYAS
//  Referecne: Warren R. Carithers Slides
//				http://www.real3dtutorials.com/
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
     * OUTTER RING AND CONE
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
    	gl3.glUniform4f(ambient_id,0.24725f,	0.1995f,	0.0745f	, 1.0f);
    	
    	int diffuse_id=gl3.glGetUniformLocation(program, "diffused_color");
    	gl3.glUniform4f(diffuse_id,0.75164f,	0.60648f,	0.22648f	, 1.0f);
    	
    	int specular_id=gl3.glGetUniformLocation(program, "specular_color");
    	gl3.glUniform4f(specular_id,0.628281f,	0.555802f,	0.366065f, 1.0f);
    	
    	int exp_id=gl3.glGetUniformLocation(program, "shininess");
    	gl3.glUniform1f(exp_id,1.5f);
    	
    	//Light properties
    	int color_id=gl3.glGetUniformLocation(program, "light_color");
    	gl3.glUniform4f(color_id, 1.0f, 1.0f, 0.0f, 1.0f);
    	
    	int pos_id=gl3.glGetUniformLocation(program, "pos");
    	gl3.glUniform4f(pos_id, 0.0f, 5.0f, 2.0f, 1.0f);
    	
    }
    
    /**
     * INNER RING
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
    public void setUpPhong1 (int program, GL3 gl3)
    {	
    	//Material properties of the teapot.
    	int ambient_id=gl3.glGetUniformLocation(program, "ambient_color");
    	gl3.glUniform4f(ambient_id,0.1f,	0.18725f,	0.1745f	,	 1.0f);
    	
    	int diffuse_id=gl3.glGetUniformLocation(program, "diffused_color");
    	gl3.glUniform4f(diffuse_id,0.396f,	0.74151f,	0.69102f,	 1.0f);
    	
    	int specular_id=gl3.glGetUniformLocation(program, "specular_color");
    	gl3.glUniform4f(specular_id,0.297254f,	0.30829f,	0.306678f,	1.0f);
    	
    	int exp_id=gl3.glGetUniformLocation(program, "shininess");
    	gl3.glUniform1f(exp_id,1.0f);
    	
    	//Light properties
    	int color_id=gl3.glGetUniformLocation(program, "light_color");
    	gl3.glUniform4f(color_id, 0.5f, 0.5f, 0.5f, 1.0f);
    	
    	int pos_id=gl3.glGetUniformLocation(program, "pos");
    	gl3.glUniform4f(pos_id, 1.0f, 5.0f, 2.0f, 1.0f);
   	
    }
    
    /**
     * UNKOWN ISOSPHERE OBJECT 
     * 
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
    public void setUpPhong2(int program, GL3 gl3)
    {	
    	//Material properties of the teapot.
    	int ambient_id=gl3.glGetUniformLocation(program, "ambient_color");
    	gl3.glUniform4f(ambient_id,0.19225f,	0.19225f,	0.19225f	,	 1.0f);
    	
    	int diffuse_id=gl3.glGetUniformLocation(program, "diffused_color");
    	gl3.glUniform4f(diffuse_id, 0.50754f,	0.50754f,	0.50754f,	 1.0f);
    	
    	int specular_id=gl3.glGetUniformLocation(program, "specular_color");
    	gl3.glUniform4f(specular_id,0.508273f,	0.508273f,	0.508273f	, 1.0f);
    	
    	int exp_id=gl3.glGetUniformLocation(program, "shininess");
    	gl3.glUniform1f(exp_id,51.0f);
    	
    	//Light properties
    	int color_id=gl3.glGetUniformLocation(program, "light_color");
    	gl3.glUniform4f(color_id, 1.0f, 1.0f, 1.0f, 1.0f);
    	
    	int pos_id=gl3.glGetUniformLocation(program, "pos");
    	gl3.glUniform4f(pos_id, 1.0f, 5.0f, 2.0f, 1.0f);

    }
   
   
    public void setUpPhong3(int program, GL3 gl3)
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
