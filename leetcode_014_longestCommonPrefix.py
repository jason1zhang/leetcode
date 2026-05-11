from typing import List

class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        """
        纵向扫描法求字符串数组的最长公共前缀。
        以第一个字符串为基准，逐位比较所有字符串的同一列字符。
        若某列字符不一致或某个字符串长度不足，则返回当前已匹配的部分。
        """
        if not strs:
            return ""
        
        for i in range(len(strs[0])):
            char = strs[0][i]
            for s in strs[1:]:
                if i >= len(s) or s[i] != char:
                    return strs[0][:i]
                
        return strs[0]

# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()

    # 定义测试用例：(输入字符串数组, 期望输出)
    test_cases = [
        (["flower", "flow", "flight"], "fl"),    # 官方示例1
        (["dog", "racecar", "car"], ""),         # 官方示例2
        ([], ""),                                # 空数组
        (["abc", "abc", "abc"], "abc"),          # 所有字符串相同
        (["alone"], "alone"),                    # 只有一个字符串
        (["", "abc", "def"], ""),                # 包含空字符串
        (["a"], "a"),                            # 单字符单字符串
        (["ab", "a"], "a"),                      # 前缀为单字符
        (["prefix", "preference", "preview"], "pre"),  # 公共前缀较长
        (["apple", "app", "april"], "ap"),       # 混合长度
    ]

    print("=" * 60)
    print("LeetCode 14. Longest Common Prefix - 测试运行")
    print("=" * 60)

    for idx, (strs, expected) in enumerate(test_cases, 1):
        result = solution.longestCommonPrefix(strs)
        passed = result == expected
        status = "✅ PASS" if passed else "❌ FAIL"

        # 对长数组显示做截断
        display_strs = str(strs) if len(strs) <= 5 else str(strs[:5])[:-1] + ", ...]"

        print(f"\n测试用例 {idx}:")
        print(f"  输入数组: {display_strs}")
        print(f"  期望结果: '{expected}'")
        print(f"  实际结果: '{result}'")
        print(f"  {status}")

    print("\n" + "=" * 60)
    print("所有测试运行完毕。")