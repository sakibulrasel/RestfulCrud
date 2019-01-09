
package restfulservice;

import bean.DrugCompany;
import dao.DrugCompanyDAO;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/drugCompanys")

public class DrugCompanyRS {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DrugCompany> getAllDrugCompany() {
        List<DrugCompany> list = new DrugCompanyDAO().getAllDrugCompany();
        return list;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public DrugCompany saveDrugCompany(DrugCompany dc) {
        DrugCompany drugCompany = new DrugCompanyDAO().saveDrugCompany(dc);
        return drugCompany;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public DrugCompany updateDrugCompany(DrugCompany dc) {
        DrugCompany drugCompany = new DrugCompanyDAO().updateDrugCompany(dc);
        return drugCompany;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DrugCompany deleteDrugCompany(@PathParam("id") int id) {
        boolean status = new DrugCompanyDAO().deleteDrugCompany(id);
        if (status) {
            DrugCompany dc = new DrugCompany();
            return dc;
        }
        return null;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DrugCompany getProduct(@PathParam("id") int id) {
        DrugCompany dc = new DrugCompanyDAO().getDrugCompany(id);
        return dc;
    }
}
