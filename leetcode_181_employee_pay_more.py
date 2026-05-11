import pandas as pd

def find_employees_with_more_than_manager(employee: pd.DataFrame) -> pd.DataFrame:
    """
    返回收入超过其经理的员工的姓名。
    """
    merged = employee.merge(employee, left_on='managerId', right_on='id', suffixes=('_emp', '_mgr'))
    result = merged[merged['salary_emp'] > merged['salary_mgr']]

    result = result[['name_emp']].rename(columns={'name_emp': 'Employee'})

    return result

# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    # 示例输入
    employee_data = {
        'id': [1, 2, 3, 4],
        'name': ['Joe', 'Henry', 'Sam', 'Max'],
        'salary': [70000, 80000, 60000, 90000],
        'managerId': [3, 4, None, None]
    }
    employee_df = pd.DataFrame(employee_data)
    
    print("输入 Employee 表：")
    print(employee_df)
    
    result_df = find_employees_with_more_than_manager(employee_df)
    
    print("\n输出（收入超过经理的员工）：")
    print(result_df)