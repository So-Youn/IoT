package dept;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
//조회한 레코드를 어떤 객체로 변환해야 하는지를 구현
/*
 * while(rs.next()){
 * ---------------------------------------------
 * 	DTO dto = new DTO(rs.getString(1),.....)         -> 이 부분만 mapRow에 구현 
 * --------------------------------------------			[달라지는 부분]
 * list.add(dto)
 * }
 */
public class MyDeptRowMapper implements RowMapper<DeptDTO> {

	@Override
	public DeptDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		//레코드 한 개를 dto와 mapping 해서 리턴
		//개발자는 무엇이랑 매핑해야 하는지만 지정해주면 된다.
		System.out.println("mapRow=>"+rowNum);
		DeptDTO dept = new DeptDTO(rs.getString(1), rs.getString(2));
		return dept;
	}
	
}
