package domain.viajes;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Ubicacion {
    private String provincia;
    private String ciudad;
    private Integer CP;
    private String calle;
    private Integer altura;
}
