import pandas as pd

def find_classes(courses: pd.DataFrame) -> pd.DataFrame:
    count = courses['class'].value_counts()
    result = pd.DataFrame(count[count>=5].index)
    return result

    
