
db.createUser(
	{
		user: "root",
		pwd: "root",
		roles: [
			{
				role: "readWrite",
				db: "aggregationdata"
			}
		]
	}
)

db = db.getSiblingDB('aggregationdata')