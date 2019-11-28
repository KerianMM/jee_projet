package montp.data;

import montp.data.entity.PersonEntity;
import montp.data.entity.security.GroupEntity;
import montp.data.entity.security.UserEntity;
import montp.services.PersonService;
import montp.services.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Startup
public class Seeder {
    
    @Inject private UserService userService;
    @Inject private PersonService personService;

    @PersistenceContext private EntityManager em;
    
    @PostConstruct
    public void init() {
        if (personService.isEmpty() &&
            userService.isEmpty()
        ) {
            //region PERSON
            PersonEntity kerian = new PersonEntity("Kérian", "MONTES-MORIN", "kerianmontes@test.com");
            PersonEntity ben    = new PersonEntity("Ben", "Clément", "ben@test.com");
            PersonEntity loic   = new PersonEntity("Loic", "Wernert", "lw@test.com");

            PersonEntity esimed     = new PersonEntity("Esi", "med", "esimed@test.com");
            PersonEntity aubanel    = new PersonEntity("Théodore", "Aubanel", "aubanel@test.com");

            personService.insert(kerian);
            personService.insert(ben);
            personService.insert(loic);

            personService.insert(esimed);
            personService.insert(aubanel);
            //endregion

            if (userService.getGroup("USER") == null) {
                GroupEntity groupUser = new GroupEntity("USER");
                GroupEntity groupAdmin = new GroupEntity("ADMIN");
                em.persist(groupUser);
                em.persist(groupAdmin);

                UserEntity userAdmin = new UserEntity("kerian", "kerian", kerian);
                UserEntity userUser = new UserEntity("ben", "ben", ben);

                List<GroupEntity> groupesAdmin  = new ArrayList<>();
                List<GroupEntity> groupesUser   = new ArrayList<>();

                groupesUser.add(groupUser);
                userUser.setGroups(groupesUser);

                groupesAdmin.add(groupUser);
                groupesAdmin.add(groupAdmin);
                userAdmin.setGroups(groupesAdmin);

                userService.insert(userAdmin);
                userService.insert(userUser);
            }
        }
    }
}