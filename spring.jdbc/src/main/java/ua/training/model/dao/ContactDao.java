package ua.training.model.dao;

import ua.training.model.entity.Contact;

import java.util.List;

public interface ContactDao {
    List<Contact> findAll();
    List<Contact> findByFirstName(String firstName);
    String findFirstNameById(Long id);
    List<Contact> findAllWithDetail();
    void insert(Contact contact);
    void insertWithDetail(Contact contact);
    void update(Contact contact);

}
