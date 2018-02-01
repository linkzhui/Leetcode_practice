package Google.Recursion.leetcode_652_Find_Duplicate_Subtrees;

import java.util.*;

//not finish yet
public class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if(root==null)
        {
            return result;
        }
        HashMap<Integer,List<TreeNode>> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerLast(root);
        while(!stack.isEmpty())
        {
            TreeNode cur = stack.pollLast();
            if(cur==null)
            {
                continue;
            }
            List<TreeNode> list = map.get(cur.val);
            if(list==null)
            {
                list = new ArrayList<>();
                list.add(cur);
                map.put(cur.val,list);
            }
            else{
                if(!set.contains(cur.val))
                {
                    for(TreeNode element:list)
                    {
                        if(isSameSubtress(element,cur))
                        {
                            set.add(cur.val);
                            result.add(cur);
                        }
                    }
                }
                list.add(cur);
            }
            if(cur.right!=null)
            {
                stack.offerLast(cur.right);
            }
            if(cur.left!=null)
            {
                stack.offerLast(cur.left);
            }
        }

        return result;

    }

  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


  private boolean isSameSubtress(TreeNode a, TreeNode b)
  {
      if(a==null||b==null)
      {
          if(a==null&&b==null)
          {
              return true;
          }
          else if(a == null&& b!=null)
          {
              return false;
          }
          else{
              return false;
          }
      }
      if(a.val==b.val)
      {
          return isSameSubtress(a.left,b.left)&&isSameSubtress(a.right,b.right);
      }
      else{
          return false;
      }
  }

}
