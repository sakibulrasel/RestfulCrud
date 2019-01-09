/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * Author     : Sakibul Haque
 */
public class DrugGroupName {
    private int dg_id;
    private String dg_name;

    public DrugGroupName() {
    }

    public DrugGroupName(int dg_id, String dg_name) {
        this.dg_id = dg_id;
        this.dg_name = dg_name;
    }

            
    public int getDg_id() {
        return dg_id;
    }

    public void setDg_id(int dg_id) {
        this.dg_id = dg_id;
    }

    public String getDg_name() {
        return dg_name;
    }

    public void setDg_name(String dg_name) {
        this.dg_name = dg_name;
    }
    
    
    
    
}
