package brandao.android.mycontactmanager.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import brandao.android.mycontactmanager.db.entity.Contact;

@Database(entities = {Contact.class},version = 1)
public abstract class ContactsAppDatabase extends RoomDatabase {

    public abstract ContactDAO getContactDAO();

}
