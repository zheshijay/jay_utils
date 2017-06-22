package algo.string_and_array;

public class RemoveNth {
	
	public int[] removeEveryNth(int[] array, int n) {
		
		System.out.println("new length: " + (array.length - array.length / n));
		
	    int[] newArray = new int[array.length - array.length / n];
	    int j = 0;
	    for (int i = 0; i < array.length; i++) {
	        if ((i + 1) % n != 0) {
	            newArray[j++] = array[i];
	        }
	    }
	    return newArray;
	}

	public static void main(String args[]){
		RemoveNth test = new RemoveNth();

		int[] nums = new int[]{1,2,3,4,5,6};
		int[] result = test.removeEveryNth(nums, 2);

		for(int eachNum: result){
			System.out.print(eachNum);
		}


	}
}
