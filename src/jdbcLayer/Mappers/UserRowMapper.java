package jdbcLayer.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import data.User;

@SuppressWarnings("rawtypes")
public class UserRowMapper implements RowMapper {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            User newUser = new User();
            
            newUser.setUid(rs.getInt("uid"));
            newUser.setUsername(rs.getString("username"));
            newUser.setPassword(rs.getString("password"));
            
            return newUser;
        }
}
