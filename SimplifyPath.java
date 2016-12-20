/*
Given an absolute path for a file (Unix-style), simplify it.
For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
*/
/*

http://www.cnblogs.com/springfor/p/3869666.html

这是一道简化路径的题，路径简化的依据是：

当遇到“/../"则需要返回上级目录，需检查上级目录是否为空。

当遇到"/./"则表示是本级目录，无需做任何特殊操作。 

当遇到"//"则表示是本级目录，无需做任何操作。

当遇到其他字符则表示是文件夹名，无需简化。

当字符串是空或者遇到”/../”，则需要返回一个"/"。

当遇见"/a//b"，则需要简化为"/a/b"。
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
