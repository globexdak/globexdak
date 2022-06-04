package com.dak.tst.batch;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.ibatis.session.SqlSession;

import com.dak.tst.dto.UserDto_01;
import com.dak.tst.lib.DbUtils;

public class TS99001 {

	private static Logger logger;
	protected SqlSession sqlSession;
	
	public TS99001() {
		logger = LogManager.getLogger(this.getClass());
	
	}

	protected void run() throws Exception {
		
//		logger.debug("TS99001 : 111>>> ");
		logger.info("TS99001 : 111>>> ");
//		logger.warn("TS99001 : 111>>> ");
//		logger.error("TS99001 : 111>>> ");
		
//		getConnection();
		try {
			getMybatis();
		}
		finally {
			sqlSession.close();
			logger.info("getMybatis : sqlSession closed " );
		}
		logger.info("TS99001 : 222>>> ");
	}
	
	public void getMybatis() throws Exception {
		logger.info("getMybatis : 111>>> " );
		sqlSession = new DbUtils().getSession();
		
		//TYPE-01 : selectOne
		String str = sqlSession.selectOne("dak.tst.batch.mapper_101.select_001","xxx");
		logger.info("getMybatis : 222>>> " + str);
		
		//TYPE-02 : selectList
		List<Map<String, Object>> resultMap = sqlSession.selectList("dak.tst.batch.mapper_101.select_002","1");
		for(Map<String, Object> map : resultMap){
			for(Map.Entry<String, Object> entry : map.entrySet()){
		        String key   = entry.getKey();
		        Object value = entry.getValue();
		     	System.out.println("key: " + key + " | value: " + value);
			}
		}
		logger.info("getMybatis : 333>>> ");
		
		
		//TYPE-03 : insert Single
		Map<String, Object> map = new HashMap<>();
		map.put("VAL01","1114");
		map.put("VAL02","1114");
		map.put("VAL03","1114");
		map.put("VAL04","1114");
		
		int cnt3 = sqlSession.insert("dak.tst.batch.mapper_101.insert_01", map);
		sqlSession.commit();
		logger.info("getMybatis : 444>>> " + cnt3);
		
		//TYPE-04 : insert Multi
		UserDto_01 dto1 = new UserDto_01();
		dto1.setVAL01("111");
		dto1.setVAL02("111");
		dto1.setVAL03("111");
		dto1.setVAL04("111");
		
		UserDto_01 dto2 = new UserDto_01();
		dto2.setVAL01("112");
		dto2.setVAL02("112");
		dto2.setVAL03("112");
		dto2.setVAL04("112");

		List<UserDto_01> list = new ArrayList<UserDto_01>();
		list.add(dto1);
		list.add(dto2);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("list", list);

//		int cnt4 = sqlSession.insert("dak.tst.batch.mapper_101.insert_02", map2);
//		sqlSession.commit();
		logger.info("getMybatis : 444>>> ");
		
    	//TYPE-05 : update
		Map<String, Object> map3 = new HashMap<>();
		map3.put("VAL01","112");
		map3.put("VAL02","aaaa");
		
//		int cnt5 = sqlSession.update("dak.tst.batch.mapper_101.update_01", map3);
//		sqlSession.commit();
		logger.info("getMybatis : 555>>> ");
		
		//TYPE-06 : delete
		Map<String, Object> map4 = new HashMap<>();
		map4.put("VAL01","111");
		
//		int cnt6 = sqlSession.delete("dak.tst.batch.mapper_101.delete_01", map4);
//		sqlSession.commit();
		logger.info("getMybatis : 555>>> ");
		
	}
	
   
	public static void main(String[] args) throws Exception {
		
		TS99001 batch = new TS99001();
		
		batch.run();

	}

}



 


