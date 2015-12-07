package jdbcLayer.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import data.Purchase;
import data.User;

@SuppressWarnings("rawtypes")
public class PurchaseRowMapper implements RowMapper {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            Purchase newPurchase = new Purchase();
            
            newPurchase.setId(rs.getInt("purchaseID"));
            newPurchase.setUserID(rs.getInt("uid"));
            newPurchase.setDate((rs.getDate("date").toString()));
            newPurchase.setBookID(rs.getInt("bookID"));
            newPurchase.setPaypalID(rs.getString("paypalID"));
            newPurchase.setShipmentID(rs.getInt("shipmentID"));
            newPurchase.setTotal(rs.getDouble("total"));
            
            return newPurchase;
        }
}
