package com.home.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.home.util.JdbcUtil;

public class PreparedStatementBatchClientTest {

	public static void main(String[] args) {
		String SQLUPDATE="update employee_table set salary=? where employee_id=?";
		try(Connection connection=JdbcUtil.getConnection();
				PreparedStatement ps=connection.prepareStatement(SQLUPDATE)){
			ps.setDouble(1, 25000.0);
			ps.setInt(2, 1);
			ps.addBatch();
			
			ps.setDouble(1, 20000.0);
			ps.setInt(2, 2);
			ps.addBatch();
			
			ps.setDouble(1, 30000.0);
			ps.setInt(2, 20);
			ps.addBatch();
			
			int[] executeBatch = ps.executeBatch();
			for (int i : executeBatch) {
				System.out.println(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
