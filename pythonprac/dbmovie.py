from pymongo import MongoClient

client = MongoClient('mongodb+srv://sparta:1234@cluster0.aruhsct.mongodb.net/Cluster0?retryWrites=true&w=majority')
db = client.dbsparta

movie = db.movies.find_one({'title': '가버나움'})['star']

movie2 = list(db.movies.find({'star':movie}))

for movie3 in movie2:
    print(movie3['title'])

db.movies.update_one({'title': '가버나움'},{'$set':{'star':'0'}})