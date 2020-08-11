/*

problem link : https://leetcode.com/problems/generate-parentheses/

 */


object Solution {
  def generateParenthesis(n: Int): List[String] = {

    val parentheses = new collection.mutable.ListBuffer[String]()

    def go(leftCnt: Int, rightCnt: Int, cur: String): Unit = {
      if (leftCnt == n && rightCnt == n) parentheses += cur
      else if (leftCnt < rightCnt || leftCnt > n) return
      else {
        go(leftCnt + 1, rightCnt, cur + "(")
        go(leftCnt, rightCnt + 1, cur + ")")
      }
    }

    go(0, 0, "")
    parentheses.toList

  }
}

