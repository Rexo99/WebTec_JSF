
package de.hsh.steam.resources;

/**
 *
 * @author dunkel
 */

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginData {
    private String username;
    private String pwd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
