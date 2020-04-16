package mapper;

import entity.Productinfo;

import java.util.List;

public interface ProductinfoMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Productinfo record);

    int insertSelective(Productinfo record);

    Productinfo selectByPrimaryKey(Integer pId);
    List<Productinfo> getProductsByPtype(String pType);
    List<Productinfo> getPtype();
    int updateByPrimaryKeySelective(Productinfo record);

    int updateByPrimaryKey(Productinfo record);
}