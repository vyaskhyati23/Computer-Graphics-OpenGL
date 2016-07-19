#version 150

// Phong fragment shader
//
// Contributor:  KHYATI K.VYAS
// Referecne: Warren R. Carithers Slides

// INCOMING DATA 

//DATA FROM THE VERTEX SHADER

varying vec3 vertexLocation;
varying vec3 normalInterpolation;
varying vec3 lightLocation;

uniform vec4 light_color;

//OBJECT PROPERTIES
uniform vec4 diffused_color;
uniform vec4 ambient_color;
uniform vec4 specular_color;

uniform float shininess;

// OUTGOING DATA

// final fragment color
out vec4 fragmentColor;

void main()
{
    // Add all necessary code to implement the
    // fragment shader portion of Phong shading
    //fragmentColor = vec4( 1.0, 1.0, 1.0, 1.0 );
	
	vec3 normal,lightDirection;
	vec3 viewDirection;
	vec3 reflectionFactor,reflectionDirection;
	
	float ka=0.5;	//ambient reflection coefficient
	float kd=0.7;	//diffuse reflection coefficient
	float ks=1.0;	//specular reflection coefficient
	
	vec4 diffused,specular;
	
	normal= normalize(normalInterpolation);
	lightDirection=normalize(lightLocation-vertexLocation);
	
	//phong model
	viewDirection =normalize(-vertexLocation);
	reflectionFactor=reflect(-lightDirection,normal);
	reflectionDirection= normalize(reflectionFactor);
	
	float product_normalLightLocation=dot(normal,lightDirection);
	diffused=light_color*(diffused_color*kd)*product_normalLightLocation;
	
	
	float reflectionViewDirection=dot(reflectionDirection,viewDirection);
	float specAngle=max(reflectionViewDirection,0.0);
	float spec=pow(specAngle,shininess);
	specular=light_color*(specular_color*ks)*spec;
	
	fragmentColor=diffused+(ambient_color*ka)+specular;
	
}
