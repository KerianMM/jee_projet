package montp.web.controllers.clients;

import montp.data.entity.ClientEntity;
import montp.data.entity.security.UserEntity;
import montp.services.ClientService;
import montp.web.controllers.base.CRUDController;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ViewScoped
@Named
public class UserClientsCRUDView extends CRUDController<ClientEntity, ClientService> {

    @Inject private UserEntity user;

    @Override
    public void init() {
        entities = service.getByCurrentUser(user);
    }

    @Override
    public void create() {
        entity = new ClientEntity(user.getPerson());
    }
}
