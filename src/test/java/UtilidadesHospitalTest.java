import modelos.*;
import org.junit.jupiter.api.Test;
import utilidades.UtilidadesHospital;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class UtilidadesHospitalTest {

    @Test
    public void testGetPacientesConTipoEnfermedad() {

        // Crear una lista de pacientes de muestra
        List<Paciente> pacientes = new ArrayList<>();
        pacientes.add(new Paciente("Juan", "Pérez", "1990-01-01", TipoEnfermedad.LEVE));
        pacientes.add(new Paciente("María", "López", "1985-05-10", TipoEnfermedad.GRAVE));
        pacientes.add(new Paciente("Pedro", "García", "1978-12-15", TipoEnfermedad.LEVE));
        pacientes.add(new Paciente("Ana", "Sánchez", "1995-09-20", TipoEnfermedad.URGENCIAS));
        pacientes.add(new Paciente("Carlos", "Gómez", "1982-03-25", TipoEnfermedad.GRAVE));

        // Llamar al método getPacientesConTipoEnfermedad para obtener la lista filtrada
        List<Paciente> resultado = UtilidadesHospital.getPacientesConTipoEnfermedad(pacientes, TipoEnfermedad.GRAVE);

        // Verificar el resultado esperado
        assertEquals(2, resultado.size()); // Esperamos que haya 2 pacientes con enfermedad GRAVE
        assertEquals("Carlos", resultado.get(0).getNombre()); // El primer paciente debe ser Carlos
        assertEquals("Gómez", resultado.get(0).getApellidos()); // El primer paciente debe tener apellidos López
        assertEquals("María", resultado.get(1).getNombre()); // El segundo paciente debe ser María
        assertEquals("López", resultado.get(1).getApellidos()); // El segundo paciente debe tener apellidos Gómez
    }

    @Test
    public void testGetHospitalesPorProvincia() {
        // Crear una lista de hospitales de muestra
        List<Hospital> hospitales = new ArrayList<>();
        hospitales.add(new Hospital("Hospital A", "Provincia 1", "Ciudad 1", "Dirección 1", LocalDate.of(2000, 1, 1), 15));
        hospitales.add(new Hospital("Hospital B", "Provincia 2", "Ciudad 2", "Dirección 2", LocalDate.of(2005, 5, 5), 8));
        hospitales.add(new Hospital("Hospital C", "Provincia 1", "Ciudad 3", "Dirección 3", LocalDate.of(2010, 10, 10), 20));
        hospitales.add(new Hospital("Hospital D", "Provincia 3", "Ciudad 4", "Dirección 4", LocalDate.of(2015, 12, 31), 12));
        hospitales.add(new Hospital("Hospital E", "Provincia 2", "Ciudad 5", "Dirección 5", LocalDate.of(2020, 6, 15), 6));

        // Llamar al método getHospitalesPorProvincia para obtener el mapa de hospitales agrupados por provincia
        Map<String, List<Hospital>> resultado = UtilidadesHospital.getHospitalesPorProvincia(hospitales);

        // Verificar el resultado esperado
        assertEquals(2, resultado.size()); // Esperamos tener 2 provincias con hospitales que tengan una capacidad mayor que 10
        assertTrue(resultado.containsKey("Provincia 1")); // Debe existir la clave "Provincia 1" en el mapa
        assertTrue(resultado.containsKey("Provincia 3")); // Debe existir la clave "Provincia 3" en el mapa
        assertFalse(resultado.containsKey("Provincia 2")); // No debe existir la clave "Provincia 2" en el mapa, ya que el único hospital en esa provincia tiene una capacidad menor que 10
        assertEquals(2, resultado.get("Provincia 1").size()); // Esperamos que haya 2 hospitales en "Provincia 1"
        assertEquals(1, resultado.get("Provincia 3").size()); // Esperamos que haya 1 hospital en "Provincia 3"
    }


    @Test
    public void testAgrupaPacientes() {
        // Crear una lista de plantas de muestra
        List<Planta> plantas = new ArrayList<>();
        plantas.add(new Planta("Planta 1", 1, TipoEnfermedad.LEVE));
        plantas.add(new Planta("Planta 2", 2, TipoEnfermedad.GRAVE));
        plantas.add(new Planta("Planta 3", 3, TipoEnfermedad.URGENCIAS));

        // Crear una lista de pacientes de muestra
        List<Paciente> pacientes = new ArrayList<>();
        pacientes.add(new Paciente("Juan", "Pérez", "1990-01-01", TipoEnfermedad.LEVE));
        pacientes.add(new Paciente("María", "López", "1985-05-10", TipoEnfermedad.GRAVE));
        pacientes.add(new Paciente("Pedro", "García", "1978-12-15", TipoEnfermedad.LEVE));
        pacientes.add(new Paciente("Ana", "Sánchez", "1995-09-20", TipoEnfermedad.URGENCIAS));

        // Llamar al método agrupaPacientes para obtener el mapa de pacientes agrupados por planta
        Map<Planta, List<Paciente>> resultado = UtilidadesHospital.agrupaPacientes(plantas, pacientes);

        // Verificar el resultado esperado
        assertEquals(3, resultado.size()); // Esperamos tener 3 plantas en el mapa
        assertEquals(2, resultado.get(new Planta("Planta 1", 1, TipoEnfermedad.LEVE)).size()); // Esperamos tener 2 pacientes en "Planta 1"
        assertEquals(1, resultado.get(new Planta("Planta 2", 2, TipoEnfermedad.GRAVE)).size()); // Esperamos tener 1 paciente en "Planta 2"
        assertEquals(1, resultado.get(new Planta("Planta 3", 3, TipoEnfermedad.URGENCIAS)).size()); // Esperamos tener 1 paciente en "Planta 3"
    }

    @Test
    public void testGetPacientesPorPlanta() {
        // Crear una lista de médicos de muestra
        List<Medico> medicos = new ArrayList<>();
        medicos.add(new Medico("Dr. Juan", "Pérez",null, TipoEnfermedad.LEVE));
        medicos.add(new Medico("Dr. María", "López", null, TipoEnfermedad.GRAVE));
        medicos.add(new Medico("Dr. Pedro", "García", null, TipoEnfermedad.URGENCIAS));
        medicos.add(new Medico("Dr. Antonio", "Fernández", null, TipoEnfermedad.URGENCIAS));
        medicos.add(new Medico("Dr. Miguel", "Rios", null, TipoEnfermedad.URGENCIAS));

        // Crear una lista de plantas de muestra
        List<Planta> plantas = new ArrayList<>();
        plantas.add(new Planta("Planta 1", 1, TipoEnfermedad.LEVE));
        plantas.add(new Planta("Planta 2", 2, TipoEnfermedad.GRAVE));
        plantas.add(new Planta("Planta 3", 3, TipoEnfermedad.URGENCIAS));

        // Llamar al método getPacientesPorPlanta para obtener el mapa de número de pacientes por planta
        Map<Planta, Integer> resultado = UtilidadesHospital.getPacientesPorPlanta(medicos, plantas);

        // Verificar el resultado esperado
        assertEquals(3, resultado.size()); // Esperamos tener 3 plantas en el mapa
        assertEquals(1, resultado.get(new Planta("Planta 1", 1, TipoEnfermedad.LEVE))); // Esperamos tener 1 paciente en "Planta 1"
        assertEquals(1, resultado.get(new Planta("Planta 2", 2, TipoEnfermedad.GRAVE))); // Esperamos tener 1 paciente en "Planta 2"
        assertEquals(3, resultado.get(new Planta("Planta 3", 3, TipoEnfermedad.URGENCIAS))); // Esperamos tener 1 paciente en "Planta 3"
    }

    @Test
    public void testRealizarDiagnostico() {
        // Crear un paciente de muestra
        Paciente paciente1 = new Paciente("Antonio", "Pérez", "1990-01-01", TipoEnfermedad.GRAVE);
        Paciente paciente2 = new Paciente("Elena", "Lopez", "1990-01-01", TipoEnfermedad.UCI);

        // Crear una lista de médicos de muestra
        List<Medico> medicos = new ArrayList<>();
        medicos.add(new Medico("Dr. Juan", "Pérez", new Planta("Planta 1", 1, TipoEnfermedad.LEVE), TipoEnfermedad.LEVE));
        medicos.add(new Medico("Dr. María", "López", new Planta("Planta 2", 2, TipoEnfermedad.GRAVE), TipoEnfermedad.GRAVE));
        medicos.add(new Medico("Dr. Pedro", "García", new Planta("Planta 3", 3, TipoEnfermedad.UCI), TipoEnfermedad.UCI));




        Diagnostico diagnostico1 = UtilidadesHospital.realizarDiagnostico(paciente1, medicos);
        Diagnostico diagnostico2 = UtilidadesHospital.realizarDiagnostico(paciente2, medicos);

        // Verificar el resultado esperado
        assertNotNull(diagnostico1);
        assertEquals(LocalDate.now(),diagnostico1.getFechaEntradaHostpital());
        assertEquals(LocalDate.now().plusMonths(1),diagnostico1.getFechaSalidaHospital());
        assertEquals(paciente1,diagnostico1.getPaciente());
        assertEquals("Dr. María",diagnostico1.getMedicoAsignado().getNombre());
        assertEquals("Planta 2",diagnostico1.getPlanta().getNombre());

        // Verificar el resultado esperado
        assertNotNull(diagnostico2);
        assertEquals(LocalDate.now(),diagnostico2.getFechaEntradaHostpital());
        assertNull(diagnostico2.getFechaSalidaHospital());
        assertEquals(paciente2,diagnostico2.getPaciente());
        assertEquals("Dr. Pedro",diagnostico2.getMedicoAsignado().getNombre());
        assertEquals("Planta 3",diagnostico2.getPlanta().getNombre());


    }










}
