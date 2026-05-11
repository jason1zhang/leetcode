"""
LeetCode 162. Find Peak Element
二分查找解法 + 测试用例
"""

from typing import List

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1

        while left < right:
            mid = (left + right) // 2
            if nums[mid] > nums[mid + 1]:
                right = mid
            else:
                left = mid + 1

        return left 
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()

    test_cases = [
        ([1, 2, 3, 1], 2),                   # 示例1：峰值3在索引2
        ([1, 2, 1, 3, 5, 6, 4], [1, 5]),    # 示例2：峰值可以是2(索引1)或6(索引5)
        ([1], 0),                            # 单元素
        ([2, 1], 0),                         # 峰值在开头
        ([1, 2], 1),                         # 峰值在结尾
        ([1, 2, 3, 4, 5], 4),               # 完全递增，峰值在末尾
        ([5, 4, 3, 2, 1], 0),               # 完全递减，峰值在开头
        ([3, 2, 1, 4, 5], 4),               # 多个峰值，任意有效即可
    ]

    print("=" * 60)
    print("LeetCode 162. Find Peak Element - 测试运行")
    print("=" * 60)

    for idx, (nums, expected) in enumerate(test_cases, 1):
        result = solution.findPeakElement(nums)
        
        # 检查结果是否是有效峰值
        n = len(nums)
        is_peak = True
        if n == 1:
            is_peak = (result == 0)
        else:
            if result == 0:
                is_peak = nums[0] > nums[1]
            elif result == n - 1:
                is_peak = nums[n-1] > nums[n-2]
            else:
                is_peak = nums[result] > nums[result-1] and nums[result] > nums[result+1]
        
        # 对于预期是列表的情况，检查是否在期望的索引集合中
        if isinstance(expected, list):
            passed = result in expected and is_peak
        else:
            passed = (result == expected) and is_peak
        
        status = "✅ PASS" if passed else "❌ FAIL"
        
        print(f"\n测试用例 {idx}:")
        print(f"  nums = {nums}")
        if isinstance(expected, list):
            print(f"  期望峰值索引: {expected} 中的任意一个")
        else:
            print(f"  期望峰值索引: {expected}")
        print(f"  实际返回索引: {result}, 值 = {nums[result]}")
        print(f"  是否为有效峰值: {is_peak}")
        print(f"  {status}")

    print("\n" + "=" * 60)
    print("所有测试运行完毕。")