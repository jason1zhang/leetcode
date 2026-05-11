from typing import List


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        """
        返回两个数组的交集，包含重复元素，次数取较小值。
        使用哈希表统计较小数组的元素频率，然后遍历较大数组进行匹配。
        """
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1

        freq = {}
        for num in nums1:
            freq[num] = freq.get(num, 0) + 1

        result = []
        for num in nums2:
            if freq.get(num, 0) > 0:
                result.append(num)
                freq[num] -= 1

        return result
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()
    
    test_cases = [
        ([1, 2, 2, 1], [2, 2], [2, 2]),           # 示例1
        ([4, 9, 5], [9, 4, 9, 8, 4], [4, 9]),     # 示例2
        ([1, 2, 3], [4, 5, 6], []),                # 无交集
        ([1, 1, 1], [1, 1], [1, 1]),               # 次数取较小值
        ([], [1], []),                              # 空数组
    ]
    
    print("=" * 60)
    print("LeetCode 350. Intersection of Two Arrays II - 测试运行")
    print("=" * 60)
    
    for idx, (nums1, nums2, expected) in enumerate(test_cases, 1):
        result = solution.intersect(nums1, nums2)
        # 因为顺序可以任意，排序后比较
        passed = sorted(result) == sorted(expected)
        status = "✅ PASS" if passed else "❌ FAIL"
        print(f"\n测试用例 {idx}:")
        print(f"  nums1: {nums1}")
        print(f"  nums2: {nums2}")
        print(f"  期望: {expected}")
        print(f"  实际: {result}")
        print(f"  {status}")
    
    print("\n" + "=" * 60)
    print("所有测试运行完毕。")