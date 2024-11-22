package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.service.ClientService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@SecurityRequirement(name = "Bearer")
@Tag(name = "Client  endpoint", description = " all endpoint of Client ")
public class ClientContoller {
    @Autowired
    ClientService clientService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Client>> Client() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Client> getClient(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getById(id).orElse(null));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        client.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
        return ResponseEntity.ok(clientService.add(client));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Client> updatClient(@RequestBody Client client) {
        client.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
        return ResponseEntity.ok(clientService.update(client));

    }
}
