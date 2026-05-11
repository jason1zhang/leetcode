"""
LeetCode 58. Length of Last Word
双指针解法（原地遍历，O(1) 额外空间）
"""

class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        """
        返回字符串中最后一个单词的长度（双指针法）。

        参数:
            s: 包含单词和空格的字符串

        返回:
            最后一个单词的字符长度
        """
        end = len(s) - 1
        while end >= 0 and s[end] == ' ':
            end -= 1

        start = end
        while start >= 0 and s[start] != ' ':
            start -= 1

        return end - start
    
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()

    test_cases = [
        ("Hello World", 5),
        ("   fly me   to   the moon  ", 4),
        ("luffy is still joyboy", 6),
        ("a", 1),
        ("a ", 1),
        ("    day    ", 3),
        ("word", 4),
        ("trailing spaces     ", 6),
    ]

    print("=" * 60)
    print("LeetCode 58. Length of Last Word - 双指针测试")
    print("=" * 60)

    for idx, (s, expected) in enumerate(test_cases, 1):
        result = solution.lengthOfLastWord(s)
        passed = result == expected
        status = "✅ PASS" if passed else "❌ FAIL"
        
        print(f"\n测试用例 {idx}:")
        print(f"  输入: {repr(s)}")
        print(f"  期望: {expected}")
        print(f"  实际: {result}")
        print(f"  {status}")

    print("\n" + "=" * 60)
    print("所有测试运行完毕。")