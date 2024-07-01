package com.practica01.controller;


import com.practica01.domain.Arbol;
import com.practica01.service.ArbolService;
import com.practica01.service.impl.FirebaseStorageServiceImpl;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping("/arbol")
public class ArbolController {
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @Autowired
    private ArbolService arbolService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        List<Arbol> arboles = arbolService.getArboles(false);
        model.addAttribute("arboles", arboles);
        model.addAttribute("totalArboles", arboles.size());
        return "/arbol/listado";
    }

    @GetMapping("/nuevo")
    public String arbolNuevo(Arbol arbol) {
        return "/arbol/modifica";
    }

    @PostMapping("/guardar")
public String arbolGuardar(Arbol arbol,
                           @RequestParam("imagenFile") MultipartFile imagenFile,
                           RedirectAttributes redirectAttrs) {

    

    if (!imagenFile.isEmpty()) {
        // Guardar el árbol para generar el ID
        arbolService.save(arbol);

        // Subir la imagen y actualizar la ruta de la imagen
        arbol.setRutaImagen(
                firebaseStorageService.cargaImagen(
                        imagenFile,
                        "arbol",
                        arbol.getIdArbol()));
    }

    arbolService.save(arbol);
    redirectAttrs.addFlashAttribute("mensaje", "Árbol guardado correctamente.");
    return "redirect:/arbol/listado";
}

    @GetMapping("/eliminar/{idArbol}")
    public String arbolEliminar(Arbol arbol) {
        arbolService.delete(arbol);
        return "redirect:/arbol/listado";
    }

    @GetMapping("/modificar/{idArbol}")
    public String arbolModificar(Arbol arbol, Model model) {
        arbol = arbolService.getArbol(arbol);
        model.addAttribute("arbol", arbol);
        return "/arbol/modifica";
    }
}
