/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco_api.presentation.database.impl;

import com.fpmislata.banco.persistence.dao.impl.jdbc.DataSourceFactory;
import com.fpmislata.banco_api.presentation.database.DatabaseMigration;
import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author alumno
 */
public class DatabaseMigrationImplFlyway implements DatabaseMigration{
    
    @Autowired
    DataSourceFactory dataSourceFactory;
    
    @Override
    public void migrate() {
        Flyway flyway = new Flyway();
        DataSource dataSource = dataSourceFactory.getDataSource();
        flyway.setDataSource(dataSource);
        flyway.setLocations("com.fpmislata.banco.persistence.database");
        flyway.setEncoding("UTF-8");
        flyway.migrate();
    }
    
}
