package cl.praxis.ClinicaPostPandemia.model.service;
import cl.praxis.ClinicaPostPandemia.model.dto.Paciente;

import java.util.List;
public interface PacienteService {
    List<Paciente> findAll();
    Paciente findOne(int id);
    boolean create(Paciente p);
    boolean update(Paciente p);
    boolean delete(int id);
}
