/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


/**
 *
 *
    Created on : Oct 23, 2018, 10:31:49 PM
    Author     : Sakibul Haque
 */


public class DrugCompany {
    private int dc_id;
    private String dc_nick_name;
    private String dc_full_name;
    private String dc_address;
    private String dc_phone;

    public DrugCompany() {
    }

    public DrugCompany(int dc_id, String dc_nick_name, String dc_full_name, String dc_address, String dc_phone) {
        this.dc_id = dc_id;
        this.dc_nick_name = dc_nick_name;
        this.dc_full_name = dc_full_name;
        this.dc_address = dc_address;
        this.dc_phone = dc_phone;
    }
    
    
    public int getDc_id() {
        return dc_id;
    }

    public void setDc_id(int dc_id) {
        this.dc_id = dc_id;
    }

    public String getDc_nick_name() {
        return dc_nick_name;
    }

    public void setDc_nick_name(String dc_nick_name) {
        this.dc_nick_name = dc_nick_name;
    }

    public String getDc_full_name() {
        return dc_full_name;
    }

    public void setDc_full_name(String dc_full_name) {
        this.dc_full_name = dc_full_name;
    }

    public String getDc_address() {
        return dc_address;
    }

    public void setDc_address(String dc_address) {
        this.dc_address = dc_address;
    }

    public String getDc_phone() {
        return dc_phone;
    }

    public void setDc_phone(String dc_phone) {
        this.dc_phone = dc_phone;
    }
    
    
    
}
