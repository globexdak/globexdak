package com.dak.tst.lib;

import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

	public void getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");  
        
        String     connurl  = "jdbc:postgresql://127.0.0.1:5432/postgres";
        String     user     = "postgres";
        String     password = "pgdak99@";
 
        try 
        {
            Connection connection = DriverManager.getConnection(connurl, user, password);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT VERSION() AS version");
 
            while (rs.next()) {
                  String version = rs.getString("version");
                  
                  logger.info("getConnection : 111>>> " + version);                  
            }           
            rs.close();
            stmt.close();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
    public SqlSession getSession() throws Exception {
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