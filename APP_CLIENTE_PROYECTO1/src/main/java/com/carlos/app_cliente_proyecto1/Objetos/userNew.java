package com.carlos.app_cliente_proyecto1.Objetos;

public class userNew extends usuario{
    private String newUser;
    private String newPass;
    private String fechaMod;

    public userNew() {
    }

    public userNew(String newUser, String newPass, String fechaMod) {
        this.newUser = newUser;
        this.newPass = newPass;
        this.fechaMod = fechaMod;
    }

    public userNew(String newUser, String newPass, String fechaMod, String user, String pass) {
        super(user, pass,"");
        this.newUser = newUser;
        this.newPass = newPass;
        this.fechaMod = fechaMod;
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

    public String getFechaMod() {
        return fechaMod;
    }

    public void setFechaMod(String fecha) {
        this.fechaMod = fecha;
    }

    @Override
    public String toString() {
        return "userNew{" + "newUser=" + newUser + ", newPass=" + newPass + ", fechaMod=" + fechaMod +", user="+this.getUser()+", pass"+this.getPass() +'}';
    }

    
}
