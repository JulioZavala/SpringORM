package app.test;

import app.dao.ServicioDAO;
import app.model.Servicio;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

    public static void main(String[] args) {
        //AppTest.getAll();
        AppTest.getServicio();
        //AppTest.addServicio();
    }

    public static void getAll() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");

        List<Servicio> servicios = servicioDAO.list();
        for (Servicio servicio : servicios) {
            System.out.println(servicio.getDescripcion() + " " + servicio.getCostoHora());
        }
    }

      
    
    public static void addServicio() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");
        
        Servicio servicio = servicioDAO.get(new Servicio(1l));
        
        servicio.setDescripcion("Alquiler de pelotas");
        servicio.setCostoHora(332.5d);
        servicioDAO.save(servicio);
        
        System.out.println(servicio.getId()+" "+servicio.getDescripcion()+" "+servicio.getCostoHora());
        
    }
    
    
    
    public static void getServicio() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");


        Servicio servicio = servicioDAO.get(new Servicio(4l));

        System.out.println(servicio.getId() + " " + servicio.getDescripcion()
                + " " + servicio.getCostoHora());
    }
}
