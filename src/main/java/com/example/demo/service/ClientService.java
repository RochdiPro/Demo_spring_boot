package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService  implements DefaultService<Client, Long> {

    @Autowired
    ClientRepository clientRepository;



    @Override
    public JpaRepository<Client, Long> getRepository() {
        return this.clientRepository;
    }
}

