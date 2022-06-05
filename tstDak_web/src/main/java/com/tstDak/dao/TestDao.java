package com.tstDak.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
 
import com.tstDak.vo.TestVo;
 
//���� Ŭ������ ���������� �����ϴ� dao bean���� ����
@Repository
public class TestDao {
    //mybatis�� SqlSession ��ü�� ���������� ���Խ�Ŵ
    //�������� ���� ������ ����, ������ ����
    //@Inject ������̼��� �־� sqlSession�� null���°� �ƴ� �ܺο��� ��ü�� ���Թ޴� ���°� �ȴ�.
    @Inject
    SqlSession sqlSession;

    //���ڵ� 1�� :selectOne(), 2�� �̻� : selectList()
    public List<TestVo> selectList_User() {
        return sqlSession.selectList("com.tstDak.TestMapper.selectN_TBTST001");
    }

    public TestVo selectOne_User(String userid) { 
        return sqlSession.selectOne("com.tstDak.TestMapper.selectN_TBTST001", userid);
    }

    //auto commit, auto close
    public void insert_User(TestVo dto) {
        sqlSession.insert("com.tstDak.TestMapper.selectN_TBTST001", dto);
    }
    
    public void update_User(TestVo dto) {
        sqlSession.update("com.tstDak.TestMapper.updateK_TBTST001", dto); 
    }

    public void delete_User(String userid) {
        sqlSession.delete("com.tstDak.TestMapper.deleteK_TBTST001", userid); 
    }
    
    public boolean checkPw(String userid, String passwd) {
        boolean result=false;
        //mapper�� 2�� �̻��� �ڷḦ ������ �� : map, dto ���
        Map<String,String> map = new HashMap<String,String>();
        map.put("id", userid);
        map.put("passwd", passwd);
        int count=sqlSession.selectOne("com.tstDak.TestMapper.select_PWCHK_01", map);
        if(count==1) result=true;
        return result;
    }
 
}