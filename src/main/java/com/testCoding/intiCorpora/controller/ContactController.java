package com.testCoding.intiCorpora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testCoding.intiCorpora.Entity.Contact;
import com.testCoding.intiCorpora.constant.CodeMessage;
import com.testCoding.intiCorpora.model.WebResponse;
import com.testCoding.intiCorpora.model.request.CreateContactRequest;
import com.testCoding.intiCorpora.model.response.responseListAddressByUser;
import com.testCoding.intiCorpora.service.ContactService;

@Controller
@RestController
@RequestMapping("/api/contact")
@Configuration("test")
public class ContactController {
    @Autowired
    private ContactService contactService;
    
    @PostMapping(path = "/v1/create",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<Contact> createContact(@RequestBody CreateContactRequest contact){
        Contact contactSaveToDb = contactService.createContact(contact);
        return WebResponse.<Contact>builder().code(CodeMessage.Success_Response.toString()).data(contactSaveToDb).build();
    }

    @GetMapping(
        path= "/v1/getall",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<Contact>> getAllContact(){
        List<Contact> allContact = contactService.getAllContact();
        return WebResponse.<List<Contact>>builder().code(CodeMessage.Success_Response.toString()).data(allContact).build();
    }

    @GetMapping(
        path= "/v1/getbyuser/{userId}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<responseListAddressByUser> getAllByUserId(@PathVariable(name = "userId") String userId){
        responseListAddressByUser addresses = contactService.getContactByUserId(userId);
        return WebResponse.<responseListAddressByUser>builder().code(CodeMessage.Success_Response.toString()).data(addresses).build(); 

    }
    @GetMapping(
        path= "/v1/delete/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> delete(@PathVariable(name = "id") String id){
        String delete = contactService.deleteContactById(id);
        return WebResponse.<String>builder().code(CodeMessage.Success_Response.toString()).data(delete).build(); 

    }

    String a = "test";

}
