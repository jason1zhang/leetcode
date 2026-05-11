from typing import List 

class Solution:
    def maxArea(self, height: List[int]) -> int:
        left, right = 0, len(height) - 1
        max_water = 0

        while left < right:
            water = (right - left) * min(height[left], height[right])
            max_water = max(max_water, water)

            if height[left] < height[right]:
                left +=1
            else:
                right -= 1

        return max_water
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()

    # 定义测试用例：(输入数组, 期望输出)
    test_cases = [
        ([1, 8, 6, 2, 5, 4, 8, 3, 7], 49),   # 官方示例
        ([1, 1], 1),                           # 最小情况
        ([4, 3, 2, 1, 4], 16),                # 高度相同的情况
        ([1, 2, 1], 2),                        # 倒 V 形
        ([2, 3, 4, 5, 18, 17, 6], 17),         # 高墙在中间
        ([1, 2, 4, 3], 4),                     # 随机
        ([2, 1, 1, 2], 6),                     # 对称形状
        ([100, 1, 100], 200),                  # 两个极高
        ([1, 3, 2, 5, 25, 24, 5], 24),         # 复杂
    ]

    print("=" * 60)
    print("LeetCode 11. Container With Most Water - 测试运行")
    print("=" * 60)

    for idx, (h, expected) in enumerate(test_cases, 1):
        result = solution.maxArea(h)
        passed = result == expected
        status = "✅ PASS" if passed else "❌ FAIL"

        # 对长数组显示做截断
        display_h = str(h) if len(h) <= 10 else str(h[:7])[:-1] + ", ...]"

        print(f"\n测试用例 {idx}:")
        print(f"  输入数组: {display_h}")
        print(f"  期望结果: {expected}")
        print(f"  实际结果: {result}")
        print(f"  {status}")

    print("\n" + "=" * 60)
    print("所有测试运行完毕。")
