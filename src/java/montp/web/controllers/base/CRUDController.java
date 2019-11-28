package montp.web.controllers.base;

import montp.data.entity.GenericEntity;
import montp.services.GenericService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.util.List;

public abstract class CRUDController<T extends GenericEntity, Service extends GenericService> extends CUDController<T, Service> {

    @Named
    @Produces
    protected List<T> entities;

    @PostConstruct
    public void onPostConstruct() {
        init();
    }
    public void init() {
        entities = service.getAll();
    }

    //region GETTERS / SETTERS
    public List<T> getEntities() {
        return entities;
    }

    public void setEntities(List<T> entities) {
        this.entities = entities;
    }
    //endregion
}
