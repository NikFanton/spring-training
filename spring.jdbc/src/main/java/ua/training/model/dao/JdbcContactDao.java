package ua.training.model.dao;

import ua.training.model.entity.Contact;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@Repository("contactDao")
public class JdbcContactDao implements ContactDao {
    private Log log = LogFactory.getLog(JdbcContactDao.class);
    private DataSource dataSource;
    private SelectAllContacts selectAllContacts;

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectAllContacts = new SelectAllContacts(dataSource);
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public List<Contact> findAll() {
        return selectAllContacts.execute();
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public String findFirstNameById(Long id) {
        return null;
    }

    @Override
    public List<Contact> findAllWithDetail() {
        return null;
    }

    @Override
    public void insert(Contact contact) {

    }

    @Override
    public void insertWithDetail(Contact contact) {

    }

    @Override
    public void update(Contact contact) {

    }
}
