package net.carlospracticas.service;

import net.carlospracticas.model.Vacante;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Service
public class VacantesServiceImpl implements IVacantesService {

    private List<Vacante> lista =null;

    public VacantesServiceImpl(){

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        lista = new LinkedList<Vacante>();

        try{

            Vacante vacante1 = new Vacante();
            vacante1.setId(1);
            vacante1.setNombre("Ingeniero Civil");
            vacante1.setDescripcion("Solicitamos Ing. Civil para diseñar puente peatonal.");
            vacante1.setFecha(sdf.parse("08-02-2020"));
            vacante1.setSalario(14000);
            vacante1.setDestacado(1);
            vacante1.setImagen("empresa1.png");

            Vacante vacante2 = new Vacante();
            vacante2.setId(2);
            vacante2.setNombre("Contable Publico");
            vacante2.setDescripcion("Empresa importante solicita contable con 5 años de experiencia titulado.");
            vacante2.setFecha(sdf.parse("09-02-2020"));
            vacante2.setSalario(12000);
            vacante2.setDestacado(0);
            vacante2.setImagen("empresa2.png");

            Vacante vacante3 = new Vacante();
            vacante3.setId(3);
            vacante3.setNombre("Ingeniero Eléctrico");
            vacante3.setDescripcion("Empresa internacional solicitua Ingeniero mecánico para mantenimiento de la instalación eléctrica.");
            vacante3.setFecha(sdf.parse("10-02-2020"));
            vacante3.setSalario(10500);
            vacante3.setDestacado(0);


            Vacante vacante4 = new Vacante();
            vacante4.setId(4);
            vacante4.setNombre("Diseñador Gráfico");
            vacante4.setDescripcion("Solicitamos Diseñador Gráfico titulado para diseñar publicidad de la empresa.");
            vacante4.setFecha(sdf.parse("11-02-2020"));
            vacante4.setSalario(7500);
            vacante4.setDestacado(1);
            vacante4.setImagen("empresa3.png");

            lista.add(vacante1);
            lista.add(vacante2);
            lista.add(vacante3);
            lista.add(vacante4);


        }catch (ParseException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Vacante> buscarTodas() {
        return lista;
    }

    @Override
    public Vacante buscarPorId(Integer idVacante) {
        for(Vacante v: lista){
            if(v.getId() == idVacante){
                return v;
            }
        }
        return null;
    }

    @Override
    public void guardar(Vacante vacante) {
        lista.add(vacante);
    }
}
