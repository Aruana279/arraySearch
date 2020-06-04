package akoshkarova.hw1;

import java.util.Arrays;

import algs.hw1.arraysearch.RowOrderedArraySearch;
import edu.princeton.cs.algs4.StdOut;

/**
 * Copy this class into your package, which must have USERID has its root.
 */
public class RowOrderedArraySolution extends RowOrderedArraySearch {

	/** Construct problem solution for given array. Do not modify this method. */
	public RowOrderedArraySolution(int[][] a) {
		super(a);
	}
	@Override
	public int[] locate(int target) {
		//FIND THE ROW WHERE TARGET COULD EXIST
		int low = 0;
		int high = this.length()-1;

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
		
		int l = 0;
		int h=high;

		while (l <= h) {
			int middle = (l+h)/2;
			int rc = inspect(high,middle) - target;
			if (rc < 0) {
				l = middle+1;
			} else if (rc > 0) {
				h = middle-1;
			} else {
				return new int[] {high , middle};
			}
		}
		
		return null;
	}
	
	/** Be sure that you call your class constructor. Do not modify this method. */ 
	public static void main (String args[]) {
		int[][] ar = RowOrderedArraySearch.create(13);
		new RowOrderedArraySolution(ar).trial();
	}
}
