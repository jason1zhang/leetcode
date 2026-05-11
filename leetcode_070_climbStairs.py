"""
LeetCode 70. Climbing Stairs
Python 解法 + 测试用例
"""

class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 2:
            return n 
        
        prev2, prev1 = 1, 2
        for _ in range(3, n + 1):
            curr = prev1 + prev2
            prev2, prev1 = prev1, curr

        return prev1
    
if __name__ == "__main__":
    solution = Solution()
    
    test_cases = [
        (2, 2),
        (3, 3),
        (4, 5),   # 1,1,1,1; 1,1,2; 1,2,1; 2,1,1; 2,2
        (5, 8),
        (1, 1),
        (10, 89),
        (45, 1836311903)  # 题目上限
    ]
    
    print("=" * 60)
    print("LeetCode 70. Climbing Stairs - 测试运行")
    print("=" * 60)
    
    for idx, (n, expected) in enumerate(test_cases, 1):
        result = solution.climbStairs(n)
        passed = result == expected
        status = "✅ PASS" if passed else "❌ FAIL"
        
        print(f"\n测试用例 {idx}:")
        print(f"  n = {n}")
        print(f"  期望: {expected}")
        print(f"  实际: {result}")
        print(f"  {status}")
    
    print("\n" + "=" * 60)
    print("所有测试运行完毕。")