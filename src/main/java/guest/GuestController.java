package guest;
 
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


 
@Controller
public class GuestController {
 
    @Autowired
    private GuestService guestService;
 
    @RequestMapping(value="/guest", method = RequestMethod.GET)
     public String guest(Model model) {
    		    	
	    	List<Guest> list = guestService.findAllGuests();
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
        	guestService.save(new Guest(name)); 
        return "redirect:guest.html";
    }

}