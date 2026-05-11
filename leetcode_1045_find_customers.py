"""
LeetCode 1045. Customers Who Bought All Products
Pandas 解法 + 测试用例
"""

import pandas as pd

def find_customers(customer: pd.DataFrame, product: pd.DataFrame) -> pd.DataFrame:
    """
    返回购买了所有产品的客户 ID。

    参数:
        customer: Customer 表，包含 customer_id, product_key 列
        product: Product 表，包含 product_key 列

    返回:
        包含一列 customer_id 的 DataFrame，这些客户购买了 Product 表中的所有产品
    """
    total_product = len(product)
    customer_counts = customer.groupby('customer_id')['product_key'].nunique()
    valid_ids = customer_counts[customer_counts == total_product].index.tolist()
    
    return pd.DataFrame({'customer_id': valid_ids})

if __name__ == "__main__":
    # 示例数据
    customer_data = {
        'customer_id': [1, 2, 3, 3, 1],
        'product_key': [5, 6, 5, 6, 6]
    }
    product_data = {
        'product_key': [5, 6]
    }
    
    customer_df = pd.DataFrame(customer_data)
    product_df = pd.DataFrame(product_data)
    
    print("Customer 表:")
    print(customer_df)
    print("\nProduct 表:")
    print(product_df)
    
    result = find_customers(customer_df, product_df)
    
    print("\n输出结果:")
    print(result)