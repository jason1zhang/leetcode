"""
LeetCode 80. Remove Duplicates from Sorted Array II
Python 解法 + 测试用例
"""

from typing import List

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        """
        原地删除有序数组中超过两次的重复项，返回新长度 k。
        
        参数:
            nums: 非递减排序的整数数组
        
        返回:
            k: 删除重复项后数组的有效长度（前 k 个元素为结果）
        """
        slow = 0
        for fast in range(len(nums)):
            if slow < 2 or nums[fast] != nums[slow - 2]:
                nums[slow] = nums[fast]
                slow += 1

        return slow 
    
# =============================================
# 测试代码（模拟判题逻辑）
# =============================================
if __name__ == "__main__":
    solution = Solution()

    test_cases = [
        ([1, 1, 1, 2, 2, 3], 5, [1, 1, 2, 2, 3]),
        ([0, 0, 1, 1, 1, 1, 2, 3, 3], 7, [0, 0, 1, 1, 2, 3, 3]),
        ([1, 2, 2, 2], 3, [1, 2, 2]),
        ([1, 1, 1, 1], 2, [1, 1]),
        ([1, 2, 3], 3, [1, 2, 3]),
        ([], 0, []),
    ]

    print("=" * 60)
    print("LeetCode 80. Remove Duplicates from Sorted Array II - 测试运行")
    print("=" * 60)

    for idx, (nums, expected_k, expected_nums) in enumerate(test_cases, 1):
        nums_copy = nums[:]  # 保留原始输入用于打印
        k = solution.removeDuplicates(nums)
        passed = (k == expected_k) and (nums[:k] == expected_nums)
        status = "✅ PASS" if passed else "❌ FAIL"
        
        print(f"\n测试用例 {idx}:")
        print(f"  原始数组: {nums_copy}")
        print(f"  返回 k = {k}, 修改后数组前 k 项 = {nums[:k]}")
        print(f"  期望 k = {expected_k}, 期望数组 = {expected_nums}")
        print(f"  {status}")

    print("\n" + "=" * 60)
    print("所有测试运行完毕。")