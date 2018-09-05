# coding = utf-8
import requests
import os
from bs4 import BeautifulSoup


def get_url():
    url = "https://www.gushiwen.org/gushi/xiaoxue.aspx"
    res = requests.get(url)
    res.encoding = 'utf-8'
    soup = BeautifulSoup(res.text, "html.parser")
    list = []
    kinds = []
    for term in soup.findAll(class_="typecont"):
        kind = term.find('strong').get_text()
        for sp in term.findAll('span'):
            title = sp.find('a').get_text()
            link = sp.find('a')['href']
            author = sp.get_text()[len(title) + 1:-1]
            list.append(link)
            kinds.append(kind)
            # print(kind)
            # print(title)
            # print(link)
            # print(author)
    return list, kinds


def get_content(url, kind):
    if url == "https://so.gushiwen.org/shiwenv_5853b45b56b2.aspx":
        return "('山村咏怀','邵雍','一去二三里，烟村四五家。亭台六七座，八九十枝花。','到二三里远的地方，有四五个生着炊烟的人家。路过六七座亭台楼阁，周围有十几枝花。','一年级上册'," \
               "'https://so.gushiwen.org/shiwenv_5853b45b56b2.aspx') "
    res = requests.get(url)
    res.encoding = 'utf-8'
    soup = BeautifulSoup(res.text, "html.parser")
    print(url)
    title = soup.find('h1').get_text()

    author_tag = soup.find(class_="source").findAll('a')
    author = author_tag[1].get_text()

    content = soup.find(class_="contson").get_text().replace('\n', '')

    mean = soup.find(class_="contyishang").find('p').get_text().replace('\n', '')[2:]
    return "('" + title + "','" + author + "','" + content + "','" + mean + "','" + kind + "','" + url + "')"


def create_sql():
    sql = 'insert into primary_school_poem(title,author,content,mean,kind,url) values'
    values = []
    re = get_url()
    for index in range(len(re[0])):
        url = re[0][index]
        kind = re[1][index]
        values.append(get_content(url, kind))
    sql = sql + ','.join(values)
    return sql


last_sql = create_sql()
f = open('D:/桌面/Python/poem.sql', 'w', encoding='utf-8')
f.write(last_sql)
print(last_sql)
# print(get_content("https://so.gushiwen.org/shiwenv_5853b45b56b2.aspx", "一年级上册"))
