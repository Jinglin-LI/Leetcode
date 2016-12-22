/*
Serialization is the process of converting a data structure 
or object into a sequence of bits 
so that it can be stored in a file or memory buffer, 
or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. 
There is no restriction on how your serialization/deserialization algorithm should work.
You just need to ensure that 
a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
    
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. 
You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
*/

// BFS, Order Level

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) {
                sb.append("#,");
            }
            else {
                sb.append(temp.val + ",");
                q.add(temp.left);
                q.add(temp.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.charAt(0) == '#')
            return null;
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int i = 1;
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) {
                continue;
            }
            if (!arr[i].equals("#")) {
                temp.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(temp.left);
            }
            else {
                temp.left = null;
                q.add(null);
            }
            i++;
            
            if (!arr[i].equals("#")) {
                temp.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(temp.right);
            }
            else {
                temp.right = null;
                q.add(null);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
