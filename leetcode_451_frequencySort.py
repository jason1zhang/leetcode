class Solution:
    def frequencySort(self, s: str) -> str:
        """
        使用哈希表统计字符频率，按频率降序排序，构建结果字符串。
        """
        freq = {}
        for ch in s:
            freq[ch] = freq.get(ch, 0) + 1

        sorted_iterms = sorted(freq.items(), key=lambda x: x[1], reverse=True)

        result = []
        for ch, cnt in sorted_iterms:
            result.append(ch * cnt)

        return ''.join(result)
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()
    
    test_cases = [
        ("tree", ["eert", "eetr"]),
        ("cccaaa", ["cccaaa", "aaaccc"]),
        ("Aabb", ["bbAa", "bbaA"]),
        ("", ""),
        ("a", "a"),
    ]
    
    print("=" * 60)
    print("LeetCode 451. 哈希表解法 测试")
    print("=" * 60)
    
    for idx, (s, expected) in enumerate(test_cases, 1):
        result = solution.frequencySort(s)
        # 简单验证长度和字符频率是否一致
        from collections import Counter
        valid = len(result) == len(s) and Counter(result) == Counter(s)
        status = "✅ PASS" if valid else "❌ FAIL"
        print(f"\n测试 {idx}: s = '{s}'")
        print(f"  结果: '{result}' {status}")