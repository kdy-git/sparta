from flask import Flask, render_template
import requests


app = Flask(__name__)


@app.route('/')
def main():
    return render_template("index.html")


@app.route('/detail/<keyword>')
def detail(keyword):
    r = requests.get(f"https://owlbot.info/api/v4/dictionary/{keyword}", headers={"Authorization": "Token e2a96a8c6470a1801f0a165e5030f63434356c7b"})
    result = r.json()
    print(result)
    return render_template("detail.html", word=keyword)


if __name__ == '__main__':
    app.run('0.0.0.0', port=5000, debug=True)