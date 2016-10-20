/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,
Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/
/*
解题，思路可见http://blog.sina.com.cn/s/blog_eb52001d0102v2ds.html。
此题是undirected graph（两个只差一个字符的单词连在一起,如下）. 找最短的两个节点的距离。
                    hit - hot
                         /   \
                       dot - lot
                        |     |
                       dog - log
                         \   /
                          cog
hit建立的word[]为ait,bit,cit..., hat,hbt, hct..., hia,hib,hic...
检测word[j]是否有endWord,是则返回res + 1; 检测其是否存在于wordList,是则将其存在q中。
curCount和nextCount记录q中当前和下一个单词的candidate的数量，为了计数res（即q空了则从一个单词到下一个单词）。
BFS比DFS效率高，比如111 - 311. 如果DFS, 111 - 112 - 112的所有变形; BFS则111 - 112 - 113 - 121 - 131 - 211 - 311.
*/

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		if (beginWord == null || endWord == null || beginWord.length() == 0 || endWord.length() == 0)
			return 0;
		Queue<String> q = new LinkedList<>();
		q.add(beginWord);
		int res = 1;
		int currCount = 1;
		int nextCount = 0;
		while (!q.isEmpty()) {
			String curr = q.poll();
			currCount--;
			for (int i = 0; i < curr.length(); i++) {
				char[] currchar = curr.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					currchar[i] = c;
					String candidate = new String(currchar);
	//				System.out.println(candidate);
					if (candidate.equals(endWord))		// 注意一定要是equals.
						return res + 1;
					if (wordList.contains(candidate)) {
						q.add(candidate);
						wordList.remove(candidate);
						nextCount++;
					}
				}
			}
			if (currCount == 0) {
				res++;
				currCount = nextCount;
				nextCount = 0;
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		WordLadder test = new WordLadder();
		Set<String> wordList = new TreeSet<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");		
		wordList.add("log");
		System.out.println(test.ladderLength("hit", "cog", wordList));
		System.out.println("");
	}
}
