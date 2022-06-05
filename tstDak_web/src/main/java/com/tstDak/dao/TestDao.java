package com.tstDak.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
 
import com.tstDak.vo.TestVo;
 
//���� Ŭ������ ���������� �����ϴ� dao bean���� ����
@Repository
public class TestDao {
	private Logger logger = LogManager.getLogger(this.getClass());
	
    //mybatis�� SqlSession ��ü�� ���������� ���Խ�Ŵ
    //�������� ���� ������ ����, ������ ����
    //@Inject ������̼��� �־� sqlSession�� null���°� �ƴ� �ܺο��� ��ü�� ���Թ޴� ���°� �ȴ�.
    @Inject
    SqlSession sqlSession;

    //���ڵ� 1�� :selectOne(), 2�� �̻� : selectList()
    public List<TestVo> selectList_User() {
    	logger.info("Welcome to TestService!");
        return sqlSession.selectList("com.tstDak.TestMapper.selectN_TBTST001");
    }

    public TestVo selectOne_User(String id) { 
        return sqlSession.selectOne("com.tstDak.TestMapper.selectK_TBTST001", id);
    }

    //auto commit, auto close
    public int insert_User(TestVo vo) {
    	return sqlSession.insert("com.tstDak.TestMapper.insertK_TBTST001", vo);
    }
    
    public int update_User(TestVo vo) {
    	return sqlSession.update("com.tstDak.TestMapper.updateK_TBTST001", vo); 
    }

    public int delete_User(String id) {
    	return sqlSession.delete("com.tstDak.TestMapper.deleteK_TBTST001", id); 
    }
    
    public boolean checkPassWd(String userid, String passwd) {
        boolean result=false;
        //mapper�� 2�� �̻��� �ڷḦ ������ �� : map, vo ���
        Map<String,String> map = new HashMap<String,String>();
        map.put("id", userid);
        map.put("passwd", passwd);
        int count=sqlSession.selectOne("com.tstDak.TestMapper.select_PWCHK_01", map);
        if(count==1) result=true;
        return result;
    }
 
}