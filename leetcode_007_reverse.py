class Solution:
    def reverse(self, x: int) -> int:
        """
        反转有符号 32 位整数，溢出则返回 0。
        思路：不断取 x 的末位数字拼接到结果上，同时检测溢出。
        """
        INT_MAX = 2**31 -1

        res = 0
        sign = 1 if x >=0 else -1
        x = abs(x)

        while x != 0:
            digit = x % 10
            x //= 10

            if res > (INT_MAX - digit) // 10:
                return 0
            
            res = res * 10 + digit

        return sign * res 
    
if __name__ == "__main__":
    solution = Solution()
    
    test_cases = [
        (123, 321),
        (-123, -321),
        (120, 21),
        (0, 0),
        (1534236469, 0),   # 反转后溢出
        (-2147483412, -2143847412),
        (1463847412, 2147483641),
    ]
    
    print("=" * 60)
    print("LeetCode 7. Reverse Integer - 测试运行")
    print("=" * 60)
    
    for x, expected in test_cases:
        result = solution.reverse(x)
        passed = result == expected
        status = "✅ PASS" if passed else "❌ FAIL"
        print(f"输入: {x:>12}, 输出: {result:>12}, 期望: {expected:>12}  {status}")
    
    print("\n" + "=" * 60)
    print("所有测试运行完毕。")