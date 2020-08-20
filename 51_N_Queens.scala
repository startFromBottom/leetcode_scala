/*

problem link : https://leetcode.com/problems/n-queens/

 */


object Solution {

  def solveNQueens(n: Int): List[List[String]] = {

    def NQueens(k: Int): List[List[(Int, Int)]] = {

      if (k == 0) List(List())
      else {
        for {
          queens <- NQueens(k - 1)
          col <- 1 to n
          queen = (k, col)
          if (isValid(queen, queens))
        } yield queen :: queens
      }
    }

    NQueens(n) map (_.reverse) map (q => convertToString(q, n))
  }

  def isValid(queen: (Int, Int), queens: List[(Int, Int)]): Boolean = {
    queens forall (q => !isChecked(q, queen))
  }

  def isChecked(q1: (Int, Int), q2: (Int, Int)): Boolean = {
    q1._1 == q2._1 ||
      q1._2 == q2._2 ||
      (q1._1 - q2._1).abs == (q1._2 - q2._2).abs
  }

  def convertToString(queen: List[(Int, Int)], n: Int): List[String] = {
    for {
      q <- queen
      val col = q._2 - 1
    } yield "." * col + "Q" + "." * (n - 1 - col)
  }


}