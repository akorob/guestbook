package guest;
 
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Component;

 
@Component
public class GuestDaoImpl implements GuestDAO  {
    // Injected database connection:
    @PersistenceContext 
    private EntityManager em;
 
    /* (non-Javadoc)
	 * @see guest.GuestDAO#persist(guest.Guest)
	 */
  
    public void persist(Guest guest) {
        em.persist(guest);
    }
 
    
    /* (non-Javadoc)
	 * @see guest.GuestDAO#getAllGuests()
	 */
    
    public List<Guest> getAllGuests() {
    	TypedQuery<Guest> query = em.createQuery(
            "SELECT g FROM Guest g ORDER BY g.id", Guest.class);
    	return query.getResultList();
    }
}