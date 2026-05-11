"""
LeetCode 183. Customers Who Never Order
Pandas 解法 + 测试示例
"""

import pandas as pd

def find_customers(customers: pd.DataFrame, orders: pd.DataFrame) -> pd.DataFrame:
    # 左连接，找出没有订单的客户
    merged = customers.merge(orders, left_on='id', right_on='customerId', how='left')
    no_orders = merged[merged['customerId'].isna()]
    result = no_orders[['name']].rename(columns={'name': 'Customers'})
    return result


# =============================================
# 测试代码（使用题目示例数据）
# =============================================
if __name__ == "__main__":
    # 示例输入
    customers_data = {
        'id': [1, 2, 3, 4],
        'name': ['Joe', 'Henry', 'Sam', 'Max']
    }
    orders_data = {
        'id': [1, 2],
        'customerId': [3, 1]
    }

    customers_df = pd.DataFrame(customers_data)
    orders_df = pd.DataFrame(orders_data)

    print("Customers 表:")
    print(customers_df)
    print("\nOrders 表:")
    print(orders_df)

    # 调用函数
    result = find_customers(customers_df, orders_df)

    print("\n从不订购的客户:")
    print(result)