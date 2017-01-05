package entity;

/**
 * Created by yanfeng-mac on 2017/1/5.
 */
public class CurrentBorrow {
    private String rno;
    private String bisbn;
    private String bname;
    private Integer bnum;

    public String getRno() {
        return rno;
    }

    public void setRno(String rno) {
        this.rno = rno;
    }

    public String getBisbn() {
        return bisbn;
    }

    public void setBisbn(String bisbn) {
        this.bisbn = bisbn;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Integer getBnum() {
        return bnum;
    }

    public void setBnum(Integer bnum) {
        this.bnum = bnum;
    }

    @Override
    public String toString() {
        return "CurrentBorrow{" +
                "rno='" + rno + '\'' +
                ", bisbn='" + bisbn + '\'' +
                ", bname='" + bname + '\'' +
                ", bnum=" + bnum +
                '}';
    }
}
