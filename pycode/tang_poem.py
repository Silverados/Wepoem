# coding = utf-8
import requests
import os
from bs4 import BeautifulSoup


def get_url():
    url = "https://so.gushiwen.org/gushi/tangshi.aspx"
    res = requests.get(url)
    res.encoding = 'utf-8'
    soup = BeautifulSoup(res.text, "html.parser")
    list = []
    kinds = []
    for term in soup.findAll(class_="typecont"):
        for sp in term.findAll('span'):
            title = sp.find('a').get_text()
            link = sp.find('a')['href']
            author = sp.get_text()[len(title) + 1:-1]
            list.append("https://so.gushiwen.org"+link)
            # print(kind)
            # print(title)
            # print(link)
            # print(author)
    return list


count = 0


def get_content(url):
    if count == 140:
        print(url)
    res = requests.get(url)
    res.encoding = 'utf-8'
    soup = BeautifulSoup(res.text, "html.parser")
    title = soup.find('h1').get_text()

    author_tag = soup.find(class_="source").findAll('a')
    author = author_tag[1].get_text()

    content = soup.find(class_="contson").get_text().replace('\n', '')

    mean = soup.find(class_="contyishang").find('p').get_text().replace('\n', '')[2:]
    return "('" + title + "','" + author + "','" + content + "','" + mean + "','" + url + "')"


def create_sql():
    sql = 'insert into tang_poem(title,author,content,mean,url) values'
    values = []
    re = get_url()
    for url in re:
        values.append(get_content(url))
    sql = sql + ',\n'.join(values)
    return sql


last_sql = create_sql()
f = open('D:/桌面/Python/tang_poem.sql', 'w', encoding='utf-8')
f.write(last_sql)
print(last_sql)

# print(get_content("https://so.gushiwen.org/shiwenv_e2890c61279c.aspx", 0))