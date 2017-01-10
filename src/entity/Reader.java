package entity;

/**
 * Created by yanfeng-mac on 2017/1/4.
 */
public class Reader {
    private String rno;
    private String rname;
    private String rgender;
    private String rage;
    private String rspecialty;
    private String rpassword;

    public String getRno() {
        return rno;
    }

    public void setRno(String rno) {
        this.rno = rno;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRgender() {
        return rgender;
    }

    public void setRgender(String rgender) {
        this.rgender = rgender;
    }

    public String getRage() {
        return rage;
    }

    public void setRage(String rage) {
        this.rage = rage;
    }

    public String getRspecialty() {
        return rspecialty;
    }

    public void setRspecialty(String rspecialty) {
        this.rspecialty = rspecialty;
    }

    public String getRpassword() {
        return rpassword;
    }

    public void setRpassword(String rpassword) {
        this.rpassword = rpassword;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "rno='" + rno + '\'' +
                ", rname='" + rname + '\'' +
                ", rgender='" + rgender + '\'' +
                ", rage='" + rage + '\'' +
                ", rspecilty='" + rspecialty + '\'' +
                ", rpassword='" + rpassword + '\'' +
                '}';
    }
}
