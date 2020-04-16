package entity;

public class Orderdetail {
    private Integer odId;

    private String username;

    private Integer pId;

    private String orderbh;

    private String ordertime;

    private String pName;

    private Double pPrice;

    private Integer odNum;

    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getOrderbh() {
        return orderbh;
    }

    public void setOrderbh(String orderbh) {
        this.orderbh = orderbh == null ? null : orderbh.trim();
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime == null ? null : ordertime.trim();
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public Double getpPrice() {
        return pPrice;
    }

    public void setpPrice(Double pPrice) {
        this.pPrice = pPrice;
    }

    public Integer getOdNum() {
        return odNum;
    }

    public void setOdNum(Integer odNum) {
        this.odNum = odNum;
    }
}