package guest;

import java.util.List;

public interface GuestDAO {

	public abstract void persist(Guest guest);

	public abstract List<Guest> getAllGuests();

}