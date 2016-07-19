//package Lab05;

  //package Lab05;
 /* 
  viewParams.java
  
   Created by Joe Geigel on 1/23/13.
  
   Contributor: KHYATI K.VYAS
  	
  	Reference:https://www.opengl.org/sdk/docs/man/html/glUniform.xhtml
   20155
   
 */


import javax.media.opengl.*;
import javax.media.opengl.fixedfunc.*;
//import Jama.Matrix;

public class viewParams
{	
	
	int idx; //variable for shader id.
	
	//Left, right,top,bottom,near,far.
	float L=-1.0f;
	float R=1.0f;
	float T=1.0f;
	float B=-1.0f;
	float N=0.9f;
	float F=4.5f;
	
	//array for orthographic view
	float[]orthographic={2.0f/(R-L),0.0f,0.0f,0.0f,
	    					0.0f,2.0f/(T-B),0.0f,0.0f,
	    					0.0f,0.0f,-2.0f/(F-N),0.0f,
	    					-(R+L)/(R-L),-(T+B)/(T-B),-(F+N)/(F-N),1.0f};
		
	//array for perspective view
	float[]perspective={(2.0f*N)/(R-L),0.0f,0.0f,0.0f,
					0.0f,(2.0f*N)/(T-B),0.0f,0.0f,
					(R+L)/(R-L),(T+B)/(T-B),-(F+N)/(F-N),-1.0f,
					0.0f,0.0f,-(2.0f*F*N)/(F-N),0.0f};
	
     /**
      *  constructor
      */
          
    public viewParams()
    {	
    	
    }
    
	/**
	 * This function sets up the view and projection parameter for a frustum
	 * projection of the scene. See the assignment description for the values
	 * for the projection parameters.
	 * 
	 * You will need to write this function, and maintain all of the values
	 * needed to be sent to the vertex shader.
	 * 
	 * @param program
	 *            - The ID of an OpenGL (GLSL) shader program to which parameter
	 *            values are to be sent
	 * 
	 * @param gl3
	 *            - GL3 object on which all OpenGL calls are to be made
	 */
       
      
      
    public void setUpFrustum (int program, GL3 gl3)
    {
        // Add your code here.
    	idx=gl3.glGetUniformLocation(program,"projection");
    	//for perspective array
    	gl3.glUniformMatrix4fv(idx,1,false,perspective,0);
    }

	/**
	 * 
	 * This function sets up the view and projection parameter for an
	 * orthographic projection of the scene. See the assignment description for
	 * the values for the projection parameters.
	 * 
	 * You will need to write this function, and maintain all of the values
	 * needed to be sent to the vertex shader.
	 * 
	 * @param program
	 *            - The ID of an OpenGL (GLSL) shader program to which parameter
	 *            values are to be sent
	 * 
	 */
      
      
      
    public void setUpOrtho (int program, GL3 gl3)
    {
         //  Add your code here.
    	idx=gl3.glGetUniformLocation(program,"projection");
    	//for orthographic array.
    	gl3.glUniformMatrix4fv(idx,1,false,orthographic,0);
    }

	/**
	 * This function clears any transformations, setting the values to the
	 * defaults: no scaling (scale factor of 1), no rotation (degree of rotation
	 * = 0), and no translation (0 translation in each direction).
	 * 
	 * You will need to write this function, and maintain all of the values
	 * which must be sent to the vertex shader.
	 * 
	 * @param program
	 *            - The ID of an OpenGL (GLSL) shader program to which parameter
	 *            values are to be sent
	 * @param gl3
	 *            - GL3 object on which all OpenGL calls are to be made
	 */
      
    public void clearTransforms( int program, GL3 gl3 )
    {
         //  Add your code here.
    	idx=gl3.glGetUniformLocation(program,"scale");
		gl3.glUniform3f(idx,1.0f,1.0f,1.0f);
		
		idx=gl3.glGetUniformLocation(program,"rotate");
		gl3.glUniform3f(idx,0.0f,0.0f,0.0f);
		
		idx=gl3.glGetUniformLocation(program,"translate");
		gl3.glUniform3f(idx,0.0f,0.0f,0.0f);
    }

	/**
	 * This function sets up the transformation parameters for the vertices of
	 * the teapot. The order of application is specified in the driver program.
	 * 
	 * You will need to write this function, and maintain all of the values
	 * which must be sent to the vertex shader.
	 * 
	 * @param program
	 *            - The ID of an OpenGL (GLSL) shader program to which parameter
	 *            values are to be sent
	 * @param gl3
	 *            - GL3 object on which all OpenGL calls are to be made
	 * @param scaleX
	 *            - amount of scaling along the x-axis
	 * @param scaleY
	 *            - amount of scaling along the y-axis
	 * @param scaleZ
	 *            - amount of scaling along the z-axis
	 * @param rotateX
	 *            - angle of rotation around the x-axis, in degrees
	 * @param rotateY
	 *            - angle of rotation around the y-axis, in degrees
	 * @param rotateZ
	 *            - angle of rotation around the z-axis, in degrees
	 * @param translateX
	 *            - amount of translation along the x axis
	 * @param translateY
	 *            - amount of translation along the y axis
	 * @param translateZ
	 *            - amount of translation along the z axis
	 */
      
      
    public void setUpTransforms( int program, GL3 gl3,
        float scaleX, float scaleY, float scaleZ,
        float rotateX, float rotateY, float rotateZ,
        float translateX, float translateY, float translateZ )
    {
          // Add your code here.
    	idx=gl3.glGetUniformLocation(program,"scale");
		gl3.glUniform3f(idx,scaleX,scaleY,scaleZ);
		
		idx=gl3.glGetUniformLocation(program,"rotate");
		gl3.glUniform3f(idx,rotateX,rotateY,rotateZ);
		
		idx=gl3.glGetUniformLocation(program,"translate");
		gl3.glUniform3f(idx,translateX,translateY,translateZ);
    }

	/**
	 * This function clears any changes made to camera parameters, setting the
	 * values to the defaults: eye (0.0,0.0,0.0), lookat (0,0,0.0,-1.0), and up
	 * vector (0.0,1.0,0.0).
	 * 
	 * You will need to write this function, and maintain all of the values
	 * which must be sent to the vertex shader.
	 * 
	 * @param program
	 *            - The ID of an OpenGL (GLSL) shader program to which parameter
	 *            values are to be sent
	 * @param gl3
	 *            - GL3 object on which all OpenGL calls are to be made
	 */
      
     
      
    void clearCamera( int program, GL3 gl3 )
    {
         //  Add your code here.
    	idx=gl3.glGetUniformLocation(program,"eye");
		gl3.glUniform3f(idx,0.0f,0.0f,0.0f);
		
		idx=gl3.glGetUniformLocation(program,"lookat");
		gl3.glUniform3f(idx,0.0f,0.0f,-1.0f);
		
		idx=gl3.glGetUniformLocation(program,"up");
		gl3.glUniform3f(idx,0.0f,1.0f,0.0f);
    	
    }

	/**
	 * This function sets up the camera parameters controlling the viewing
	 * transformation.
	 * 
	 * You will need to write this function, and maintain all of the values
	 * which must be sent to the vertex shader.
	 * 
	 * @param program
	 *            - The ID of an OpenGL (GLSL) shader program to which parameter
	 *            values are to be sent
	 * @param gl3
	 *            - GL3 object on which all OpenGL calls are to be made
	 * @param eyeX
	 *            - x coordinate of the camera location
	 * @param eyeY
	 *            - y coordinate of the camera location
	 * @param eyeZ
	 *            - z coordinate of the camera location
	 * @param lookatX
	 *            - x coordinate of the lookat point
	 * @param lookatY
	 *            - y coordinate of the lookat point
	 * @param lookatZ
	 *            - z coordinate of the lookat point
	 * @param upX
	 *            - x coordinate of the up vector
	 * @param upY
	 *            - y coordinate of the up vector
	 * @param upZ
	 *            - z coordinate of the up vector
	 */
       
      
    void setUpCamera( int program, GL3 gl3,
        float eyeX, float eyeY, float eyeZ,
        float lookatX, float lookatY, float lookatZ,
        float upX, float upY, float upZ )
    {
         //Add your code here.
		idx=gl3.glGetUniformLocation(program,"eye");
		gl3.glUniform3f(idx,eyeX,eyeY,eyeZ);
		
		idx=gl3.glGetUniformLocation(program,"lookat");
		gl3.glUniform3f(idx,lookatX,lookatY,lookatZ);
		
		idx=gl3.glGetUniformLocation(program,"up");
		gl3.glUniform3f(idx,upX,upY,upZ);
    }

}
