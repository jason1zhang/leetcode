import pandas as pd


def active_users(activity: pd.DataFrame) -> pd.DataFrame:
    """
    统计截至 2019-07-27（含）的近 30 天内，每天的活跃用户数。
    活跃定义：当天至少有一条活动记录（任意类型）。
    """
    activity['activity_date'] = pd.to_datetime(activity['activity_date'])

    end_date = pd.Timestamp('2019-07-27')
    start_date = end_date - pd.DateOffset(days=29)

    mask = (activity['activity_date'] >= start_date) & (activity['activity_date'] <= end_date)
    filtered = activity.loc[mask]

    if filtered.empty:
        return pd.DataFrame(columns=['day', 'active_users'])
    
    result = filtered.groupby('activity_date')['user_id'].nunique().reset_index()
    result.columns = ['day', 'active_users']

    return result

if __name__ == '__main__':
    # 构造示例数据
    data = {
        'user_id': [1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4],
        'session_id': [1, 1, 1, 4, 4, 4, 2, 2, 2, 3, 3],
        'activity_date': [
            '2019-07-20', '2019-07-20', '2019-07-20',
            '2019-07-20', '2019-07-21', '2019-07-21',
            '2019-07-21', '2019-07-21', '2019-07-21',
            '2019-06-25', '2019-06-25'   # 该日期超出窗口，应被过滤
        ],
        'activity_type': [
            'open_session', 'scroll_down', 'end_session',
            'open_session', 'send_message', 'end_session',
            'open_session', 'send_message', 'end_session',
            'open_session', 'end_session'
        ]
    }
    df = pd.DataFrame(data)
    
    print("输入表 Activity:")
    print(df)
    print("\n查询结果:")
    result = active_users(df)
    print(result)
    
    # 简单断言验证
    assert len(result) == 2, f"预期 2 天，实际 {len(result)} 天"
    # 核对具体日期和人数
    expected_dates = {'2019-07-20', '2019-07-21'}
    result_dates = set(result['day'].dt.strftime('%Y-%m-%d'))
    assert result_dates == expected_dates, f"日期不符: {result_dates}"
    
    # 检查每天活跃用户数
    for _, row in result.iterrows():
        day_str = row['day'].strftime('%Y-%m-%d')
        if day_str == '2019-07-20':
            assert row['active_users'] == 2
        elif day_str == '2019-07-21':
            assert row['active_users'] == 2
        else:
            raise AssertionError(f"意外日期: {day_str}")
    
    print("\n✅ 所有测试通过！")