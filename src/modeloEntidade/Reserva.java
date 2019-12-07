/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloEntidade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.Exeptions.DomainExeption;

/**
 *
 * @author THIAGO
 */
public class Reserva {
    
    private Integer roomnamber;
    private Date checkIn;
    private Date checkOut;
    
    private static SimpleDateFormat sdf  = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer roomnamber, Date checkIn, Date checkOut) {
        if (!checkOut.after(checkIn)){
            
            throw new DomainExeption("Data Invalida");
            }
        this.roomnamber = roomnamber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomnamber() {
        return roomnamber;
    }

    public void setRoomnamber(Integer roomnamber) {
        this.roomnamber = roomnamber;
    }

    public Date getCheckIn() {
        return checkIn;
    }


    public Date getCheckOut() {
        return checkOut;
    }

    public long duration(){
        long diff =  checkOut.getTime()-checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        
    }
    
    public void updateDates(Date checkIn, Date checkOut ){
        Date now = new Date();
            
            if (checkIn.before(now)|| checkOut.before(now)){
                throw new DomainExeption("a reserva data de atualização deve ser datas futuras ");
            }
           if (!checkOut.after(checkIn)){
            
            throw new DomainExeption("Data Invalida");
            }
               
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        
    }
    @Override
    public String toString(){
        return "Room " + roomnamber + ", check-In " +sdf.format(checkIn) + ", check-Out  " + sdf.format(checkOut)+" , "+  duration() + " Night";
    }
    
}
