/*

problem link : https://leetcode.com/problems/binary-tree-postorder-traversal/

*/

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}


object Solution {

  // recursive solution
  def postorderTraversal(root: TreeNode): List[Int] = root match {
    case null => Nil
    case _ => postorderTraversal(root.left) ::: postorderTraversal(root.right) ::: List(root.value)
  }
}

object Solution2 {

  // iterative solution
  def postorderTraversal(root: TreeNode): List[Int] = {
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
      if (node.left != null) {
        stack = node.left :: stack
      }
      if (node.right != null) {
        stack = node.right :: stack
      }
    }
    result
  }

}

