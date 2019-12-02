package montp.web.controllers.security;

import montp.data.entity.PersonEntity;
import montp.data.entity.security.UserEntity;
import montp.services.UserService;
import montp.web.controllers.base.CUDController;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.Calendar;
import java.util.Date;

@ViewScoped
@Named
public class RegisterView extends CUDController<UserEntity, UserService> {

    @Override
    public void create() {
        entity = new UserEntity(new PersonEntity(false, "test", "test", "test@test.fr", "0600000000", new Date(1997, Calendar.FEBRUARY, 23), "13 rue du test", "13000", new Float("13000.50"), new Float("11.50")));
    }

    @Override
    public void save() {
        entity.setUserName(entity.getPerson().getEmail());
        super.save();
    }
}
