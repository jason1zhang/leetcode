"""
LeetCode 577. Employee Bonus
Pandas 解法 + 测试示例

找出奖金少于1000或没有奖金的员工姓名及其奖金金额。
"""

import pandas as pd

def employee_bonus(employee: pd.DataFrame, bonus: pd.DataFrame) -> pd.DataFrame:
    """
    查找满足以下条件之一的员工姓名及奖金：
    1. 奖金少于 1000 的员工
    2. 没有任何奖金记录的员工
    
    参数:
        employee: Employee 表，包含 empId, name, supervisor, salary 列
        bonus: Bonus 表，包含 empId, bonus 列
    
    返回:
        包含 name 和 bonus 列的 DataFrame，行为符合条件的员工记录
    """
    merged = employee.merge(bonus, on='empId', how='left')

    condition = (merged['bonus'] < 1000) | (merged['bonus'].isna())
    result = merged[condition]

    return result[['name', 'bonus']]


# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    # 示例数据
    employee_data = {
        'empId': [3, 1, 2, 4],
        'name': ['Brad', 'John', 'Dan', 'Thomas'],
        'supervisor': [None, 3, 3, 3],
        'salary': [4000, 1000, 2000, 4000]
    }
    bonus_data = {
        'empId': [2, 4],
        'bonus': [500, 2000]
    }
    
    employee_df = pd.DataFrame(employee_data)
    bonus_df = pd.DataFrame(bonus_data)
    
    print("Employee 表:")
    print(employee_df)
    print("\nBonus 表:")
    print(bonus_df)
    
    result = employee_bonus(employee_df, bonus_df)
    
    print("\n输出结果:")
    print(result)