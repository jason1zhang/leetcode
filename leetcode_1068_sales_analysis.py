"""
LeetCode 1068. Product Sales Analysis I
Pandas 解法 + 测试示例
"""

import pandas as pd

def sales_analysis(sales: pd.DataFrame, product: pd.DataFrame) -> pd.DataFrame:
    merged = sales.merge(product, on='product_id', how='left')
    return merged[['product_name', 'year', 'price']]

if __name__ == "__main__":
    # 示例数据
    sales_data = {
        'sale_id': [1, 2, 7],
        'product_id': [100, 100, 200],
        'year': [2008, 2009, 2011],
        'quantity': [10, 12, 15],
        'price': [5000, 5000, 9000]
    }
    product_data = {
        'product_id': [100, 200, 300],
        'product_name': ['Nokia', 'Apple', 'Samsung']
    }

    sales_df = pd.DataFrame(sales_data)
    product_df = pd.DataFrame(product_data)

    print("Sales 表:")
    print(sales_df)
    print("\nProduct 表:")
    print(product_df)

    result = sales_analysis(sales_df, product_df)

    print("\n输出结果:")
    print(result)