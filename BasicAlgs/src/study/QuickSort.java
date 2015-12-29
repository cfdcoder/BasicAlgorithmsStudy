package study;

public class QuickSort {
    int[] Arr;
    int countQS;
    
    //constructor
    QuickSort(int[] A){
    	this.Arr=A.clone();
    	this.countQS=0;
    }
    
    //get pivot index with smaller elements on the left and bigger elements on the right
    private int Partition(int[] A, int lo, int hi){
        int pivot=A[hi];
        int pIndex=lo;//set partition index as start initially
        for(int i=lo;i<hi;i++){
        	if(A[i]<=pivot){
        		Swap(A,i,pIndex);
        		pIndex++;
        	}
        }
        Swap(A, pIndex, hi);
        return pIndex;
    }
    	
    public void Sort(int[] A, int lo, int hi){
    	if(lo<hi){	
    		this.countQS++;
    		int p = Partition(A, lo, hi);
    		
    		System.out.println("pivot element=:"+A[p]+"##");
    		System.out.print("pivot left elements are: ");
    		GetArray(A, lo, p-1);
    		System.out.print("pivot right elements are: ");
    		GetArray(A, p+1, hi);
    		
    		Sort(A, lo, p-1);
    		Sort(A, p+1, hi);
    		
    	}

    }
    
    //exchange two numbers
    public static void Swap(int[] A, int x, int y){
    	int temp=A[x];
    	A[x]=A[y];
    	A[y]=temp;
    }
	
      
    public void OutputArray(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + ", ");
		}
		System.out.println(" ");
	}

    public void GetArray(int[] A, int lo, int hi){
    	for(int i=lo;i<=hi;i++){
    		System.out.print("*"+A[i]);
    	}
    	System.out.println(" ");
    }
    
	public void OutputQuickCounts() {
		System.out.println(" ");
		System.out.print("num of partition executions: " + this.countQS);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0, 1, 3, 5, 7, 9, 15, 13, 11, 2, 4, 6, 8, 10, 14, 12};
		
		QuickSort QS = new QuickSort(A);
		System.out.print("initial arr: ");
		QS.OutputArray(QS.Arr);
		QS.Sort(QS.Arr, 0, QS.Arr.length-1);
		System.out.print("final arr: ");
		QS.OutputArray(QS.Arr);
		QS.OutputQuickCounts();

	}

}
