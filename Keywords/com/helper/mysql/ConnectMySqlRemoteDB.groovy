package com.helper.mysql
import java.sql.*
import com.kms.katalon.core.annotation.Keyword
import com.mysql.cj.protocol.Resultset

public class ConnectMySqlRemoteDB {



	Connection connection =null

	// Making the DB connection & return connection object to test case
	/*@Keyword
	 def Connection connectDB(){
	 Class.forName("com.mysql.cj.jdbc.Driver")
	 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ArcTestData", "root", "")
	 return connection
	 }*/

	//Executing the constructed Query and Saving results in resultset
	@Keyword
	def ResultSet executeQuery(String queryString) {
		Class.forName("com.mysql.cj.jdbc.Driver")
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ArcTestData", "root", "")
		if(connection!=null)
			println "connection created"
		Statement stm = connection.createStatement()
		ResultSet  rs = stm.executeQuery(queryString)
		return rs
	}

	//Closing the connection
	@Keyword
	def Connection closeDatabaseConnection() {
		if(connection != null && !connection.isClosed()){
			connection.close()
		}
		connection = null
	}

	//Return the boolean value for result set object .
	@Keyword
	def ResultSet execute(String queryString, Connection conn) {
		Statement stm = connection.createStatement()
		boolean result = stm.execute(queryString)
		return result
	}
}

