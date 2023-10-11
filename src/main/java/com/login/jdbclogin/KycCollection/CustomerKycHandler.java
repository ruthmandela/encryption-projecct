package com.login.jdbclogin.KycCollection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class CustomerKycHandler {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    Environment env;
    public void updateCustomerKycData(CustomerKycRequestModel payload){
        try{
                String sql = "INSERT INTO api_kyc_master (residence_country, branch_code, refferal_name, dividence_disposal, client_category,bank_account_name,bank_account_number) value (?,?,?,?,?,?,?)";
                Object[] param = new Object[]{payload.customerPreference.getCountryOfResidence(), payload.customerPreference.getBankBranchCode(), payload.customerPreference.getReferralName()
                        , payload.customerPreference.getDividendDisposalPreference(), payload.customerPreference.getClientCategory(),payload.customerPreference.bankDetails.getBankAccountName(),payload.customerPreference.bankDetails.getBankAccountNumber()};
                System.out.println("get this here"+payload.customerPreference.getCurrency());
                jdbcTemplate.update(sql, param);
        }catch(Exception el){
            el.printStackTrace();

        }
    }
    public void saveCustomerContactInfo(CustomerKycRequestModel payload){
        try{

            String sql="INSERT INTO api_kyc_master (physical_address,street,house_number,building,county,region,postal_address," +
                    "postal_code,town_city) values (?,?,?,?,?,?,?,?,?) ";
            Object[]param= new Object[]{payload.customerContactInfo.getPhysicalAddress(),payload.customerContactInfo.getStreet(),payload.customerContactInfo.getHouseNumber(),payload.customerContactInfo.getBuilding(),payload.customerContactInfo.getCounty(),payload.customerContactInfo.getRegion(),payload.customerContactInfo.getPostalAddress(),payload.customerContactInfo.getPostalCode(),payload.customerContactInfo.getTown()};
            jdbcTemplate.update(sql,param);
        }catch(Exception el){
            el.printStackTrace();
        }

    }
    public void saveCustomerEmergencyContact(CustomerKycRequestModel payload){

        try{

            String sql="INSERT INTO api_kyc_master(nok_name,relationship,nok_email,nok_phone_number,nok_identification_number) values (?,?,?,?,?)";
            Object[]params=new Object[]{payload.customerEmergencyContactInfo.getName(),payload.customerEmergencyContactInfo.getRelationship(),payload.customerEmergencyContactInfo.getEmail(),payload.customerEmergencyContactInfo.getPhoneNumber(),payload.customerEmergencyContactInfo.getIdentificationNumber()};
            jdbcTemplate.update(sql,params);
        }catch(Exception el){
            el.printStackTrace();
        }

    }
    public void saveCustomerFatca(CustomerKycRequestModel payload){
        try{
//            Gson gson = new GsonBuilder().create();
//            CustomerFatcaModel resp=gson.fromJson(payload.getCustomerFatca().toString(),CustomerFatcaModel.class);
            String sql="INSERT INTO api_kyc_master (us_mailing_address,social_security_number,us_postal_address) values (?,?,?)";
            Object[]param=new Object[]{payload.customerFatca.getUnitedStatesMailingAddress(),payload.customerFatca.getSocialSecurityNumber(),payload.customerFatca.getUnitedStatesPostalAddress()};
            jdbcTemplate.update(sql,param);

        }catch(Exception el){
            el.printStackTrace();

        }
    }
    public void customerProductSelection(CustomerKycRequestModel payload){
        try{

            String sql= "INSERT INTO api_kyc_master(product_code,bundle_product)values (?,?)";
            Object[]params=new Object[]{payload.customerProductSelection.getProductCode(),payload.customerProductSelection.getBundleCode()};
            jdbcTemplate.update(sql,params);
        }catch(Exception el){
            el.printStackTrace();
        }

    }
    public JSONObject currencies(List<String> currency) throws JSONException {

        JSONObject jsonObject=new JSONObject();
        JSONArray array=new JSONArray();
        for(int i=0;i<= currency.size();i++){
            String value=currency.get(i);
            array.getJSONArray(i);

        }
        jsonObject.getString(String.valueOf(array));
        return jsonObject;

    }

}
