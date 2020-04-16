package entity;

public class WebInfo {
    private Integer id;
    private String visittime;
    private Integer visittimes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVisittime() {
        return visittime;
    }

    public void setVisittime(String visittime) {
        this.visittime = visittime;
    }

    public Integer getVisittimes() {
        return visittimes;
    }

    public void setVisittimes(Integer visittimes) {
        this.visittimes = visittimes;
    }

    @Override
    public String toString() {
        return "WebInfo{" +
                "id=" + id +
                ", visittime='" + visittime + '\'' +
                ", visittimes=" + visittimes +
                '}';
    }
}
