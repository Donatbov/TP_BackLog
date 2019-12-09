package ejb;

import model.Agence;
import model.BackLog;
import utils.Utils;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@DataSourceDefinition(
        name = "java:app/env/jdbc/MyDataSource",
        className = "com.mysql.jdbc.jdbc2.optional.MysqlDataSource",
        user = "root",
        password = "root",
        serverName = "127.0.0.1",
        portNumber = 3306,
        databaseName = "backlog_gestion")

//@DataSourceDefinition(
//        name = "Derby - backlog_gestion;create=true@localhost",
//        className = "org.apache.derby.jdbc.ClientDataSource",
//        user = "root",
//        password = "root",
//        portNumber = 1527,
//        databaseName = "backlog_gestion")

@Stateless
@Remote
public class AgenceEJB {
    @PersistenceContext
    private EntityManager em;

    public AgenceEJB() { /* Nothing to do here */ }

    public Agence addAgence(String name, BackLog backLog) {
            return Utils.persistOrFail(em, new Agence(name, backLog));
    }

    public Agence addAgence(Agence a) {
        return Utils.persistOrFail(em, a);
    }

    public void deleteAgence(long id) {
        Agence a = em.getReference(Agence.class, id);
        em.remove(a);
    }
}
