
package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.Exeptions.DomainExeption;
import modeloEntidade.Reserva;

public class JavaAulaExeptions {


    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {          
              
        System.out.print("Room Number ");
        int number = sc.nextInt();

        System.out.print("Check-In Date (dd/MM/yyyy ): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-Out Date (dd/MM/yyyy ): ");
        Date checkOut = sdf.parse(sc.next());
        
        Reserva reserva = new Reserva(number, checkIn, checkOut);
        System.out.println("Reserva "+reserva);
        
        System.out.println();
        System.out.println("Entre com a data atualização ");
        System.out.print("Check-In Date (dd/MM/yyyy ): ");
        checkIn = sdf.parse(sc.next());
        System.out.print("Check-Out Date (dd/MM/yyyy ): ");
        checkOut = sdf.parse(sc.next());
        reserva.updateDates(checkIn, checkOut);
        System.out.println("Reserva "+reserva);
          } 
        catch (ParseException e ){
            System.out.println("Date Invalida ");
          
        }
        catch (DomainExeption e) {         
            System.out.println("Reserva invalida " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Erro Inesperado");
        }
       
       
       

         sc.close();


    }
    
}
