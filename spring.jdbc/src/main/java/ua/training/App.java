package ua.training;

import org.springframework.context.support.GenericXmlApplicationContext;
import ua.training.model.dao.ContactDao;
import ua.training.model.entity.Contact;

import java.util.List;

public class App {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:context.xml");
        context.refresh();
        ContactDao contactDao = context.getBean("contactDao", ContactDao.class);
        List<Contact> contacts = contactDao.findAll();
        contacts.forEach(System.out::println);
    }
}
