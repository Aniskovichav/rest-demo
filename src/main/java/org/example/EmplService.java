package org.example;

import org.example.dao.EmployeeDao;
import org.example.db.JPAService;
import org.example.entity.Employee;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

@Path("/empl")
public class EmplService {

    private EmployeeDao employeeDao = new EmployeeDao();
    static {
        JPAService.initialize();
    }

    @GET
    @Path("/get-all-employee")
    @Produces(MediaType.APPLICATION_XML)
    public List<Employee> getAllEmpls() {

        return employeeDao.findAll();

    }

    @DELETE
    @Path("/remove/{id}")
    public Response deleteById(@PathParam("id") String id){
        int emplId = Integer.parseInt(id);
        if(emplId >= 0){
            if(Objects.isNull(employeeDao.findById(emplId))) {
                return Response.status(400).entity("Empl with ID " + id + "NOT exist").build();
            }
            employeeDao.deleteById(emplId);
            return Response.status(200).entity("Empl with ID " + id + " successfully removed").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("Empl with ID " + id + "NOT removed").build();
    }
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_XML)
    public Response create(Employee employee){
        employeeDao.create(employee);
        try {
            employeeDao.create(employee);
            return Response.status(200).entity("Employee successfully created").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(400).entity("Employee NOT created").build();
        }
    }

}
