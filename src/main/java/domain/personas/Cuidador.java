package domain.personas;

import domain.viajes.Viaje;

public class Cuidador{
    private Persona cuidador;

    Boolean aceptoViaje(Viaje unViaje) {
        return lePareceBuenViaje(unViaje);
    }

    private Boolean lePareceBuenViaje(Viaje unViaje) {
        //TODO lógica para decidir si le parece un bien viaje o no
        return true;
    }

    public void notificarArranque() {
    }

    public void notificarLlegadaBien() {
    }
}
