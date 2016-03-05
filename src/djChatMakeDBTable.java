import java.sql.*;

import java.sql.Connection;

public class djChatMakeDBTable {
	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = 
				(Connection) DriverManager.getConnection("jdbc:mysql://localhost", "root", "1234");
		
		Statement stmt = conn.createStatement();
		String sqlReset = "DROP DATABASE DJChatDB";
		String sql1 = "CREATE DATABASE DJChatDB default character set euckr";
		String sql2 = "USE DJChatDB"; 
		String sql3 = "CREATE TABLE userInfo(idNum int not null auto_increment primary key, userId varchar(20),password varchar(20),name varchar(10),nickName varchar(20), phoneNum varchar(14),statusMsg varchar(20))";
		String sql4 = "CREATE TABLE userJoinRoom(indexNum int not null auto_increment primary key, userId varchar(20), chatRoomNum int, talkRoomName varchar(30),lastread timestamp)";
		String sql5 = "CREATE TABLE chatRoomInfo(chatRoomNum int not null auto_increment primary key, joinUserCount int,chatType varchar(2))";
		String sql6 = "CREATE TABLE chatMsgInfo(indexNum int auto_increment primary key, msg varchar(200),chatRoomNum int, userId varchar(20),joinUserCount int,readUserCount int,sendTime timestamp)";
		String sql7 = "CREATE TABLE userFriend(userId varchar(20),friendId varchar(20),friendStatus int)";
		stmt.execute(sqlReset);
		System.out.println("reset");
		stmt.executeUpdate(sql1);
		System.out.println("DJChatDB DB Make");
		stmt.executeUpdate(sql2);
		System.out.println("DJChatDB USE");
		stmt.executeUpdate(sql3);
		stmt.executeUpdate(sql4);
		stmt.executeUpdate(sql5);
		stmt.executeUpdate(sql6);
		stmt.executeUpdate(sql7);
		System.out.println("DJChatDB Table Make");
	}
}
