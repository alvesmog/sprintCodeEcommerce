package br.com.spring.code.ecommerce;

import br.com.spring.code.ecommerce.gestaopessoas.Endereco;
import br.com.spring.code.ecommerce.gestaopessoas.Pessoa;
import br.com.spring.code.ecommerce.gestaopessoas.PessoaFisica;
import br.com.spring.code.ecommerce.gestaopessoas.PessoaJuridica;
import br.com.spring.code.ecommerce.gestaopessoas.RepositorioPessoas;
import br.com.spring.code.ecommerce.gestaopessoas.TipoPessoa;
import br.com.spring.code.ecommerce.gestaopessoas.Usuario;
import br.com.spring.code.ecommerce.gestaoprodutos.Categoria;
import br.com.spring.code.ecommerce.gestaoprodutos.Produto;
import br.com.spring.code.ecommerce.gestaoprodutos.RepositorioProdutos;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Populando dados no sistema
    	RepositorioPessoas pessoas = new RepositorioPessoas();
    	RepositorioProdutos produtos = new RepositorioProdutos();
    	
    	PessoaFisica pf = new PessoaFisica("12547896532");
    	
    	PessoaJuridica pj = new PessoaJuridica("63285674514054");
    	
    	Endereco end1 = new Endereco(1, "Rua A", "125", "Cordeiro", "A", "A", "A", "Z", "A", "D");
    	Endereco end2 = new Endereco(2, "Rua 12", "25", "Torre", "A", "C", "A", "Z", "A", "D");
    	
    	Usuario user1 = new Usuario(1, "joao", "1234");
    	Usuario user2 = new Usuario(2, "arthur", "4321");
    	
    	Pessoa pessoa1 = new Pessoa("Joao Augusto", "986413568", "joao@teste.com", 1.5, ((TipoPessoa) pf), end1, user1, 2);
    	Pessoa pessoa2 = new Pessoa("Arthur Leandro", "96853214", "arthur@teste.com", 2.5, ((TipoPessoa) pj), end2, user2, 3);
    	Pessoa pessoa3 = new Pessoa("Carlina", "5842027547", "candryushchenko0@a8.net", 1.0, ((TipoPessoa) pj), end2, user2, 3);
    	Pessoa pessoa4 = new Pessoa("Nichole", "8232611354", "nbrigdale1@vkontakte.ru", 4.2, ((TipoPessoa) pj), end2, user2, 3);
    	Pessoa pessoa5 = new Pessoa("Matthew", "2555717124", "mtitmuss2@multiply.com", 3.5, ((TipoPessoa) pj), end2, user2, 3);
    	Pessoa pessoa6 = new Pessoa("Corrinne", "7047897644", "cchallens3@1688.com", 1.8, ((TipoPessoa) pj), end2, user2, 3);
    	Pessoa pessoa7 = new Pessoa("Sherilyn", "9461924214", "sivanyutin4@sakura.ne.jp", 2.2, ((TipoPessoa) pj), end2, user2, 3);
    	
    	pessoas.adicionar(pessoa1);
    	pessoas.adicionar(pessoa2);
    	pessoas.adicionar(pessoa3);
    	pessoas.adicionar(pessoa4);
    	pessoas.adicionar(pessoa5);
    	pessoas.adicionar(pessoa6);
    	pessoas.adicionar(pessoa7);
    	
    	Categoria cat1 = new Categoria(1, "Roupa");
    	Categoria cat2 = new Categoria(1, "Móveis");
    	Categoria cat3 = new Categoria(1, "Decoração");
    	Categoria cat4 = new Categoria(1, "Peças de Cama");
    	
    	Produto produto1 = new Produto(1, "Ninho para Bebê Redutor", "Com a suavidade do tecido 100% algodão e enchimento fofinho", "./images/ninho.png", pessoa1);
    	Produto produto2 = new Produto(2, "Berço Minicama 3 em 1 Dom", "Com design moderno, a cabeceira e a peseira se destacam com originais linhas curvilíneas", "./images/berço.png", pessoa2);
    	Produto produto3 = new Produto(3, "Andador Goal Walker 4 em 1 Cosco", "Com a suavidade do tecido 100% algodão e enchimento fofinho", "./images/andardor.png", pessoa3);
    	Produto produto4 = new Produto(4, "Prateleira com Varão Branca", "madeira MDF com varão é a escolha ideal para acomodar caixas e enfeites", "./images/prateleira.png", pessoa4);
    	Produto produto5 = new Produto(5, "Kit Mijões Bebê 3 Peças Vaquinha", "Confeccionadas em 85% algodão e 15% pode variar entre outras fibras", "./images/kitmijoes.png", pessoa5);
    	Produto produto6 = new Produto(6, "Kit Berço Trança Poá Azul Bebê", "com peças confeccionadas em tecidos 100% algodão e essenciais para o enxoval do bebê", "./images/kitberco.png", pessoa6);
    	
    	produtos.adicionar(produto1);
    	produtos.adicionar(produto2);
    	produtos.adicionar(produto3);
    	produtos.adicionar(produto4);
    	produtos.adicionar(produto5);
    	produtos.adicionar(produto6);
    	
    	
    	
    }
}
