#version 150

// Texture mapping fragment shader
//
// Contributor:  KHYATI K.VYAS
// Referecne: Warren R. Carithers Slides

// INCOMING DATA
varying vec2 texCoord;


// Add all variables containing data used by the
// fragment shader for lighting and texture mapping

//Textures to be loaded into the shader.
uniform sampler2D texture_front;
uniform sampler2D texture_back;
in vec2 vTexCoord;

// OUTGOING DATA

// final fragment color
out vec4 fragmentColor;


void main()
{
    // Replace with proper texture mapping code
	

    //fragmentColor = texture2D(texture,texCoord);
	
	//if the front face is being textured, use the smiley2.png
	//if the back face is being textured,use the frowny2.png
	
	if(gl_FrontFacing)
			{fragmentColor=texture2D(texture_back,texCoord);}
	else
			{fragmentColor=texture2D(texture_front,texCoord);}
}
