from typing import List


class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        """
        Returns the smallest sorted list of ranges that cover all numbers in the array.
        """
        if not nums:
            return []
        
        result = []
        start = nums[0] # start of current range

        for i in range(1, len(nums)):
            # If the current number is not consecutive, close the previous range
            if nums[i] != nums[i - 1] + 1:
                if start == nums[i - 1]:
                    result.append(str(start))
                else:
                    result.append(f"{start}->{nums[i - 1]}")
                
                start = nums[i] # start a new range

        # handle the last range
        if start == nums[-1]:
            result.append(str(start))
        else:
            result.append(f"{start}->{nums[-1]}")

        return result
    
# ---------- Test Section ----------
if __name__ == "__main__":
    sol = Solution()

    # Example 1
    nums1 = [0, 1, 2, 4, 5, 7]
    expected1 = ["0->2", "4->5", "7"]
    output1 = sol.summaryRanges(nums1)
    print(f"Input: {nums1}")
    print(f"Output: {output1}")
    print(f"Expected: {expected1}")
    print("Test passed:", output1 == expected1)
    print("-" * 40)

    # Example 2
    nums2 = [0, 2, 3, 4, 6, 8, 9]
    expected2 = ["0", "2->4", "6", "8->9"]
    output2 = sol.summaryRanges(nums2)
    print(f"Input: {nums2}")
    print(f"Output: {output2}")
    print(f"Expected: {expected2}")
    print("Test passed:", output2 == expected2)
    print("-" * 40)

    # Additional test: empty array
    nums3 = []
    expected3 = []
    output3 = sol.summaryRanges(nums3)
    print(f"Input: {nums3}")
    print(f"Output: {output3}")
    print(f"Expected: {expected3}")
    print("Test passed:", output3 == expected3)
    print("-" * 40)

    # Additional test: single element
    nums4 = [5]
    expected4 = ["5"]
    output4 = sol.summaryRanges(nums4)
    print(f"Input: {nums4}")
    print(f"Output: {output4}")
    print(f"Expected: {expected4}")
    print("Test passed:", output4 == expected4)
    print("-" * 40)