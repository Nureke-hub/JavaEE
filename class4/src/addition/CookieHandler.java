package addition;

import javax.servlet.http.Cookie;

public class CookieHandler {
    private Cookie[] cookies;

    public CookieHandler(Cookie [] cookies) {
        this.cookies = cookies;
    }

    public String getCookie(String value){
        for (Cookie c : cookies){
            if(c.getName().equals(value)){
                return c.getValue();
            }
        }
        return null;
    }

    public Cookie setCookie(String name, String value){
        return new Cookie(name, value);
    }

}
