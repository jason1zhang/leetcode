class Solution:
    def validPalindrome(self, s: str) -> bool:
        """
        判断字符串 s 在最多删除一个字符后能否成为回文串。
        使用双指针从两端向中间扫描，遇到不匹配时，
        尝试跳过左边或右边的字符，检查剩余子串是否为回文。
        """
        def is_palindrome(left: int, right: int) -> bool:
            while left < right:
                if s[left] != s[right]:
                    return False
                
                left += 1
                right -= 1

            return True
        
        left, right = 0, len(s) - 1
        while left < right:
            if s[left] == s[right]:
                left += 1
                right -= 1
            else:
                return is_palindrome(left+1, right) or is_palindrome(left, right-1)
            
        return True
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()

    # 测试用例格式：(输入字符串, 期望输出)
    test_cases = [
        ("aba", True),           # 示例1：本身是回文
        ("abca", True),          # 示例2：删除'c' -> "aba"
        ("abc", False),          # 示例3：删除任何一个都不行
        ("a", True),             # 单字符
        ("ab", True),            # 删除一个即空串或单字符
        ("deeee", True),         # 删一个'd' -> "eeee"
        ("eeeed", True),         # 删一个'd' -> "eeee"
        ("racecar", True),       # 本身回文
        ("racecarx", True),      # 删末尾'x'
        ("xracecar", True),      # 删开头'x'
        ("abcba", True),         # 本身回文
        ("abccbax", True),       # 删末尾'x'
        ("abcde", False),        # 怎么删都不是
        ("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga", True),
        # 长字符串回文测试（LeetCode 经典用例）
    ]

    print("=" * 60)
    print("LeetCode 680. Valid Palindrome II - 测试运行")
    print("=" * 60)

    for idx, (s, expected) in enumerate(test_cases, 1):
        result = solution.validPalindrome(s)
        passed = result == expected
        status = "✅ PASS" if passed else "❌ FAIL"

        # 长字符串显示截断
        display_s = s if len(s) <= 30 else s[:27] + "..."

        print(f"\n测试用例 {idx}:")
        print(f"  输入: \"{display_s}\"")
        print(f"  期望: {expected}")
        print(f"  实际: {result}")
        print(f"  {status}")

    print("\n" + "=" * 60)
    print("所有测试运行完毕。")
            