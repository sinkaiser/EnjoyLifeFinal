package com.attendpartner.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AttendPartnerDAO implements AttendPartnerDAO_interface {

	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ELDB");
		} catch (NamingException e) {
			System.out.println("DataSource錯誤");
			e.printStackTrace();
		}
	}

	
	private static final String SELECT_ALL =
		      "SELECT * FROM attendpartner by eventNo desc";
	private static final String SELECT_BY_EVENTNO_PARTNER =
		      "SELECT * FROM attendpartner where eventNo=? AND partner=? order by eventDate desc";
	private static final String SELECT_BY_EVENTNO =
		      "SELECT * FROM attendpartner where eventNo = ? order by eventNo desc";
	private static final String INSERT =
		      "INSERT INTO attendpartner (eventType,eventTitle,eventContent,addr,eventDate,modifyDate,eventPhoto,memberId,hidden) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE =
		      "UPDATE attendpartner set eventNo=?, partner=?, attend=1";
	private static final String UPDATE_ATTEND =
			"UPDATE attendpartner set attend = 1 where eventNo = ?";
	


	@Override
	public List<AttendPartnerVO> getAll() {
		List<AttendPartnerVO> list = new ArrayList<AttendPartnerVO>();
		AttendPartnerVO attendPartnerVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// partnerVO 也稱為 Domain objects
				attendPartnerVO = new AttendPartnerVO();
				attendPartnerVO.setEventNo(rs.getInt("eventNo"));
				attendPartnerVO.setPartner(rs.getString("partner"));
				attendPartnerVO.setAttend(rs.getInt("attend"));
				list.add(attendPartnerVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}
	
	
	
	@Override
	public List<AttendPartnerVO> selectByEventNoPartner(Integer eventNo,String partner) {
		List<AttendPartnerVO> list = new ArrayList<AttendPartnerVO>();
		AttendPartnerVO attendPartnerVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_BY_EVENTNO_PARTNER);

			pstmt.setInt(1, eventNo);
			pstmt.setString(2, partner);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// partnerVO 也稱為 Domain objects
				attendPartnerVO = new AttendPartnerVO();
				attendPartnerVO.setEventNo(rs.getInt("eventNo"));
				attendPartnerVO.setPartner(rs.getString("partner"));
				list.add(attendPartnerVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}
	
	@Override
	public List<AttendPartnerVO> selectByEventNo(Integer eventNo) {
		List<AttendPartnerVO> list = new ArrayList<AttendPartnerVO>();
		AttendPartnerVO attendPartnerVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_BY_EVENTNO);

			pstmt.setInt(1, eventNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// partnerVO 也稱為 Domain objects
				attendPartnerVO = new AttendPartnerVO();
				attendPartnerVO.setEventNo(rs.getInt("eventNo"));
				attendPartnerVO.setPartner(rs.getString("partner"));
				list.add(attendPartnerVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}
	
	
	@Override
	public AttendPartnerVO insert(AttendPartnerVO attendPartnerVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT);

			pstmt.setInt(1, attendPartnerVO.getEventNo());
			pstmt.setString(2, attendPartnerVO.getPartner());
			pstmt.setInt(3, attendPartnerVO.getAttend());

			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return attendPartnerVO;

	}

	@Override
	public AttendPartnerVO update(AttendPartnerVO attendPartnerVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, attendPartnerVO.getEventNo());
			pstmt.setString(2, attendPartnerVO.getPartner());
			pstmt.setInt(3, attendPartnerVO.getAttend());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return attendPartnerVO;

	}

	@Override
	public AttendPartnerVO attend(AttendPartnerVO attendPartnerVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_ATTEND);

			pstmt.setInt(1, attendPartnerVO.getEventNo());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return attendPartnerVO;

	}
	
}