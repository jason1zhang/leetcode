"""
LeetCode 1070. Product Sales Analysis III
Pandas 解法 + 测试示例
"""

import pandas as pd

def sales_analysis (sales: pd.DataFrame) -> pd.DataFrame:
    first_year = sales.groupby('product_id')['year'].min().reset_index()
    first_year.columns = ['product_id', 'first_year']

    merged = sales.merge(first_year, on='product_id')
    result = merged[merged['year'] == merged['first_year']]

    return result[['product_id', 'first_year', 'quantity', 'price']]

if __name__ == "__main__":
    # 示例数据
    sales_data = {
        'sale_id': [1, 2, 7],
        'product_id': [100, 100, 200],
        'year': [2008, 2009, 2011],
        'quantity': [10, 12, 15],
        'price': [5000, 5000, 9000]
    }
    df = pd.DataFrame(sales_data)
    print("Sales 表:")
    print(df)
    
    result = sales_analysis(df)
    print("\n输出结果:")
    print(result)