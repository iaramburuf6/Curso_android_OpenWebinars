package almacenamientolocal.iaramburu.realm.app;

import android.app.Application;

import java.util.concurrent.atomic.AtomicLong;

import almacenamientolocal.iaramburu.realm.Model.AveriaDB;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by i.aramburu on 09/01/2018.
 */

public class MyApp extends Application {

    public static AtomicLong AveriaID = new AtomicLong();

    @Override
    public void onCreate() {
        super.onCreate();
        initRealm();

        Realm realm = Realm.getDefaultInstance();
        AveriaID = getIdByTable(realm, AveriaDB.class);

        realm.close();

    }

    // Metodo para iniciar realm con una configuracion
    private void initRealm() {
        Realm.init(getApplicationContext());
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    // Metodo para conseguir el valor de ID
    private <T extends RealmObject> AtomicLong getIdByTable(Realm realm, Class<T> anyClass) {
        RealmResults<T> results = realm.where(anyClass).findAll();
        return (results.size() > 0) ? new AtomicLong(results.max("id").intValue()) : new AtomicLong();
    }

}
