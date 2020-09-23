/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.abstractfactory;

import dao.sqlserver.ConectorSQLServer;

/**
 *
 * @author tiago
 */
public class FabricaConcretaSQLServer extends FabricaAbstrata{

    @Override
    public ConectorAbstrato criarConector() {
        return new ConectorSQLServer();
    }
}
