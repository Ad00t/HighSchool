from common import *
from bs4 import BeautifulSoup as bs
import requests
import json

config = json.loads(open('config.json', 'r').read())

def main():
    print('Logging in...')
    br = login(config)

    print('Opening students list...')
    br.open('https://hypergrade.com/student')
    soup = bs(br.read())
    users = soup.find_all("td", {'class': 'username'})

    print('Retrieving ' + len(users) + ' students...')
    file = open('students.txt', 'w')
    for user in users:
        file.write(user.string + "\n")

if __name__ == '__main__':
    main()