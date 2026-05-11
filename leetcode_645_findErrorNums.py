from typing import List


class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        """
        使用普通字典统计频率，找到重复数（计数2）和缺失数（计数0）。
        """
        freq = {}
        for num in nums:
            freq[num] = freq.get(num, 0) + 1

        n = len(nums)
        dup = missing = -1
        for i in range(1, n + 1):
            count = freq.get(i, 0)
            if count == 2:
                dup = i
            elif count == 0:
                missing = i
        
        return [dup, missing]
    
# 测试代码（可直接运行）
if __name__ == "__main__":
    sol = Solution()
    test_cases = [
        ([1,2,2,4], [2,3]),
        ([1,1], [1,2]),
        ([2,2], [2,1]),
    ]
    for nums, expected in test_cases:
        print(f"nums={nums}, result={sol.findErrorNums(nums)}, expected={expected}")