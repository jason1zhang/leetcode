from typing import List


class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        将两个有序数组合并到 nums1 中，不返回任何值，直接修改 nums1。
        """
        p1 = m - 1
        p2 = n - 1
        p = m + n - 1

        while p1 >= 0 and p2 >= 0:
            if nums1[p1] > nums2[p2]:
                nums1[p] = nums1[p1]
                p1 -= 1
            else:
                nums1[p] = nums2[p2]
                p2 -= 1

            p -= 1

        while p2 >= 0:
            nums1[p] = nums2[p2]
            p2 -= 1
            p -= 1

# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()
    
    # 定义测试用例
    test_cases = [
        # (nums1 初始状态, m, nums2, n, 期望输出)
        ([1, 2, 3, 0, 0, 0], 3, [2, 5, 6], 3, [1, 2, 2, 3, 5, 6]),
        ([1], 1, [], 0, [1]),
        ([0], 0, [1], 1, [1]),
        ([4, 5, 6, 0, 0, 0], 3, [1, 2, 3], 3, [1, 2, 3, 4, 5, 6]),
        ([2, 0], 1, [1], 1, [1, 2]),
    ]
    
    print("=" * 60)
    print("LeetCode 88. Merge Sorted Array - 测试运行")
    print("=" * 60)
    
    for idx, (nums1_init, m, nums2, n, expected) in enumerate(test_cases, 1):
        # 复制一份初始数组，因为 merge 会原地修改
        nums1 = nums1_init.copy()
        
        print(f"\n测试用例 {idx}:")
        print(f"  nums1 (初始) = {nums1_init}")
        print(f"  m = {m}, nums2 = {nums2}, n = {n}")
        
        # 调用合并方法
        solution.merge(nums1, m, nums2, n)
        
        # 验证结果是否与期望一致
        passed = nums1 == expected
        status = "✅ PASS" if passed else "❌ FAIL"
        
        print(f"  nums1 (合并后) = {nums1}")
        print(f"  期望输出      = {expected}")
        print(f"  {status}")
    
    print("\n" + "=" * 60)
    print("所有测试运行完毕。")