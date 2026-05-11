from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        total_profit = 0

        for i in range(1, len(prices)):
            if prices[i] > prices[i - 1]:
                total_profit += prices[i] -  prices[i - 1]

        return total_profit
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()

    # 定义测试用例：(输入数组, 期望输出)
    test_cases = [
        ([7, 1, 5, 3, 6, 4], 7),      # 官方示例1
        ([1, 2, 3, 4, 5], 4),         # 官方示例2：持续上涨
        ([7, 6, 4, 3, 1], 0),         # 持续下跌
        ([1, 2, 3, 2, 5], 5),         # 先涨后跌再涨
        ([3, 3, 3, 3], 0),            # 价格不变
        ([1], 0),                     # 单天无法交易
        ([2, 1, 2, 1, 0, 1, 2], 3),  # 多次波动
    ]

    print("=" * 60)
    print("LeetCode 122. Best Time to Buy and Sell Stock II - 测试运行")
    print("=" * 60)

    for idx, (prices, expected) in enumerate(test_cases, 1):
        result = solution.maxProfit(prices)
        passed = result == expected
        status = "✅ PASS" if passed else "❌ FAIL"

        # 对长数组显示做截断
        display_prices = str(prices) if len(prices) <= 10 else str(prices[:7])[:-1] + ", ...]"

        print(f"\n测试用例 {idx}:")
        print(f"  输入数组: {display_prices}")
        print(f"  期望结果: {expected}")
        print(f"  实际结果: {result}")
        print(f"  {status}")

    print("\n" + "=" * 60)
    print("所有测试运行完毕。")