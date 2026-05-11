class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        """
        找出字符串 s 中不含有重复字符的最长子串的长度
        """
        char_set = set()
        left = 0
        max_len = 0

        for right in range(len(s)):
            while s[right] in char_set:
                char_set.remove(s[left])
                left += 1

            char_set.add(s[right])
            max_len = max(max_len, right - left + 1)
        
        return max_len
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()

    # 定义测试用例：(输入字符串, 期望输出)
    test_cases = [
        ("abcabcbb", 3),
        ("bbbbb", 1),
        ("pwwkew", 3),
        ("", 0),
        (" ", 1),
        ("au", 2),
        ("dvdf", 3),
        ("anviaj", 5),
        ("abcdefg", 7),
        ("abba", 2),
    ]

    print("=" * 60)
    print("LeetCode 3. Longest Substring Without Repeating Characters - 测试运行")
    print("=" * 60)

    for idx, (s, expected) in enumerate(test_cases, 1):
        result = solution.lengthOfLongestSubstring(s)
        passed = result == expected
        status = "✅ PASS" if passed else "❌ FAIL"

        # 对长字符串做截断显示
        display_s = s if len(s) <= 30 else s[:27] + "..."

        print(f"\n测试用例 {idx}:")
        print(f"  输入字符串: \"{display_s}\"")
        print(f"  期望结果: {expected}")
        print(f"  实际结果: {result}")
        print(f"  {status}")

    print("\n" + "=" * 60)
    print("所有测试运行完毕。")
