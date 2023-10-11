package com.login.jdbclogin.CustomerKycTermination;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;
@Component

public class CustomerKycTerminationHandler {
    final static Logger log= LoggerFactory.getLogger(CustomerKycTerminationHandler .class);
    @Autowired
    Environment env;
    @Autowired
    JdbcTemplate jdbcTemplate;
    public  boolean kycTermination(CustomerKycTerminationModel  payload){
        try{
            String sql="UPDATE api_kyc_master SET kyc_status=?  WHERE request_id=?";
            Object[]param=new Object[]{"COMPLETE",payload.getRequestId()};
            jdbcTemplate.update(sql,param);
            return true;
        }catch(Exception el){
            el.printStackTrace();
            StringWriter sw=new StringWriter();
            el.printStackTrace(new PrintWriter(sw));
            log.error("get this error{} "+sw.toString());

            return false;
        }

    }
    public CustomerKycQueueModel retrieveNationalId(String requestId){
        CustomerKycQueueModel model=null;
        try{
            String sql="SELECT (app_code) AS appCode, (national_id) AS nationalId FROM api_kyc_master WHERE request_id=?";
            Object[] params = new Object[]{requestId};
            return jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(CustomerKycQueueModel.class),params);
        }catch(Exception el){
            el.printStackTrace();
            return model;
        }
    }
    public int count(String requestId){
        try {
            String sql = "SELECT count(*) AS vcount from api_kyc_master where request_id=? ";
            Object[] params = new Object[]{requestId};
            int total = jdbcTemplate.queryForObject(sql, Integer.class, params);

            return total;
        }catch(Exception el){
            el.printStackTrace();
            return -1;
        }

    }
}
