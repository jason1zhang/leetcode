import pandas as pd 

def game_analysis(activity: pd.DataFrame) -> pd.DataFrame:
    """
    返回每位玩家的第一次登录日期。
    """
    result = activity.groupby('player_id')['event_date'].min().reset_index()

    result.rename(columns={'event_date': 'first_login'}, inplace=True)

    return result

# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    # 创建示例 Activity 表
    data = {
        'player_id': [1, 1, 2, 3, 3],
        'device_id': [2, 2, 3, 1, 4],
        'event_date': ['2016-03-01', '2016-05-02', '2017-06-25', 
                       '2016-03-02', '2018-07-03'],
        'games_played': [5, 6, 1, 0, 5]
    }
    activity_df = pd.DataFrame(data)
    activity_df['event_date'] = pd.to_datetime(activity_df['event_date'])  # 转为日期类型
    
    print("输入 Activity 表：")
    print(activity_df)
    
    result_df = game_analysis(activity_df)
    
    print("\n输出（每位玩家第一次登录日期）：")
    print(result_df)