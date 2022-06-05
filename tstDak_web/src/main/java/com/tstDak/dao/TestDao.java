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
 
//현재 클래스를 스프링에서 관리하는 dao bean으로 설정
@Repository
public class TestDao {
	private Logger logger = LogManager.getLogger(this.getClass());
	
    //mybatis의 SqlSession 객체를 스프링에서 주입시킴
    //의존관계 주입 느슨한 결합, 제어의 역전
    //@Inject 어노테이션이 있어 sqlSession은 null상태가 아닌 외부에서 객체를 주입받는 형태가 된다.
    @Inject
    SqlSession sqlSession;

    //레코드 1개 :selectOne(), 2개 이상 : selectList()
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
        //mapper에 2개 이상의 자료를 전달할 때 : map, vo 사용
        Map<String,String> map = new HashMap<String,String>();
        map.put("id", userid);
        map.put("passwd", passwd);
        int count=sqlSession.selectOne("com.tstDak.TestMapper.select_PWCHK_01", map);
        if(count==1) result=true;
        return result;
    }
 
}