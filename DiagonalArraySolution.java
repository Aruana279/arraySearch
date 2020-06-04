package akoshkarova.hw1;

import algs.hw1.arraysearch.DiagonalArraySearch;

/**
 * Copy this class into your package, which must have USERID has its root.
 */
public class DiagonalArraySolution extends DiagonalArraySearch {

	/** Construct problem solution for given array. Do not modify this method. */
	public DiagonalArraySolution(int[][] a) {
		super(a);
	}
	
	/** 
	 * For this homework assignment, you need to complete the implementation of this
	 * method.
	 */
	@Override
	public int[] locate(int target) {
		int n=this.length();
		int low = 0;
		int high = n-1;

		while (low <= high) {
			int mid = (low+high)/2;
			int difference = inspect(mid,0) - target;
			
			if (difference < 0) {
				low = mid+1;
			} else if (difference > 0) {
				high = mid-1;
				
			} else {
				return new int[] {mid , 0};
			}
		}
		
		
		int left=0;
		int right=n-1-high;
		
		if (high<0) {return null;}
		if (low>=this.length()) {return null;}
				

		while (left <= right && high>=0 && high<=n) {
			int middleCol = (left+right)/2;
			int middleRow = middleCol+high;
			int diff = inspect(middleRow,middleCol) - target;
			if (diff < 0) {
				left = middleCol+1;
			} else if (diff > 0) {
				right = middleCol-1;
			} else {
				return new int[] {middleRow , middleCol};
			}
		}
		
		return null;
	}
	
	/** Be sure that you call your class constructor. Do not modify this method. */ 
	public static void main (String args[]) {
		int[][] ar = DiagonalArraySearch.create(13);
		new DiagonalArraySolution(ar).trial();
	}
}
