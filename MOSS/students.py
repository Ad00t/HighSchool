from common import *
from bs4 import BeautifulSoup as bs
import requests
import json

config = json.loads(open('config.json', 'r').read())

def main():
    br = login(config)

    soup = bs(br.open('https://hypergrade.com/student'), 'html5lib')
    users = soup.find_all("td", {'class': 'username'})

    print('Retrieving students...')
    file = open('students.txt', 'w')
    for user in users:
        file.write(user.string + "\n")

if __name__ == '__main__':
    main()