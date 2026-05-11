from typing import List


class Solution:
    def merge(self, intervals: List[list[int]]) -> List[List[int]]:
        """
        合并所有重叠的区间，返回一个不重叠的区间数组。
        思路：先按区间的起始位置排序，然后依次合并重叠的区间。
        """
        if not intervals:
            return []
        
        intervals.sort(key = lambda x: x[0])

        merged = [intervals[0]]

        for i in range(1, len(intervals)):
            _, prev_end = merged[-1]
            curr_start, curr_end = intervals[i]

            if curr_start <= prev_end:
                merged[-1][1] = max(prev_end, curr_end)
            else:
                merged.append(intervals[i])

        return merged 
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()
    
    test_cases = [
        ([[1,3],[2,6],[8,10],[15,18]], [[1,6],[8,10],[15,18]]),
        ([[1,4],[4,5]], [[1,5]]),
        ([[4,7],[1,4]], [[1,7]]),
        ([[1,4],[5,6]], [[1,4],[5,6]]),
        ([], []),
        ([[1,3]], [[1,3]]),
        ([[1,4],[0,4]], [[0,4]]),  # 起始顺序乱，但排序后会处理好
        ([[1,4],[2,3]], [[1,4]]),  # 完全包含的情况
    ]
    
    print("=" * 60)
    print("LeetCode 56. Merge Intervals - 测试运行")
    print("=" * 60)
    
    for idx, (intervals, expected) in enumerate(test_cases, 1):
        # 复制一份原始输入用于显示（因为排序会修改原列表）
        original = [pair[:] for pair in intervals]
        result = solution.merge(intervals)
        passed = result == expected
        status = "✅ PASS" if passed else "❌ FAIL"
        print(f"\n测试用例 {idx}:")
        print(f"  输入: {original}")
        print(f"  期望: {expected}")
        print(f"  实际: {result}")
        print(f"  {status}")
    
    print("\n" + "=" * 60)
    print("所有测试运行完毕。")

