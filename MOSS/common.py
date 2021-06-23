import mechanize
import http.cookiejar as cookie

def login(config):
    cj = cookie.CookieJar()
    br = mechanize.Browser()
    br.set_cookiejar(cj)
    br.open('https://hypergrade.com/login-old')

    br.select_form(nr=0)
    br.form['email'] = config['login']['email']
    br.form['pwd'] = config['login']['pwd']

    res = br.submit()
    if (res.code == 200):
        print('Successfully logged in as ' + config['login']['email'])
    else:
        print('Login unsuccessful: ' + res)

    return br