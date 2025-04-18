import pandas as pd

def department_highest_salary(employee: pd.DataFrame, department: pd.DataFrame) -> pd.DataFrame:
# Rename department table columns for merging
    department = department.rename(columns={'id': 'departmentId', 'name': 'Department'})

# Merge the Employee and Department DataFrames
    merged_df = pd.merge(employee, department, on='departmentId')

# Find the maximum salary for each department
    max_salaries = merged_df.groupby('Department')['salary'].max().reset_index()
    max_salaries = max_salaries.rename(columns={'salary': 'MaxSalary'})

# Merge again to filter employees with the maximum salary in their department
    result = pd.merge(merged_df, max_salaries, on='Department')

# Select the desired columns and filter where employee salary equals the department's max salary
    final_result = result[result['salary'] == result['MaxSalary']][['Department', 'name', 'salary']]
    final_result = final_result.rename(columns={'name': 'Employee', 'salary': 'Salary'})

    return final_result
