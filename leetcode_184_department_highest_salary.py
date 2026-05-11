"""
LeetCode 184. Department Highest Salary
使用图片示例数据运行
"""

import pandas as pd

def department_highest_salary(employee: pd.DataFrame, department: pd.DataFrame) -> pd.DataFrame:
    merged = employee.merge(department, left_on='departmentId', right_on='id', suffixes=('', '_dept'))

    max_salaries = merged.groupby('departmentId')['salary'].max().reset_index()
    max_salaries.rename(columns={'salary': 'max_salary'}, inplace=True)

    result = merged.merge(max_salaries, on='departmentId')
    result = result[result['salary'] == result['max_salary']]

    result = result.rename(columns={'name_dept': 'Department', 'name': 'Employee', 'salary': 'Salary'})
    
    return result[['Department', 'Employee', 'Salary']]


# =============================================
# 使用图片中的示例数据测试
# =============================================
if __name__ == "__main__":
    # Employee 表数据（与图片一致）
    employee_data = {
        'id': [1, 2, 3, 4, 5],
        'name': ['Joe', 'Jim', 'Henry', 'Sam', 'Max'],
        'salary': [70000, 90000, 80000, 60000, 90000],
        'departmentId': [1, 1, 2, 2, 1]
    }
    
    # Department 表数据（与图片一致）
    department_data = {
        'id': [1, 2],
        'name': ['IT', 'Sales']
    }

    employee_df = pd.DataFrame(employee_data)
    department_df = pd.DataFrame(department_data)

    print("Employee 表:")
    print(employee_df)
    print("\nDepartment 表:")
    print(department_df)

    result = department_highest_salary(employee_df, department_df)

    print("\n每个部门薪资最高的员工:")
    print(result)