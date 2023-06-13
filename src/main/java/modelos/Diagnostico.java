package modelos;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Diagnostico {
    private LocalDate fechaEntradaHostpital;
    private LocalDate fechaSalidaHospital;
    private TipoEnfermedad tipoEnfermedad;
    private Paciente paciente;
    private Planta planta;
    private Medico medicoAsignado;

}
