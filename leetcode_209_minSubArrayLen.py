from typing import List


class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        """
        找出和 >= target 的最短连续子数组的长度，不存在则返回 0。
        使用滑动窗口：右指针不断扩展，左指针收缩以寻找更短长度。
        """
        n = len(nums)
        left = 0
        curr_sum = 0
        min_len = n + 1

        for right in range(n):
            curr_sum += nums[right]
            while curr_sum >= target:
                curr_len = right - left + 1
                if curr_len < min_len:
                    min_len = curr_len

                curr_sum -= nums[left]
                left += 1

        return 0 if min_len == n + 1 else min_len
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()
    
    test_cases = [
        (7, [2,3,1,2,4,3], 2),          # 示例1
        (4, [1,4,4], 1),                 # 示例2
        (11, [1,1,1,1,1,1,1,1,1], 0),   # 示例3
        (1, [1], 1),                     # 最小满足
        (5, [1,2,3,4,5], 1),             # 单个元素就满足
        (15, [1,2,3,4,5], 5),            # 整个数组
        (100, [1,2,3,4,5], 0),           # 无解
    ]
    
    print("=" * 60)
    print("LeetCode 209. Minimum Size Subarray Sum - 测试运行")
    print("=" * 60)
    
    for idx, (target, nums, expected) in enumerate(test_cases, 1):
        result = solution.minSubArrayLen(target, nums)
        passed = result == expected
        status = "✅ PASS" if passed else "❌ FAIL"
        print(f"\n测试用例 {idx}:")
        print(f"  target: {target}, nums: {nums}")
        print(f"  期望: {expected}")
        print(f"  实际: {result}")
        print(f"  {status}")
    
    print("\n" + "=" * 60)
    print("所有测试运行完毕。")