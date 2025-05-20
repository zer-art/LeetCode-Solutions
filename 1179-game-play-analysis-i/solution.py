import pandas as pd

def game_analysis(activity: pd.DataFrame) -> pd.DataFrame:
    activity.event_date = pd.to_datetime(activity.event_date)
    output = activity.groupby('player_id')['event_date'].min().reset_index()
    output.rename(columns = { 'event_date' : 'first_login'} , inplace = True)
    return output
    
