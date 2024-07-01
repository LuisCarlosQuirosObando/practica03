package com.practica01.service;

import com.practica01.domain.Arbol;
import java.util.List;

public interface ArbolService {
    public List<Arbol> getArboles(boolean activos);
    
    public Arbol getArbol(Arbol arbol);
    
    public void save(Arbol arbol);
    
    public void delete(Arbol arbol);
}
