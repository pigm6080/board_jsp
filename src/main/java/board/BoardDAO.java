package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import common.JdbcUtil;

public class BoardDAO {
	
	private JdbcUtil ju;
	
	public BoardDAO() {
		System.out.println("DAO생성 준비");
		ju = JdbcUtil.getInstance();
		System.out.println("DAO생성 완료");
	}
	
	public int insert(BoardVO vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String quary = "INSERT INTO board(title, writer, content, regdate, cnt) "
				+ "VALUES (?, ?, ?, CURDATE(), 0)";
		int ret = -1;
		try {
			con = ju.getConnection();
			pstmt = con.prepareStatement(quary);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			ret = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {try {pstmt.close();} catch (Exception e) {e.printStackTrace();}}
			if(con != null) {try {con.close();} catch (Exception e) {e.printStackTrace();}}
		}
		return ret;	
	}
	public int update(BoardVO vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String quary = "update board set title=?, content=? where num=?";
		int ret = -1;
		try {
			con = ju.getConnection();
			pstmt = con.prepareStatement(quary);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getNum());
			ret = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {try {pstmt.close();} catch (Exception e) {e.printStackTrace();}}
			if(con != null) {try {con.close();} catch (Exception e) {e.printStackTrace();}}
		}
		return ret;	
	}
	public int updateCnt(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String quary = "update board set cnt=cnt+1 where num=?";
		int ret = -1;
		try {
			con = ju.getConnection();
			pstmt = con.prepareStatement(quary);
			pstmt.setInt(1, num);
			ret = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {try {pstmt.close();} catch (Exception e) {e.printStackTrace();}}
			if(con != null) {try {con.close();} catch (Exception e) {e.printStackTrace();}}
		}
		return ret;	
	}
	public int delete(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String quary = "delete from board where num=?";
		int ret = -1;
		try {
			con = ju.getConnection();
			pstmt = con.prepareStatement(quary);
			pstmt.setInt(1, num);
			ret = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {try {pstmt.close();} catch (Exception e) {e.printStackTrace();}}
			if(con != null) {try {con.close();} catch (Exception e) {e.printStackTrace();}}
		}
		return ret;	
	}
	public List<BoardVO> selectAll() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String quary = "select num, title, writer, content, regdate, cnt from board order by num desc";
		List<BoardVO> ls = new ArrayList<BoardVO>();
		try {
			con = ju.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(quary);
			while (rs.next()) {
				BoardVO vo = new BoardVO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						new Date(rs.getDate(5).getTime()),
						rs.getInt(6));
				ls.add(vo);
			System.out.println(new Date(rs.getDate(5).getTime()));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {try {rs.close();} catch (Exception e) {e.printStackTrace();}}
			if(stmt != null) {try {stmt.close();} catch (Exception e) {e.printStackTrace();}}
			if(con != null) {try {con.close();} catch (Exception e) {e.printStackTrace();}}
		}
		return ls;	
	}
	
	public BoardVO selectOne(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String quary = "select num, title, writer, content, regdate, cnt from board where num=?";
		BoardVO vo = null;
		try {
			con = ju.getConnection();
			pstmt = con.prepareStatement(quary);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				updateCnt(num);
				vo = new BoardVO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						new Date(rs.getDate(5).getTime()),
						rs.getInt(6));
					}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {try {rs.close();} catch (Exception e) {e.printStackTrace();}}
			if(pstmt != null) {try {pstmt.close();} catch (Exception e) {e.printStackTrace();}}
			if(con != null) {try {con.close();} catch (Exception e) {e.printStackTrace();}}
		}
		return vo;	
	}
	
	
	
	
}
