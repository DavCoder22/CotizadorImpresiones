package com.microservice.impresoras.controller;

import com.microservice.impresoras.entities.Impresora;
import com.microservice.impresoras.service.IImpresoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/impresoras")
public class ImpresoraController {

    @Autowired
    private IImpresoraService impresoraService;

    @GetMapping
    public ResponseEntity<List<Impresora>> findAllPrinters() {
        List<Impresora> impresoras = impresoraService.findAll();
        return new ResponseEntity<>(impresoras, HttpStatus.OK);
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPrinter(@RequestBody Impresora impresora) {
        impresoraService.save(impresora);
    }

    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editPrinter(@PathVariable Long id, @RequestBody Impresora impresora) {
        impresora.setId(id);
        impresoraService.save(impresora);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Impresora> findPrinterById(@PathVariable Long id) {
        Impresora impresora = impresoraService.findById(id);
        return new ResponseEntity<>(impresora, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePrinter(@PathVariable Long id) {
        impresoraService.deleteById(id);
    }
}
