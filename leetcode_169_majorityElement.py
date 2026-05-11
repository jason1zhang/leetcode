from typing import List 

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        """
        使用哈希表统计每个数字的出现次数，
        当某个数字出现次数超过 n // 2 时立即返回。
        """
        counts = {}
        majority_threshold = len(nums) // 2

        for num in nums:
            counts[num] = counts.get(num, 0) + 1
            if counts[num] > majority_threshold:
                return num 
            
        return -1
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()

    # 定义测试用例：(输入数组, 期望输出)
    test_cases = [
        ([3, 2, 3], 3),
        ([2, 2, 1, 1, 1, 2, 2], 2),
        ([1], 1),
        ([5, 5, 5, 5], 5),
        ([10, 9, 10, 9, 10], 10),
        ([-1, -1, -1, 2, 2], -1),
        ([1000000000, 1000000000, -1000000000, 1000000000], 1000000000),
    ]

    print("=" * 60)
    print("LeetCode 169. Majority Element - 测试运行")
    print("=" * 60)

    for idx, (nums, expected) in enumerate(test_cases, 1):
        result = solution.majorityElement(nums)
        passed = result == expected
        status = "✅ PASS" if passed else "❌ FAIL"

        # 对过长的数组显示做截断处理，便于阅读
        display_nums = str(nums) if len(nums) <= 10 else str(nums[:7])[:-1] + ", ...]"

        print(f"\n测试用例 {idx}:")
        print(f"  输入数组: {display_nums}")
        print(f"  期望结果: {expected}")
        print(f"  实际结果: {result}")
        print(f"  {status}")

    print("\n" + "=" * 60)
    print("所有测试运行完毕。")

