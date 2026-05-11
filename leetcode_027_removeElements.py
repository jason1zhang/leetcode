"""
LeetCode 27. Remove Element
Python 解法 + 测试用例
"""

from typing import List

class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        """
        原地移除数组中所有等于 val 的元素，返回剩余元素的个数 k。
        修改后的数组前 k 个元素均为不等于 val 的值（顺序任意）。
        
        参数:
            nums: 整数数组
            val: 需要移除的目标值
        
        返回:
            k: 数组中不等于 val 的元素数量
        """
        slow = 0
        for fast in range(len(nums)):
            if nums[fast] != val:
                nums[slow] = nums[fast]
                slow += 1

        return slow 
    
# =============================================
# 测试代码（模拟判题逻辑）
# =============================================
if __name__ == "__main__":
    solution = Solution()

    test_cases = [
        ([3, 2, 2, 3], 3, 2),
        ([0, 1, 2, 2, 3, 0, 4, 2], 2, 5),
        ([1], 1, 0),
        ([4, 5], 6, 2),
        ([], 0, 0),
        ([2, 2, 2], 2, 0),
        ([1, 2, 3, 4], 5, 4),
    ]

    print("=" * 60)
    print("LeetCode 27. Remove Element - 测试运行")
    print("=" * 60)

    for idx, (nums, val, expected_k) in enumerate(test_cases, 1):
        nums_copy = nums[:]  # 保留原始输入用于打印
        k = solution.removeElement(nums, val)
        passed = (k == expected_k)
        
        # 可选：检查前 k 个元素是否包含 val
        if passed:
            for i in range(k):
                if nums[i] == val:
                    passed = False
                    break
        
        status = "✅ PASS" if passed else "❌ FAIL"
        
        print(f"\n测试用例 {idx}:")
        print(f"  原始数组: {nums_copy}")
        print(f"  val = {val}")
        print(f"  返回 k = {k}, 修改后数组前 k 项 = {nums[:k]}")
        print(f"  期望 k = {expected_k}")
        print(f"  {status}")

    print("\n" + "=" * 60)
    print("所有测试运行完毕。")