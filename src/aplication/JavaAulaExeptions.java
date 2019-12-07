
package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import modeloEntidade.Reserva;

public class JavaAulaExeptions {


    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Room Number ");
        int number = sc.nextInt();
        
        System.out.print("Check-In Date (dd/MM/yyyy ): ");
        Date checkIn = sdf.parse(sc.next());
        
         System.out.print("Check-Out Date (dd/MM/yyyy ): ");
        Date checkOut = sdf.parse(sc.next());
        
        if (!checkOut.after(checkIn)){
            
            System.err.println("Data Invalida");
            
        }
        else {
            Reserva reserva = new Reserva(number, checkIn, checkOut);
            System.out.println("Reserva "+reserva);
            
            System.out.println();
            System.out.println("Entre com a data atualização ");
            
            System.out.print("Check-In Date (dd/MM/yyyy ): ");
            checkIn = sdf.parse(sc.next());
        
            System.out.print("Check-Out Date (dd/MM/yyyy ): ");
            checkOut = sdf.parse(sc.next());
            
            
            
            String error = reserva.updateDates(checkIn, checkOut);
            if (error != null){
                
                System.out.println("Error reserva " + error);
            }
            else{
            System.out.println("Reserva "+reserva);
            }
            
        }
        
        sc.close();


    }
    
}
