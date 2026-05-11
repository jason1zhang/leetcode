class Solution:
    def canPermutePalindrome(self, s: str) -> bool:
        """
        判断字符串 s 是否可以通过重新排列形成一个回文串。
        回文排列的充要条件：出现奇数次的字符最多只有一个。
        使用一个集合来跟踪当前出现奇数次的字符。
        """
        odd_chars = set()

        for ch in s:
            if ch in odd_chars:
                odd_chars.remove(ch)
            else:
                odd_chars.add(ch)

        return len(odd_chars) <= 1
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()
    
    test_cases = [
        ("tactcoa", True),          # 示例：可排列为 "tacocat"
        ("a", True),                # 单字符，本身就是回文
        ("aa", True),               # 偶数个相同字符
        ("ab", False),              # 两个不同字符，奇数次各一个（两个奇数）
        ("aba", True),              # 本身回文，奇数个a
        ("carerac", True),          # 可以排成 "racecar"
        ("aabbcc", True),           # 全部偶数
        ("aabbc", True),            # 一个奇数
        ("aabbcd", False),          # 两个奇数 (c,d)
        ("", True),                 # 空字符串视为回文排列
        ("Aa", False),              # 题设为区分大小写？通常题目指定字符范围，这里假定大小写敏感
    ]
    
    print("=" * 60)
    print("面试题 01.04. Palindrome Permutation - 测试运行")
    print("=" * 60)
    
    for idx, (s, expected) in enumerate(test_cases, 1):
        result = solution.canPermutePalindrome(s)
        passed = result == expected
        status = "✅ PASS" if passed else "❌ FAIL"
        print(f"\n测试用例 {idx}:")
        print(f"  输入: \"{s}\"")
        print(f"  期望: {expected}")
        print(f"  实际: {result}")
        print(f"  {status}")
    
    print("\n" + "=" * 60)
    print("所有测试运行完毕。")