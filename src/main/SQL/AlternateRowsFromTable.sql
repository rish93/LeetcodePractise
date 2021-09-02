
--To fetch ALTERNATE records from a table (EVEN NUMBERED)

Select * from TableName where ColumnName % 2 = 0
For Eg : select * from HumanResources.Employee where BusinessEntityID % 2 = 0

--To fetch ALTERNATE records from a table (ODD NUMBERED)

Select * from TableName where ColumnName % 2 = 1
