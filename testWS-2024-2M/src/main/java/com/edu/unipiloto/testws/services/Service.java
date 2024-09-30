package com.edu.unipiloto.testws.services;

import com.edu.unipiloto.testws.entidad.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Maria
 */
@Path("services")
public class Service {

    private static Map<Integer, Person> personas = new HashMap();

    static {
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            int id = i + 1;
            person.setId(id);
            person.setFullName("Persona " + id);
            person.setAge(new Random().nextInt(40) + 1);
            person.setSalary();
            personas.put(id, person);
        }
    }

    @GET
    @Path("/getAllPersonsInJson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersonsInJson() {
        return new ArrayList<Person>(personas.values());
    }

    @GET
    @Path("/getAllPersonsInXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Person> getAllPersonsInXML() {
        return new ArrayList<Person>(personas.values());
    }

     @GET
    @Path("/getPersonByIdXML/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByIdXML(@PathParam("id") int id) {
        return personas.get(id);
    }
    
    
    @GET
    @Path("/getPersonByIdJson/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByIdJson(@PathParam("id") int id) {
        return personas.get(id);
    }
    
    @POST
    @Path("/addPersonInJson")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person addPersonInJson(Person persona) {
        personas.put(new Integer(persona.getId()), persona);
        return persona;
    }

    @GET
    @Path("/getSalaryAvarage")
    @Produces(MediaType.APPLICATION_XML)
    public String getSalaryAvarage() {
        double totalSalary = 0;

        for (Person person : personas.values()) {
            totalSalary += person.getSalary();
        }

        double averageSalary = totalSalary / personas.size();
        return "<salaryAverage>" + averageSalary + "</salaryAverage>";
    }

    @GET
    @Path("/getSalarySumInJson")
    @Produces(MediaType.APPLICATION_JSON)
    public double getSalarySumInJson() {
        double totalSalary = 0;

        for (Person person : personas.values()) {
            totalSalary += person.getSalary();
        }

        return totalSalary;
    }
}


