class Solution:
    def CheckPermutation(self, s1: str, s2: str) -> bool:
        """
        使用哈希表（字典）判断两个字符串是否互为字符重排。
        适用于任意字符集，不限于小写字母。
        """
        if len(s1) != len(s2):
            return False
        
        freq = {}
        for ch in s1:
            freq[ch] = freq.get(ch, 0) + 1

        for ch in s2:
            if ch not in freq or freq[ch] == 0:
                return False
            freq[ch] -= 1

        return True 
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()

    # 测试用例格式：(s1, s2, 期望输出)
    test_cases = [
        ("abc", "bca", True),      # 示例1：正常重排
        ("abc", "bad", False),     # 示例2：字符不同
        ("", "", True),            # 空字符串
        ("a", "a", True),          # 单字符相同
        ("ab", "a", False),        # 长度不同
        ("aaa", "aaa", True),      # 重复字符
        ("abcd", "abce", False),   # 仅差一个字符
        ("listen", "silent", True),# 经典变位词
        ("hello", "world", False), # 完全不同
        ("Hello", "hello", False), # 大小写不同（题设为小写，这里测试区分大小写）
    ]

    print("=" * 60)
    print("面试题 01.02. Check Permutation - 测试运行 (哈希表法)")
    print("=" * 60)

    for idx, (s1, s2, expected) in enumerate(test_cases, 1):
        result = solution.CheckPermutation(s1, s2)
        passed = result == expected
        status = "✅ PASS" if passed else "❌ FAIL"

        print(f"\n测试用例 {idx}:")
        print(f"  s1 = \"{s1}\"")
        print(f"  s2 = \"{s2}\"")
        print(f"  期望: {expected}")
        print(f"  实际: {result}")
        print(f"  {status}")

    print("\n" + "=" * 60)
    print("所有测试运行完毕。")