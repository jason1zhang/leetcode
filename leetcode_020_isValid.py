"""
LeetCode 20. Valid Parentheses
Python 解法 + 测试用例
"""

class Solution:
    def isValid(self, s: str) -> bool:
        """
        判断括号字符串是否有效。
        
        参数:
            s: 只包含 '(', ')', '{', '}', '[', ']' 的字符串
        
        返回:
            bool: 括号是否有效匹配
        """
        stack = []
        mapping = {')': '(', '}': '{', ']': '['}

        for char in s:
            if char in mapping:
                top = stack.pop() if stack else '#'
                if mapping[char] != top:
                    return False
            else:
                stack.append(char)

        return not stack
    
if __name__ == "__main__":
    solution = Solution()
    
    test_cases = [
        ("()", True),
        ("()[]{}", True),
        ("(]", False),
        ("([)]", False),
        ("{[]}", True),
        ("", True),          # 空字符串视为有效
        ("[", False),
        ("]", False),
        ("(((([{}]))))", True),
    ]
    
    print("=" * 60)
    print("LeetCode 20. Valid Parentheses - 测试运行")
    print("=" * 60)
    
    for idx, (s, expected) in enumerate(test_cases, 1):
        result = solution.isValid(s)
        passed = result == expected
        status = "✅ PASS" if passed else "❌ FAIL"
        
        print(f"\n测试用例 {idx}:")
        print(f"  输入: {repr(s)}")
        print(f"  期望: {expected}")
        print(f"  实际: {result}")
        print(f"  {status}")
    
    print("\n" + "=" * 60)
    print("所有测试运行完毕。")