package service;

import entity.Orderinfo;

public interface OrderinfoService {
    int deleteByPrimaryKey(String username);
    Orderinfo selectByPrimary(String username);

    int insert(Orderinfo record);

    int insertSelective(Orderinfo record);
}
