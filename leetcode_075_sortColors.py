from typing import List

class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        原地排序，不使用内置 sort，常数空间，一趟扫描。
        使用三个指针：p0（0的右边界）、p2（2的左边界）、curr（当前考察位置）。
        """
        p0, curr, p2 = 0, 0, len(nums) - 1

        while curr <= p2:
            if nums[curr] == 0:
                nums[p0], nums[curr] = nums[curr], nums[p0]
                p0 += 1
                curr += 1
            elif nums[curr] == 2:
                nums[curr], nums[p2] = nums[p2], nums[curr]
                p2 -= 1
            else:
                curr += 1

# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()
    
    test_cases = [
        ([2,0,2,1,1,0], [0,0,1,1,2,2]),
        ([2,0,1], [0,1,2]),
        ([0], [0]),
        ([1], [1]),
        ([2], [2]),
        ([1,0], [0,1]),
        ([2,1], [1,2]),
        ([0,2,1], [0,1,2]),
        ([2,2,1,1,0,0], [0,0,1,1,2,2]),
    ]
    
    print("=" * 60)
    print("LeetCode 75. Sort Colors - 测试运行")
    print("=" * 60)
    
    for idx, (nums, expected) in enumerate(test_cases, 1):
        original = nums[:]  # 保留原始输入用于显示
        solution.sortColors(nums)
        passed = nums == expected
        status = "✅ PASS" if passed else "❌ FAIL"
        print(f"\n测试用例 {idx}:")
        print(f"  输入: {original}")
        print(f"  期望: {expected}")
        print(f"  实际: {nums}")
        print(f"  {status}")
    
    print("\n" + "=" * 60)
    print("所有测试运行完毕。")