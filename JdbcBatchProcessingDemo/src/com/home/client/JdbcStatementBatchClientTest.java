package com.home.client;

import java.sql.Connection;
import java.sql.Statement;

import com.home.util.JdbcUtil;

public class JdbcStatementBatchClientTest {

	public static void main(String[] args) {
		try(Connection connection=JdbcUtil.getConnection();
				Statement statement=connection.createStatement()){
			statement.addBatch("update employee_table set email='v@gmail.com' where employee_id=1");
			statement.addBatch("update employee_table set email='p@gmail.com' where employee_id=2");
			statement.addBatch("delete from employee_table where employee_id=3");
			int[] executeBatch = statement.executeBatch();
			for (int i : executeBatch) {
				System.out.println(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
