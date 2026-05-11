class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        """
        判断字符串 s 是否可以由它的一个子串重复多次构成。
        
        方法一：字符串拼接法（巧妙技巧）
        若 s 由重复子串组成，则 (s + s) 去掉首尾字符后必然包含 s 本身。
        例如 s = "abab" → s+s = "abababab" → 去头尾得 "bababa" → 包含 "abab" ✅
        若 s = "aba"  → s+s = "abaaba"   → 去头尾得 "baab"   → 不包含 "aba" ❌
        """
        # 将两个 s 拼接，并去掉第一个和最后一个字符，然后检查 s 是否在其中
        return s in (s + s)[1:-1]
    
    # =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()

    # 测试用例格式：(输入字符串, 期望输出)
    test_cases = [
        ("abab", True),           # 官方示例1
        ("aba", False),           # 官方示例2
        ("abcabcabcabc", True),   # 官方示例3
        ("a", False),             # 单字符，无法由重复子串构成（长度至少为2）
        ("aaaa", True),           # 由"a"或"aa"重复构成
        ("abac", False),          # 完全随机
        ("abcabcabc", True),      # 奇数长度重复
        ("ababab", True),         # 偶数长度，可视为"ab"或"abab"
        ("abcaabca", True),       # 子串"abca"重复两次
        ("aabaaba", False),       # 无法由重复子串构成（aab重复？aab*aab -> aabaab 不对，aa*3 -> aaaaaa 不对）
    ]

    print("=" * 60)
    print("LeetCode 459. Repeated Substring Pattern - 测试运行")
    print("=" * 60)

    all_passed = True
    for idx, (s, expected) in enumerate(test_cases, 1):
        result = solution.repeatedSubstringPattern(s)
        passed = result == expected
        all_passed = all_passed and passed
        status = "✅ PASS" if passed else "❌ FAIL"

        print(f"\n测试用例 {idx}:")
        print(f"  输入: \"{s}\"")
        print(f"  期望: {expected}")
        print(f"  实际: {result}")
        print(f"  {status}")

    print("\n" + "=" * 60)
    if all_passed:
        print("所有测试用例通过！")
    else:
        print("存在未通过的测试用例，请检查代码。")