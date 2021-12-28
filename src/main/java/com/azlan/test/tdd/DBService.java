package com.azlan.test.tdd;

import java.util.logging.Logger;

public class DBService {

    private static final Logger LOGGER = Logger.getLogger(DBService.class.getName());

    private Database db;

    public DBService(Database database){
        this.db = database;
    }

    public boolean dbCheck(){
        return db.isAvailable();
    }

    public int query(String query){
        LOGGER.info(query);
        return db.getUniqueID();
    }

    @Override
    public String toString() {
        return "Using database with id: " + db.getUniqueID();
    }
}
