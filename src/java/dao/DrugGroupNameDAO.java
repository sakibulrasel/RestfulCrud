/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.DrugGroupName;
import bean.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnect;

/**
 *
 * Author     : Sakibul Haque
 */
public class DrugGroupNameDAO {
    public List<DrugGroupName> getAllDrugGroupName() {
        List<DrugGroupName> list = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.getConnection().createStatement().executeQuery("select * from drug_group_name");
            while (rs.next()) {
                list.add(new DrugGroupName(rs.getInt("dg_id"), rs.getString("dg_name")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DrugGroupNameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public DrugGroupName saveDrugGroupName(DrugGroupName dgn) {
        String sql = "insert into drug_group_name (dg_name) values('" + dgn.getDg_name()+ "')";
        try {
            int value = DBConnect.getConnection().createStatement().executeUpdate(sql);
            if (value > 0) {
                return dgn;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DrugGroupNameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public DrugGroupName updateDrugGroupName(DrugGroupName dgn) {
        String sql = "update drug_group_name set dg_name='" + dgn.getDg_name() + "' where dg_id='" + dgn.getDg_id()+ "'";
        try {
            int value = DBConnect.getConnection().createStatement().executeUpdate(sql);
            if (value > 0) {
                return dgn;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DrugGroupNameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean deleteDrugGroupName(int id) {
        String sql = "delete from drug_group_name where dg_id='" + id + "'";
        try {
            int value = DBConnect.getConnection().createStatement().executeUpdate(sql);
            if (value > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DrugGroupNameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public DrugGroupName getDrugGroupName(int id) {
        DrugGroupName dgn = new DrugGroupName();
        try {
            ResultSet rs = DBConnect.getConnection().createStatement().executeQuery("select * from drug_group_name where dg_id='" + id + "'");
            while (rs.next()) {
                dgn.setDg_id(rs.getInt("dg_id"));
                dgn.setDg_name(rs.getString("dg_name"));
            }
            return dgn;
        } catch (SQLException ex) {
            Logger.getLogger(DrugGroupNameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
