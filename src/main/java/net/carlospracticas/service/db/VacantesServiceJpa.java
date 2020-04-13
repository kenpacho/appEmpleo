package net.carlospracticas.service.db;

import net.carlospracticas.model.Vacante;
import net.carlospracticas.repository.VacantesRepository;
import net.carlospracticas.service.IVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class VacantesServiceJpa implements IVacantesService {

    @Autowired
    private VacantesRepository vacantesRepo;

    @Override
    public List<Vacante> buscarTodas() {
        return vacantesRepo.findAll();

    }

    @Override
    public Vacante buscarPorId(Integer idVacante) {
       Optional<Vacante> optional = vacantesRepo.findById(idVacante);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public void guardar(Vacante vacante) {
        vacantesRepo.save(vacante);

    }
}
