package net.carlospracticas.service.db;

import net.carlospracticas.model.Usuario;
import net.carlospracticas.repository.UsuariosRepository;
import net.carlospracticas.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class UsuariosServiceJpa implements IUsuariosService {

        @Autowired
        private UsuariosRepository usuariosRepo;

        @Override
        public void guardar(Usuario usuario) {
            usuariosRepo.save(usuario);
        }

        @Override
        public void eiminar(Integer idUsuario) {
            usuariosRepo.deleteById(idUsuario);
        }

        @Override
        public List<Usuario> buscarTodos() {
            return usuariosRepo.findAll();
        }


    }

