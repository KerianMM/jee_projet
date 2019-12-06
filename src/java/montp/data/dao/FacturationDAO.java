package montp.data.dao;

import montp.data.entity.FacturationEntity;
import montp.data.entity.ProjectEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class FacturationDAO extends GenericDAO<FacturationEntity> {
    public FacturationDAO() {
        super(FacturationEntity.class);
    }

    public List<FacturationEntity> findByProject(ProjectEntity project) {
        return em.createQuery(makeQLString("e", "WHERE e.project = :project"))
                .setParameter("project", project)
                .getResultList();
    }
}
