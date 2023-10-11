package com.login.jdbclogin.CustomerKycStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;

@Component

public class CustomerKycStatusHandler {
    final static Logger log= LoggerFactory.getLogger(CustomerKycStatusHandler.class);
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    Environment env;
    public CustomerKycResponse customerKycStatus(CustomerKycStatusModel payload){
        log.info("get this here{}"+payload.getIdentificationNumber(),payload.getLegalIdType());
        try{


            String sql= "SELECT IF(kyc_status IS NULL,'INCOMPLETE',kyc_status) AS kycStatus FROM\n" +
                    "api_kyc_master WHERE id_type=? AND national_id=?";
            Object[] param = new Object[] {payload.getLegalIdType(), payload.getIdentificationNumber()};
      return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(CustomerKycResponse.class),param);
        }catch(Exception el){
            el.printStackTrace();
            return null;
        }




    }
    public int  getCount(String nationalId, String id_type){
       String sql="SELECT (kyc_status)AS vcount FROM api_kyc_master  WHERE id_type=? AND national_id=?";
      Object[] param = new Object[] {id_type, nationalId};
        int res=jdbcTemplate.queryForObject(sql,param,Integer.class);
        return res;


    }
}
