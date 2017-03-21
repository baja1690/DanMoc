package com.app.diy.repository.local;

import com.app.diy.models.Tutorial;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;

/**
 * Created by Cuong Pham on 3/21/17.
 */

public class RealmDb {
    private static RealmDb mInstance;

    private RealmDb() {

    }

    public static RealmDb getInstance(){
        if(mInstance == null){
            mInstance = new RealmDb();
        }
        return mInstance;
    }

    private RealmConfiguration mRealmConfiguration;

    public RealmDb(RealmConfiguration mRealmConfiguration) {
        this.mRealmConfiguration = mRealmConfiguration;
    }

    public void saveTutorial(final Tutorial tutorial){
        Realm realm = null;
        realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(tutorial);
            }
        });
    }

    public void getTutorial(final Callback<List<Tutorial>> callback){
        Realm realm = null;
        try {
            realm = Realm.getDefaultInstance();
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    RealmQuery<Tutorial> realmQuery = realm.where(Tutorial.class);
                    //RealmResults<UserEntity> realmResults = realmQuery.findAll();
                    List<Tutorial> tutorials = realmQuery.findAll();
                    callback.onSuccess(tutorials);
                }
            });
        } catch (Exception ex) {
            callback.onError(ex);
        }
        finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

    public void saveCategory(){

    }

    interface Callback<T> {
        void onSuccess(T response);
        void onError(Exception e);
    }
}
