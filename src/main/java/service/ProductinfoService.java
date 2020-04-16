package service;

import entity.Productinfo;

import java.util.List;

public interface ProductinfoService {
    int deleteByPrimaryKey(Integer pId);

    int insert(Productinfo record);

    int insertSelective(Productinfo record);
    List<Productinfo> getProductsByPtype(String pType);

    Productinfo selectByPrimaryKey(Integer pId);
    List<Productinfo> getPtype();
    int updateByPrimaryKeySelective(Productinfo record);

    int updateByPrimaryKey(Productinfo record);
}
