package montp.data.dao;

import montp.data.entity.ProjectStatusEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ProjectStatusDAO extends GenericDAO<ProjectStatusEntity> {
    @Override
    public List<ProjectStatusEntity> findAll() {
        return em.createQuery(makeQLString("s", "ORDER BY s.orderNum"))
                .getResultList();
    }
}
