/*

problem link : https://leetcode.com/problems/subsets/

 */


object Solution1 {
  def subsets(nums: Array[Int]): List[List[Int]] = {
    if (nums.isEmpty)
      List(List())

    val l = nums.length
    val res = new collection.mutable.ListBuffer[List[Int]]()

    def go(idx: Int, cur: List[Int]): Unit = {
      res += cur.reverse
      for (i <- idx to l - 1) {
        go(i + 1, nums(i) :: cur)
      }
    }

    go(0, List())
    res.toList

  }
}

object Solution2 {
  def subsets(nums: Array[Int]): List[List[Int]] = {
    // with foldLeft
    nums.foldLeft(List[List[Int]](List()))((arr, k) => arr ::: arr.map(k :: _))
  }
}