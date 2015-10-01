package com.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.json.simple.JSONArray;


public class MemberDAO implements MemberDAO_interface{
	private static DataSource ds = null;
	public MemberDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/ELDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}	
	private static final String SELECT_BY_ID = "Select memberId, password, memberName, email, sex, birthday, registerdate, address, picture, permission  from Member where memberId = ?";
	private static final String SELECT_ALL = "Select memberId, memberName, email, sex, birthday, registerdate, address, picture,permission  from Member";
	private static final String INSERT = "Insert into Member (memberId, password, memberName, email, sex, birthday, registerdate, address, picture, permission) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String DELETE = "Delete from Member where memberId=?";
	@Override
	public MemberVO SelectById(String memberId) {
		MemberVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SELECT_BY_ID);
			stmt.setString(1, memberId);
			rset = stmt.executeQuery();
			if (rset.next()) {
				result = new MemberVO();
				result.setMemberId(rset.getString("memberid"));
				result.setPassword(rset.getBytes("password"));
				result.setMemberName(rset.getString("memberName"));
				result.setEmail(rset.getString("email"));
				result.setSex(rset.getString("sex"));
				result.setBirthday(rset.getDate("birthday"));		                                  
				result.setRegisterDate(rset.getTimestamp("registerdate"));
				result.setAddress(rset.getString("address"));
				result.setPicture(rset.getInt("picture"));
				result.setPermission(rset.getInt("permission"));
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
		return result;
	}
	@Override
	public List<MemberVO> getAll() {
		List<MemberVO> result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SELECT_ALL);
			rset = stmt.executeQuery();
			result = new Vector<>();
			while (rset.next()) {
				MemberVO temp = new MemberVO();
				temp.setMemberId(rset.getString("memberid"));
				temp.setMemberName(rset.getString("memberName"));
				temp.setEmail(rset.getString("email"));
				temp.setSex(rset.getString("sex"));
				temp.setBirthday(rset.getDate("birthday"));
				temp.setRegisterDate(rset.getTimestamp("registerDate"));
				temp.setAddress(rset.getString("address"));
				temp.setPicture(rset.getInt("picture"));
				temp.setPermission(rset.getInt("permission"));
				result.add(temp);
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
		return result;
	}		
	@Override
	public MemberVO insert(MemberVO memberVO) {
		MemberVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(INSERT);
			stmt.setString(1, memberVO.getMemberId());
			stmt.setBytes(2, memberVO.getPassword());
			stmt.setString(3, memberVO.getMemberName());
			stmt.setString(4, memberVO.getEmail());
			stmt.setString(5, memberVO.getSex());
			stmt.setString(8, memberVO.getAddress());
			int b =0;
			stmt.setInt(10, b);
			java.util.Date temp = memberVO.getBirthday();
			if (temp != null) {
				java.sql.Date someTime = new java.sql.Date(temp.getTime());
				stmt.setDate(6, someTime);
			} else {
				stmt.setDate(6, null);
			}
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			stmt.setTimestamp(7, ts);
//			Blob b = null;
			stmt.setInt(9, memberVO.getPicture());			
			int i = stmt.executeUpdate();
			if (i == 1) {
				result = this.SelectById(memberVO.getMemberId());
			}
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
	@Override
	public int delete(String memberId) {
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(DELETE);

			stmt.setString(1, memberId);
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
	
	private static final String UPDATE = "Update Member set memberName=?, "
			+ "email=?, sex=?, birthday=?, address=?, picture=? where memberId = ?";
	@Override
	public int update(MemberVO memberVO) {
		int result = 0;
		Connection conn=null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(UPDATE);
			//stmt.setBytes(1, memberVO.getPassword());
			//System.out.println(memberVO.getMemberName());
			stmt.setString(1, memberVO.getMemberName());
			stmt.setString(2, memberVO.getEmail());
			stmt.setString(3, memberVO.getSex());
			java.util.Date temp = memberVO.getBirthday();
			if (temp != null) {
				java.sql.Date someTime = new java.sql.Date(temp.getTime());
				stmt.setDate(4, someTime);
			} else {
				stmt.setDate(4, null);
			}
			stmt.setString(5, memberVO.getAddress());
			stmt.setInt(6, memberVO.getPicture());
			stmt.setString(7, memberVO.getMemberId());
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
	private static final String UPDATEPWD = "Update Member set password=? where memberId = ?";
	@Override
	public int UPDATEPWD(MemberVO memberVO) {
		int result = 0;
		Connection conn=null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(UPDATEPWD);
			stmt.setBytes(1, memberVO.getPassword());
			stmt.setString(2, memberVO.getMemberId());
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
	private static final String UPDATEPWDPERMISSION = "Update Member set permission=? where memberId = ?";
	@Override
	public int updatepermission(MemberVO memberVO) {
		int result = 0;
		Connection conn=null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(UPDATEPWDPERMISSION);
			stmt.setInt(1, memberVO.getPermission());
			stmt.setString(2, memberVO.getMemberId());
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
	private static final String SELECT_BY_IDLIKE = "Select memberId from Member where memberId  like '%'+?+'%'";
	public JSONArray SelectByIdLike(String memberId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		JSONArray list = new JSONArray();
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SELECT_BY_IDLIKE);
			stmt.setString(1, memberId);
			rset = stmt.executeQuery();			
			while (rset.next()) {
				 list.add(rset.getString(1));				 
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
	private static final String SELECT_BY_COUNT = "select count(*) from partner where MemberId = ? and Hidden=0 and Closed=0";
	public int SelectByCount(String memberId) {
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SELECT_BY_COUNT);
			stmt.setString(1, memberId);
			rset = stmt.executeQuery();
			if(rset.next()){
				result = rset.getInt(1);
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
		return result;
	}
}