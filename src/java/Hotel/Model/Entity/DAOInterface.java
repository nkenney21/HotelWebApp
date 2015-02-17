/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotel.Model.Entity;

import java.util.List;

/**
 *
 * @author neilkenney
 */
public interface DAOInterface {

    void createHotel(String hotel_name, String street_address, String city, String state, String postal_code, String notes);

    void deleteHotelById(String hotelId);
    //
    //    public static void main(String[] args) {
    //        HotelDao db = new HotelDao();
    //        db.deleteHotelByName("Hotel Neil");
    //        System.out.println(db.getAllHotels());
    //    }

    List<Hotel> getAllHotels();

   void updateHotelById(String hotelId,List ColValues);
   
   Hotel getHotelById(String Id);
    
}
