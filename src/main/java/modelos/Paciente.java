package modelos;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Paciente {

    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private TipoEnfermedad tipoEnfermedad;

}
