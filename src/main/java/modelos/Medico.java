package modelos;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Medico {
    private String nombre;
    private String apellidos;
    private Planta planta;
    private TipoEnfermedad especialidad;
}
