/*

problem link : https://leetcode.com/problems/binary-tree-inorder-traversal/

 */


// Definition for a binary tree node.
class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  // recursive solution
  def inorderTraversal(root: TreeNode): List[Int] = {

    val res = new collection.mutable.ListBuffer[Int]()

    def go(root: TreeNode): Unit = {
      if (root != null) {
        go(root.left)
        res += root.value
        go(root.right)
      }
    }

    go(root)
    res.toList

  }
}

object Solution2 {

  def inorderTraversal(root: TreeNode): List[Int] = {
    // iteration solution
    var cur = root
    var stack: List[TreeNode] = List()
    var result: List[Int] = List()

    while (cur != null || stack.nonEmpty) {
      while (cur != null) {
        stack = cur :: stack
        cur = cur.left
      }
      cur = stack.head
      result = cur.value :: result
      stack = stack.tail
      cur = cur.right
    }

    result
  }

}

object Solution3 {
  // recursive solution (more functional)
  def inorderTraversal(root: TreeNode): List[Int] = root match {
    case null => List()
    case _ => inorderTraversal(root.left) ::: List(root.value) ::: inorderTraversal(root.right)
  }

}