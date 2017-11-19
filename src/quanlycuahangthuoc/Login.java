/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlycuahangthuoc;

/**
 *
 * @author Admin
 */
public class Login {
    private String id,pass;

    public Login() {
        id="admin";
        pass="minda";
    }

    public Login(String id, String pass) {
        this.id = id;
        this.pass = pass;
    }

    @Override
    public String toString() {
        return id+pass; //To change body of generated methods, choose Tools | Templates.
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
