package montp.web.controllers.security;

import montp.web.FacesTools;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@ApplicationScoped
@Named
public class SecurityView implements Serializable {

    public void logout() {
        FacesTools.getRequest().getSession().invalidate();
        FacesTools.redirect("app/index.xhtml");
    }

    public void login() {
        FacesTools.redirect("app/index.xhtml");
    }

    public void securityCheck() {}
}
