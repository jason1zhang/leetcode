from typing import List


class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        freq = {}
        for num in nums:
            freq[num] = freq.get(num, 0) + 1

        return [num for num, cnt in freq.items() if cnt == 1]
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()
    
    test_cases = [
        ([1, 2, 1, 3, 2, 5], [3, 5]),    # 示例1（顺序可换）
        ([-1, 0], [-1, 0]),               # 示例2
        ([0, 1], [0, 1]),                 # 示例3
        ([2, 2, 4, 4, 5, 6], [5, 6]),     # 常规
        ([-10, 0, -10, 7], [0, 7]),       # 含负数
        ([100, 200, 200, 300], [100, 300]),
    ]
    
    print("=" * 60)
    print("LeetCode 260. Single Number III - 测试运行")
    print("=" * 60)
    
    for idx, (nums, expected) in enumerate(test_cases, 1):
        result = solution.singleNumber(nums)
        # 因为输出顺序任意，比较时转为集合或排序后比较
        passed = sorted(result) == sorted(expected)
        status = "✅ PASS" if passed else "❌ FAIL"
        print(f"\n测试用例 {idx}:")
        print(f"  nums: {nums}")
        print(f"  期望: {expected}")
        print(f"  实际: {result}")
        print(f"  {status}")
    
    print("\n" + "=" * 60)
    print("所有测试运行完毕。")