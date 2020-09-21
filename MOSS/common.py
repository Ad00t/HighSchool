import mechanize
import http.cookiejar as cookie

def login(config):
    cj = cookie.CookieJar()
    br = mechanize.Browser()
    br.set_cookiejar(cj)
    url = "https://hypergrade.com/student"

    br.open(url)

    br.select_form(nr=0)
    br.form['email'] = config['login']['email']
    br.form['pwd'] = config['login']['pwd']
    br.submit()

    return br