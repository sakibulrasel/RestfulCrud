/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restfulservice;

import bean.DrugGroupName;
import dao.DrugGroupNameDAO;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author zakir
 */
@Path("/drugGroupNames")
public class DrugGroupNameRS {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DrugGroupName> getAllDrugGroupName() {
        List<DrugGroupName> list = new DrugGroupNameDAO().getAllDrugGroupName();
        return list;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public DrugGroupName saveDrugGroupName(DrugGroupName d) {
        DrugGroupName dgn = new DrugGroupNameDAO().saveDrugGroupName(d);
        return dgn;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public DrugGroupName updateDrugGroupName(DrugGroupName d) {
        DrugGroupName dgn = new DrugGroupNameDAO().updateDrugGroupName(d);
        return dgn;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DrugGroupName deleteDrugGroupName(@PathParam("id") int id) {
        boolean status = new DrugGroupNameDAO().deleteDrugGroupName(id);
        if (status) {
            DrugGroupName dgn = new DrugGroupName();
            return dgn;
        }
        return null;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DrugGroupName getDrugGroupName(@PathParam("id") int id) {
        DrugGroupName dgn = new DrugGroupNameDAO().getDrugGroupName(id);
        return dgn;
    }
}
