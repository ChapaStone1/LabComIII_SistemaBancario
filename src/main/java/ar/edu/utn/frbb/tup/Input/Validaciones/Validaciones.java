package ar.edu.utn.frbb.tup.Input.Validaciones;
import java.time.LocalDate;
import java.util.Scanner;

import ar.edu.utn.frbb.tup.Modelos.Personas.TipoPersona;

public class Validaciones {
    public static Boolean fechaNacValida(String fechaTexto) {
            // Intentar analizar la cadena de entrada como una fecha LocalDate
            try {
                LocalDate fechaNacimiento = LocalDate.parse(fechaTexto);
                return true;
            } catch (Exception e) {
                System.out.println("Error: La fecha ingresada no tiene el formato correcto.");
                System.out.println("Ingrese nuevamente la fecha de nacimiento en formato yyyy-MM-dd:");
            }
        return false;
    }

    public static TipoPersona tipoPersonaValida(int opcion) {
        TipoPersona tipoPersona = null;
        if (opcion == 1) {
            tipoPersona = TipoPersona.PERSONA_FISICA;
        } 
        else if (opcion == 2) {
            tipoPersona = TipoPersona.PERSONA_JURIDICA;
        } 
        else {
            // Manejar una opción no válida
            System.out.println("Opción no válida. Vuelva a intentarlo.");
            tipoPersona = null;
        }
        return tipoPersona;
    }
    
    
}
