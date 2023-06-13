package utilidades;

import modelos.*;

import java.util.*;
import java.util.stream.Collectors;

public class UtilidadesHospital {

    public UtilidadesHospital() {
    }



    /**
     * Devuelve la lista de pacientes cuya enfermedad es el tipo del pasado y ordenador por apellidos.
     *
     * (1 punto)
     *
     * @param pacientes
     * @param tipoEnfermedad
     * @return
     */
    public static List<Paciente> getPacientesConTipoEnfermedad(List<Paciente> pacientes, TipoEnfermedad tipoEnfermedad){
        return new ArrayList<>();
    }


    /**
     * Devuelve la lista de hospitales agrupados por la provincia donde se encuentran siempre y cuando
     * su capacidad dea mayor que 10
     *
     * (1 punto)
     *
     * @param hospitales
     * @return
     */
    public static Map<String, List<Hospital>> getHospitalesPorProvincia(List<Hospital> hospitales){
        return new HashMap<>();
    }


    /**
     * Devuelve los pacientes agrupados por planta, hay que poner cada paciente en la planta cuyo TipoEnfermedad
     * sea igual a la del paciente
     * (2 puntos)
     *
     * @param pacientes
     * @param plantas
     * @return
     */
    public static Map<Planta,List<Paciente>> agrupaPacientes(List<Planta> plantas,List<Paciente> pacientes){
        return new HashMap<>();
    }


    /**
     * Devuelve el número de pacientes por planta, teniendo en cuanta que cada paciente se asocia a la planta que corresponda
     * con su tipo de enfermedad
     *
     * (2 puntos)
     *
     * @param medicos
     * @param plantas
     * @return
     */
    public static Map<Planta,Integer> getPacientesPorPlanta(List<Medico> medicos, List<Planta> plantas){

        return new HashMap<>();
    }


    /**
     * El método crea y devuelve un nuevo Diágnostico con los siguientes datos:
     * fecha entrada -> fecha actual
     * paciente -> el que se pasa como parámetro
     * médico -> el primero que coincida con el tipoEnfermedad del Paciente
     * planta -> la del médico asignado
     * fecha salida -> SI enfermedad es LEVE -> fecha actual
     *              -> SI enfermedad es URGENCIAS -> fecha actual + 1 día
     *              -> SI enfermedad es GRAVE -> fecha actual + 1 mes
     *              -> SI enfermedad es UCI -> null
     *
     *
     * (4 puntos)
     */
    public static Diagnostico realizarDiagnostico(Paciente paciente,List<Medico> medicos){
        return null;
    }









}
