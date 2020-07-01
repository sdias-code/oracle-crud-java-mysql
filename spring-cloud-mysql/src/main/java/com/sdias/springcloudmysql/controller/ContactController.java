package com.sdias.springcloudmysql.controller;

import com.sdias.springcloudmysql.model.Contact;
import com.sdias.springcloudmysql.repository.ContactRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private ContactRepository repository;

    ContactController(ContactRepository contactRepository){
        this.repository = contactRepository;
    }

    @GetMapping
    public List findAll(){
        return repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return repository.findById(id)
                .map(record-> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/{id}")
    public Contact create(@RequestBody Contact contact){
        return repository.save(contact);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Contact contact){
        return repository.findById(id)
                .map(record-> {
                    record.setName(contact.getName());
                    record.setEmail(contact.getEmail());
                    record.setPhone(contact.getPhone());
                    Contact update = repository.save(record);
                    return ResponseEntity.ok().body(update);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        return repository.findById(id)
                .map(record-> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
