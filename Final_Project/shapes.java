//
//  shapes.java
//
//  Routines for shape-drawing functions.
//
//  @author KHYATI K.VYAS
//  
//

public class shapes extends simpleShape {

	/**
	 * Object selection variables
	 */
	public static final int OBJ_SUN = 0;
	public static final int OBJ_CONE = 1;
	public static final int OBJ_DONUT = 2;
	public static final int OBJ_EARTH = 3;
	public static final int OBJ_RING = 4;
	public static final int OBJ_ISO = 5;

	/**
	 * Constructor
	 */
	public shapes() {
	}

	/**
	 * Each group of three values specifies a Cone vertex
	 */
	float[] ConeVertices = { -0.731006f, 2.363033f, -0.274866f, -0.535915f, 2.363033f, -0.255651f, -0.348322f,
			2.363033f, -0.198745f, -0.175435f, 2.363033f, -0.106336f, -0.023899f, 2.363033f, 0.018027f, 0.100464f,
			2.363033f, 0.169564f, 0.192874f, 2.363033f, 0.342451f, 0.249780f, 2.363033f, 0.530044f, 0.268994f,
			2.363033f, 0.725134f, -0.731006f, 4.363033f, 0.725134f, 0.249780f, 2.363033f, 0.920224f, 0.192874f,
			2.363033f, 1.107817f, 0.100464f, 2.363033f, 1.280704f, -0.023899f, 2.363033f, 1.432241f, -0.175435f,
			2.363033f, 1.556604f, -0.348322f, 2.363033f, 1.649014f, -0.535915f, 2.363033f, 1.705919f, -0.731006f,
			2.363033f, 1.725134f, -0.926096f, 2.363033f, 1.705919f, -1.113689f, 2.363033f, 1.649013f, -1.286576f,
			2.363033f, 1.556603f, -1.438113f, 2.363033f, 1.432240f, -1.562476f, 2.363033f, 1.280704f, -1.654886f,
			2.363033f, 1.107817f, -1.711791f, 2.363033f, 0.920223f, -1.731006f, 2.363033f, 0.725133f, -1.711791f,
			2.363033f, 0.530043f, -1.654885f, 2.363033f, 0.342450f, -1.562474f, 2.363033f, 0.169563f, -1.438112f,
			2.363033f, 0.018026f, -1.286575f, 2.363033f, -0.106336f, -1.113688f, 2.363033f, -0.198746f, -0.926094f,
			2.363033f, -0.255652f, };
	/**
	 * Each group of three values specifies a cone vertex normal
	 */
	float[] ConeNormals = { 0.087800f, 0.445500f, -0.891000f, 0.259900f, 0.445500f, -0.856700f, 0.422000f, 0.445500f,
			-0.789600f, 0.568000f, 0.445500f, -0.692100f, 0.692100f, 0.445500f, -0.568000f, 0.789600f, 0.445500f,
			-0.422000f, 0.856700f, 0.445500f, -0.259900f, 0.891000f, 0.445500f, -0.087800f, 0.891000f, 0.445500f,
			0.087800f, 0.856700f, 0.445500f, 0.259900f, 0.789600f, 0.445500f, 0.422000f, 0.692100f, 0.445500f,
			0.568000f, 0.568000f, 0.445500f, 0.692100f, 0.422000f, 0.445500f, 0.789600f, 0.259900f, 0.445500f,
			0.856700f, 0.087800f, 0.445500f, 0.891000f, -0.087800f, 0.445500f, 0.891000f, -0.259900f, 0.445500f,
			0.856700f, -0.422000f, 0.445500f, 0.789600f, -0.568000f, 0.445500f, 0.692100f, -0.692100f, 0.445500f,
			0.568000f, -0.789600f, 0.445500f, 0.422000f, -0.856700f, 0.445500f, 0.259900f, -0.891000f, 0.445500f,
			0.087800f, -0.891000f, 0.445500f, -0.087800f, -0.856700f, 0.445500f, -0.259900f, -0.789600f, 0.445500f,
			-0.422000f, -0.692100f, 0.445500f, -0.568000f, -0.568000f, 0.445500f, -0.692100f, -0.422000f, 0.445500f,
			-0.789600f, -0.259900f, 0.445500f, -0.856700f, -0.087800f, 0.445500f, -0.891000f, 0.000000f, -1.000000f,
			-0.000000f, };
	/**
	 * Each group of three values specifies a cone elements
	 */
	int[] ConeElements = { 0, 9, 1, 1, 9, 2, 2, 9, 3, 3, 9, 4, 4, 9, 5, 5, 9, 6, 6, 9, 7, 7, 9, 8, 8, 9, 10, 10, 9,
			11, 11, 9, 12, 12, 9, 13, 13, 9, 14, 14, 9, 15, 15, 9, 16, 16, 9, 17, 17, 9, 18, 18, 9, 19, 19, 9, 20, 20,
			9, 21, 21, 9, 22, 22, 9, 23, 23, 9, 24, 24, 9, 25, 25, 9, 26, 26, 9, 27, 27, 9, 28, 28, 9, 29, 29, 9, 30,
			30, 9, 31, 31, 9, 32, 32, 9, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
			22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, };

	/**
	 * Each group of three values specifies a cone normal indices
	 */
	int[] ConeNormalIndices = { 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9,
			9, 10, 10, 10, 11, 11, 11, 12, 12, 12, 13, 13, 13, 14, 14, 14, 15, 15, 15, 16, 16, 16, 17, 17, 17, 18, 18,
			18, 19, 19, 19, 20, 20, 20, 21, 21, 21, 22, 22, 22, 23, 23, 23, 24, 24, 24, 25, 25, 25, 26, 26, 26, 27, 27,
			27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32,
			32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, };

	/**
	 * makeCone() - create a Cone object
	 */
	private void makeCone() {

		for (int i = 0; i < ConeElements.length - 2; i += 3) {

			// calculate the base indices of the three vertices
			int point1 = 3 * ConeElements[i]; // slots 0, 1, 2
			int point2 = 3 * ConeElements[i + 1]; // slots 3, 4, 5
			int point3 = 3 * ConeElements[i + 2]; // slots 6, 7, 8

			int normal1 = 3 * ConeNormalIndices[i];
			int normal2 = 3 * ConeNormalIndices[i + 1];
			int normal3 = 3 * ConeNormalIndices[i + 2];

			addTriangleWithNorms(ConeVertices[point1 + 0], ConeVertices[point1 + 1], ConeVertices[point1 + 2],
					ConeNormals[normal1 + 0], ConeNormals[normal1 + 1], ConeNormals[normal1 + 2],

			ConeVertices[point2 + 0], ConeVertices[point2 + 1], ConeVertices[point2 + 2],
					ConeNormals[normal2 + 0], ConeNormals[normal2 + 1], ConeNormals[normal2 + 2],

			ConeVertices[point3 + 0], ConeVertices[point3 + 1], ConeVertices[point3 + 2],
					ConeNormals[normal3 + 0], ConeNormals[normal3 + 1], ConeNormals[normal3 + 2]);
		}
	}
	
	/*********************************************************** Inner Ring ************************************************************/
	/**
	 * Each group of three values specifies a Inner ring vertex
	 */
	
	
	float DonutVertices[] = { 0.312500f, 0.000000f, 0.000000f, 0.218750f, 0.054127f, 0.000000f, 0.218750f, -0.054127f,
			0.000000f, 0.220971f, 0.000000f, -0.220971f, 0.154680f, 0.054127f, -0.154680f, 0.154680f, -0.054127f,
			-0.154680f, 0.000000f, 0.000000f, -0.312500f, 0.000000f, 0.054127f, -0.218750f, 0.000000f, -0.054127f,
			-0.218750f, -0.220971f, 0.000000f, -0.220971f, -0.154680f, 0.054127f, -0.154680f, -0.154680f, -0.054127f,
			-0.154680f, -0.312500f, 0.000000f, -0.000000f, -0.218750f, 0.054127f, -0.000000f, -0.218750f, -0.054127f,
			-0.000000f, -0.220971f, 0.000000f, 0.220971f, -0.154680f, 0.054127f, 0.154680f, -0.154680f, -0.054127f,
			0.154680f, 0.000000f, 0.000000f, 0.312500f, 0.000000f, 0.054127f, 0.218750f, 0.000000f, -0.054127f,
			0.218750f, 0.220971f, 0.000000f, 0.220971f, 0.154680f, 0.054127f, 0.154680f, 0.154680f, -0.054127f,
			0.154680f };

	/**
	 *  Each group of three values specifies a Inner Ring vertex normal
	 */
	
	
	float DonutNormals[] = { 0.707100f, 0.000000f, -0.707100f, -0.215100f, 0.952600f, 0.215100f, -0.304100f, 0.952600f,
			0.000000f, -0.215100f, -0.952600f, 0.215100f, -0.304100f, -0.952600f, 0.000000f, 0.000000f, 0.000000f,
			-1.000000f, 0.000000f, 0.952600f, 0.304100f, 0.000000f, -0.952600f, 0.304100f, -0.707100f, 0.000000f,
			-0.707100f, 0.215100f, 0.952600f, 0.215100f, 0.215100f, -0.952600f, 0.215100f, -1.000000f, 0.000000f,
			0.000000f, 0.304100f, 0.952600f, 0.000000f, 0.304100f, -0.952600f, 0.000000f, -0.707100f, 0.000000f,
			0.707100f, 0.215100f, 0.952600f, -0.215100f, 0.215100f, -0.952600f, -0.215100f, 0.000000f, 0.000000f,
			1.000000f, 0.000000f, 0.952600f, -0.304100f, 0.000000f, -0.952600f, -0.304100f, 0.707100f, 0.000000f,
			0.707100f, -0.215100f, 0.952600f, -0.215100f, -0.215100f, -0.952600f, -0.215100f, 1.000000f, 0.000000f,
			0.000000f };

	/**
	 *  Each group of three values specifies a Inner Ring elements
	 */
	
	int DonutElements[] = { 3, 4, 1, 4, 5, 2, 2, 5, 3, 6, 7, 4, 7, 8, 5, 5, 8, 6, 9, 10, 7, 10, 11, 8, 11, 9, 6, 12, 13,
			10, 13, 14, 11, 11, 14, 12, 15, 16, 13, 16, 17, 14, 17, 15, 12, 18, 19, 16, 19, 20, 17, 17, 20, 18, 18, 21,
			22, 22, 23, 20, 23, 21, 18, 0, 1, 22, 1, 2, 23, 2, 0, 21, 0, 3, 1, 1, 4, 2, 0, 2, 3, 3, 6, 4, 4, 7, 5, 3, 5,
			6, 6, 9, 7, 7, 10, 8, 8, 11, 6, 9, 12, 10, 10, 13, 11, 9, 11, 12, 12, 15, 13, 13, 16, 14, 14, 17, 12, 15,
			18, 16, 16, 19, 17, 15, 17, 18, 19, 18, 22, 19, 22, 20, 20, 23, 18, 21, 0, 22, 22, 1, 23, 23, 2, 21 };
	/**
	 *  Each group of three values specifies a Inner Ring nromal Indices
	 */
	
	int DonutNormalIndices[] = { 0, 1, 2, 1, 3, 4, 4, 3, 0, 5, 6, 1, 6, 7, 3, 3, 7, 5, 8, 9, 6, 9, 10, 7, 10, 8, 5, 11,
			12, 9, 12, 13, 10, 10, 13, 11, 14, 15, 12, 15, 16, 13, 16, 14, 11, 17, 18, 15, 18, 19, 16, 16, 19, 17, 17,
			20, 21, 21, 22, 19, 22, 20, 17, 23, 2, 21, 2, 4, 22, 4, 23, 20, 23, 0, 2, 2, 1, 4, 23, 4, 0, 0, 5, 1, 1, 6,
			3, 0, 3, 5, 5, 8, 6, 6, 9, 7, 7, 10, 5, 8, 11, 9, 9, 12, 10, 8, 10, 11, 11, 14, 12, 12, 15, 13, 13, 16, 11,
			14, 17, 15, 15, 18, 16, 14, 16, 17, 18, 17, 21, 18, 21, 19, 19, 22, 17, 20, 23, 21, 21, 2, 22, 22, 4, 20 };

	/*
	 * makeDonut() - create a Inner circle of the space ship object
	 */
	private void makeDonut() {

		for (int i = 0; i < DonutElements.length - 2; i += 3) {

			// calculate the base indices of the three vertices
			int point1 = 3 * DonutElements[i]; // slots 0, 1, 2
			int point2 = 3 * DonutElements[i + 1]; // slots 3, 4, 5
			int point3 = 3 * DonutElements[i + 2]; // slots 6, 7, 8

			int normal1 = 3 * DonutNormalIndices[i];
			int normal2 = 3 * DonutNormalIndices[i + 1];
			int normal3 = 3 * DonutNormalIndices[i + 2];

			addTriangleWithNorms(DonutVertices[point1 + 0], DonutVertices[point1 + 1], DonutVertices[point1 + 2],
					DonutNormals[normal1 + 0], DonutNormals[normal1 + 1], DonutNormals[normal1 + 2],

			DonutVertices[point2 + 0], DonutVertices[point2 + 1], DonutVertices[point2 + 2], DonutNormals[normal2 + 0],
					DonutNormals[normal2 + 1], DonutNormals[normal2 + 2],

			DonutVertices[point3 + 0], DonutVertices[point3 + 1], DonutVertices[point3 + 2], DonutNormals[normal3 + 0],
					DonutNormals[normal3 + 1], DonutNormals[normal3 + 2]);
		}
	}
	/*********************************************************** END OF INNER RING****************************************/

	/***************************************** OUTTER RING ***********************************************************************/
	//
	// Each group of three values specifies a  OUTTER RING vertex
	//
	float RingVertices[] = { 0.312500f, 0.000000f, 0.000000f, 0.218750f, 0.054127f, 0.000000f, 0.218750f, -0.054127f,
		0.000000f, 0.220971f, 0.000000f, -0.220971f, 0.154680f, 0.054127f, -0.154680f, 0.154680f, -0.054127f,
		-0.154680f, 0.000000f, 0.000000f, -0.312500f, 0.000000f, 0.054127f, -0.218750f, 0.000000f, -0.054127f,
		-0.218750f, -0.220971f, 0.000000f, -0.220971f, -0.154680f, 0.054127f, -0.154680f, -0.154680f, -0.054127f,
		-0.154680f, -0.312500f, 0.000000f, -0.000000f, -0.218750f, 0.054127f, -0.000000f, -0.218750f, -0.054127f,
		-0.000000f, -0.220971f, 0.000000f, 0.220971f, -0.154680f, 0.054127f, 0.154680f, -0.154680f, -0.054127f,
		0.154680f, 0.000000f, 0.000000f, 0.312500f, 0.000000f, 0.054127f, 0.218750f, 0.000000f, -0.054127f,
		0.218750f, 0.220971f, 0.000000f, 0.220971f, 0.154680f, 0.054127f, 0.154680f, 0.154680f, -0.054127f,
		0.154680f };
	//
	// Each group of three values specifies a  OUTTER RING vertex normal
	//
	float RingNormals[] = { 0.707100f, 0.000000f, -0.707100f, -0.215100f, 0.952600f, 0.215100f, -0.304100f, 0.952600f,
			0.000000f, -0.215100f, -0.952600f, 0.215100f, -0.304100f, -0.952600f, 0.000000f, 0.000000f, 0.000000f,
			-1.000000f, 0.000000f, 0.952600f, 0.304100f, 0.000000f, -0.952600f, 0.304100f, -0.707100f, 0.000000f,
			-0.707100f, 0.215100f, 0.952600f, 0.215100f, 0.215100f, -0.952600f, 0.215100f, -1.000000f, 0.000000f,
			0.000000f, 0.304100f, 0.952600f, 0.000000f, 0.304100f, -0.952600f, 0.000000f, -0.707100f, 0.000000f,
			0.707100f, 0.215100f, 0.952600f, -0.215100f, 0.215100f, -0.952600f, -0.215100f, 0.000000f, 0.000000f,
			1.000000f, 0.000000f, 0.952600f, -0.304100f, 0.000000f, -0.952600f, -0.304100f, 0.707100f, 0.000000f,
			0.707100f, -0.215100f, 0.952600f, -0.215100f, -0.215100f, -0.952600f, -0.215100f, 1.000000f, 0.000000f,
			0.000000f };

	// Each group of three entries specifies  OUTTER RING elements
	//
	int RingElements[] = { 3, 4, 1, 4, 5, 2, 2, 5, 3, 6, 7, 4, 7, 8, 5, 5, 8, 6, 9, 10, 7, 10, 11, 8, 11, 9, 6, 12, 13,
			10, 13, 14, 11, 11, 14, 12, 15, 16, 13, 16, 17, 14, 17, 15, 12, 18, 19, 16, 19, 20, 17, 17, 20, 18, 18, 21,
			22, 22, 23, 20, 23, 21, 18, 0, 1, 22, 1, 2, 23, 2, 0, 21, 0, 3, 1, 1, 4, 2, 0, 2, 3, 3, 6, 4, 4, 7, 5, 3, 5,
			6, 6, 9, 7, 7, 10, 8, 8, 11, 6, 9, 12, 10, 10, 13, 11, 9, 11, 12, 12, 15, 13, 13, 16, 14, 14, 17, 12, 15,
			18, 16, 16, 19, 17, 15, 17, 18, 19, 18, 22, 19, 22, 20, 20, 23, 18, 21, 0, 22, 22, 1, 23, 23, 2, 21 };


	// Each group of three entries specifies  OUTTER RING normal indices
	//
	int RingNormalIndices[] = { 0, 1, 2, 1, 3, 4, 4, 3, 0, 5, 6, 1, 6, 7, 3, 3, 7, 5, 8, 9, 6, 9, 10, 7, 10, 8, 5, 11,
			12, 9, 12, 13, 10, 10, 13, 11, 14, 15, 12, 15, 16, 13, 16, 14, 11, 17, 18, 15, 18, 19, 16, 16, 19, 17, 17,
			20, 21, 21, 22, 19, 22, 20, 17, 23, 2, 21, 2, 4, 22, 4, 23, 20, 23, 0, 2, 2, 1, 4, 23, 4, 0, 0, 5, 1, 1, 6,
			3, 0, 3, 5, 5, 8, 6, 6, 9, 7, 7, 10, 5, 8, 11, 9, 9, 12, 10, 8, 10, 11, 11, 14, 12, 12, 15, 13, 13, 16, 11,
			14, 17, 15, 15, 18, 16, 14, 16, 17, 18, 17, 21, 18, 21, 19, 19, 22, 17, 20, 23, 21, 21, 2, 22, 22, 4, 20 };

	/*
	 * makeRing() - create the outter ring object
	 */
	private void makeRing() {

		for (int i = 0; i < RingElements.length - 2; i += 3) {

			// calculate the base indices of the three vertices
			int point1 = 3 * RingElements[i]; // slots 0, 1, 2
			int point2 = 3 * RingElements[i + 1]; // slots 3, 4, 5
			int point3 = 3 * RingElements[i + 2]; // slots 6, 7, 8

			int normal1 = 3 * RingNormalIndices[i];
			int normal2 = 3 * RingNormalIndices[i + 1];
			int normal3 = 3 * RingNormalIndices[i + 2];

			addTriangleWithNorms(RingVertices[point1 + 0], RingVertices[point1 + 1], RingVertices[point1 + 2],
					RingNormals[normal1 + 0], RingNormals[normal1 + 1], RingNormals[normal1 + 2],

			RingVertices[point2 + 0], RingVertices[point2 + 1], RingVertices[point2 + 2], RingNormals[normal2 + 0],
					RingNormals[normal2 + 1], RingNormals[normal2 + 2],

			RingVertices[point3 + 0], RingVertices[point3 + 1], RingVertices[point3 + 2], RingNormals[normal3 + 0],
					RingNormals[normal3 + 1], RingNormals[normal3 + 2]);
		}
	}
	/***************************************** END OF OUTTER RING ***********************************************************************/

	/***************************************** ISOSPHERE ***********************************************************************/
	//
	// Each group of three values specifies a ISOSPHERE vertex
	//
	float isoSphereVertices[] = { -1.334826f, -0.192765f, 0.260851f, -0.611218f, 0.360015f, 0.786576f, -1.611214f,
			0.360015f, 1.111500f, -2.229252f, 0.360019f, 0.260851f, -1.611214f, 0.360015f, -0.589799f, -0.611218f,
			0.360015f, -0.264875f, -1.058437f, 1.254454f, 1.111500f, -2.058433f, 1.254454f, 0.786576f, -2.058433f,
			1.254454f, -0.264875f, -1.058437f, 1.254454f, -0.589799f, -0.440399f, 1.254450f, 0.260851f, -1.334826f,
			1.807235f, 0.260851f, -1.497281f, -0.043420f, 0.760846f, -0.909503f, -0.043420f, 0.569862f, -1.071957f,
			0.281497f, 1.069862f, -0.484178f, 0.281499f, 0.260851f, -0.909503f, -0.043420f, -0.048161f, -1.860555f,
			-0.043417f, 0.260851f, -2.023015f, 0.281498f, 0.760848f, -1.497281f, -0.043420f, -0.239145f, -2.023015f,
			0.281498f, -0.239146f, -1.071957f, 0.281497f, -0.548161f, -0.383768f, 0.807235f, 0.569863f, -0.383768f,
			0.807235f, -0.048162f, -1.334826f, 0.807235f, 1.260851f, -0.747040f, 0.807235f, 1.069867f, -2.285883f,
			0.807235f, 0.569863f, -1.922611f, 0.807235f, 1.069867f, -1.922611f, 0.807235f, -0.548166f, -2.285883f,
			0.807235f, -0.048162f, -0.747040f, 0.807235f, -0.548166f, -1.334826f, 0.807235f, -0.739149f, -0.646636f,
			1.332971f, 0.760848f, -1.597694f, 1.332972f, 1.069862f, -2.185473f, 1.332970f, 0.260851f, -1.597694f,
			1.332972f, -0.548161f, -0.646636f, 1.332971f, -0.239146f, -1.172370f, 1.657889f, 0.760846f, -0.809096f,
			1.657886f, 0.260851f, -1.760148f, 1.657889f, 0.569862f, -1.760148f, 1.657889f, -0.048161f, -1.172370f,
			1.657889f, -0.239145f, };

	//
	// Each group of three values specifies a ISOSPHERE vertex normal
	//
	float isoSphereNormals[] = { 0.102400f, -0.943500f, 0.315100f, 0.700200f, -0.661700f, 0.268000f, -0.268000f,
			-0.943500f, 0.194700f, -0.268000f, -0.943500f, -0.194700f, 0.102400f, -0.943500f, -0.315100f, 0.905000f,
			-0.330400f, 0.268000f, 0.024700f, -0.330400f, 0.943500f, -0.889700f, -0.330400f, 0.315100f, -0.574600f,
			-0.330400f, -0.748800f, 0.534600f, -0.330400f, -0.777900f, 0.802600f, -0.125600f, 0.583100f, -0.306600f,
			-0.125600f, 0.943500f, -0.992100f, -0.125600f, 0.000000f, -0.306600f, -0.125600f, -0.943500f, 0.802600f,
			-0.125600f, -0.583100f, 0.408900f, 0.661700f, 0.628400f, -0.471300f, 0.661700f, 0.583100f, -0.700200f,
			0.661700f, -0.268000f, 0.038500f, 0.661700f, -0.748800f, 0.724000f, 0.661700f, -0.194700f, 0.268000f,
			0.943500f, -0.194700f, 0.491100f, 0.794700f, -0.356800f, 0.408900f, 0.661700f, -0.628400f, -0.102400f,
			0.943500f, -0.315100f, -0.187600f, 0.794700f, -0.577300f, -0.471300f, 0.661700f, -0.583100f, -0.331300f,
			0.943500f, 0.000000f, -0.607100f, 0.794700f, 0.000000f, -0.700200f, 0.661700f, 0.268000f, -0.102400f,
			0.943500f, 0.315100f, -0.187600f, 0.794700f, 0.577300f, 0.038500f, 0.661700f, 0.748800f, 0.268000f,
			0.943500f, 0.194700f, 0.491100f, 0.794700f, 0.356800f, 0.724000f, 0.661700f, 0.194700f, 0.889700f,
			0.330400f, -0.315100f, 0.794700f, 0.187600f, -0.577300f, 0.574600f, 0.330400f, -0.748800f, -0.024700f,
			0.330400f, -0.943500f, -0.303500f, 0.187600f, -0.934200f, -0.534600f, 0.330400f, -0.777900f, -0.905000f,
			0.330400f, -0.268000f, -0.982200f, 0.187600f, 0.000000f, -0.905000f, 0.330400f, 0.268000f, -0.534600f,
			0.330400f, 0.777900f, -0.303500f, 0.187600f, 0.934200f, -0.024700f, 0.330400f, 0.943500f, 0.574600f,
			0.330400f, 0.748800f, 0.794700f, 0.187600f, 0.577300f, 0.889700f, 0.330400f, 0.315100f, 0.306600f,
			0.125600f, -0.943500f, 0.303500f, -0.187600f, -0.934200f, 0.024700f, -0.330400f, -0.943500f, -0.802600f,
			0.125600f, -0.583100f, -0.794700f, -0.187600f, -0.577300f, -0.889700f, -0.330400f, -0.315100f, -0.802600f,
			0.125600f, 0.583100f, -0.794700f, -0.187600f, 0.577300f, -0.574600f, -0.330400f, 0.748800f, 0.306600f,
			0.125600f, 0.943500f, 0.303500f, -0.187600f, 0.934200f, 0.534600f, -0.330400f, 0.777900f, 0.992100f,
			0.125600f, 0.000000f, 0.982200f, -0.187600f, 0.000000f, 0.905000f, -0.330400f, -0.268000f, 0.471300f,
			-0.661700f, -0.583100f, 0.187600f, -0.794700f, -0.577300f, -0.038500f, -0.661700f, -0.748800f, -0.408900f,
			-0.661700f, -0.628400f, -0.491100f, -0.794700f, -0.356800f, -0.724000f, -0.661700f, -0.194700f, -0.724000f,
			-0.661700f, 0.194700f, -0.491100f, -0.794700f, 0.356800f, -0.408900f, -0.661700f, 0.628400f, 0.700200f,
			-0.661700f, -0.268000f, 0.607100f, -0.794700f, 0.000000f, 0.331300f, -0.943500f, 0.000000f, -0.038500f,
			-0.661700f, 0.748800f, 0.187600f, -0.794700f, 0.577300f, 0.471300f, -0.661700f, 0.583100f, };

	// Each group specifies ISOSPHERE elements.
	//
	int isoSphereElements[] = { 0, 13, 12, 1, 13, 15, 0, 12, 17, 0, 17, 19, 0, 19, 16, 1, 15, 22, 2, 14, 24, 3, 18, 26,
			4, 20, 28, 5, 21, 30, 1, 22, 25, 2, 24, 27, 3, 26, 29, 4, 28, 31, 5, 30, 23, 6, 32, 37, 7, 33, 39, 8, 34,
			40, 9, 35, 41, 10, 36, 38, 38, 41, 11, 38, 36, 41, 36, 9, 41, 41, 40, 11, 41, 35, 40, 35, 8, 40, 40, 39, 11,
			40, 34, 39, 34, 7, 39, 39, 37, 11, 39, 33, 37, 33, 6, 37, 37, 38, 11, 37, 32, 38, 32, 10, 38, 23, 36, 10,
			23, 30, 36, 30, 9, 36, 31, 35, 9, 31, 28, 35, 28, 8, 35, 29, 34, 8, 29, 26, 34, 26, 7, 34, 27, 33, 7, 27,
			24, 33, 24, 6, 33, 25, 32, 6, 25, 22, 32, 22, 10, 32, 30, 31, 9, 30, 21, 31, 21, 4, 31, 28, 29, 8, 28, 20,
			29, 20, 3, 29, 26, 27, 7, 26, 18, 27, 18, 2, 27, 24, 25, 6, 24, 14, 25, 14, 1, 25, 22, 23, 10, 22, 15, 23,
			15, 5, 23, 16, 21, 5, 16, 19, 21, 19, 4, 21, 19, 20, 4, 19, 17, 20, 17, 3, 20, 17, 18, 3, 17, 12, 18, 12, 2,
			18, 15, 16, 5, 15, 13, 16, 13, 0, 16, 12, 14, 2, 12, 13, 14, 13, 1, 14, };
	
	// Each group specifies ISOSPHERE Normal Indices.
		//
	int isoSphereNormalIndices[] = { 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9,
			9, 9, 10, 10, 10, 11, 11, 11, 12, 12, 12, 13, 13, 13, 14, 14, 14, 15, 15, 15, 16, 16, 16, 17, 17, 17, 18,
			18, 18, 19, 19, 19, 20, 20, 20, 21, 21, 21, 22, 22, 22, 23, 23, 23, 24, 24, 24, 25, 25, 25, 26, 26, 26, 27,
			27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34, 34, 35, 35, 35, 36,
			36, 36, 37, 37, 37, 38, 38, 38, 39, 39, 39, 40, 40, 40, 41, 41, 41, 42, 42, 42, 43, 43, 43, 44, 44, 44, 45,
			45, 45, 46, 46, 46, 47, 47, 47, 48, 48, 48, 49, 49, 49, 50, 50, 50, 51, 51, 51, 52, 52, 52, 53, 53, 53, 54,
			54, 54, 55, 55, 55, 56, 56, 56, 57, 57, 57, 58, 58, 58, 59, 59, 59, 60, 60, 60, 61, 61, 61, 62, 62, 62, 63,
			63, 63, 64, 64, 64, 65, 65, 65, 66, 66, 66, 67, 67, 67, 68, 68, 68, 69, 69, 69, 70, 70, 70, 71, 71, 71, 72,
			72, 72, 73, 73, 73, 74, 74, 74, 75, 75, 75, 76, 76, 76, 77, 77, 77, 78, 78, 78, 79, 79, 79, };

	/*
	 * makeisoSphere() - create a isoSphere object 
	 */
	
	private void makeisoSphere() {

		for (int i = 0; i < isoSphereElements.length - 2; i += 3) {

			// calculate the base indices of the three vertices
			int point1 = 3 * isoSphereElements[i]; // slots 0, 1, 2
			int point2 = 3 * isoSphereElements[i + 1]; // slots 3, 4, 5
			int point3 = 3 * isoSphereElements[i + 2]; // slots 6, 7, 8

			int normal1 = 3 * isoSphereNormalIndices[i];
			int normal2 = 3 * isoSphereNormalIndices[i + 1];
			int normal3 = 3 * isoSphereNormalIndices[i + 2];

			addTriangleWithNorms(isoSphereVertices[point1 + 0], isoSphereVertices[point1 + 1],
					isoSphereVertices[point1 + 2], isoSphereNormals[normal1 + 0], isoSphereNormals[normal1 + 1],
					isoSphereNormals[normal1 + 2],

			isoSphereVertices[point2 + 0], isoSphereVertices[point2 + 1], isoSphereVertices[point2 + 2],
					isoSphereNormals[normal2 + 0], isoSphereNormals[normal2 + 1], isoSphereNormals[normal2 + 2],

			isoSphereVertices[point3 + 0], isoSphereVertices[point3 + 1], isoSphereVertices[point3 + 2],
					isoSphereNormals[normal3 + 0], isoSphereNormals[normal3 + 1], isoSphereNormals[normal3 + 2]);
		}
	}
	/****************************************END OF ISOSPHERE ****************************************************/

	
	/**************************************** SUN ****************************************************/
	/**
	 * Each group of three values specifies a sun vertex
	 */
	float[] quadVertices = {
			// top row
			-0.50f, 0.50f, 0.50f, -0.25f, 0.50f, 0.50f, 0.00f, 0.50f, 0.50f, 0.25f, 0.50f, 0.50f, 0.50f, 0.50f, 0.50f,
			// second row
			-0.50f, 0.25f, 0.50f, -0.25f, 0.25f, 0.50f, 0.00f, 0.25f, 0.50f, 0.25f, 0.25f, 0.50f, 0.50f, 0.25f, 0.50f,
			// third (middle) row
			-0.50f, 0.00f, 0.50f, -0.25f, 0.00f, 0.50f, 0.00f, 0.00f, 0.50f, 0.25f, 0.00f, 0.50f, 0.50f, 0.00f, 0.50f,
			// fourth row
			-0.50f, -0.25f, 0.50f, -0.25f, -0.25f, 0.50f, 0.00f, -0.25f, 0.50f, 0.25f, -0.25f, 0.50f, 0.50f, -0.25f,
			0.50f,
			// fifth (last) row
			-0.50f, -0.50f, 0.50f, -0.25f, -0.50f, 0.50f, 0.00f, -0.50f, 0.50f, 0.25f, -0.50f, 0.50f, 0.50f, -0.50f,
			0.50f };

	/**
	 * Each pair of values specifies a vertex's texture coordinates
	 */

	float[] quadUV = {
			// top row
			0.00f, 1.00f, 0.25f, 1.00f, 0.50f, 1.00f, 0.75f, 1.00f, 1.00f, 1.00f,
			// second row
			0.00f, 0.75f, 0.25f, 0.75f, 0.50f, 0.75f, 0.75f, 0.75f, 1.00f, 0.75f,
			// third (middle) row
			0.00f, 0.50f, 0.25f, 0.50f, 0.50f, 0.50f, 0.75f, 0.50f, 1.00f, 0.50f,
			// fourth row
			0.00f, 0.25f, 0.25f, 0.25f, 0.50f, 0.25f, 0.75f, 0.25f, 1.00f, 0.25f,
			// fifth (last) row
			0.00f, 0.00f, 0.25f, 0.00f, 0.50f, 0.00f, 0.75f, 0.00f, 1.00f, 0.00f };

	/**
	 * Because the sun faces +Z, all the normals are (0,0,1)
	 */
	float[] quadNormals = { 0.0f, 0.0f, 1.0f };

	/**
	 * Each group of three entries specifies a triangle for the sun
	 */
	int[] quadElements = {
			// top row
			0, 5, 1, 5, 6, 1, 1, 6, 2, 6, 7, 2, 2, 7, 3, 7, 8, 3, 3, 8, 4, 8, 9, 4,
			// second row
			5, 10, 6, 10, 11, 6, 6, 11, 7, 11, 12, 7, 7, 12, 8, 12, 13, 8, 8, 13, 9, 13, 14, 9,
			// third row
			10, 15, 11, 15, 16, 11, 11, 16, 12, 16, 17, 12, 12, 17, 13, 17, 18, 13, 13, 18, 14, 18, 19, 14,
			// fourth row
			15, 20, 16, 20, 21, 16, 16, 21, 17, 21, 22, 17, 17, 22, 18, 22, 23, 18, 18, 23, 19, 23, 24, 19 };

	/**
	 * makeQuad() - create a sun object
	 */

	// %% make for new object like this
	private void makeQuad() {
		int i;

		for (i = 0; i < quadElements.length - 2; i += 3) {

			// Calculate the base indices of the three vertices
			int point1 = 3 * quadElements[i]; // slots 0, 1, 2
			int point2 = 3 * quadElements[i + 1]; // slots 3, 4, 5
			int point3 = 3 * quadElements[i + 2]; // slots 6, 7, 8

			// Calculate the base indices of the three texture coordinates
			int normal1 = 2 * quadElements[i]; // slots 0, 1, 2
			int normal2 = 2 * quadElements[i + 1]; // slots 3, 4, 5
			int normal3 = 2 * quadElements[i + 2]; // slots 6, 7, 8

			// Add triangle and texture coordinates
			addTriangleWithUV(quadVertices[point1 + 0], quadVertices[point1 + 1], quadVertices[point1 + 2],
					quadUV[normal1 + 0], quadUV[normal1 + 1], quadVertices[point2 + 0], quadVertices[point2 + 1],
					quadVertices[point2 + 2], quadUV[normal2 + 0], quadUV[normal2 + 1], quadVertices[point3 + 0],
					quadVertices[point3 + 1], quadVertices[point3 + 2], quadUV[normal3 + 0], quadUV[normal3 + 1]);

		}

	}
	
	/****************************************END OF SUN ****************************************************/
	
	/**************************************** EARTH ****************************************************/
	/**
	 * method for creating sphere
	 */
	public void makeEarth()

	{
		float r = 1.4f;
		float add = 0.5f;
		int slices =60;
		int stacks =20;
		if (slices < 3)
			slices = 3;

		if (stacks < 3)
			stacks = 3;

		for (int i = 0; i < stacks; i++) {

			float phi_t = ((float) i / stacks) * 180;
			float phi_t_1 = ((float) (i + 1) / stacks) * 180;
			float phi1 = (float) Math.toRadians(phi_t);
			float phi2 = (float) Math.toRadians(phi_t_1);
			for (int j = 0; j < slices; j++) {

				float angle_t = ((float) j / slices) * (360);
				float angle_t_1 = ((float) (j + 1) / slices) * (360);

				float theta1 = (float) Math.toRadians(angle_t);
				float theta2 = (float) Math.toRadians(angle_t_1);
				
				float sin_phi_1=(float)(Math.sin(phi1));
				float sin_theta_1=(float) (Math.sin(theta1));
				float sin_phi_2=(float)(Math.sin(phi2));
				float sin_theta_2=(float)(Math.sin(theta2));
				

				float cos_theta_1=(float)(Math.cos(theta1));
				float cos_phi_1=(float)(Math.cos(phi1));
				float cos_theta_2=(float)(Math.cos(theta2));
				float cos_phi_2=(float)(Math.cos(phi2));
								
				
				float a_x = (float) (r * sin_phi_1 * cos_theta_1);
				float a_y = (float) (r * cos_phi_1);
				float a_z = (float) (r * sin_phi_1 * sin_theta_1);
				float ux = (float) ((Math.asin(a_x) / Math.PI) + add);
				float vx = (float) (-(Math.asin(a_y) / Math.PI) + add);

				float b_x = (float) (r * sin_phi_1 * cos_theta_2);
				float b_y = (float) (r * cos_phi_1);
				float b_z = (float) (r * sin_phi_1 * sin_theta_2);
				float ux1 = (float) ( (Math.asin(b_x) / Math.PI) + add);
				float vx1 = (float) (-(Math.asin(b_y) / Math.PI) + add);

				float c_x = (float) (r * sin_phi_2 * cos_theta_1);
				float c_y = (float) (r * cos_phi_2);
				float c_z = (float) (r * sin_phi_2 * sin_theta_1);
				float ux2 = (float) ((Math.asin(c_x) / Math.PI) + add);
				float vx2 = (float) (-(Math.asin(c_y) / Math.PI) + add);

				float d_x = (float) (r * sin_phi_2 * cos_theta_2);
				float d_y = (float) (r * cos_phi_2);
				float d_z = (float) (r * sin_phi_2 * sin_theta_2);
				float ux3 = (float) ((Math.asin(d_x) / Math.PI) + add);
				float vx3 = (float) (-(Math.asin(d_y) / Math.PI) + 0.5);

				//adding triangles to make the sphere.
				addTriangles(a_x, a_y, a_z, ux, vx, c_x, c_y, c_z, ux2, vx2, b_x, b_y, b_z, ux1, vx1);
				addTriangles(b_x, b_y, b_z, ux1, vx1, c_x, c_y, c_z, ux2, vx2, d_x, d_y, d_z, ux3, vx3);
			}
		}

	}

	/**
	 * Making various objects
	 * 
	 * @param choice
	 *            - 0 for sun, 
	 *            - 1 for cone
	 *            - 2 for inner ring
	 *            - 3 for earth
	 *            - 4 for outer ring
	 *            - 5 for isophere
	 */
	public void makeShape(int choice) {
		if (choice == shapes.OBJ_SUN)
	{makeQuad();makeQuad();}
		else if (choice == shapes.OBJ_CONE)
			makeCone();
		else if (choice == shapes.OBJ_DONUT)
			makeDonut();
		else if (choice == shapes.OBJ_EARTH)
			makeEarth();
		else if (choice == shapes.OBJ_RING)
			makeRing();
		else if (choice == shapes.OBJ_ISO)
			makeisoSphere();

	}
}
