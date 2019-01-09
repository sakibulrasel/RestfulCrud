/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.DrugCompany;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnect;

/**
 *
 * @author sakib
 */
public class DrugCompanyDAO {

    public List<DrugCompany> getAllDrugCompany() {
        List<DrugCompany> list = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.getConnection().createStatement().executeQuery("select * from drug_company");
            while (rs.next()) {
                list.add(new DrugCompany(rs.getInt("dc_id"), rs.getString("dc_nick_name"), rs.getString("dc_full_name"), rs.getString("dc_address"), rs.getString("dc_phone")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DrugCompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public DrugCompany saveDrugCompany(DrugCompany dc) {
        String sql = "insert into drug_company (dc_nick_name, dc_full_name, dc_address,dc_phone) values('" + dc.getDc_nick_name() + "','" + dc.getDc_full_name() + "','" + dc.getDc_address() + "','" + dc.getDc_phone() + "')";
        try {
            int value = DBConnect.getConnection().createStatement().executeUpdate(sql);
            if (value > 0) {
                return dc;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DrugCompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public DrugCompany updateDrugCompany(DrugCompany dc) {
        String sql = "update drug_company set dc_nick_name='" + dc.getDc_nick_name() + "', dc_full_name='" + dc.getDc_full_name() + "', dc_address='" + dc.getDc_address() + "', dc_phone='" + dc.getDc_phone() + "' where dc_id='" + dc.getDc_id() + "'";
        try {
            int value = DBConnect.getConnection().createStatement().executeUpdate(sql);
            if (value > 0) {
                return dc;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DrugCompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean deleteDrugCompany(int id) {
        String sql = "delete from drug_company where dc_id='" + id + "'";
        try {
            int value = DBConnect.getConnection().createStatement().executeUpdate(sql);
            if (value > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DrugCompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public DrugCompany getDrugCompany(int id) {
        DrugCompany dc = new DrugCompany();
        try {
            ResultSet rs = DBConnect.getConnection().createStatement().executeQuery("select * from product where pid='" + id + "'");
            while (rs.next()) {
                dc.setDc_id(rs.getInt("dc_id"));
                dc.setDc_nick_name(rs.getString("dc_nick_name"));
                dc.setDc_full_name(rs.getString("dc_full_name"));
                dc.setDc_address(rs.getString("dc_address"));
                dc.setDc_phone(rs.getString("dc_phone"));
            }
            return dc;
        } catch (SQLException ex) {
            Logger.getLogger(DrugCompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
