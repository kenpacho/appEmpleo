package net.carlospracticas.Controller;


import net.carlospracticas.model.Vacante;
import net.carlospracticas.service.IVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vacantes")
public class vacantesController {

    @Autowired
    private IVacantesService serviceVacante;

    @GetMapping("/create")
    public String crear(){
        return "vacantes/formVacante";
    }

    @PostMapping("/save")
    public String guardar(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion, @RequestParam("estatus") String estatus, @RequestParam("fecha") String fecha,
                           @RequestParam("destacado") int destacado, @RequestParam("salario") Double salario, @RequestParam("detalles") String detalles){

        System.out.println("Nombre vacante: " + nombre);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Estatus: " + estatus);
        System.out.println("Fecha Publicacion: " + fecha);
        System.out.println("Destacado: " + destacado);
        System.out.println("Salario Ofrecido: " + salario);
        System.out.println("Detalles: " + detalles);

        return "vacantes/listVacantes";

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
}
