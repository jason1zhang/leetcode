from typing import List


class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        freq = {}
        for num in nums:
            freq[num] = freq.get(num, 0) + 1

        return [num for num, cnt in freq.items() if cnt > len(nums) // 3]
    
# ---------- Test Section ----------
if __name__ == "__main__":
    sol = Solution()

    # Test case 1: Example from prompt
    nums1 = [3, 2, 3]
    expected1 = [3]
    output1 = sol.majorityElement(nums1)
    print(f"Input: {nums1}")
    print(f"Output: {output1}")
    print(f"Expected: {expected1}")
    print("Passed:", output1 == expected1)
    print("-" * 40)

    # Test case 2: Single element
    nums2 = [1]
    expected2 = [1]
    output2 = sol.majorityElement(nums2)
    print(f"Input: {nums2}")
    print(f"Output: {output2}")
    print(f"Expected: {expected2}")
    print("Passed:", output2 == expected2)
    print("-" * 40)

    # Test case 3: Two elements, each appears once (n//3 = 0, so both qualify)
    nums3 = [1, 2]
    expected3 = [1, 2]  # order may vary; we compare as sets
    output3 = sol.majorityElement(nums3)
    print(f"Input: {nums3}")
    print(f"Output: {output3}")
    print(f"Expected: {expected3}")
    print("Passed:", set(output3) == set(expected3))
    print("-" * 40)

    # Test case 4: No element appears more than n//3 times
    nums4 = [1, 2, 3, 4, 5]
    expected4 = []
    output4 = sol.majorityElement(nums4)
    print(f"Input: {nums4}")
    print(f"Output: {output4}")
    print(f"Expected: {expected4}")
    print("Passed:", output4 == expected4)
    print("-" * 40)

    # Test case 5: All elements same
    nums5 = [2, 2, 2, 2]
    expected5 = [2]
    output5 = sol.majorityElement(nums5)
    print(f"Input: {nums5}")
    print(f"Output: {output5}")
    print(f"Expected: {expected5}")
    print("Passed:", output5 == expected5)
    print("-" * 40)

    # Test case 6: Two candidates each appearing more than n//3 times
    # n = 7, n//3 = 2, so count > 2 => at least 3 occurrences each
    nums6 = [1, 1, 1, 2, 2, 2, 3]   # 1 appears 3 times, 2 appears 3 times
    expected6 = [1, 2]
    output6 = sol.majorityElement(nums6)
    print(f"Input: {nums6}")
    print(f"Output: {output6}")
    print(f"Expected: {expected6}")
    print("Passed:", set(output6) == set(expected6))
    print("-" * 40)

    # Test case 7: Large values and negative numbers
    nums7 = [-1, -1, -1, -2, -2, -2, -3]
    expected7 = [-1, -2]
    output7 = sol.majorityElement(nums7)
    print(f"Input: {nums7}")
    print(f"Output: {output7}")
    print(f"Expected: {expected7}")
    print("Passed:", set(output7) == set(expected7))
    print("-" * 40)