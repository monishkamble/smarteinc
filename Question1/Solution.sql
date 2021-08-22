select City, State, Country, ('0'||CityCode) as CityCode, Records from
(select City, State, Country, substr(PhoneNo,0,3) as CityCode, count(*) as Records
from Phone_Records
group by City, CityCode
order by City asc, Records desc)
group by City
order by Country, State, City;