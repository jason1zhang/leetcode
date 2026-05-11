"""
LeetCode 607. Sales Person
Pandas 解法 + 测试用例
"""

import pandas as pd

def sales_person(sales_person: pd.DataFrame, company: pd.DataFrame, orders: pd.DataFrame) -> pd.DataFrame:
    """
    找出没有任何与名为 "RED" 的公司相关的订单的销售人员姓名。
    """
    red_com_id = company[company['name'] == 'RED']['com_id']
    red_sales_id = orders[orders['com_id'].isin(red_com_id)]['sales_id'].unique()
    result = sales_person[~sales_person['sales_id'].isin(red_sales_id)][['name']]

    return result



if __name__ == "__main__":
    # 示例数据
    sales_person_data = {
        'sales_id': [1, 2, 3, 4, 5],
        'name': ['John', 'Amy', 'Mark', 'Pam', 'Alex'],
        'salary': [100000, 12000, 65000, 25000, 5000],
        'commission_rate': [6, 5, 12, 25, 10],
        'hire_date': pd.to_datetime(['2006-04-01', '2010-05-01', '2008-12-25', '2005-01-01', '2007-02-03'])
    }
    
    company_data = {
        'com_id': [1, 2, 3, 4],
        'name': ['RED', 'ORANGE', 'YELLOW', 'GREEN'],
        'city': ['Boston', 'New York', 'Boston', 'Austin']
    }
    
    orders_data = {
        'order_id': [1, 2, 3, 4],
        'order_date': pd.to_datetime(['2014-01-01', '2014-02-01', '2014-03-01', '2014-04-01']),
        'com_id': [3, 4, 1, 1],
        'sales_id': [4, 5, 1, 4],
        'amount': [10000, 5000, 50000, 25000]
    }
    
    sales_person_df = pd.DataFrame(sales_person_data)
    company_df = pd.DataFrame(company_data)
    orders_df = pd.DataFrame(orders_data)
    
    print("SalesPerson 表:")
    print(sales_person_df)
    print("\nCompany 表:")
    print(company_df)
    print("\nOrders 表:")
    print(orders_df)
    
    result = sales_person(sales_person_df, company_df, orders_df)
    
    print("\n输出结果:")
    print(result)