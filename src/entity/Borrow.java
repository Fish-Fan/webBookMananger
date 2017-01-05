package entity;

/**
 * Created by yanfeng-mac on 2017/1/4.
 */
public class Borrow {
    private String rno;
    private String bisbn;
    private String bname;
    private String startdate;
    private String enddate;
    private Float fine;
    private Integer ispay;

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

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public Float getFine() {
        return fine;
    }

    public void setFine(Float fine) {
        this.fine = fine;
    }

    public Integer getIspay() {
        return ispay;
    }

    public void setIspay(Integer ispay) {
        this.ispay = ispay;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "rno='" + rno + '\'' +
                ", bisbn='" + bisbn + '\'' +
                ", bname='" + bname + '\'' +
                ", startdate='" + startdate + '\'' +
                ", enddate='" + enddate + '\'' +
                ", fine=" + fine +
                ", ispay=" + ispay +
                '}';
    }
}
