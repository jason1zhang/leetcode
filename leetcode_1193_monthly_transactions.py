"""
LeetCode 1193. Monthly Transactions I
Pandas 完整解决方案
"""

import pandas as pd

def monthly_transactions(transactions: pd.DataFrame) -> pd.DataFrame:
    """
    计算每月每个国家的交易统计信息。
    
    参数:
        transactions: 包含列 'id', 'country', 'state', 'amount', 'trans_date'
    
    返回:
        包含列 'month', 'country', 'trans_count', 'approved_count',
        'trans_total_amount', 'approved_total_amount' 的 DataFrame
    """
    transactions = transactions.copy()
    transactions['month'] = transactions['trans_date'].dt.strftime('%Y-%m')

    transactions['approved_amount'] = transactions.apply(
        lambda row: row['amount'] if row['state'] == 'approved' else 0
        ,axis = 1
    )

    result = transactions.groupby(['month', 'country'], as_index=False).agg(
        trans_count = ('id', 'count')
        ,approved_count = ('state', lambda x: (x == 'approved').sum())
        ,trans_total_amount = ('amount', 'sum')
        ,approved_total_amount = ('approved_amount', 'sum')
    )

    return result

# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    # 构造示例数据
    data = {
        'id': [121, 122, 123, 124],
        'country': ['US', 'US', 'US', 'DE'],
        'state': ['approved', 'declined', 'approved', 'approved'],
        'amount': [1000, 2000, 2000, 2000],
        'trans_date': pd.to_datetime(['2018-12-18', '2018-12-19', '2019-01-01', '2019-01-07'])
    }
    transactions_df = pd.DataFrame(data)
    
    print("原始 Transactions 表:")
    print(transactions_df)
    print("\n" + "="*60 + "\n")
    
    # 调用函数
    result = monthly_transactions(transactions_df)
    
    print("统计结果:")
    print(result)