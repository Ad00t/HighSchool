from common import *
from bs4 import BeautifulSoup as bs
import urllib.parse as parse
import urllib.request as request
import moss
import os
import json

config = json.loads(open('config.json', 'r').read())

def main():
    br = login(config)

    student_emails = []
    with open('students.txt') as file:
        for line in file:
            if line != '' and line != '\n':
                student_emails.append(parse.quote(line[:-1]))

    if not os.path.exists('submissions'):
        os.makedirs('submissions')

    print('Downloading submissions...')
    start = config['start']
    for p in range (3, 7):
        for j in range(start, start + config['n'][str(p)]):
            download_submission(br, student_emails[j], p)
        start += config['n'][str(p)]

def download_submission(br, email, p):
    url_host = 'https://hypergrade.com'
    url = url_host + '/approve.php?u=' + email + '&i=' + config['i'][str(p)]
    download_hrefs = bs(br.open(url), 'html5lib').find_all(lambda tag: tag.name == 'a'
                                                           and tag.get('download') == '')
    
    if len(download_hrefs) > 0:
        try:
            download_url = url_host + download_hrefs[0].get('href')
            filepath = 'submissions/' + email + '.java'
            br.retrieve(download_url, filepath)[0]
        except Exception as e:
            print(e)
    else:
        print('No code for ' + email + ', Period ' + str(p))

if __name__ == '__main__':
    main()
    moss.main()