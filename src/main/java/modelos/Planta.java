package modelos;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Planta {

    private String nombre;
    private Integer numero;
    private TipoEnfermedad tipoEnfermedad;

}
