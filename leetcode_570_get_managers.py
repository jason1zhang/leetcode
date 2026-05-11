"""
LeetCode 570. Managers with at Least 5 Direct Reports
Pandas 解法 + 测试示例
"""

import pandas as pd

def find_managers(employee: pd.DataFrame) -> pd.DataFrame:
    report_counts = employee['managerId'].value_counts()
    valid_ids = report_counts[report_counts >= 5].index.tolist()

    return employee[employee['id'].isin(valid_ids)][['name']]


if __name__ == "__main__":
    # 示例数据
    data = {
        'id': [101, 102, 103, 104, 105, 106],
        'name': ['John', 'Dan', 'James', 'Amy', 'Anne', 'Ron'],
        'department': ['A', 'A', 'A', 'A', 'A', 'B'],
        'managerId': [None, 101, 101, 101, 101, 101]
    }
    df = pd.DataFrame(data)
    print("Employee 表:")
    print(df)
    
    result = find_managers(df)
    print("\n至少有5名直接下属的经理:")
    print(result)