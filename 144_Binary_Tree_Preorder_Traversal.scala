/*

problem link : https://leetcode.com/problems/binary-tree-preorder-traversal/

 */

// Definition for a binary tree node.
class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}


object Solution {

  // recursive solution (java, python style ...)
  def preorderTraversal(root: TreeNode): List[Int] = {
    val res = new collection.mutable.ListBuffer[Int]()

    def go(t: TreeNode): Unit = {
      if (t == null) return
      res += t.value
      go(t.left)
      go(t.right)
    }

    go(root)

    res.toList
  }
}

object Solution2 {

  // iterative solution(use stack)
  def preorderTraversal(root: TreeNode): List[Int] = {

    if (root == null) {
      return Nil
    }

    var stack: List[TreeNode] = List()
    var result: List[Int] = List()
    stack = root :: stack
    while (stack.nonEmpty) {
      val node = stack.head
      result = node.value :: result
      stack = stack.tail // pop
      if (node.right != null) {
        stack = node.right :: stack
      }
      if (node.left != null) {
        stack = node.left :: stack
      }
    }

    result.reverse

  }

}

object Solution3 {

  // recursive solution (more functional)
  def preorderTraversal(root: TreeNode): List[Int] = root match {
    case null => Nil
    case _ => List(root.value) ::: preorderTraversal(root.left) ::: preorderTraversal(root.right)
  }


}