import pandas as pd

def duplicate_emails(person: pd.DataFrame) -> pd.DataFrame:
    """
    找出 Person 表中重复出现的邮箱，返回只含 Email 列的数据框。
    """
    email_counts = person.groupby('email').size().reset_index(name='count')

    duplicates = email_counts[email_counts['count'] > 1]

    result = duplicates[['email']].rename(columns={'email': 'Email'})

    return result

# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    # 示例数据
    person_data = {
        'id': [1, 2, 3],
        'email': ['a@b.com', 'c@d.com', 'a@b.com']
    }
    person_df = pd.DataFrame(person_data)
    
    print("输入 DataFrame:")
    print(person_df)
    
    result = duplicate_emails(person_df)
    
    print("\n输出结果（重复的邮箱）：")
    print(result)