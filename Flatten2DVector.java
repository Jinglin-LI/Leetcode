/*
Implement an iterator to flatten a 2d vector.
For example, Given 2d vector =
[
  [1,2],
  [3],
  [4,5,6]
] 
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
*/

public class Vector2D {
	List<Iterator<Integer>> list;
	int curr = 0;
	
	public Vector2D(List<List<Integer>> vec2d) {
		list = new ArrayList<>();
		for (List<Integer> l : vec2d) {
			if (l.size() > 0)
				list.add(l.iterator());
		}
	}
	
	public int next() {
		int res = list.get(curr).next();
		if (!list.get(curr).hasNext()) {
			curr++;                                                   // 当前迭代器用完，curr++, 即转到下一个迭代器。
		}
		return res;
	}
	
	public boolean hasNext() {
		return curr < list.size() && list.get(curr).hasNext();
	}
}
