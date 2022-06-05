package com.tstDak.service;

import java.util.List;

import com.tstDak.vo.TestVo;
 
public interface TestService {
	
    public List<TestVo> selectList_User();
    public TestVo selectOne_User(String userid);
    public int insert_User(TestVo vo);
    public int update_User(TestVo vo);
    public int delete_User(String userid);
    public boolean checkPassWd(String userid, String passwd);
    
}
