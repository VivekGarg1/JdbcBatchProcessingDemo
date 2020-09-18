package com.home.client;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.home.util.JdbcUtil;

public class CallableStatementBatchClientTest {

	public static void main(String[] args) {
		String SQLUPDATE="call proc_updateEmpSalaryBYId(?,?)";
		try(Connection connection=JdbcUtil.getConnection();
				CallableStatement cs=connection.prepareCall(SQLUPDATE)){
			cs.setDouble(1, 30000.0);
			cs.setInt(2, 1);
			cs.addBatch();
			
			cs.setDouble(1, 28000.0);
			cs.setInt(2, 2);
			cs.addBatch();
			
			cs.setDouble(1, 30000.0);
			cs.setInt(2, 20);
			cs.addBatch();
			
			int[] executeBatch = cs.executeBatch();
			for (int i : executeBatch) {
				System.out.println(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
