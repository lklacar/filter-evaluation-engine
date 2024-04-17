select *
from test
WHERE ((NOT (name LIKE '%John%')) AND (NOT (age > 100)))
