package com.message.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MessageDAO {
	private static DataSource ds = null;
	public MessageDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/ELDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String SELECT_BY_MESSAGEFROM = "Select * from Message where messageFrom = ? order by talkDate desc";
	public List<MessageVO> select_by_messageFrom(String messageFrom) {
		List<MessageVO> list = new ArrayList<MessageVO>();		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SELECT_BY_MESSAGEFROM);
			stmt.setString(1, messageFrom);	
			rset = stmt.executeQuery();
			while (rset.next()) {
				MessageVO result = new MessageVO();
				result.setMessageNo(rset.getInt("messageNo"));
				result.setMessageFrom(rset.getString("messageFrom"));
				result.setMessageTo(rset.getString("messageTo"));
				result.setMessageTitle(rset.getString("MessageTitle"));
				result.setMessage(rset.getString("message"));
				result.setShowMessage(rset.getInt("showMessage"));
				result.setUnMessage(rset.getInt("unMessage"));
				result.setTalkDate(rset.getTimestamp("talkDate"));				
				list.add(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	private static final String SELECT_BY_MESSAGENO = "Select * from Message where messageNo = ? order by talkDate desc";
	public List<MessageVO> select_by_messageNO(int messageNo) {
		List<MessageVO> list = new ArrayList<MessageVO>();		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SELECT_BY_MESSAGENO);
			stmt.setInt(1, messageNo);	
			rset = stmt.executeQuery();
			while (rset.next()) {
				MessageVO result = new MessageVO();
				result.setMessageNo(rset.getInt("messageNo"));
				result.setMessageFrom(rset.getString("messageFrom"));
				result.setMessageTo(rset.getString("messageTo"));
				result.setMessageTitle(rset.getString("MessageTitle"));
				result.setMessage(rset.getString("message"));
				result.setShowMessage(rset.getInt("showMessage"));
				result.setUnMessage(rset.getInt("unMessage"));
				result.setTalkDate(rset.getTimestamp("talkDate"));				
				list.add(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	private static final String SELECT_BY_MESSAGETO = "Select * from Message where messageTo = ? order by talkDate desc";
	public List<MessageVO> select_by_messageTo(String messageTo) {
		List<MessageVO> list = new ArrayList<MessageVO>();		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SELECT_BY_MESSAGETO);
			stmt.setString(1, messageTo);	
			rset = stmt.executeQuery();
			while (rset.next()) {
				MessageVO result = new MessageVO();
				result.setMessageNo(rset.getInt("messageNo"));
				result.setMessageFrom(rset.getString("messageFrom"));
				result.setMessageTo(rset.getString("messageTo"));
				result.setMessageTitle(rset.getString("MessageTitle"));
				result.setMessage(rset.getString("message"));
				result.setShowMessage(rset.getInt("showMessage"));
				result.setUnMessage(rset.getInt("unMessage"));
				result.setTalkDate(rset.getTimestamp("talkDate"));				
				list.add(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	private static final String INSERTMESSAGE = "Insert into Message (messageFrom, messageTo, messageTitle,message,talkDate,showMessage,unMessage) values (?,?,?,?,?,?,?)";
	public int insertmessage(MessageVO messageVO) {
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(INSERTMESSAGE);
			stmt.setString(1, messageVO.getMessageFrom());
			stmt.setString(2, messageVO.getMessageTo());
			stmt.setString(3, messageVO.getMessageTitle());
			stmt.setString(4, messageVO.getMessage());
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			stmt.setTimestamp(5, ts);
			stmt.setInt(6, 0);
			stmt.setInt(7, 0);
			result = stmt.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	private static final String UPDATEMESSAGE1 = "Update Message set showMessage=?  where messageNo = ?";
	public int updatemessage1(MessageVO messageVO) {
		int result = 0;
		Connection conn=null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(UPDATEMESSAGE1);
			stmt.setInt(1, 1);
			stmt.setInt(2, messageVO.getMessageNo());

			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;		
	}
	
	private static final String UPDATEMESSAGE2 = "Update Message set unMessage=?  where messageNo = ?";
	public int updatemessage2(MessageVO messageVO) {
		int result = 0;
		Connection conn=null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(UPDATEMESSAGE2);
			stmt.setInt(1, 1);
			stmt.setInt(2, messageVO.getMessageNo());

			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;		
	}
	
	
	private static final String DELETEMESSAGE = " Delete from Message where messageFrom=? and messageTo = ?";
	public int deleteMessage(String messageFrom,String messageTo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(DELETEMESSAGE);
			stmt.setString(1, messageFrom);
			stmt.setString(2, messageTo);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
