package modelos;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Hospital {

    private String nombre;
    private String provincia;
    private String ciudad;
    private String direccion;
    private LocalDate fechaFundacion;
    private Integer capacidadMaxima;

}
