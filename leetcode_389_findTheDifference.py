class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        """
        使用哈希表统计 s 中每个字符的频率，
        遍历 t 时扣减计数，找到计数为负或缺失的字符即为额外添加的。
        时间复杂度 O(n)，空间复杂度 O(k)，k 为不同字符数（最多26）。
        """
        freq = {}
        for ch in s:
            freq[ch] = freq.get(ch, 0) + 1

        for ch in t:
            if (ch not in freq) or (freq[ch] == 0):
                return ch 
            
            freq[ch] -= 1

        return ""
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()
    
    test_cases = [
        ("abcd", "abcde", "e"),    # 示例1
        ("", "y", "y"),            # 空s
        ("a", "aa", "a"),          # 重复字符
        ("abc", "bcad", "d"),      # 中间添加
        ("ae", "aea", "a"),        # 添加已存在的字符
    ]
    
    print("=" * 60)
    print("LeetCode 389. Find the Difference - 哈希表解法 测试")
    print("=" * 60)
    
    for idx, (s, t, expected) in enumerate(test_cases, 1):
        result = solution.findTheDifference(s, t)
        passed = result == expected
        status = "✅ PASS" if passed else "❌ FAIL"
        print(f"\n测试用例 {idx}:")
        print(f"  s = \"{s}\", t = \"{t}\"")
        print(f"  期望: {expected}")
        print(f"  实际: {result}")
        print(f"  {status}")
    
    print("\n" + "=" * 60)
    print("所有测试运行完毕。")