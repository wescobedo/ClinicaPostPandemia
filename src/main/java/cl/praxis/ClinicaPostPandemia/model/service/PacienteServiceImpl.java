package cl.praxis.ClinicaPostPandemia.model.service;

import cl.praxis.ClinicaPostPandemia.ClinicaPostPandemiaApplication;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import cl.praxis.ClinicaPostPandemia.model.dto.Paciente;

@Service
public class PacienteServiceImpl implements PacienteService{

    private List<Paciente> pacienteList;
    private static final Logger logger = LoggerFactory.getLogger(ClinicaPostPandemiaApplication.class);



    public PacienteServiceImpl() {

        pacienteList = new ArrayList<>();

        pacienteList.add(new Paciente(1, "Waldo", "Escobedo", "1234", 1,0 ));
        pacienteList.add(new Paciente(2, "Clorinda", "Meza", "1122", 2,1 ));
        pacienteList.add(new Paciente(3, "Alexis", "Sanchez", "3344", 3,1 ));
    }

    public PacienteServiceImpl(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    @Override
    public List<Paciente> findAll() {

        logger.info("Ejecutando findAll de pacienteServiceImpl");

        return pacienteList;
    }

    @Override
    public Paciente findOne(int id) {

        return pacienteList.stream()
                .filter(paciente -> paciente.getId() == id)
                .findFirst()
                .orElse(null);

    }

    @Override
    public boolean create(Paciente p) {
        pacienteList.add(p);
        return true;
    }

    @Override
    public boolean update(Paciente p) {
        Paciente paciente = findOne(p.getId());
        paciente.setFirstName(p.getFirstName());
        paciente.setLastName(p.getLastName());
        paciente.setRut(p.getRut());
        paciente.setFichaId(p.getFichaId());
        paciente.setHospitalizado(p.getHospitalizado());
        return true;
    }

    @Override
    public boolean delete(int id) {
        Paciente p = findOne(id);
        if (p!=null) {
            pacienteList.remove(p);
            return true;

        }
        return false;
    }
}
