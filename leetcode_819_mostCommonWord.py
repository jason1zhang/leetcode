import re
from typing import List


class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        paragraph = paragraph.lower()
        paragraph = re.sub(r"[!?',;.]", " ", paragraph)

        words = paragraph.split()

        banned_set = set(banned)

        freq = {}
        for word in words:
            if word not in banned_set:
                freq[word] = freq.get(word, 0) + 1

            
        return max(freq, key=freq.get)
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    solution = Solution()

    # 定义测试用例：(paragraph, banned, expected)
    test_cases = [
        (
            "Bob hit a ball, the hit BALL flew far after it was hit.",
            ["hit"],
            "ball"
        ),
        (
            "a.",
            [],
            "a"
        ),
        (
            "Bob!",
            [],
            "bob"
        ),
        (
            "Bob. hIt, baLL",
            ["bob", "hit"],
            "ball"
        ),
        (
            "a, a, a, a, b,b,b,c, c",
            ["a"],
            "b"
        ),
    ]

    print("=" * 60)
    print("LeetCode 819. Most Common Word - 测试运行")
    print("=" * 60)

    for idx, (paragraph, banned, expected) in enumerate(test_cases, 1):
        result = solution.mostCommonWord(paragraph, banned)
        passed = result == expected
        status = "✅ PASS" if passed else "❌ FAIL"
        print(f"\n测试用例 {idx}:")
        print(f"  paragraph: \"{paragraph}\"")
        print(f"  banned: {banned}")
        print(f"  期望结果: \"{expected}\"")
        print(f"  实际结果: \"{result}\"")
        print(f"  {status}")

    print("\n" + "=" * 60)
    print("所有测试运行完毕。")