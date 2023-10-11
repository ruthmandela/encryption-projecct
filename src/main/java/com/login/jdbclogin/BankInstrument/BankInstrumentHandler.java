package com.login.jdbclogin.BankInstrument;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component

public class BankInstrumentHandler {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public boolean orderCard(String res){
        try{
            JSONObject object=new JSONObject(res);
            String sql="UPDATE account_main SET BANK_INSTRUMENT =? WHERE GROUP_NO=?";
            Object[] param=new Object[]{object.getString("bankInstrument"),object.getString("groupNo")};
              jdbcTemplate.update(sql,param);
              return true;
        }catch(Exception el){
            el.printStackTrace();
            return false;
        }
    }
}
