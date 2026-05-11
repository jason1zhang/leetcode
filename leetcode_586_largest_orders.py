"""
LeetCode 586. Customer Placing the Largest Number of Orders
Pandas 解法 + 测试示例
"""

import pandas as pd

def largest_orders(orders: pd.DataFrame) -> pd.DataFrame:
    counts = orders['customer_number'].value_counts()

    max_count = counts.max()
    result = counts[counts == max_count].index.tolist()

    return pd.DataFrame({'customer_number': result})

if __name__ == "__main__":
    # 示例数据
    orders_data = {
        'order_number': [1, 2, 3, 4],
        'customer_number': [1, 2, 3, 3]
    }
    orders_df = pd.DataFrame(orders_data)
    print("Orders 表:")
    print(orders_df)
    
    result = largest_orders(orders_df)
    print("\n订单最多的客户:")
    print(result)