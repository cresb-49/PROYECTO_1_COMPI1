package com.carlos.web_proyecto1.Objetos;

public class userNew extends usuario{
    private String newUser;
    private String newPass;

    public userNew() {
    }

    public userNew(String newUser, String newPass, String fechaMod) {
        this.newUser = newUser;
        this.newPass = newPass;
        this.setFechaMod(fechaMod);
    }

    public userNew(String newUser, String newPass, String fechaMod, String user, String pass) {
        super(user, pass,"");
        this.newUser = newUser;
        this.newPass = newPass;
        this.setFechaMod(fechaMod);
    }

    public String getNewUser() {
        return newUser;
    }

    public void setNewUser(String newUser) {
        this.newUser = newUser;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    @Override
    public String toString() {
        return "userNew{" + "newUser=" + newUser + ", newPass=" + newPass + ", fechaMod=" + this.getFechaMod() +", user="+this.getUser()+", pass"+this.getPass() +", accion="+this.getAccion()+'}';
    }

    
}
