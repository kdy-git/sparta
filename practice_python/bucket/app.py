from flask import Flask, render_template, request, jsonify
app = Flask(__name__)

from pymongo import MongoClient
client = MongoClient('mongodb+srv://sparta:1234@cluster0.aruhsct.mongodb.net/Cluster0?retryWrites=true&w=majority')
db = client.dbsparta

@app.route('/')
def home():
    return render_template('index.html')

@app.route("/bucket", methods=["POST"])
def bucket_post():
    bucket_list = list(db.bucket.find({}, {'_id': False}))
    count = len(bucket_list) + 1

    bucket_receive = request.form['bucket_give']

    doc = {
        'num':count,
        'bucket':bucket_receive,
        'done':0
    }

    db.bucket.insert_one(doc)

    return jsonify({'msg': 'POST(기록) 연결 완료!'})

@app.route("/bucket/done", methods=["POST"])
def bucket_done():
    bucket_done_receive = request.form['bucket_done_give']

    db.bucket.update_one({'num':int(bucket_done_receive)}, {'$set': {'done': 1}})

    return jsonify({'msg': '버킷 완료!'})

@app.route("/bucket", methods=["GET"])
def bucket_get():

    bucket_list = list(db.bucket.find({}, {'_id': False}))

    return jsonify({'bucket_list': bucket_list})

if __name__ == '__main__':
    app.run('0.0.0.0', port=5000, debug=True)