package net.carlospracticas.service;

import net.carlospracticas.model.Vacante;

import java.util.List;

public interface IVacantesService {
    List<Vacante> buscarTodas();
    Vacante buscarPorId(Integer idVacante);
    void guardar(Vacante vacante);
}
