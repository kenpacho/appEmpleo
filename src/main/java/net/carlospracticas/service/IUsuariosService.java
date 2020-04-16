package net.carlospracticas.service;

import  net.carlospracticas.model.Usuario;

import net.carlospracticas.model.Usuario;

import java.util.List;

public interface IUsuariosService {


    void guardar(Usuario usuario);


    void eliminar(Integer idUsuario);

    List<Usuario> buscarTodos();

}
