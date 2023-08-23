package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 22/08/2023
 * Project Name: loja
 */

public class CadastroDeProduto {

    public static void main(String[] args) {
        cadastrarProduto();

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto produto = produtoDao.buscarPorId(1L);
        System.out.println(produto.getPreco());

        List<Produto> todos = produtoDao.buscarTodos();
        todos.forEach(p -> System.out.println(p.getNome()));

        List<Produto> produtos = produtoDao.buscarPorNome("Xiomi Redmi");
        produtos.forEach(p -> System.out.println(p.getNome()));

        List<Produto> nomeDaCategoria = produtoDao.buscarPorNomeDaCategoria("Celulares");
        nomeDaCategoria.forEach(p -> System.out.println(p.getNome()));

        BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("Xiomi Redmi");
        System.out.println(precoDoProduto);
    }

    private static void cadastrarProduto() {
        Categoria celuares = new Categoria("Celulares");
        Produto celular = new Produto(
                "Xiomi Redmi",
                "Muito legal",
                new BigDecimal("500"),
                celuares);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celuares);
        produtoDao.cadastrar(celular);

        em.getTransaction().commit();
        em.close();
    }
}
