package com.dak.tst.lib;

import java.io.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 
public class DbUtils {

	private static Logger logger;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

	public DbUtils() {
		logger = LogManager.getLogger(this.getClass());
	
	}
	    
    public SqlSession getSession(){
        try{

            String path = "resources/cfg/mybatis-config.xml";

            Reader reader =    Resources.getResourceAsReader(path);

            sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
            logger.info("getSession() 111 >>>");
        }catch(Exception e){
            System.out.println(e.getMessage());
            sqlSession.close();
        }
        
        return sqlSession;
    }
    
}