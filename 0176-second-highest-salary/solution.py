import pandas as pd

def second_highest_salary(employee: pd.DataFrame) -> pd.DataFrame:
    unique_salary = employee['salary'].sort_values(ascending=False).unique()

    if len(unique_salary) >= 2:
        second_highest = unique_salary[1]
        data = pd.DataFrame({
            'SecondHighestSalary': [second_highest]
        })
        return data
    else:
        data = pd.DataFrame({
            'SecondHighestSalary': [None]
        })
        return data
