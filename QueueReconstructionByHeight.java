/*
Suppose you have a random list of people standing in a queue. 
Each person is described by a pair of integers (h, k), 
where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. 
Write an algorithm to reconstruct the queue.
Note:
The number of people is less than 1,100.
Example
Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
*/
// 排序数组，高度降序，第二个数升序。然后遍历数组，根据 people[i][1] (第二个数) 将此数插入到list中的此位置中。然后利用list特性不断插入。

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
		if (people == null || people.length == 0 || people[0].length == 0)
			return people;
	
		Arrays.sort(people, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0])
					return o2[0] - o1[0];
				else
					return o1[1] - o2[1];
			}
		});
    
		List<int[]> list = new ArrayList<>();     
		for (int i = 0; i < people.length; i++)
			list.add(people[i][1], people[i]);                  // 利用list特性，不断插入新的数在people[i][1]的位置。
			
	    int[][] res = new int[people.length][people[0].length];
		for (int i = 0; i < res.length; i++) {
			res[i][0] = list.get(i)[0];                 // 注意此用法。
			res[i][1] = list.get(i)[1];
		}   
		return res;
	}
}
