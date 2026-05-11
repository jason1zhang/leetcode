class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        """
        使用字典判断两个字符串是否为字母异位词。
        适用于任意字符集，不仅限于小写英文字母。
        """
        if len(s) != len(t):
            return False
        
        char_count = {}

        for ch in s:
            char_count[ch] = char_count.get(ch, 0) + 1

        for ch in t:
            if ch not in char_count or char_count[ch] == 0:
                return False
            
            char_count[ch] -= 1

        return True
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()
    
    # 定义测试用例：(s, t, 期望输出)
    test_cases = [
        ("anagram", "nagaram", True),   # 异位词
        ("rat", "car", False),          # 不同字母
        ("a", "ab", False),             # 长度不等
        ("aacc", "ccac", False),        # 相同字母，数量不同
        ("", "", True),                 # 空字符串
        ("listen", "silent", True),     # 经典异位词
        ("triangle", "integral", True), # 较长异位词
        ("hello", "world", False),      # 普通不匹配
        ("张三", "三张", True),          # 中文异位词（验证通用性）
        ("abc", "abcd", False),         # 长度差一
    ]
    
    print("=" * 60)
    print("LeetCode 242. Valid Anagram (字典解法) - 测试运行")
    print("=" * 60)
    
    for idx, (s, t, expected) in enumerate(test_cases, 1):
        result = solution.isAnagram(s, t)
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