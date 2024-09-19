package org.example;


import org.example.dao.CurrencyDao;
import org.example.db.JPAService;
import org.example.entity.Currencies;
import org.example.entity.Currency;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

@Path("/rate")
public class RateService {
    private CurrencyDao currencyDao = new CurrencyDao();
    static {
        JPAService.initialize();
    }

    @GET
    @Path("/get-all-rate")
    @Produces(MediaType.APPLICATION_XML)
    public List<Currency> getAllRate() {

        return currencyDao.findAll();

    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_XML)
    public Response create(Currency currency){
        try {
            currencyDao.create(currency);
            return Response.status(200).entity("Currency rating successfully created").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(400).entity("Currency rating NOT created").build();
        }
    }

    @POST
    @Path("/create-all")
    @Consumes(MediaType.APPLICATION_XML)
    public Response create(Currencies currencies){
        try {
            currencyDao.create(currencies.getCurrencies());
            return Response.status(200).entity("Currencies rating successfully created").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(400).entity("Currencies rating NOT created").build();
        }
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_XML)
    public Response update(Currency currency){
        try {
            currencyDao.update(currency);
            return Response.status(200).entity("Currency rating successfully updated").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(400).entity("Currency rating NOT updated").build();
        }
    }
    @DELETE
    @Path("/remove/{id}")
    public Response deleteById(@PathParam("id") String id){
        int emplId = Integer.parseInt(id);
        if(emplId >= 0){
            if(Objects.isNull(currencyDao.findById(emplId))) {
                return Response.status(400).entity("Currency with ID " + id + "NOT exist").build();
            }
            currencyDao.deleteById(emplId);
            return Response.status(200).entity("Currency with ID " + id + " successfully removed").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("Currency with ID " + id + "NOT removed").build();
    }
}
