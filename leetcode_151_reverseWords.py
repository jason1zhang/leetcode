class Solution:
    def reverseWords(self, s: str) -> str:
        words = []
        n = len(s)
        i = n - 1

        while i >= 0:
            while i >= 0 and s[i] == ' ':
                i -= 1

            if i < 0:
                break

            j = i
            while i >= 0 and s[i] != ' ':
                i -= 1

            word = s[i + 1: j + 1]
            words.append(word)

        return ' '.join(words)
    
    # ================== 测试代码 ==================
if __name__ == "__main__":
    sol = Solution()
    
    test_cases = [
        ("the sky is blue", "blue is sky the"),
        ("  hello world  ", "world hello"),
        ("a good   example", "example good a"),
        ("  Bob    Loves  Alice   ", "Alice Loves Bob"),
        ("Alice", "Alice"),
        ("   ", ""),  # 全空格
        ("", ""),     # 空字符串
    ]
    
    print("测试结果：")
    for s, expected in test_cases:
        result = sol.reverseWords(s)
        status = "✅" if result == expected else f"❌ (got '{result}')"
        print(f"输入: '{s}' -> 输出: '{result}' {status}")