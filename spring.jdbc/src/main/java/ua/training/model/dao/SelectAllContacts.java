package ua.training.model.dao;

import org.springframework.jdbc.object.MappingSqlQuery;
import ua.training.model.entity.Contact;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAllContacts extends MappingSqlQuery<Contact> {
    private static final String SQL_SELECT_ALL_CONTACT = "SELECT ID, FIRST_NAME, LAST_NAME, BIRTH_DATE FROM CONTACT";

    public SelectAllContacts(DataSource dataSource) {
        super(dataSource, SQL_SELECT_ALL_CONTACT);
    }

    protected Contact mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Contact contact = new Contact();
        contact.setId(resultSet.getLong("id"));
        contact.setFirstName(resultSet.getString("first_name"));
        contact.setLastName(resultSet.getString("last_name"));
        contact.setDate(resultSet.getDate("birth_date"));
        return contact;
    }
}
