package com.fabiojr.cursomc;

import java.text.SimpleDateFormat;
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
import com.fabiojr.cursomc.domain.Pagamento;
import com.fabiojr.cursomc.domain.PagamentoComBoleto;
import com.fabiojr.cursomc.domain.PagamentoComCartao;
import com.fabiojr.cursomc.domain.Pedido;
import com.fabiojr.cursomc.domain.Produto;
import com.fabiojr.cursomc.enums.EstadoPagamento;
import com.fabiojr.cursomc.enums.TipoCliente;
import com.fabiojr.cursomc.repositories.CategoriaRepository;
import com.fabiojr.cursomc.repositories.CidadeRepository;
import com.fabiojr.cursomc.repositories.ClienteRepository;
import com.fabiojr.cursomc.repositories.EnderecoRepository;
import com.fabiojr.cursomc.repositories.EstadoRepository;
import com.fabiojr.cursomc.repositories.PagamentoRepository;
import com.fabiojr.cursomc.repositories.PedidoRepository;
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
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;

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
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/01/2020 1:35"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("30/01/2020 10:40"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2 ,sdf.parse("20/02/2020 10:00"),null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1 ,pagto2));
		
	}
	

}
