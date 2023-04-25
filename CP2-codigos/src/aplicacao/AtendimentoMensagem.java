package aplicacao;

import java.util.Scanner;

import entidades.Mensagem;
import fila.FilaMensagens;

/*INTEGRANTES: 
 * Gabriela Terzi Gonzalez RM 93192
 * Gabrielly De Paula Freitas RM 94695
 * Giovanna Sayuri Costa Antunes RM 95259
 * Marcela Gervasoni Gomes RM 94668
 * Nath�lia Corr�a Lopes RM 95907 */

public class AtendimentoMensagem {
		public static void main(String[] args) {
		    Scanner teclado = new Scanner(System.in);
		    
		    int opcoes;
		    int motivo;
		    int tipoMensagem;
		    int acao;
		    
		    Mensagem filaReclamacao[] = new Mensagem[10];
			Mensagem filaSugestao[] = new Mensagem[10];
			Mensagem filaResolucao[] = new Mensagem[10];
			FilaMensagens resolucao = new FilaMensagens(filaResolucao);
			FilaMensagens sugestao = new FilaMensagens(filaSugestao);
			FilaMensagens reclamacao = new FilaMensagens(filaReclamacao);

		    while(true){
		        System.out.println("MENU\n");
		        System.out.println("0 - Encerrar o programa");
		        System.out.println("1 - Receber mensagem");
		        System.out.println("2 - Atendimento mensagem");
		        System.out.println("3 - Recebimento e encaminhamento resolu��o");
		        
		        opcoes = teclado.nextInt();
		        teclado.nextLine();

		        switch (opcoes){
		            case 0:
		                System.out.println("Programa Encerrado");
		                System.exit(0);
		                break;
		                
		            case 1:
		                System.out.println("Recebimento de Mensagem:\n ");
		                System.out.print("Nome (opcional): ");
		                String nome = teclado.nextLine();
		                System.out.print("Email / Telefone: ");
		                String emailTelefone = teclado.nextLine();
		                System.out.print("Motivo Contato (1 - reclama��o / 2 - sugest�o): ");
		                motivo = teclado.nextInt();
		                
		                teclado.nextLine();
		                
		                System.out.print("Mensagem (texto): ");
		                String mensagem = teclado.nextLine();
		                
		                if(motivo == 1){
		                    reclamacao.enqueue(new Mensagem(nome, emailTelefone, motivo, mensagem));
		                    System.out.println("Sua reclama��o foi adicionada na fila de reclama��o!");
		                } else if (motivo == 2){
		                    sugestao.enqueue(new Mensagem(nome, emailTelefone, motivo, mensagem));
		                    System.out.println("Sua mensagem foi adicionada na fila de sugest�es!");
		                } else {
		                    System.out.println("Mensagem inv�lida");
		                }
		                break;
		                
		            case 2:
		                System.out.println("Atendimento de Mensagem:\n ");
		                System.out.print("Tipo de mensagem (1 - reclama��o / 2 - sugest�o): ");
		                
		                tipoMensagem = teclado.nextInt();
		                
		                teclado.nextLine();
		                
		                if(tipoMensagem == 1 && !reclamacao.isEmpty()){
		                    Mensagem mreclamacao = reclamacao.dequeue();
		                    
		                    System.out.println("Mensagem selecionada: " + mreclamacao.mensagem);
		                    System.out.print("A��o desejada (1 - responder / 2 - encaminhar para resolu��o): ");
		                    acao = teclado.nextInt();
		                    
		                    teclado.nextLine();
		                    
		                    if(acao == 1){
		                        System.out.println("Enviada resposta para cliente: sua solicita��o j� foi resolvida. Obrigada!");
		                    } else if(acao == 2){
		                        resolucao.enqueue(mreclamacao);
		                        System.out.println("Sua mensagem foi adicionada na fila de resolu��o.");
		                    } else {
		                        System.out.println("Opera��o inv�lida!");
		                    }
		                } else if (tipoMensagem == 2 && !sugestao.isEmpty()){
		                    Mensagem msugestao = sugestao.dequeue();
		                    
		                    System.out.println("Mensagem selecionada: " + msugestao.mensagem);
		                    System.out.print("A��o desejada (1 - responder / 2 - encaminhar para resolu��o): ");
		                    acao = teclado.nextInt();
		                    
		                    teclado.nextLine();
		                    
		                    if(acao == 1){
		                        System.out.println("Enviada resposta para cliente: sua solicita��o j� foi resolvida. Obrigada!");
		                    } else if(acao == 2){
		                        resolucao.enqueue(msugestao);
		                        System.out.println("Sua mensagem foi adicionada na fila de resolu��o.");
		                    } else {
		                        System.out.println("Opera��o inv�lida!");
		                    }
		                } else {
		                    System.out.println("N�o possui mensagens desse tipo.");
		                }
		                break;
		                
		            case 3:
		                if(!resolucao.isEmpty()){
		                    Mensagem mresolucao = resolucao.dequeue();
		                    System.out.println("Resolu��o da mensagem: " + mresolucao.mensagem);
		                    System.out.println("Enviada resposta para cliente: sua solicita��o j� foi resolvida pelo setor respons�vel. Obrigada!");
		                } else {
		                    System.out.println("N�o tem mensagens em resolu��o.");
		                }
		                break;
		                
		            default:
		                System.out.println("Op��o inv�lida!");
		                break;
		        }
		        teclado.close();
		    }
		}
		
}
