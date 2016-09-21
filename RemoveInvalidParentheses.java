/*
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
Note: The input string may contain letters other than the parentheses ( and ).

Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]
*/
/*
BFS. 利用queue和for循环，利用Queue<String> 存每一个去掉一个符号string(不一定valid). 利用hashset存valid的结果。
将queue.poll出的第一个元素每一次都减去一个括号放入queue的队尾。
用size()来控制相同长度的字符串“一拨儿”被处理。进而第一次得到结果（get == true）之后，字符串长度不再缩短。
用哈希表来存储删除括号的字符串，isValid来判断是否括号是合法的。
例如：()) -> )) -> () break.字符串长的时候想象成树~
*/

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null)
            return res;
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.add(s);
        boolean get = false;
        while (!q.isEmpty()) {
            int size = q.size();                                    // 用以分隔有相同长度的字符串，都被处理。
            for (int i = 0; i < size; i++) {
                String str = q.poll();
                if (isValid(str)) {
                    get = true;
                    res.add(str);
                }
                if (!get) {
                    for (int j = 0; j < str.length(); j++) {
                        if (str.charAt(j) != '(' && str.charAt(j) != ')')
                            continue;
                        String newStr = str.substring(0, j) + str.substring(j + 1);       // 删除str.charAt(j)
                        if (!visited.contains(newStr)) {
                            q.add(newStr);
                            visited.add(newStr);
                        }
                    }
                }
            }
            if (get)
                break;
        }
        return res;
    }
    private boolean isValid(String s) {
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                left++;
            else if (s.charAt(i) == ')') {
                if (left == 0)
                    return false;
                else
                    left--;
            }
        }
        return left == 0;
    }
}
