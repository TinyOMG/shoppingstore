package serviceimpl;

import entity.Productinfo;
import mapper.ProductinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ProductinfoService;

import java.util.List;

@Service
public class ProductinfoServiceImpl implements ProductinfoService {
    @Autowired
    ProductinfoMapper pim;


    @Override
    public int deleteByPrimaryKey(Integer pId) {
        return pim.deleteByPrimaryKey(pId);
    }

    @Override
    public int insert(Productinfo record) {
        return pim.insert(record);
    }

    @Override
    public int insertSelective(Productinfo record) {
        return pim.insertSelective(record);
    }

    @Override
    public List<Productinfo> getProductsByPtype(String pType) {
        return pim.getProductsByPtype(pType);
    }

    @Override
    public Productinfo selectByPrimaryKey(Integer pId) {
        return pim.selectByPrimaryKey(pId);
    }

    @Override
    public List<Productinfo> getPtype() {
        return pim.getPtype();
    }

    @Override
    public int updateByPrimaryKeySelective(Productinfo record) {
        return pim.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Productinfo record) {
        return pim.updateByPrimaryKey(record);
    }
}
