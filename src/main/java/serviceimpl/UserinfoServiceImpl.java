package serviceimpl;

import entity.Userinfo;
import mapper.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserinfoService;

@Service
public class UserinfoServiceImpl implements UserinfoService {

    @Autowired
    UserinfoMapper uim;
    @Override
    public int deleteByPrimaryKey(Integer uId) {
        return uim.deleteByPrimaryKey(uId);
    }

    @Override
    public int insert(Userinfo record) {
        return uim.insert(record);
    }

    @Override
    public int insertSelective(Userinfo record) {
        return uim.insertSelective(record);
    }

    @Override
    public Userinfo selectByPrimaryKey(Integer uId) {
        return uim.selectByPrimaryKey(uId);
    }

    @Override
    public Userinfo selectByUsername(String name) {
        return uim.selectByUsername(name);
    }

    @Override
    public int updateByPrimaryKeySelective(Userinfo record) {
        return uim.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Userinfo record) {
        return uim.updateByPrimaryKey(record);
    }
}
