package repositorio;
import java.io.File;
import java.io.FileOutputStream;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programa��o Orientada a Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Properties;
import java.util.TreeMap;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeMessage.RecipientType;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


import modelo.Cliente;
import modelo.Combo;
import modelo.Pedido;
import modelo.Produto;

public class Restaurante {
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	private TreeMap<String, Cliente> clientes = new TreeMap<>();

	public void adicionarProduto(Produto p){
		produtos.add(p);
	}
	public void removerProduto(Produto p){
		produtos.remove(p);
	}

	public Produto localizarProduto(int id){
		for(Produto p : produtos){
			if(p.getId() == id) {
				return p;
			}
		}
		return null;
	}
	
	public Produto localizarProduto(String nome){
		for(Produto p : produtos){
			if(p.getDescricao().equalsIgnoreCase(nome))
				return p;
		}
		return null;
	}


	public void abrirPedido(Pedido p){
		pedidos.add(p);
	}
	
	public void removerPedido(Pedido p, String tel){
		pedidos.remove(p);
		for (String telefone : clientes.keySet()) {
			if (telefone.equals(tel)) {
				clientes.get(telefone).removerPedidosCliente();
			}
		}
		ArrayList<Produto> produtos = p.produtosPedido();
		for (Produto prod : produtos) {
			prod.removerPedido(p);
		}
	}
	
	public void removerProdutoPedido(Pedido p) {
		
	}

	public Pedido localizarPedido(int id){
		for(Pedido p : pedidos){
			if(p.getId()==id)
				return p;
		}
		return null;
	}
	
	public Pedido localizarPedido(String telCli){
		for(String telefone : clientes.keySet()){
			if(telefone.equalsIgnoreCase(telCli))
				return clientes.get(telefone).obterPedidoAberto();
		}
		return null;
	}
	
//	public Pedido localizarPedidoUltimo(String telCli){
//		int ult = 0;
//		for(Cliente c : clientes){
//			if(c.getTelefone().equalsIgnoreCase(telCli))
//				ult = c.getPedidos().size()-1;
//				return c.getPedidos().get(ult);
//		}
//		return null;
//	}

	public ArrayList<Produto> getProdutos() {
		Collections.sort(produtos, new Criterio());
		return produtos;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}
	
	public void adicionarPedido(Pedido p){
		pedidos.add(p);
	}
	
	public Collection<Cliente> getClientes() {
		return clientes.values();
	}

	public int getTotalProdutos(){
		return produtos.size();
	}
	
	public Cliente localizarCliente(String tel){
		for(String telefone : clientes.keySet()){
			if(telefone.equalsIgnoreCase(tel)) {
				return clientes.get(telefone);
			}
		}
		return null;
	}
	
	public void adicionarCliente(Cliente c) {
		clientes.put(c.getTelefone(), c);
	}
	
	public void editarTelefone(String tel, String novo) {
		for (String telefone : clientes.keySet()) {
			if (telefone.equals(tel))
				clientes.get(telefone).setTelefone(novo);
		}
	}
	
	
	public void criarPdf(Pedido p) {
		Document document = new Document();
		System.out.println("envio email");
		double totalPedido = p.totalPedido();
		double taxa = 10.0;
		try {			
			PdfWriter.getInstance(document, new FileOutputStream("pdf//nota.pdf"));
			
			document.setPageSize(PageSize.A4);
			document.addSubject("Nota do Pedido " + p.getId());
			
			document.addAuthor("Beyond Food Delivery");
			document.open();
		
			Image imagem = Image.getInstance("src//imagens//BEYOND-FOOD2.png");
			imagem.scaleToFit(250, 150);
			document.add(imagem);

			document.add(new Paragraph("Dados do Pedido\n"));
			
			document.add(new Paragraph("\n" + p.verClientePedido() + "\n"));
			
			document.add(new Paragraph("Pedido ID: " + p.getId() + "\n"));
			
			document.add(new Paragraph("Lista de Produtos\n"));
			ArrayList<Produto> ped = p.produtosPedido();
			
			for (Produto prod : ped) {
				document.add(new Paragraph("ID: " + prod.getId() + " --- Descricao: " + prod.getDescricao() + " --- Preco: " + prod.getPreco()));

			}
			document.add(new Paragraph("\n -- Valor pedido: R$" + totalPedido + " -- taxa de entrega R$ " + taxa));
			document.add(new Paragraph("TOTAL: R$" + (totalPedido + taxa) ));
			document.close();

			document.close();
			System.out.println("PDF criado com sucesso!");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public void enviarEmail(String e, String s) {
		
		final String email = e;
		final String senha = s;

		//Setting up configurations for the email connection to the Google SMTP server using TLS
		Properties props = new Properties();
		props.put("mail.smtp.host", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		//Establishing a session with required user details
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, senha);
			}
		});

		try {
			MimeMessage msg = new MimeMessage(session);

			Address from = new InternetAddress("poo.projeto.delivery@gmail.com");
			Address to = new InternetAddress(email);

			//configurando o remetente e o destinatario
			msg.setFrom(from);
			msg.addRecipient(RecipientType.TO, to);

			//configurando a data de envio,  o assunto e o texto da mensagem
			msg.setSentDate(new Date());
			msg.setSubject("Enviando Email com mensagem e anexo");		
			msg.setSubject("Nota do Pedido - Beyond Food" );
			msg.setText("exemplo de email");
			msg.setHeader("XPriority", "1");
			
			
			// conteudo html que sera atribuido a mensagem
			String htmlMessage = "<html><h1>Beyond Food Delivery</h1> <p>Email com anexo</p></br><p>Pedido realizado no Beyond Food Delivery</p> </html>";
			//criando a Multipart
			Multipart multipart = new MimeMultipart();
			//criando a primeira parte da mensagem
			MimeBodyPart attachment0 = new MimeBodyPart();
			//configurando o htmlMessage com o mime type
			attachment0.setContent(htmlMessage,"text/html; charset=UTF-8");
			//adicionando na multipart
			multipart.addBodyPart(attachment0);
			//arquivo que ser� anexado
			String pathname = "pdf/nota.pdf";//pode conter o caminho
			File file = new File(pathname);
			//criando a segunda parte da mensagem
			MimeBodyPart attachment1 = new MimeBodyPart();  
			//configurando o DataHandler para o arquivo desejado
			//a leitura dos bytes, descoberta e configuracao do tipo
			//do arquivo ser�o resolvidos pelo JAF (DataHandler e FileDataSource)
			attachment1.setDataHandler(new DataHandler(new FileDataSource(file)));
			
			//configurando o nome do arquivo que pode ser diferente do arquivo
			//original 
			attachment1.setFileName(file.getName());
			
			//adicionando o anexo na multipart
			multipart.addBodyPart(attachment1);

			//adicionando a multipart como conteudo da mensagem 
			msg.setContent(multipart);
			
			Transport.send(msg);
			
			System.out.println("enviado ok");
		} catch (MessagingException mex) {
			System.out.println("problema no envio" + mex);

		}

	}
	

}

