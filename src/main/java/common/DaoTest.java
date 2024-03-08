package common;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;


class DaoTest {
	
	JdbcUtil util = JdbcUtil.getInstance();
	
	@Test
	void test() throws SQLException {
		
		util.getConnection();
		
		fail("Not yet implemented");
	}

}
