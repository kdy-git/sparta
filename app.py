from flask import Flask, render_template, request, jsonify, redirect, url_for
from pymongo import MongoClient
import requests

app = Flask(__name__)

client = MongoClient('mongodb+srv://leo4902:wnwkd0919!@cluster0.57geb.mongodb.net/Cluster0?retryWrites=true&w=majority')
db = client.dbsparta

@app.route('/')
def home():
    return render_template('index.html')

# @app.route("/data")
# def data():
#     url = "http://openapi.seoul.go.kr:8088/4a6a484f496c656f33336a5167796d/json/culturalEventInfo/1/500/"
#     response = requests.get(url).json()['culturalEventInfo']['row']
#
#     for row in response:
#         doc = {
#             'codename': row["CODENAME"],
#             'title': row["TITLE"],
#             'guname': row["GUNAME"],
#             'main_img': row["MAIN_IMG"],
#             'use_trgt': row["USE_TRGT"],
#             'program': row["PROGRAM"]
#         }
#         db.seoul_data.insert_one(doc)
#
#     return jsonify({'msg': 'db 저장 완료'})

@app.route("/search",methods=["POST"])
def search():

    codename_receive = request.form['codename_give']
    guname_receive = request.form['guname_give']

    print(guname_receive)

    searching_result = list(db.seoul_data.find({'codename':codename_receive, 'guname':guname_receive},{'_id':False}))

    return jsonify({'search_result':searching_result})

@app.route("/show")
def show():

    show_result = list(db.seoul_data.find({},{'_id':False}))

    return jsonify({'show_result':show_result})

if __name__ == '__main__':
    app.run('0.0.0.0', port=5000, debug=True)

