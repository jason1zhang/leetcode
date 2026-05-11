import pandas as pd

def article_views(views: pd.DataFrame) -> pd.DataFrame:
    """
    返回所有浏览过自己文章的作者 ID，去重并按升序排列。
    """
    filtered = views[views['author_id'] == views['viewer_id']]

    result = filtered[['author_id']].drop_duplicates().sort_values('author_id')

    return result.rename(columns={'author_id': 'id'})


# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    # 创建示例数据
    data = {
        'article_id': [1, 1, 2, 2, 4, 3, 3],
        'author_id':  [3, 3, 7, 7, 7, 4, 4],
        'viewer_id':  [5, 6, 7, 6, 1, 4, 4],
        'view_date':  ['2019-08-01', '2019-08-02', '2019-08-01', 
                       '2019-08-02', '2019-07-22', '2019-07-21', '2019-07-21']
    }
    views_df = pd.DataFrame(data)
    
    print("输入 Views 表：")
    print(views_df)
    
    result_df = article_views(views_df)
    
    print("\n输出（浏览过自己文章的作者）：")
    print(result_df)