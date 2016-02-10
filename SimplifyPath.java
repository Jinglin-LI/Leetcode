/*
Given an absolute path for a file (Unix-style), simplify it.
For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
*/

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] split = path.split("/");
        for (String s : split) {
            if (!s.equals(".") && !s.isEmpty()) {                  // continuous "/" like "//" will make split element to be "".
                if (s.equals("..")) {
                    if (!stack.isEmpty())
                        stack.pop();
                }
                else
                    stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());                      // StringBuilder insert(0, *), previous elements will be postponed.
        }
        return sb.length() == 0? "/" : sb.toString();
    }
}
