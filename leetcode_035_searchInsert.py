from typing import List


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        """
        在排序数组中搜索目标值，返回索引；若不存在则返回应插入的位置。
        使用二分查找，时间复杂度 O(log n)。
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

        return left 
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()
    
    test_cases = [
        ([1, 3, 5, 6], 5, 2),   # 示例 1：目标存在
        ([1, 3, 5, 6], 2, 1),   # 示例 2：目标不存在，插入位置 1
        ([1, 3, 5, 6], 7, 4),   # 示例 3：目标不存在，插入末尾
        ([1], 0, 0),            # 目标比所有元素小
        ([1], 2, 1),            # 目标比所有元素大
        ([1, 3], 2, 1),         # 插入中间
        ([], 5, 0),             # 空数组（题目保证长度≥1，但这里做保护）
    ]
    
    print("=" * 60)
    print("LeetCode 35. Search Insert Position - 测试运行")
    print("=" * 60)
    
    for idx, (nums, target, expected) in enumerate(test_cases, 1):
        result = solution.searchInsert(nums, target)
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