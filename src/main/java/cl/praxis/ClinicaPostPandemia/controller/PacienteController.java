package cl.praxis.ClinicaPostPandemia.controller;

import cl.praxis.ClinicaPostPandemia.ClinicaPostPandemiaApplication;
import cl.praxis.ClinicaPostPandemia.model.dto.Paciente;
import cl.praxis.ClinicaPostPandemia.model.service.PacienteService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    private static final Logger logger = LoggerFactory.getLogger(ClinicaPostPandemiaApplication.class);
    PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @GetMapping()
    public String findAll(Model model){
        logger.info("Ejecutando findAll() de PacienteController");
        model.addAttribute("pacientes", service.findAll());
        return "pacienteList";
    }
    @GetMapping("/{id}")
    public String findOne(@PathVariable("id") int id, Model model){
        model.addAttribute("paciente", service.findOne(id));

        return "pacienteEdit";
    }

    @PostMapping
    public String update(@ModelAttribute Paciente paciente){
        boolean result = service.update(paciente);

        if (result){
            logger.info("Paciente actualizado correctamente");
        } else {
            logger.error("Error al actualizar paciente");
        }

        return "redirect:/pacientes";
    }
    @GetMapping("/new")
    public ModelAndView create(){
        return new ModelAndView("pacienteNew");
    }

    @PostMapping("/new")
    public String save(@ModelAttribute Paciente paciente){
        boolean result = service.create(paciente);

        if (result){
            logger.info("Paciente creado correctamente");
        } else {
            logger.error("Error al crear paciente");
        }
        return "redirect:/pacientes";
    }

    @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") int id){
        boolean result = service.delete(id);

        if (result){
            logger.info("Paciente eliminado correctamente");
        } else {
            logger.error("Error al eliminar el Paciente");
        }
        return "redirect:/pacientes";
    }



}
