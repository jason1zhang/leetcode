"""
LeetCode 219. Contains Duplicate II
Python 解法 + 测试用例
"""

from typing import List

class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        index_map = {}
        for i, num in enumerate(nums):
            if (num in index_map) and (i - index_map[num] <= k):
                return True
            
            index_map[num] = i 

        return False
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()

    test_cases = [
        ([1, 2, 3, 1], 3, True),           # 示例1
        ([1, 0, 1, 1], 1, True),           # 示例2
        ([1, 2, 3, 1, 2, 3], 2, False),    # 示例3
        ([99, 99], 2, True),               # k 大于索引差
        ([1, 2, 3, 4, 5], 1, False),       # 无重复
        ([1], 1, False),                   # 单元素
        ([1, 2, 1], 0, False),             # k=0，必须 i!=j，所以不可能
        ([1, 2, 1], 2, True),              # 索引差正好为2
        ([-1, -1], 1, True),               # 负数
    ]

    print("=" * 60)
    print("LeetCode 219. Contains Duplicate II - 测试运行")
    print("=" * 60)

    for idx, (nums, k, expected) in enumerate(test_cases, 1):
        result = solution.containsNearbyDuplicate(nums, k)
        passed = result == expected
        status = "✅ PASS" if passed else "❌ FAIL"

        # 显示时截断过长数组
        display_nums = str(nums) if len(nums) <= 10 else str(nums[:7])[:-1] + ", ...]"

        print(f"\n测试用例 {idx}:")
        print(f"  nums = {display_nums}, k = {k}")
        print(f"  期望: {expected}")
        print(f"  实际: {result}")
        print(f"  {status}")

    print("\n" + "=" * 60)
    print("所有测试运行完毕。")