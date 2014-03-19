package guest;
 
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

 
@Controller
public class GuestController {
 
    @Autowired
    private GuestDao guestDao;
 
    
    /*
    public ModelAndView guestbook(HttpServletRequest request) {
        // Handle a new guest (if any):
        String name = request.getParameter("name");
        if (name != null)
            guestDao.persist(new Guest(name));
 
        // Prepare the result view (guest.jsp):
        return new ModelAndView("guest.jsp", "guestDao", guestDao);
    }
    
    */
    @RequestMapping(value="/guest", method = RequestMethod.GET)
     public String guest(Model model) {
    		    	
	    	List<Guest> list = guestDao.getAllGuests();
	    	for(Guest g: list){
	    		System.out.println(g);
	    	}
			model.addAttribute("list",list);
			model.addAttribute("controllerMessage",
				"This is the message from the controller "+new Date());
			return "guest";
	}
    
    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact")
                            Guest guest, BindingResult result) {
        String name =  guest.getName();
        System.out.println("Name:" + name);
        if (name != null)
            guestDao.persist(new Guest(name)); 
        return "redirect:guest.html";
    }

}