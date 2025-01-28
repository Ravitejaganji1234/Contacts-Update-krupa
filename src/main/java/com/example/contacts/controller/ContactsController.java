package com.example.contacts.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;
  import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.contacts.model.*;
  import com.example.contacts.service.*;



  @RestController

  @CrossOrigin(origins ="https://talebts-frontend.azurewebsites.net")
  @RequestMapping("apis/employees/contacts")

public class ContactsController {
    @Autowired 
    public ContactsJpaService contactsService;

    @GetMapping("/contacts")
    public ArrayList<Contacts> getContacts(){
        return contactsService.getContacts();
    }

    @GetMapping("/contacts/{contactsId}")

    public Contacts getContactsById(@PathVariable int contactsId){
      return contactsService.getContactsById(contactsId);
    }

    @GetMapping("/contactsCreated/{contactCreatedEmployee}")
    public List<Contacts> getContactsByCreatedBy(@PathVariable String contactCreatedEmployee) {
        return  contactsService.getContactsByCreatedBy(contactCreatedEmployee);
    }

    @GetMapping("/contactsBy/{employeeId}")

    public List<Contacts> getContactsByEmployeeId(@PathVariable String employeeId){
        return  contactsService.getContactsByEmployeeId(employeeId);
    }
    
    
    
    @PostMapping("/contacts")

    public Contacts addContacts(@RequestBody Contacts contacts){
      return contactsService.addContacts(contacts);
    }

    @PutMapping("/contacts/{contactsId}")

    public Contacts updateContacts(@PathVariable int contactsId,@RequestBody Contacts contacts){
      return contactsService.updateContacts(contactsId,contacts);
    }

    @DeleteMapping("/contacts/{contactsId}")

    public void deleteContacts(@PathVariable int contactsId){
      contactsService.deleteContacts(contactsId);
    }
}
