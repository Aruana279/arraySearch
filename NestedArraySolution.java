package akoshkarova.hw1;

import algs.hw1.arraysearch.NestedArraySearch;



/**

 * Copy this class into your package, which must have USERID has its root.

 */

public class NestedArraySolution extends NestedArraySearch {

 

       /** Construct problem solution for given array. Do not modify this method. */

       public NestedArraySolution(int[][] a) {

              super(a);

       }

      

       /** 

       * For this homework assignment, you need to complete the implementation of this

       * method.

       */

       @Override

       public int[] locate(int target) {
    	   int n=this.length();
    	   int low=0;
    	   
    	   int high=(int)(1+Math.floor((n-1)/3));
    	   
    	   while (low <= high && high>0) {
    		   int mid = (low+high)/2;
    		 //System.out.println(mid);
    		   int rowForInit=2 * mid;
    		   
    		   
    		   int difference = inspect (rowForInit, mid) - target;
    		   if (difference < 0) {
    			   low = mid + 1;} 
    		   else if (difference > 0) {
    			   high = mid - 1;} 
    		   else {return new int[] {rowForInit, mid};}
    		   }
    	   

    	   if (high < 0 || high>n) {return null;}    	   
    	   int left = high;
    	   int right = high+n-(1+3*high);
    	   int minValRow = 2 * high;
    	   int minValCol= high;
    	   
    	   while (left <= right ) {
    		   int middle = (left+right)/2;
    		   //System.out.println(middle);
    		   
    		   int rc = inspect (minValRow+(middle-minValCol), middle) - target;
    		   if (rc < 0) {
    			   left = middle + 1;} 
    		   else if (rc > 0) {
    			   right = middle - 1;
    			   } 
    		   else {return new int[] {minValRow+(middle-minValCol), middle};}
    		   }
    	   
    	   
    	   int leftMost = high;
    	   int rightMost = high+n-(1+3*high); //the rightmost (column) value in the triangle
    	   
    	   while (leftMost <= rightMost) {
    		   int middle = (leftMost+rightMost)/2;
    		   int diff = inspect (n-high-1, middle) - target;
    		   if (diff > 0) {
    			   leftMost = middle+1;} 
    		   else if (diff < 0) {
    			   rightMost = middle-1;} 
    		   else {return new int[] {n-high-1, middle};}
    		   }
    	   
    	   
    	   int lo = minValRow + 1;
    	   int hi = n-2-high;
    	   while (lo <= hi) {
    		   int middle = (lo+hi)/2;
    		   int diff = inspect(middle, minValCol) - target;
    		   if (diff > 0) {
    			   lo = middle + 1;}
    		   else if (diff < 0) {
    			   hi = middle - 1;}
    		   else {return new int[] {middle, minValCol};}
    		   }

         return null;
              
              
              

       }

      

      

      

 

      

      

      

       /** Be sure that you call your class constructor. Do not modify this method. */ 

       public static void main (String args[]) {

              int[][] ar = NestedArraySearch.create(13);

              new NestedArraySolution(ar).trial();

       }
}



/*
public class NestedArraySolution extends NestedArraySearch {


	public NestedArraySolution(int[][] a) {
		super(a);
	}

	
	@Override
	public int[] locate(int target) {
		
		double k;
		int n=this.length();
		k=1+Math.floor((n-1)/3);
		int leftTr=0;
		int rightTr=(int)k-1;
		while (leftTr <= rightTr && rightTr>=0 && rightTr<=n) {
			int colTr = (leftTr+rightTr)/2;
			//System.out.println(colTr);
			int diffTr = inspect(colTr*2,colTr) - target;
			if (diffTr < 0) {
				leftTr = colTr+1;

			} else if (diffTr > 0) {
				rightTr = colTr-1;
				
				
			} else {
				return new int[] {colTr*2 , colTr};
			}
		}
		System.out.println("Target:");
		System.out.println(target);
		System.out.println("RightTr:");
		System.out.println(rightTr);

		
		if (rightTr<0) {return null;}
		if (target-inspect(rightTr*2+n-(1+3*rightTr),rightTr+n-(1+3*rightTr))<=0) {
			int left=rightTr;
			int low=rightTr*2;
			int right=rightTr+n-(1+3*rightTr);
			int high=n-1-low;
			while (left <= right) {
				int middleCol = (left+right)/2;
				int middleRow = (low+high)/2;
	
				int diff = inspect(middleRow,middleCol) - target;
				if (diff < 0) {
					left = middleCol+1;
					low=middleRow+1;
				} else if (diff > 0) {
					right = middleCol-1;
					high=middleRow-1;
				} else {
					return new int[] {middleRow , middleCol};
				}
			}
			
		}
		
		else if (target-inspect(n-(rightTr+1), rightTr)<=0){
			int left=n-(rightTr+1);
			int right=rightTr+n-(1+3*rightTr);
			while (left <= right) {
				int middleRow = n-(rightTr+1);
				int middleCol = (left+right)/2;
	
				int diff = inspect(middleRow,middleCol) - target;
				if (diff < 0) {
					right = middleCol-1;
				} else if (diff > 0) {
					left = middleCol+1;
				} else {
					return new int[] {middleRow , middleCol};
				}
			}			
		}
		
		else if (target-inspect(1, 0)<=0){
			int left=rightTr*2;
			int right=n-(rightTr+1);
			while (left <= right) {
				int middleCol = 0;
				int middleRow = (left+right)/2;
	
				int diff = inspect(middleRow,middleCol) - target;
				if (diff < 0) {
					right = middleRow-1;
				} else if (diff > 0) {
					left = middleRow+1;
				} else {
					return new int[] {middleRow , middleCol};
				}
			}			
		}
		
		

		return null;
	}
	

	public static void main (String args[]) {
		int[][] ar = NestedArraySearch.create(13);
		new NestedArraySolution(ar).trial();
	}
}

*/

	
	
	/*
	int sum=0;
	for (int i=0; i<k; i++) {
		triangle+=1;
		int currentMax=3*(n-(1+3*i));
		if (currentMax==0) { sum+=1;}
		else {sum+=currentMax;}
		if (target-sum<=0) {
			//FindingTheValue output= new FindingTheValue();

				
			}
	}
	*/
	
	/*
	private int[] findValueInTheTriangle(int target,int triangle) {
		int n=this.length();
		if (target-inspect((triangle-1)*2+n-(1+3*(triangle-1)),triangle-1+n-(1+3*(triangle-1)))<=0) {
			int left=triangle-1;
			int low=(triangle-1)*2;
			int right=left+n-(1+3*(triangle-1));
			int high=low+n-(1+3*(triangle-1));
			while (left <= right) {
				int middleCol = (left+right)/2;
				int middleRow = (low+high)/2;
	
				int diff = inspect(middleRow,middleCol) - target;
				if (diff < 0) {
					left = middleCol+1;
					middleRow+=1;
				} else if (diff > 0) {
					right = middleCol-1;
					middleRow-=1;
				} else {
					return new int[] {middleRow , middleCol};
				}
			}
		}
		else if (target-inspect(n-triangle, triangle-1)<=0){
			int left=n-triangle;
			int right=triangle-1+n-(1+3*(triangle-1));
			while (left <= right) {
				int middleRow = n-triangle;
				int middleCol = (left+right)/2;
	
				int diff = inspect(middleRow,middleCol) - target;
				if (diff < 0) {
					right = middleCol-1;
				} else if (diff > 0) {
					left = middleCol+1;
				} else {
					return new int[] {middleRow , middleCol};
				}
			}			
		}
		
		else if (target-inspect(1, 0)<=0){
			int left=(triangle-1)*2;
			int right=n-triangle;
			while (left <= right) {
				int middleCol = 0;
				int middleRow = (left+right)/2;
	
				int diff = inspect(middleRow,middleCol) - target;
				if (diff < 0) {
					right = middleRow-1;
				} else if (diff > 0) {
					left = middleRow+1;
				} else {
					return new int[] {middleRow , middleCol};
				}
			}			
		}
		
		return null;
		
	}
	*/
	
	



