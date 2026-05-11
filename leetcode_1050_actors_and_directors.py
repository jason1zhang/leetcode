"""
LeetCode 1050. Actors and Directors Who Cooperated At Least Three Times
Pandas 解法 + 测试用例
"""

import pandas as pd

def actors_and_directors(actor_director: pd.DataFrame) -> pd.DataFrame:
    """
    返回合作次数至少为三次的演员和导演 ID 对。

    参数:
        actor_director: 包含 actor_id, director_id, timestamp 列的 DataFrame

    返回:
        包含 actor_id 和 director_id 两列的 DataFrame
    """
    counts = actor_director.groupby(['actor_id', 'director_id']).size()
    valid_pairs = counts[counts >= 3]
    result = valid_pairs.reset_index()[['actor_id', 'director_id']]

    return result

if __name__ == "__main__":
    # 示例数据
    data = {
        'actor_id':    [1, 1, 1, 1, 1, 2, 2],
        'director_id': [1, 1, 1, 2, 2, 1, 1],
        'timestamp':   [0, 1, 2, 3, 4, 5, 6]
    }
    df = pd.DataFrame(data)
    print("ActorDirector 表:")
    print(df)
    
    result = actors_and_directors(df)
    print("\n输出结果:")
    print(result)