"""
LeetCode 178. Rank Scores
Pandas 解法 + 测试示例
"""

import pandas as pd

def order_scores(scores: pd.DataFrame) -> pd.DataFrame:
    scores['rank'] = scores['score'].rank(method='dense', ascending=False).astype(int)
    result = scores[['score', 'rank']].sort_values('score', ascending=False)

    return result

if __name__ == "__main__":
    # 示例数据
    data = {
        'id': [1, 2, 3, 4, 5, 6],
        'score': [3.50, 3.65, 4.00, 3.85, 4.00, 3.65]
    }
    df = pd.DataFrame(data)
    print("输入表:")
    print(df)
    print("\n输出表:")
    print(order_scores(df))