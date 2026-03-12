package dgtic.core.service;

import dgtic.core.model.entity.Ciudad;
import dgtic.core.model.entity.Pais;
import dgtic.core.repository.ICiudadRepository;
import dgtic.core.repository.IPaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisCiudadService {

    @Autowired
    IPaisRepository paisRepository;

    @Autowired
    ICiudadRepository ciudadRepository;

    public List<Pais> getPaises(){
        return paisRepository.findAll();
    }

    public List<Ciudad> getCiudadPorPais(Long paisId){
        return ciudadRepository.findByPaisId(paisId);
    }

}
