package board;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import common.JdbcUtil;

public class BoardDao {
	
	private JdbcUtil ju;
	
	//삽입(C)
	public int insert(BoardVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int ret = -1;
		try {
			con = ju.getConnection();
			String query = "INSERT INTO BOARD VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ? , SYSDATE, 0 )";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			ret = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		
		return ret;
	}
	
	//조회(R)
	public List<BoardVo> selectAll(){
		Connection con;
		Statement stmt;
		ResultSet rs;
		String query = "SELECT * FROM BOARD";
		ArrayList<BoardVo> ls = new ArrayList<BoardVo>();
		try {
			con = ju.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			while(rs.next()) {
				BoardVo vo = new BoardVo(rs.getInt(1),
						rs.getString(2), 
						rs.getString(3),
						rs.getString(4),
						new Date(rs.getDate(5).getTime()),
						rs.getInt(6));
				ls.add(vo);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	//수정(U)
	
	//삭제(D)

}
