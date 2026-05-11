from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        """
        在升序数组 nums 中搜索 target，返回下标；不存在则返回 -1。
        使用二分查找，每次缩小一半搜索范围。
        """
        left, right = 0, len(nums) - 1

        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return mid 
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1

        return -1
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()
    
    test_cases = [
        ([-1, 0, 3, 5, 9, 12], 9, 4),     # 示例1：目标存在
        ([-1, 0, 3, 5, 9, 12], 2, -1),    # 示例2：目标不存在
        ([5], 5, 0),                       # 单元素，存在
        ([5], 1, -1),                      # 单元素，不存在
        ([1, 2, 3, 4, 5], 5, 4),           # 目标在右边界
        ([1, 2, 3, 4, 5], 1, 0),           # 目标在左边界
        ([], 5, -1),                       # 空数组（题目保证 n≥1，但防护一下）
    ]
    
    print("=" * 60)
    print("LeetCode 704. Binary Search - 测试运行")
    print("=" * 60)
    
    for idx, (nums, target, expected) in enumerate(test_cases, 1):
        result = solution.search(nums, target)
        passed = result == expected
        status = "✅ PASS" if passed else "❌ FAIL"
        print(f"\n测试用例 {idx}:")
        print(f"  nums: {nums}")
        print(f"  target: {target}")
        print(f"  期望: {expected}")
        print(f"  实际: {result}")
        print(f"  {status}")
    
    print("\n" + "=" * 60)
    print("所有测试运行完毕。")