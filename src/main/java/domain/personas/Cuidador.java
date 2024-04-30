package domain.personas;

import domain.viajes.Viaje;

public class Cuidador{
    private Persona cuidador;

    public Boolean aceptasViaje(Viaje unViaje) {
        if(lePareceBuenViaje(unViaje)) {
            unViaje.aceptoViaje(this);
            return true;
        } else {
            return false;
        }
    }

    private Boolean lePareceBuenViaje(Viaje unViaje) {
        //TODO lógica para decidir si le parece un bien viaje o no
        return true;
    }

    public void notificarArranque() {
        //TODO logica para recibir el mensaje
    }

    public void notificarLlegadaBien() {
        //TODO logica para recibir el mensaje
    }
}
