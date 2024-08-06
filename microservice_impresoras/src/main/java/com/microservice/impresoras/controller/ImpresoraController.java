package com.microservice.impresoras.controller;

import com.microservice.impresoras.entities.Impresora;
import com.microservice.impresoras.service.IImpresoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


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

    // Nuevas funcionalidades
    @GetMapping("/conteo-tipo")
    public ResponseEntity<Map<String, Long>> conteoPorTipo() {
        Map<String, Long> conteoPorTipo = impresoraService.conteoPorTipo();
        return new ResponseEntity<>(conteoPorTipo, HttpStatus.OK);
    }

    @GetMapping("/filamento/promedio-costo-por-hora")
    public ResponseEntity<BigDecimal> promedioCostoPorHoraFilamento() {
        BigDecimal promedio = impresoraService.promedioCostoPorHora("filamento");
        return new ResponseEntity<>(promedio, HttpStatus.OK);
    }

    @GetMapping("/resina/promedio-costo-por-hora")
    public ResponseEntity<BigDecimal> promedioCostoPorHoraResina() {
        BigDecimal promedio = impresoraService.promedioCostoPorHora("resina");
        return new ResponseEntity<>(promedio, HttpStatus.OK);
    }
}
