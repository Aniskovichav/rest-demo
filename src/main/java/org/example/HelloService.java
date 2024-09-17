package org.example;

import org.apache.commons.lang.StringUtils;
import org.example.dao.EmployeeDao;
import org.example.db.JPAService;
import org.example.entity.Employee;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;


@Path("/hello")
public class HelloService {

    private EmployeeDao employeeDao = new EmployeeDao();
    static {
        JPAService.initialize();

    }

    @GET
    @Path("/is-alive")
    @Produces(MediaType.TEXT_PLAIN)
    public String serverTime() {


        Employee e1 = new Employee();
        e1.setName("James");
        e1.setRole("Admin");
        e1.setInsertTime(new Date());
        employeeDao.create(e1);

        System.out.println("server time request");
        return new Date().toString() + "/ Employee size: " + employeeDao.findAll().size();
    }

    @GET
    @Path("/show-all-empl")
    @Produces(MediaType.TEXT_PLAIN)
    public String showAllEmpls() {

        return "All empls: " + employeeDao.findAll();

    }


    @GET
    @Path("{clientName}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response greetClient(@PathParam("clientName") String name) {
        if (StringUtils.isBlank(name)){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Invalid name").type(MediaType.TEXT_PLAIN).build();
        }
        String output = "Hi " + name;
        return Response.status(200).entity(output).build();
    }
}
