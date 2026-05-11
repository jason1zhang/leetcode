from typing import List


class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        """
        判断数组中是否存在重复元素。
        使用哈希集合记录已遍历元素，若遇到已存在的元素则返回 True。
        时间复杂度 O(n)，空间复杂度 O(n)。
        """
        seen = set()

        for num in nums:
            if num in seen:
                return True

            seen.add(num)
        
        return False
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()
    
    test_cases = [
        ([1, 2, 3, 1], True),                # 示例1：有重复
        ([1, 2, 3, 4], False),               # 示例2：无重复
        ([1, 1, 1, 3, 3, 4, 3, 2, 4, 2], True),  # 示例3：大量重复
        ([], False),                          # 空数组
        ([10], False),                        # 单元素
        ([5, 5], True),                       # 两个相同
    ]
    
    print("=" * 60)
    print("LeetCode 217. Contains Duplicate - 测试运行")
    print("=" * 60)
    
    for idx, (nums, expected) in enumerate(test_cases, 1):
        result = solution.containsDuplicate(nums)
        passed = result == expected
        status = "✅ PASS" if passed else "❌ FAIL"
        print(f"\n测试用例 {idx}:")
        print(f"  nums: {nums}")
        print(f"  期望: {expected}")
        print(f"  实际: {result}")
        print(f"  {status}")
    
    print("\n" + "=" * 60)
    print("所有测试运行完毕。")