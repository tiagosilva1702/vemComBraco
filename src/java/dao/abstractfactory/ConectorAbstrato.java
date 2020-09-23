/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.abstractfactory;

import java.sql.Connection;

/**
 *
 * @author tiago
 */
public interface ConectorAbstrato {
    public Connection conectar();
}
