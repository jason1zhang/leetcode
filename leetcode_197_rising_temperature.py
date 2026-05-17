import pandas as pd

def rising_temperature(weather: pd.DataFrame) -> pd.DataFrame:
    """
    Returns the ids of rows where the temperature is higher than the previous day's temperature.
    The previous day is defined as exactly one calendar day earlier.
    """
    # Sort by date to compare with previous row
    weather_sorted = weather.sort_values('recordDate').copy()

    weather_sorted['prev_temp'] = weather_sorted['temperature'].shift(1)
    weather_sorted['prev_date'] = weather_sorted['recordDate'].shift(1)

    mask = (weather_sorted['recordDate'] - weather_sorted['prev_date']).dt.days == 1
    mask &= weather_sorted['temperature'] > weather_sorted['prev_temp']

    result = weather_sorted.loc[mask, ['id']]
    return result

if __name__ == "__main__":
    # Test with sample data from LeetCode #197
    data = {
        'id': [1, 2, 3, 4],
        'recordDate': ['2015-01-01', '2015-01-02', '2015-01-03', '2015-01-04'],
        'temperature': [10, 25, 20, 30]
    }
    weather_df = pd.DataFrame(data)
    weather_df['recordDate'] = pd.to_datetime(weather_df['recordDate'])  # ensure datetime
    
    print("Input DataFrame:")
    print(weather_df)
    print("\nResult (ids with temperature > previous day):")
    result_df = rising_temperature(weather_df)
    print(result_df)
    
    # Expected output: id 2 (2015-01-02, 25 > 10) and id 4 (2015-01-04, 30 > 20)
    # So result should be:
    #    id
    # 1   2
    # 3   4