package cr.ac.una.controller;

import cr.ac.una.services.SkillService;
import jakarta.ejb.EJB;
import jakarta.jws.WebService;

/**
 * 
 * @author arayaroma
 */
@WebService(serviceName = "SkillController")
public class SkillController {

    @EJB
    SkillService skillService;
    
}
