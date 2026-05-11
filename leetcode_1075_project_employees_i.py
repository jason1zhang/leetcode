import pandas as pd

def project_employees_i(project: pd.DataFrame, employee: pd.DataFrame) -> pd.DataFrame:
    """
    计算每个项目中员工的平均工作年限，保留两位小数。
    """
    merged = project.merge(employee, on='employee_id', how='inner')

    result = merged.groupby('project_id')['experience_years'].mean().reset_index()

    result['experience_years'] = result['experience_years'].round(2)

    result.rename(columns={'experience_years': 'average_years'}, inplace=True)

    return result 

# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    # 示例数据
    project_data = {
        'project_id': [1, 1, 1, 2, 2],
        'employee_id': [1, 2, 3, 1, 4]
    }
    employee_data = {
        'employee_id': [1, 2, 3, 4],
        'name': ['Khaled', 'Ali', 'John', 'Doe'],
        'experience_years': [3, 2, 1, 2]
    }
    
    project_df = pd.DataFrame(project_data)
    employee_df = pd.DataFrame(employee_data)
    
    print("Project 表：")
    print(project_df)
    print("\nEmployee 表：")
    print(employee_df)
    
    result_df = project_employees_i(project_df, employee_df)
    print("\n输出结果：")
    print(result_df)