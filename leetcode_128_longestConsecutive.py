from typing import List


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        num_set = set(nums)
        max_len = 0

        for num in num_set:
            # 仅当 num-1 不在集合中时，才把 num 当作连续序列的起点
            if num - 1 not in num_set:
                curr_num = num 
                curr_len = 1 

                # 不断向后找连续的数字
                while curr_num + 1 in num_set:
                    curr_num += 1
                    curr_len += 1

                max_len = max(max_len, curr_len)

        return max_len
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()
    
    test_cases = [
        ([100, 4, 200, 1, 3, 2], 4),          # 示例1
        ([0, 3, 7, 2, 5, 8, 4, 6, 0, 1], 9), # 示例2
        ([1, 0, 1, 2], 3),                    # 示例3：包含重复
        ([], 0),                               # 空数组
        ([5], 1),                              # 单元素
        ([1, 2, 3, 4, 5], 5),                 # 完全连续
        ([9, 1, 4, 7, 3, 2, 6, 8], 4),       # 乱序连续
        ([-3, -2, -1, 0, 1], 5),              # 包含负数
    ]
    
    print("=" * 60)
    print("LeetCode 128. Longest Consecutive Sequence - 测试运行")
    print("=" * 60)
    
    for idx, (nums, expected) in enumerate(test_cases, 1):
        result = solution.longestConsecutive(nums)
        passed = result == expected
        status = "✅ PASS" if passed else "❌ FAIL"
        
        # 显示时截断过长数组
        display_nums = nums if len(nums) <= 10 else str(nums[:10])[:-1] + ", ...]"
        print(f"\n测试用例 {idx}:")
        print(f"  nums: {display_nums}")
        print(f"  期望: {expected}")
        print(f"  实际: {result}")
        print(f"  {status}")
    
    print("\n" + "=" * 60)
    print("所有测试运行完毕。")