package com.website.demo.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.website.demo.service.CustomerService;
import com.website.demo.util.PropsUtil;

public final class DatabaseHelper {
	private static final String DRIVER ;
	private static final String URL;
	private static final String USERNAME;
	private static final String PASSWORD;
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
	static{
		Properties config = PropsUtil.loadProps("config.properties");
		DRIVER = config.getProperty("jdbc.driver");
		URL = config.getProperty("jdbc.url");
		USERNAME = config.getProperty("jdbc.name");
		PASSWORD = config.getProperty("jdbc.password");
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			LOGGER.error("驱动加载失败");
		}
	}
	
	private static final ThreadLocal<Connection> CONNECTION_HOLDER = new ThreadLocal<Connection>();
	
	public static Connection getConnection(){
		Connection con = CONNECTION_HOLDER.get();
		try {
			if(con==null){
				con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CONNECTION_HOLDER.set(con);
		}
		return con;
	}
	
	public static void closeConnection(){
		Connection con = CONNECTION_HOLDER.get();
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				CONNECTION_HOLDER.remove();
			}
		}
	}
	private static final QueryRunner QUERY_RUNNER = new QueryRunner();
	
	public static <T> List<T> queryList(Class<T> cls,String sql , Object...params){
		List<T> entityList = null;
		Connection con = getConnection();
		try {
			entityList = QUERY_RUNNER.query(con, sql, new BeanListHandler<T>(cls), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnection();
		}
		return entityList;
	}
	
}
