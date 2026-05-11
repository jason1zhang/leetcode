from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        """
        原地删除有序数组中的重复项，返回唯一元素的个数 k。
        修改后的数组前 k 个元素为去重后的有序序列。
        """
        if not nums:
            return 0
        
        slow = 0

        for fast in range(1, len(nums)):
            if nums[fast] != nums[slow]:
                slow += 1
                nums[slow] = nums[fast]

        return slow + 1
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()
    
    # 定义测试用例：(输入数组, 期望的唯一元素个数, 期望的前k个元素)
    test_cases = [
        ([1, 1, 2], 2, [1, 2]),
        ([0, 0, 1, 1, 1, 2, 2, 3, 3, 4], 5, [0, 1, 2, 3, 4]),
        ([1], 1, [1]),
        ([1, 1, 1, 1, 1], 1, [1]),
        ([ -1, 0, 0, 0, 3, 3, 5 ], 4, [-1, 0, 3, 5]),
    ]
    
    print("=" * 60)
    print("LeetCode 26. Remove Duplicates from Sorted Array - 测试运行")
    print("=" * 60)
    
    for idx, (nums_init, expected_k, expected_nums) in enumerate(test_cases, 1):
        # 复制一份输入数组，因为函数会原地修改
        nums = nums_init.copy()
        original_nums = nums_init.copy()
        
        print(f"\n测试用例 {idx}:")
        print(f"  原始数组: {original_nums}")
        
        # 调用函数
        k = solution.removeDuplicates(nums)
        
        # 验证返回的 k 值是否正确
        k_passed = (k == expected_k)
        # 验证前 k 个元素是否与期望一致
        elements_passed = (nums[:k] == expected_nums)
        passed = k_passed and elements_passed
        
        status = "✅ PASS" if passed else "❌ FAIL"
        
        print(f"  返回的 k = {k} (期望 {expected_k})")
        print(f"  修改后的数组前 {k} 项: {nums[:k]}")
        print(f"  期望的前 {expected_k} 项: {expected_nums}")
        print(f"  修改后完整数组: {nums} (后面部分无关紧要)")
        print(f"  {status}")
        
        if not k_passed:
            print(f"    -> k 值不匹配")
        if not elements_passed:
            print(f"    -> 前 k 个元素不匹配")
    
    print("\n" + "=" * 60)
    print("所有测试运行完毕。")