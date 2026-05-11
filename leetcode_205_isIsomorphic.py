class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        map_s_to_t = {}
        map_t_to_s = {}

        for char_s, char_t in zip(s, t):
            if char_s in map_s_to_t:
                if map_s_to_t[char_s] != char_t:
                    return False
            else:
                map_s_to_t[char_s] = char_t

            if char_t in map_t_to_s:
                if map_t_to_s[char_t] != char_s:
                    return False
            else:
                map_t_to_s[char_t] = char_s

        return True

# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()

    # 定义测试用例：(s, t, 期望输出)
    test_cases = [
        ("egg", "add", True),           # 示例1
        ("foo", "bar", False),          # 示例2 (题目中示例2写的是"f11"/"b23"，但原题实际是"foo"/"bar")
        ("paper", "title", True),       # 示例3
        ("f11", "b23", False),          # 按照题目描述的自定义测试
        ("abc", "def", True),           # 全新映射
        ("badc", "baba", False),        # 不同字符映射到同一字符
        ("a", "a", True),               # 单字符
        ("ab", "aa", False),            # s中不同字符映射到t中相同字符
        ("aa", "ab", False),            # s中相同字符映射到t中不同字符
    ]

    print("=" * 60)
    print("LeetCode 205. Isomorphic Strings - 测试运行")
    print("=" * 60)

    for idx, (s, t, expected) in enumerate(test_cases, 1):
        result = solution.isIsomorphic(s, t)
        passed = result == expected
        status = "✅ PASS" if passed else "❌ FAIL"

        print(f"\n测试用例 {idx}:")
        print(f"  s = \"{s}\"")
        print(f"  t = \"{t}\"")
        print(f"  期望结果: {expected}")
        print(f"  实际结果: {result}")
        print(f"  {status}")

    print("\n" + "=" * 60)
    print("所有测试运行完毕。")    
            