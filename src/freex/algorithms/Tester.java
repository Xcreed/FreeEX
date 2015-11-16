package freex.algorithms;

public abstract class Tester {
	
	//static long [][] mat;

	public static void main(String[] args) {
		
		long [][] mat = {
						{0,3,4,999999999,8,99999999},
						{999999999,0,999999999,999999999,5,999999999},
						{999999999,999999999,0,999999999,3,999999999},
						{999999999,999999999,999999999,0,999999999,999999999},
						{999999999,999999999,999999999,7,0,3},
						{999999999,999999999,999999999,2,999999999,0},
						};
		Floyd matrixsPaths = new Floyd();
		System.out.println(matrixsPaths.floydAl(mat));
		

	}

}

