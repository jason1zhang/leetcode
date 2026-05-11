from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num_map = {}

        for i, num in enumerate(nums):
            complement = target - num

            if complement in num_map:
                return [num_map[complement], i]
            
            num_map[num] = i

        return []
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()
    
    # 定义测试用例 (nums, target, expected_output)
    test_cases = [
        ([2, 7, 11, 15], 9, [0, 1]),
        ([3, 2, 4], 6, [1, 2]),
        ([3, 3], 6, [0, 1]),
        ([1, 5, 8, 3], 11, [2, 3]),     
        ([0, 4, 3, 0], 0, [0, 3]),      # 额外用例：处理0的情况
    ]
    
    print("=" * 50)
    print("LeetCode 1. Two Sum - 测试运行")
    print("=" * 50)
    
    for idx, (nums, target, expected) in enumerate(test_cases, 1):
        result = solution.twoSum(nums, target)
        # 因为返回顺序可以任意，所以排序后比较（或者直接检查两个索引和是否为目标值）
        # 这里直接验证结果中的两个数加起来是否等于target，且索引不相同
        is_correct = False
        if len(result) == 2:
            i, j = result
            if i != j and nums[i] + nums[j] == target:
                is_correct = True
        
        status = "✅ PASS" if is_correct else "❌ FAIL"
        print(f"\n测试用例 {idx}:")
        print(f"  nums   = {nums}")
        print(f"  target = {target}")
        print(f"  期望结果 = {expected} (顺序可不同)")
        print(f"  实际结果 = {result}")
        print(f"  验证: nums[{result[0]}] + nums[{result[1]}] = {nums[result[0]]} + {nums[result[1]]} = {target}")
        print(f"  {status}")
    
    print("\n" + "=" * 50)
    print("所有测试运行完毕。")