package serviceimpl;

import entity.Orderinfo;
import mapper.OrderinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.OrderinfoService;

@Service
public class OrderinfoServiceImpl implements OrderinfoService {
    @Autowired
    OrderinfoMapper oim;


    @Override
    public int deleteByPrimaryKey(String username) {
        return oim.deleteByPrimaryKey(username);
    }

    @Override
    public Orderinfo selectByPrimary(String username) {
        return oim.selectByPrimary(username);
    }

    @Override
    public int insert(Orderinfo record) {
        return oim.insert(record);
    }

    @Override
    public int insertSelective(Orderinfo record) {
        return oim.insertSelective(record);
    }
}
