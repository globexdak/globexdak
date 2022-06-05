package com.tstDak.service;

import java.util.List;
import javax.inject.Inject;
 
import org.springframework.stereotype.Service;
 
import com.tstDak.dao.TestDao;
import com.tstDak.vo.TestVo;
 
//���� Ŭ������ ���������� �����ϴ� service bean���� ����
@Service
public class TestServiceImpl implements TestService {
    //dao �ν��Ͻ��� ���Խ�Ŵ
    @Inject
    TestDao testDao;

    @Override
    public List<TestVo> selectList_User() {
        return testDao.selectList_User();
    }

    @Override
    public TestVo selectOne_User(String userid) {
        return testDao.selectOne_User(userid);
    }
    
    @Override
    public int insert_User(TestVo vo) {
    	return testDao.insert_User(vo);
    }

    @Override
    public int update_User(TestVo vo) {
    	return testDao.update_User(vo); 
    }
    
    @Override
    public int delete_User(String userid) {
    	return testDao.delete_User(userid); 
    }

    @Override
    public boolean checkPassWd(String userid, String passwd) {
        return testDao.checkPassWd(userid, passwd); 
    }
}