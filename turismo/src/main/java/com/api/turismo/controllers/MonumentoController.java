package com.api.turismo.controllers;

import com.api.turismo.model.Monumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.turismo.services.MonumentoService;

import java.util.List;

@RestController
@RequestMapping("/monumentos")
public class MonumentoController {
    @Autowired
    private MonumentoService monumentoService;

    @GetMapping
    public List<Monumento> getMonumentos(){
        return this.monumentoService.getMonumentos();
    }
    @GetMapping("/search")
    public ResponseEntity<Monumento> getMonumentoByNombre(@RequestParam("name") String nombre) {
        Monumento monumento = monumentoService.getMonumentoByName(nombre);
        if (monumento != null) {
            return ResponseEntity.ok(monumento);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @GetMapping("/monumentos/search")
    public List<Monumento> searchMonumentosByNombre(@RequestParam("name") String nombre) {
        return monumentoService.searchMonumentosByNombre(nombre);
    }

    @GetMapping("/localidad")
    public List<Monumento> getMonumentosByLocalidadId(@RequestParam("localidadId") Long localidadId) {
        return monumentoService.getMonumentosByLocalidadId(localidadId);
    }

    @PostMapping
    public ResponseEntity<Monumento> createMonumento(@RequestBody Monumento monumento) {
        try {
            Monumento savedMonumento = monumentoService.saveMonumento(monumento);
            return new ResponseEntity<>(savedMonumento, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> deleteMonumento(@PathVariable Long id) {
        try {
            monumentoService.deleteMonumento(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monumento> updateMonumento(@PathVariable Long id, @RequestBody Monumento newMonumento) {
        try {
            Monumento updatedMonumento = monumentoService.updateMonumento(id, newMonumento);
            return new ResponseEntity<>(updatedMonumento, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
