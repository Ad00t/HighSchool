import mosspy
import json
import os

config = json.loads(open('config.json', 'r').read())

def main():
    m = mosspy.Moss(config['mossid'], 'java')

    print('Adding submissions to MOSS...')
    counter = 0
    for filename in os.listdir('submissions'):
        filepath = 'submissions/' + filename
        if os.stat(filepath).st_size > 0:
            m.addFile(filepath)
            counter += 1
    print(str(counter) + ' submissions loaded')

    print('Creating MOSS report...')
    url = m.send()
    print("Report URL: " + url)

if __name__ == "__main__":
    main()
