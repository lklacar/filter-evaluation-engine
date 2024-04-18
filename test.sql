select *
from test
WHERE (((NOT (name LIKE '%John%')) AND (NOT (age > 100))) AND (city = 'New York' OR city = 'Los Angeles'))


WHERE ((name = 'John' AND age = 25) AND city = 'New York')
