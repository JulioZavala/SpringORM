package app.test;

import app.dao.CampoDAO;
import app.dao.LocalDAO;
import app.dao.ServicioDAO;
import app.model.Campo;
import app.model.Local;
import app.model.Servicio;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

    public static void main(String[] args) {
        //AppTest.getAll();
        //AppTest.getServicio();
        //AppTest.addServicio();
        AppTest.updateServicio();
        //AppTest.deleteServicio();
    }

    public static void getAll() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        CampoDAO campoDAO = (CampoDAO) context.getBean("campoDAO");
        LocalDAO localDAO = (LocalDAO) context.getBean("localDAO");

        /*
        List<Campo> campos = campoDAO.list();
        for (Campo campo : campos) {
            System.out.println(campo.getId() + " " + campo.getDescripcion() + " - " + campo.getLocal().getDescripcion() + " " + campo.getCostoHora());
        }
        */
        
        /*
        List<Local> locales = localDAO.list();
        for (Local local : locales) {
            List<Campo> campos = local.getCampo();
            for (Campo campo : campos) {
                System.out.println(local.getId()+ " " + local.getDescripcion() + " - " + campo.getDescripcion() + " " + campo.getCostoHora());
            }
        }
        */
        
        Local local = localDAO.get(new Local(4l));
        List<Campo> campos = campoDAO.allByLocal(local);
        System.out.println("---" + local.getDescripcion() +"---");
        for (Campo campo : campos) {
            System.out.println(campo.getDescripcion() + " " + campo.getCostoHora());
        }
    }

      
    
    public static void addServicio() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");
        
        Servicio servicio = servicioDAO.get(new Servicio(1l));
        
        servicio.setDescripcion("Alquiler de sombreros");
        servicio.setCostoHora(2.5d);
        servicioDAO.save(servicio);
        
        System.out.println(servicio.getId()+" "+servicio.getDescripcion()+" "+servicio.getCostoHora());
        
    }
    
    
    
    public static void getServicio() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");


        Servicio servicio = servicioDAO.get(new Servicio(1l));

        System.out.println(servicio.getId() + " " + servicio.getDescripcion()
                + " " + servicio.getCostoHora());
    }


public static void updateServicio() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");
        
        
        Servicio servicio = servicioDAO.get(new Servicio(5l))  ;
        
        servicio.setCostoHora(10.4d);
        servicioDAO.update(servicio);
        
    }

public static void deleteServicio() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");
        
        
        Servicio servicio = new Servicio(7l);
        servicioDAO.delete(servicio);
        
    }


}
