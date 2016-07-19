//
// Vertex shader for the transformation assignment
//
// Author:  W. R. Carithers
//
// Contributor:KHYATI K.VYAS

#version 150

// attribute:  vertex position
in vec4 vPosition;

// add other global shader variables to hold the
// parameters your application code is providing


uniform vec3 rotate;
uniform vec3 translate;
uniform vec3 scale;
uniform vec3 eye;
uniform vec3 lookat;
uniform vec3 up;
uniform mat4 projection;

void main()
{	
	//Translation matrix
	mat4 translate_Matrix=mat4(1.0,0.0,0.0,0.0,
							0.0,1.0,0.0,0.0,
							0.0,0.0,1.0,0.0,
							translate.x,translate.y,translate.z,1.0);
	translate_Matrix=transpose(translate_Matrix);
	
	//Sclaing matrix
	mat4 scale_Matrix=mat4(scale.x,0.0,0.0,0.0,
							0.0,scale.y,0.0,0.0,
							0.0,0.0,scale.z,0.0,
							0.0,0.0,0.0,1.0);
	scale_Matrix=transpose(scale_Matrix);
	
	//angles for x
	float cosTheta_x=cos((rotate.x));
	float sinTheta_x=sin((rotate.x));
	
	//angles for y
	float cosTheta_y=cos((rotate.y));
	float sinTheta_y=sin((rotate.y));
	
	//angles z
	float cosTheta_z=cos((rotate.z));
	float sinTheta_z=sin((rotate.z));
	
	//Rotation around x axis;
	mat4 rotate_xAxis=mat4(1.0,0.0,0.0,0.0,
							0.0,cosTheta_x,sinTheta_x,0.0,
							0.0,-sinTheta_x,cosTheta_x,0.0,
							0.0,0.0,0.0,1.0);
	rotate_xAxis=transpose(rotate_xAxis);	
	
	//Rotation around y axis;						
	mat4 rotate_yAxis=mat4(cosTheta_y,0.0,-sinTheta_y,0.0,
							0.0,1.0,0.0,0.0,
							sinTheta_y,0.0,cosTheta_y,0.0,
							0.0,0.0,0.0,1.0);
	rotate_yAxis=transpose(rotate_yAxis);
	
	//Rotation around z axis;						
	mat4 rotate_zAxis=mat4(cosTheta_z,sinTheta_z,0.0,0.0,
							-sinTheta_z,cosTheta_z,0.0,0.0,
							0.0,0.0,1.0,0.0,
							0.0,0.0,0.0,1.0);
	rotate_zAxis=transpose(rotate_zAxis);
	
	//vec4 transformation_Matrix=translate_Matrix*rotate_zAxis*rotate_yAxis*rotate_xAxis*scale_Matrix*vPosition;
	
	//world coordiantes	
	vec3 n;
	vec3 u;
	vec3 v;
	
	//normalizing world coordiantes
	n=normalize(eye-lookat);
	u=normalize(cross(up,n));
	v=normalize(cross(n,u));
	
	//viewing Transformation matrix
	mat4 viewing_Transformation=mat4(u.x,u.y,u.z,(-1.0*dot(u,eye)),
									v.x,v.y,v.z,(-1.0*dot(v,eye)),
									n.x,n.y,n.z,(-1.0*dot(n,eye)),
									0.0,0.0,0.0,1.0);
	
	//viewing_Transformation=transpose(viewing_Transformation);
	
	//world coordinates from the camera coordiantes formed by multiplying the transformation matrices with the viewing transformation matrix.
	vec4 world_to_camera=translate_Matrix*rotate_zAxis*rotate_yAxis*rotate_xAxis*scale_Matrix*vPosition*viewing_Transformation;
	
    //By default, no transformations are performed.
    gl_Position = projection*world_to_camera;
}
