package com.testCoding.intiCorpora.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testCoding.intiCorpora.Entity.Contact;
import com.testCoding.intiCorpora.Entity.UserProfile;
import com.testCoding.intiCorpora.execption.NotFoundException;
import com.testCoding.intiCorpora.model.dto.DtoAddressByUser;
import com.testCoding.intiCorpora.model.request.CreateContactRequest;
import com.testCoding.intiCorpora.model.response.ResponseAddressByUser;
import com.testCoding.intiCorpora.model.response.responseListAddressByUser;
import com.testCoding.intiCorpora.repository.ContactRepository;
import com.testCoding.intiCorpora.repository.UserRepository;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;

    public Contact createContact(CreateContactRequest contactRequest){
        Contact contact = new Contact();
        UserProfile user = userRepository.findById(contactRequest.getUserId()).orElse(null);
        if(user == null){
            throw new NotFoundException("User Id tidak ketemu");
        }
        contact.setAddress(contactRequest.getAddress());
        contact.setUser(user);
        
        return contactRepository.save(contact);
    }
    public List<Contact> getAllContact(){
        return contactRepository.findAll();
    }
    public String deleteContactById(String id){
        contactRepository.deleteById(id);
        return "Contact Sudah Berhasil Di Hapus";
    }
    public responseListAddressByUser getContactByUserId(String userId){
        UserProfile user = userRepository.findById(userId).orElse(null);
        if(user==null){
            throw new NotFoundException("Data tidak ditemukan");
        }
        List<DtoAddressByUser> dataDatabase = contactRepository.findAllByUserId(userId);
        List<ResponseAddressByUser> addressByUsers = new ArrayList<>();
        responseListAddressByUser responseListAddressByUser = new responseListAddressByUser();
        for(DtoAddressByUser data: dataDatabase){
            ResponseAddressByUser contact = new ResponseAddressByUser();
            contact.setId(data.getId());
            contact.setAddress(data.getAddress());
            addressByUsers.add(contact);
        }
        responseListAddressByUser.setId(userId);
        responseListAddressByUser.setContact(addressByUsers);
        responseListAddressByUser.setName(user.getName());
        return responseListAddressByUser;
    }

}
