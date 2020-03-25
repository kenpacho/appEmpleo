package net.carlospracticas.Controller;


import net.carlospracticas.model.Vacante;
import net.carlospracticas.service.ICategoriasService;
import net.carlospracticas.service.IVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/vacantes")
public class vacantesController {

    @Autowired
    private IVacantesService serviceVacante;

    @Autowired
    private ICategoriasService serviceCategorias;

    @GetMapping("/create")
    public String crear(Vacante vacante, Model model){
        model.addAttribute("categorias", serviceCategorias.buscarTodas());
        return "vacantes/formVacante";
    }


    @PostMapping("/save")
    public String guardar(Vacante vacante, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            for(ObjectError error: result.getAllErrors()){
                System.out.println("Ocurrio un error: " + error.getDefaultMessage());
            }
            return "vacantes/formVacante";
        }
        serviceVacante.guardar(vacante);
        attributes.addFlashAttribute("msg", "Registro guardado");
        System.out.println("Vacante: " + vacante);
        return "redirect:/vacantes/index";

    }

    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int idVacante, Model model){
        System.out.println("Borrando vacante con id: " +idVacante );
        model.addAttribute("id", idVacante);
        return "mensaje";

    }


    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idVacante, Model model){
        Vacante vacante = serviceVacante.buscarPorId(idVacante);
        System.out.println("Vacante: " + vacante);
        model.addAttribute("vacante", vacante);
        return "detalle";


    }

    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        List<Vacante> lista = serviceVacante.buscarTodas();
        model.addAttribute("vacantes", lista);
        return "vacantes/listVacantes";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }


}
