from flask import Flask, render_template, request, jsonify, redirect, url_for
from pymongo import MongoClient, collection
from bson.objectid import ObjectId
import requests

app = Flask(__name__)

client = MongoClient('mongodb+srv://sparta:1234@cluster0.aruhsct.mongodb.net/Cluster0?retryWrites=true&w=majority')
db = client.dbsparta

@app.route('/')
def home():
    return render_template('index.html')

@app.route("/data")
def data():
    url = "http://openapi.seoul.go.kr:8088/4a6a484f496c656f33336a5167796d/json/culturalEventInfo/1/500/"
    response = requests.get(url).json()['culturalEventInfo']['row']

    for row in response:
        doc = {
            'codename': row["CODENAME"],
            'title': row["TITLE"],
            'guname': row["GUNAME"],
            'main_img': row["MAIN_IMG"],
            'use_trgt': row["USE_TRGT"],
            'program': row["PROGRAM"]
        }
        db.seoul_data.insert_one(doc)

    return jsonify({'msg': 'db 저장 완료'})

@app.route("/search",methods=["POST"])
def search():

    codename_receive = request.form['codename_give']
    guname_receive = request.form['guname_give']

    if (codename_receive != "") and (guname_receive == ""):
        search_result = list(db.seoul_data.find({'codename': codename_receive}, {'_id': False}))
    elif (codename_receive == "") and (guname_receive != ""):
        search_result = list(db.seoul_data.find({'guname': guname_receive}, {'_id': False}))
    elif (codename_receive != "") and (guname_receive != ""):
        search_result = list(db.seoul_data.find({'codename': codename_receive, 'guname': guname_receive}, {'_id': False}))

    return jsonify({'search_result':search_result})

@app.route("/show")
def show():

    show_result = list(db.seoul_data.find())

    for result in show_result:
        result['_id'] = str(result['_id'])

    return jsonify({'show_result':show_result})

@app.route("/poster" ,methods=["POST"])
def getposter():

    id_receive = request.form['id_give']
    print(id_receive)

    id_result = db.seoul_data.find_one({'_id': ObjectId(id_receive)}, {'_id': False})
    print(id_result)

    return jsonify({'id_result': id_result})

# @app.route("/comments")
# def comment():
#     postnum_receive = request.args.get("postnum_give")
#     data = list(db.seoul_data.find({}, {'_id': False}))
#
#     return jsonify({'data_receive':data})

if __name__ == '__main__':
    app.run('0.0.0.0', port=5000, debug=True)

