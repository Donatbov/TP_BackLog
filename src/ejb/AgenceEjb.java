package ejb;

import model.Agence;
import model.BackLog;
import utils.Utils;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.LocalBean;
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

@Stateless
@LocalBean
public class AgenceEjb {
    @PersistenceContext
    private EntityManager em;

    public AgenceEjb() { /* Nothing to do here */ }

    public boolean addAgence(String name, BackLog backLog) {
        return Utils.persistOrFail(em, new Agence(name, backLog));
    }

    public boolean addAgence(Agence a) {
        return Utils.persistOrFail(em, a);
    }

}
