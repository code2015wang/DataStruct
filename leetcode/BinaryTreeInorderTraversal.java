/* 给定一个二叉树，返回其中序遍历结果,如[1.null,2,3],返回
[1,3,2]
 */
/*
  public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) {val = x;}

}
*/
import java.util.List;
import java.util.ArrayList;
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
