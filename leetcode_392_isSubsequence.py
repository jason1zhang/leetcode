"""
LeetCode 392. Is Subsequence
Python 解法 + 测试用例
"""

class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        i, j = 0, 0

        while i < len(s) and j < len(t):
            if s[i] == t[j]:
                i += 1

            j += 1

        return i == len(s)
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()

    test_cases = [
        ("abc", "ahbgdc", True),      # 示例1
        ("axc", "ahbgdc", False),     # 示例2
        ("", "ahbgdc", True),         # 空 s 永远是子序列
        ("abc", "", False),           # 非空 s，空 t，不是子序列
        ("", "", True),               # 两者都空
        ("ace", "abcde", True),       # 跳跃匹配
        ("aec", "abcde", False),      # 顺序错误
        ("aaaa", "bbaaaa", True),     # 重复字符
    ]

    print("=" * 60)
    print("LeetCode 392. Is Subsequence - 测试运行")
    print("=" * 60)

    for idx, (s, t, expected) in enumerate(test_cases, 1):
        result = solution.isSubsequence(s, t)
        passed = result == expected
        status = "✅ PASS" if passed else "❌ FAIL"
        
        print(f"\n测试用例 {idx}:")
        print(f"  s = \"{s}\", t = \"{t}\"")
        print(f"  期望: {expected}")
        print(f"  实际: {result}")
        print(f"  {status}")

    print("\n" + "=" * 60)
    print("所有测试运行完毕。")
