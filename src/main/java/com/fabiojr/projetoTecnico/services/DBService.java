package com.fabiojr.projetoTecnico.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiojr.projetoTecnico.domain.Categoria;
import com.fabiojr.projetoTecnico.domain.Cidade;
import com.fabiojr.projetoTecnico.domain.Cliente;
import com.fabiojr.projetoTecnico.domain.Endereco;
import com.fabiojr.projetoTecnico.domain.Estado;
import com.fabiojr.projetoTecnico.domain.ItemPedido;
import com.fabiojr.projetoTecnico.domain.Pagamento;
import com.fabiojr.projetoTecnico.domain.PagamentoComBoleto;
import com.fabiojr.projetoTecnico.domain.PagamentoComCartao;
import com.fabiojr.projetoTecnico.domain.Pedido;
import com.fabiojr.projetoTecnico.domain.Produto;
import com.fabiojr.projetoTecnico.enums.EstadoPagamento;
import com.fabiojr.projetoTecnico.enums.TipoCliente;
import com.fabiojr.projetoTecnico.repositories.CategoriaRepository;
import com.fabiojr.projetoTecnico.repositories.CidadeRepository;
import com.fabiojr.projetoTecnico.repositories.ClienteRepository;
import com.fabiojr.projetoTecnico.repositories.EnderecoRepository;
import com.fabiojr.projetoTecnico.repositories.EstadoRepository;
import com.fabiojr.projetoTecnico.repositories.ItemPedidoRepository;
import com.fabiojr.projetoTecnico.repositories.PagamentoRepository;
import com.fabiojr.projetoTecnico.repositories.PedidoRepository;
import com.fabiojr.projetoTecnico.repositories.ProdutoRepository;

@Service
public class DBService {

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

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public void instantiateTestDatabase() throws ParseException {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritorio");
		Categoria cat3 = new Categoria(null, "Top Geek");

		Produto p1 = new Produto(null, "Computador completo I5", "OnLine Imports", 2000.00);
		Produto p2 = new Produto(null, "Impressora HP 1100wp", "OnLine Imports", 600.00);
		Produto p3 = new Produto(null, "Mouse Simples", "OnLine Imports", 80.00);
		Produto p4 = new Produto(null, "Mouse Razer", "OnLine Imports", 120.00);
		Produto p5 = new Produto(null, "Mouse optmus", "OnLine Imports", 100.00);
		Produto p6 = new Produto(null, "Caneta Azul", "Bic Imports LTDA", 4.00);
		Produto p7 = new Produto(null, "Caneta preta", "Bic Imports", 4.00);
		Produto p8 = new Produto(null, " Grampeador", "OnLine Imports", 12.00);
		Produto p9 = new Produto(null, "Monitor 14pol Samsung", "Imports Samsung do Brasil", 450.00);
		Produto p10 = new Produto(null, "Cadeira Gamer ssw5", "Moveis Coelho", 600.00);
		Produto p11 = new Produto(null, "Adesivos Geek", "Grafica topico", 50.00);
		Produto p12 = new Produto(null, "Miniatura Hommer Simpson", "Geeks miniaturas LTDA", 60.00);
		Produto p13 = new Produto(null, "Caneca Goku", "Geeks miniaturas LTDA", 60.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3, p4, p5, p9));
		cat2.getProdutos().addAll(Arrays.asList(p6, p7, p8, p10));
		cat2.getProdutos().addAll(Arrays.asList(p11, p12, p13));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat1));
		p5.getCategorias().addAll(Arrays.asList(cat1));
		p6.getCategorias().addAll(Arrays.asList(cat2));
		p7.getCategorias().addAll(Arrays.asList(cat2));
		p8.getCategorias().addAll(Arrays.asList(cat2));
		p9.getCategorias().addAll(Arrays.asList(cat1));
		p10.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p11.getCategorias().addAll(Arrays.asList(cat1, cat3));
		p12.getCategorias().addAll(Arrays.asList(cat1, cat3));
		p13.getCategorias().addAll(Arrays.asList(cat1, cat3));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13));

		Estado est1 = new Estado(null, "Santa Catarina");
		Estado est2 = new Estado(null, "Paraná");

		Cidade c1 = new Cidade(null, "Criciuma", est1);
		Cidade c2 = new Cidade(null, "Curitiba", est2);
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
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/01/2020 1:35"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("30/01/2020 10:40"), cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/02/2020 10:00"),
				null);
		ped2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		ItemPedido ip1 = new ItemPedido(ped1, p3, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p3, 100.00, 2, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

	}

	public ItemPedidoRepository getItemPedidoRepository() {
		return itemPedidoRepository;
	}

	public void setItemPedidoRepository(ItemPedidoRepository itemPedidoRepository) {
		this.itemPedidoRepository = itemPedidoRepository;
	}

}
