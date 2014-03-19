package guest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GuestServiceImpl implements GuestService{
	
	@Autowired
    private GuestDAO guestDao;
	
	@Transactional
    public void save(Guest guest) {
		guestDao.persist(guest);
    }
	
	
	public List<Guest> findAllGuests() {
		return guestDao.getAllGuests();
	}
}
