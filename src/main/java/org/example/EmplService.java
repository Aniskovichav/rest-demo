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
import java.util.List;

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

}
