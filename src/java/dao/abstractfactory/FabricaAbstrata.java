/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.abstractfactory;

/**
 *
 * @author tiago
 */
public abstract class FabricaAbstrata {
    
    public abstract ConectorAbstrato criarConector();
    
    public static FabricaAbstrata criarFabricaAbstrata(SGBD sgbd) {
        switch (sgbd) {
            case MYSQL:
                return new FabricaConcretaMysql();
            case SQLSERVER:
                return new FabricaConcretaSQLServer();
            default:
                throw new IllegalArgumentException("SGBD não encontrado.");
        }
    }
}
