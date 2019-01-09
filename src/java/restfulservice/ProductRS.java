
package restfulservice;

import bean.Product;
import dao.ProductDAO;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/products")

public class ProductRS {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProduct() {
        List<Product> list = new ProductDAO().getAllProduct();
        return list;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Product saveProduct(Product p) {
        Product product = new ProductDAO().saveProduct(p);
        return product;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Product updateProduct(Product p) {
        Product product = new ProductDAO().updateProduct(p);
        return product;
    }
    
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product saleProduct(Product p, @PathParam("id") int id, @PathParam("qty") int qty) {
        Product product = new ProductDAO().saleProduct(p, id, qty);
        return product;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product deleteProduct(@PathParam("id") int id) {
        boolean status = new ProductDAO().deleteProduct(id);
        if (status) {
            Product p = new Product();
            return p;
        }
        return null;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@PathParam("id") int id) {
        Product p = new ProductDAO().getProduct(id);
        return p;
    }
}
