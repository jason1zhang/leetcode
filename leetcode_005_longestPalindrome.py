class Solution:
    def longestPalindrome(self, s: str) -> str:
        """
        中心扩展法：枚举每个可能的回文中心（共 2n-1 个），向两边扩展。
        """
        if not s:
            return ""
        
        start, end = 0, 0

        def expand(left: int, right: int) -> tuple:
            """从 (left, right) 向两边扩展，返回回文子串的 (start, end) 索引"""
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1

            return left + 1, right - 1
        
        for i in range(len(s)):
            l1, r1 = expand(i, i)
            l2, r2 = expand(i, i + 1)

            if r1 - l1 > end - start:
                start, end = l1, r1 

            if r2 - l2 > end - start:
                start, end = l2, r2 

        return s[start: end + 1]
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()
    
    test_cases = [
        ("babad", ["bab", "aba"]),  # 两种可能答案
        ("cbbd", ["bb"]),
        ("a", ["a"]),
        ("ac", ["a", "c"]),        # 单字符均可
        ("racecar", ["racecar"]),
        ("", [""]),
        ("aaaa", ["aaaa"]),
    ]
    
    print("=" * 60)
    print("LeetCode 5. Longest Palindromic Substring - 测试运行")
    print("=" * 60)
    
    for idx, (s, expected_list) in enumerate(test_cases, 1):
        result = solution.longestPalindrome(s)
        # 验证结果是否为回文且长度与预期一致
        is_palindrome = result == result[::-1]
        # 预期之一匹配即可（因为可能有多个答案）
        valid = is_palindrome and (result in expected_list)
        status = "✅ PASS" if valid else "❌ FAIL"
        
        print(f"\n测试用例 {idx}:")
        print(f"  输入: \"{s}\"")
        print(f"  期望: {expected_list}")
        print(f"  实际: \"{result}\"")
        print(f"  回文验证: {is_palindrome}")
        print(f"  {status}")
    
    print("\n" + "=" * 60)
    print("所有测试运行完毕。")