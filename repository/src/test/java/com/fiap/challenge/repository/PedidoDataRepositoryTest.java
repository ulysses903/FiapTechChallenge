package com.fiap.challenge.repository;

import com.fiap.challenge.domain.ClienteRepository;
import com.fiap.challenge.domain.PedidoRepository;
import com.fiap.challenge.domain.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = ConfiguracaoDeTesteParaCamadaDeRepositorio.class)
class PedidoDataRepositoryTest {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
//
//    @Test
//    void deve_incluir_cliente() {
//        Produto produto = ProdutoBuilder.novo().criar();
//        produtoRepository.save(produto);
//        Cliente cliente = ClienteBuilder.novo().criar();
//        clienteRepository.save(cliente);
//        Pedido pedido = new Pedido(BigDecimal.TEN, singletonList(produto), cliente);
//
//        pedidoRepository.save(pedido);
//
//        List<Pedido> pedidos = pedidoRepository.findAll();
//        assertThat(pedidos).extracting(Pedido::getId).containsExactly(pedido.getId());
//    }
}