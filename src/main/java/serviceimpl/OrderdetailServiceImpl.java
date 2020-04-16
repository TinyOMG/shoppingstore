package serviceimpl;

import entity.Orderdetail;
import mapper.OrderdetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.OrderdetailService;

@Service
public class OrderdetailServiceImpl implements OrderdetailService {
    @Autowired
    OrderdetailMapper otm;

    @Override
    public int deleteByPrimaryKey(Integer odId) {
        return otm.deleteByPrimaryKey(odId);
    }

    @Override
    public int insert(Orderdetail record) {
        return otm.insert(record);
    }

    @Override
    public int insertSelective(Orderdetail record) {
        return otm.insertSelective(record);
    }

    @Override
    public Orderdetail selectByPrimaryKey(Integer odId) {
        return otm.selectByPrimaryKey(odId);

    }

    @Override
    public int updateByPrimaryKeySelective(Orderdetail record) {
        return otm.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Orderdetail record) {
        return otm.updateByPrimaryKey(record);
    }
}
