package org.jinhe.example.mysqlcluster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		String sql = "select * from test1 ";
		conn = DBHelper.getConnection();
		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						System.out.println("=============" + rs.getString(1));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}