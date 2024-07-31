package cl.praxis.ClinicaPostPandemia.model.dto;

public class Paciente {

    private int id;
    private String firstName;
    private String lastName;
    private String rut;
    private int fichaId;
    private int hospitalizado;


    public Paciente() {
    }

    public Paciente(int id, String firstName, String lastName, String rut, int fichaId, int hospitalizado) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rut = rut;
        this.fichaId = fichaId;
        this.hospitalizado = hospitalizado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getFichaId() {
        return fichaId;
    }

    public void setFichaId(int fichaId) {
        this.fichaId = fichaId;
    }

    public int getHospitalizado() {
        return hospitalizado;
    }

    public void setHospitalizado(int hospitalizado) {
        this.hospitalizado = hospitalizado;
    }
}
