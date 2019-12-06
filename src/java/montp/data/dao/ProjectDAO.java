package montp.data.dao;

import montp.data.entity.ClientEntity;
import montp.data.entity.ProjectEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ProjectDAO extends GenericDAO<ProjectEntity> {
    public ProjectDAO() {
        super(ProjectEntity.class);
    }

    public List<ProjectEntity> findByClient(ClientEntity client) {
        return em.createQuery(makeQLString("p", "WHERE p.client = :client"))
                .setParameter("client", client)
                .getResultList();
    }
}
