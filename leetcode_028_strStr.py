from typing import List

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        """
        暴力匹配法：
        遍历 haystack 中每一个可能的起始位置，
        检查从该位置开始长度为 len(needle) 的子串是否与 needle 相等。
        """
        m, n = len(haystack), len(needle)

        if n == 0:
            return 0
        
        for i in range(m - n + 1):
            if haystack[i: i+n] == needle:
                return i 
            
        return -1
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()

    # 定义测试用例：(haystack, needle, 期望输出)
    test_cases = [
        ("sadbutsad", "sad", 0),        # 官方示例1
        ("leetcode", "leeto", -1),      # 官方示例2
        ("hello", "ll", 2),             # 中间匹配
        ("aaaaa", "bba", -1),           # 无匹配
        ("", "", 0),                    # 两空字符串
        ("a", "", 0),                   # needle 为空
        ("", "a", -1),                  # haystack 为空
        ("mississippi", "issip", 4),    # 重叠匹配
        ("abc", "c", 2),                # 末尾匹配
        ("abc", "abc", 0),              # 完全匹配
    ]

    print("=" * 60)
    print("LeetCode 28. Find the Index of the First Occurrence in a String")
    print("=" * 60)

    for idx, (haystack, needle, expected) in enumerate(test_cases, 1):
        result = solution.strStr(haystack, needle)
        passed = result == expected
        status = "✅ PASS" if passed else "❌ FAIL"

        # 显示时用 repr 防止空格混淆
        print(f"\n测试用例 {idx}:")
        print(f"  haystack: '{haystack}'")
        print(f"  needle  : '{needle}'")
        print(f"  期望结果: {expected}")
        print(f"  实际结果: {result}")
        print(f"  {status}")

    print("\n" + "=" * 60)
    print("所有测试运行完毕。")