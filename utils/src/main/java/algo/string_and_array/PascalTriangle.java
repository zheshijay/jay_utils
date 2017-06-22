package algo.string_and_array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
		if (rowIndex < 0)
			return list;

		for (int i = 0; i < rowIndex + 1; i++) {
			list.add(0, 1);
			for (int j = 1; j < list.size() - 1; j++) {

				System.out.println("set " + j + " to " + list.get(j) + " + " + list.get(j + 1));
				list.set(j, list.get(j) + list.get(j + 1));
			}
		}
		return list;
	}

	
	/**
	 * 
	 * 
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

	 * 
	 * @param numRows
	 * @return
	 */
	
	public List<List<Integer>> generate(int numRows)
	{
		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for(int i=0;i<numRows;i++)
		{
			row.add(0, 1);
			for(int j=1;j<row.size()-1;j++)
				row.set(j, row.get(j)+row.get(j+1));
			allrows.add(new ArrayList<Integer>(row));
		}
		return allrows;
		
	}

	public static void main(String args[]){
		
		PascalTriangle test = new PascalTriangle();

		System.out.println(test.generate(5));
	}
}
