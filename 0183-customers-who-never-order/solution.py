import pandas as pd

def find_customers(customers: pd.DataFrame, orders: pd.DataFrame) -> pd.DataFrame:
    non_ordering_customers = customers[~customers['id'].isin(orders['customerId'])]
    return non_ordering_customers[['name']].rename(columns={'name': 'Customers'})

    
