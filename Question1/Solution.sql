-- I have imported the data from india_phoneno_not_null file into a SQLite database with smarte.sqlite
-- Please find below query to get the expected output

select City, State, Country, ('0'||CityCode) as CityCode, Records from
(select City, State, Country, substr(PhoneNo,0,3) as CityCode, count(*) as Records
from Phone_Records
group by City, CityCode
order by City asc, Records desc)
group by City
order by Country, State, City;