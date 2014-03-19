package guest;

import java.util.List;

public interface GuestService {

	public abstract void save(Guest guest);

	public abstract List<Guest> findAllGuests();

}