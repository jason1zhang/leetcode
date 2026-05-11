from typing import List


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        原地将所有零移动到数组末尾，保持非零元素的相对顺序。
        使用双指针：slow 指向下一个非零元素应该放置的位置。
        """
        slow = 0

        for fast in range(len(nums)):
            if nums[fast] != 0:
                nums[slow], nums[fast] = nums[fast], nums[slow]
                slow += 1

# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()
    
    test_cases = [
        ([0, 1, 0, 3, 12], [1, 3, 12, 0, 0]),
        ([0], [0]),
        ([1, 2, 3, 4, 5], [1, 2, 3, 4, 5]),
        ([0, 0, 1], [1, 0, 0]),
        ([1, 0, 0, 2, 0, 3], [1, 2, 3, 0, 0, 0]),
    ]
    
    print("=" * 60)
    print("LeetCode 283. Move Zeroes - 测试运行")
    print("=" * 60)
    
    for idx, (nums, expected) in enumerate(test_cases, 1):
        # 创建副本用于显示原始输入
        original = nums[:]
        solution.moveZeroes(nums)  # 原地修改
        passed = nums == expected
        status = "✅ PASS" if passed else "❌ FAIL"
        print(f"\n测试用例 {idx}:")
        print(f"  输入: {original}")
        print(f"  期望: {expected}")
        print(f"  实际: {nums}")
        print(f"  {status}")
    
    print("\n" + "=" * 60)
    print("所有测试运行完毕。")