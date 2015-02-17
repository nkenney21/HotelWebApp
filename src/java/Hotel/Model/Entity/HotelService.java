

package Hotel.Model.Entity;

import java.util.List;

/**
 *
 * @author neilkenney
 */
public class HotelService {
    
    DAOInterface dao = new HotelDao();
    
    
    public List<Hotel> returnAllRecords(String tableName){
        return dao.getAllHotels();
    }
    
    public void deleteRecordByName(String id){
        dao.deleteHotelById(id);
    }
    
    public Hotel returnHotelByID(String Id){
        return dao.getHotelById(Id);
    }
    
    public void updateHotel(String hotelid, List colVales){
        dao.updateHotelById(hotelid, colVales);
    }
    
    public void createRecord(String hotel_name, String street_address, String city, String state, String postal_code, String notes){
        dao.createHotel(hotel_name, street_address,city,state,postal_code,notes);
    }

  
//    public static void main(String[] args) {
//        HotelService hotel = new HotelService();
//        Hotel re = hotel.returnHotelByID("1");
//        System.out.println(re.getHotel_Name());
//    }
}
