"""
LeetCode 55. Jump Game
Python 解法 + 测试用例
"""

from typing import List

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        max_reach = 0
        n = len(nums)

        for i in range(n):
            if i > max_reach:
                return False
            
            max_reach = max(max_reach, i + nums[i])
            if max_reach >= n - 1:
                return True
            
        return True 
    
if __name__ == "__main__":
    solution = Solution()
    
    test_cases = [
        ([2, 3, 1, 1, 4], True),      # 示例1变体
        ([3, 2, 1, 0, 4], False),     # 示例2
        ([0], True),                   # 单元素已在终点
        ([2, 0, 0], True),            # 跳1步到索引1，再跳0步，但已在终点
        ([1, 1, 1, 0], True),         # 每次跳1步可到达终点
        ([1, 0, 1, 0], False),        # 索引1无法越过0
        ([5, 4, 3, 2, 1, 0, 0], False),
        ([3, 0, 8, 2, 0, 0, 1], True),
    ]
    
    print("=" * 60)
    print("LeetCode 55. Jump Game - 测试运行")
    print("=" * 60)
    
    for idx, (nums, expected) in enumerate(test_cases, 1):
        result = solution.canJump(nums)
        passed = result == expected
        status = "✅ PASS" if passed else "❌ FAIL"
        
        print(f"\n测试用例 {idx}:")
        print(f"  nums = {nums}")
        print(f"  期望: {expected}")
        print(f"  实际: {result}")
        print(f"  {status}")
    
    print("\n" + "=" * 60)
    print("所有测试运行完毕。")