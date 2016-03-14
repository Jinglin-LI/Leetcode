/*
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.

Corner Cases:
A line other than the last line might contain only one word. What should you do in this case?
In this case, that line should be left-justified.
*/

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0 || maxWidth < 0)
            return res;
        List<String> line = new ArrayList<>();                                // 缓存每一行的单词，clear，再存。
        String str = "";
        int len = 0, div = 0, mod = 0;
        
        for (int i = 0; i < words.length; i++) {
            if (len + line.size() + words[i].length() <= maxWidth) {          // line.size()是空格，先把可以存在这一行的单词存起来
                line.add(words[i]);
                len = len + words[i].length();                                // 把len变为增加完单词的长度
            }
            else {                                                            // 如果再加一个单词就满了
                if (line.size() == 1) {                                       // 现有的只有一个单词，详见“Corner Case”, 向左对齐
                    str = line.get(0);                                        // 将缓存在line中的元素存在str中最终add进res
                    for (int j = maxWidth - str.length(); j > 0; j--)         // 将单词后面填满空格
                        str = str + " ";
                }
                else if (line.size() > 1) {
                    div = (maxWidth - len) / (line.size() - 1);               // 看剩下的空间给几个单词平均分配
                    mod = (maxWidth - len) % (line.size() - 1);               // mod为剩下的空间分配完多余的空间，左边分配的空格多
                    str = line.get(0);
                    for (int j = 1; j < line.size(); j++) {
                        for (int k = 0; k < div; k++)
                            str = str + " ";
                        if (j <= mod)                                         // 即尽量分配相同的空格，否则左边的部分分配的比右边的多
                            str = str + " ";
                        str = str + line.get(j);
                    }
                }
                res.add(str);
                line.clear();
                line.add(words[i]);
                len = words[i].length();
            }
        }
        str = line.get(0);                                                    // 最后一行
        for (int i = 1; i < line.size(); i++) 
            str = str + " " + line.get(i);
        for (int i = maxWidth - str.length(); i > 0; i--)
            str = str + " ";
        res.add(str);
        return res;
    }
}
