"""
LeetCode 176. Second Highest Salary
Pandas 解法 + 测试示例
"""

import pandas as pd

def second_highest_salary(employee: pd.DataFrame) -> pd.DataFrame:
    unique_salaries = employee['salary'].drop_duplicates().sort_values(ascending=False)
    second = unique_salaries.iloc[1] if len(unique_salaries) >= 2 else None 

    return pd.DataFrame({'SecondHighestSalary': [second]})

# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    # 示例1：正常有第二高
    data1 = {
        'id': [1, 2, 3],
        'salary': [100, 200, 300]
    }
    df1 = pd.DataFrame(data1)
    print("示例1 输入:")
    print(df1)
    print("\n输出:")
    print(second_highest_salary(df1))
    print("\n" + "-"*40 + "\n")

    # 示例2：只有一种薪水，应返回 None
    data2 = {
        'id': [1, 2],
        'salary': [100, 100]
    }
    df2 = pd.DataFrame(data2)
    print("示例2 输入:")
    print(df2)
    print("\n输出:")
    print(second_highest_salary(df2))
    print("\n" + "-"*40 + "\n")

    # 示例3：空表，应返回 None
    data3 = {
        'id': [],
        'salary': []
    }
    df3 = pd.DataFrame(data3)
    print("示例3 输入 (空表):")
    print(df3)
    print("\n输出:")
    print(second_highest_salary(df3))
    