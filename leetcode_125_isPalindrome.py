class Solution:
    def isPalindrome(self, s: str) -> bool:
        """
        判断字符串是否为有效回文串（只考虑字母和数字，忽略大小写）。
        使用双指针原地判断，空间复杂度 O(1)。
        """
        left, right = 0, len(s) - 1

        while left < right:
            while left < right and not s[left].isalnum():
                left += 1
            
            while left < right and not s[right].isalnum():
                right -= 1

            if s[left].lower() != s[right].lower():
                return False
            
            left += 1
            right -= 1

        return True
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()
    
    # 定义测试用例：(输入字符串, 期望输出)
    test_cases = [
        ("A man, a plan, a canal: Panama", True),
        ("race a car", False),
        (" ", True),
        ("", True),
        ("a.", True),
        ("0P", False),
        ("ab_a", True),
        ("Do geese see God?", True),
        ("Never odd or even", True),
    ]
    
    print("=" * 60)
    print("LeetCode 125. Valid Palindrome - 测试运行")
    print("=" * 60)
    
    for idx, (s, expected) in enumerate(test_cases, 1):
        result = solution.isPalindrome(s)
        passed = result == expected
        status = "✅ PASS" if passed else "❌ FAIL"
        
        # 为了显示清晰，对长字符串做截断
        display_s = s if len(s) <= 50 else s[:47] + "..."
        print(f"\n测试用例 {idx}:")
        print(f"  输入字符串: \"{display_s}\"")
        print(f"  期望结果: {expected}")
        print(f"  实际结果: {result}")
        print(f"  {status}")
    
    print("\n" + "=" * 60)
    print("所有测试运行完毕。")