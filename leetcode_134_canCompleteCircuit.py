from typing import List

class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        total_tank = 0
        curr_tank = 0
        start_station = 0

        for i in range(len(gas)):
            diff = gas[i] - cost[i]
            total_tank += diff
            curr_tank += diff

            if curr_tank < 0:
                start_station = i + 1
                curr_tank = 0

        return start_station if total_tank >= 0 else -1


# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()

    # 定义测试用例：(gas数组, cost数组, 期望输出)
    test_cases = [
        ([1, 2, 3, 4, 5], [3, 4, 5, 1, 2], 3),   # 官方示例
        ([2, 3, 4], [3, 4, 3], -1),              # 无法完成一圈
        ([5, 1, 2, 3, 4], [4, 4, 1, 5, 1], 4),   # 其他起点
        ([2], [2], 0),                           # 单站刚好足够
        ([3], [4], -1),                          # 单站不够
        ([5, 8, 2, 8], [6, 5, 6, 6], 3),         # 复杂情况
        ([1, 2, 3, 4, 5], [1, 2, 3, 4, 5], 0),   # 所有差值为0，任意起点均可
    ]

    print("=" * 60)
    print("LeetCode 134. Gas Station - 测试运行")
    print("=" * 60)

    for idx, (gas, cost, expected) in enumerate(test_cases, 1):
        result = solution.canCompleteCircuit(gas, cost)
        passed = result == expected
        status = "✅ PASS" if passed else "❌ FAIL"

        # 对长数组显示做截断
        display_gas = str(gas) if len(gas) <= 10 else str(gas[:7])[:-1] + ", ...]"
        display_cost = str(cost) if len(cost) <= 10 else str(cost[:7])[:-1] + ", ...]"

        print(f"\n测试用例 {idx}:")
        print(f"  gas:  {display_gas}")
        print(f"  cost: {display_cost}")
        print(f"  期望结果: {expected}")
        print(f"  实际结果: {result}")
        print(f"  {status}")

    print("\n" + "=" * 60)
    print("所有测试运行完毕。")