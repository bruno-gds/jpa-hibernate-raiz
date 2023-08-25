package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Cliente;

import javax.persistence.EntityManager;


/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 22/08/2023
 * Project Name: loja
 */

public class ClienteDao {

    private EntityManager em;


    public ClienteDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Cliente cliente){
        this.em.persist(cliente);
    }

    public Cliente buscarPorId(Long id){
        return em.find(Cliente.class, id);
    }
}
