package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Pedido;

import javax.persistence.EntityManager;


/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 22/08/2023
 * Project Name: loja
 */

public class PedidoDao {

    private EntityManager em;


    public PedidoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Pedido pedido){
        this.em.persist(pedido);
    }
}
