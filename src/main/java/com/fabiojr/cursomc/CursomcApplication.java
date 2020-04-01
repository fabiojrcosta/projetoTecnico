package com.fabiojr.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fabiojr.cursomc.domain.Categoria;
import com.fabiojr.cursomc.domain.Cidade;
import com.fabiojr.cursomc.domain.Cliente;
import com.fabiojr.cursomc.domain.Endereco;
import com.fabiojr.cursomc.domain.Estado;
import com.fabiojr.cursomc.domain.Produto;
import com.fabiojr.cursomc.enums.TipoCliente;
import com.fabiojr.cursomc.repositories.CategoriaRepository;
import com.fabiojr.cursomc.repositories.CidadeRepository;
import com.fabiojr.cursomc.repositories.ClienteRepository;
import com.fabiojr.cursomc.repositories.EnderecoRepository;
import com.fabiojr.cursomc.repositories.EstadoRepository;
import com.fabiojr.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", "OnLine Imports", 2000.00);
		Produto p2 = new Produto(null, "Impressora HP 1100wp", "OnLine Imports", 600.00);
		Produto p3 = new Produto(null, "Mouse", "OnLine Imports", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat1.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll( Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Santa Catarina");
		Estado est2 = new Estado(null, "Paraná");
		
		Cidade c1 = new Cidade(null, "Criciuma", est1);
		Cidade c2 = new Cidade(null, "Curitiba", est2 );
		Cidade c3 = new Cidade(null, "Paranaguá", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "mariade@gmail.com", "348234558", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("995482214", "9987845666"));
		
		Endereco e1 = new Endereco(null, "Rua Tamoio", "casa de esquina", "20", "Girassol", "88805500", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua Taim", "casa azul", "50", "Girassol", "88809500", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));		
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
	}

}
