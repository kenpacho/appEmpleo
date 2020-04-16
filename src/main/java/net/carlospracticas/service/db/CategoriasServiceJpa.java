package net.carlospracticas.service.db;

import net.carlospracticas.model.Categoria;
import net.carlospracticas.repository.CategoriasRepository;
import net.carlospracticas.service.ICategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class CategoriasServiceJpa implements ICategoriasService {

    @Autowired
    private CategoriasRepository categoriasRepo;


    @Override
    public void guardar(Categoria categoria) {
        categoriasRepo.save(categoria);

    }

    @Override
    public List<Categoria> buscarTodas() {
        return categoriasRepo.findAll();

    }

    @Override
    public Categoria buscarPorId(Integer idCategoria) {
        Optional<Categoria> optional =  categoriasRepo.findById(idCategoria);
        if(optional.isPresent()){
            return optional.get();

        }
        return null;
    }

    @Override
    public void eliminar(Integer idCategoria) {
        categoriasRepo.deleteById(idCategoria);
    }
}
