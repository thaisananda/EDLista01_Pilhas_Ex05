package view;

import javax.swing.JOptionPane;
import controller.FilaController;
import meumodel.Cliente;
import model.Fila;

public class Principal {
	
	public static void main(String[] args) {
		Fila<Cliente> filaComum = new Fila<>();
		Fila<Cliente> filaPrioritarios = new Fila<>();
		FilaController controller = new FilaController();
		
		int opc = 0;
        int contadorComum = 1;
        int contadorPrioritario = 100;

        while (opc != 9) {
            opc = Integer.parseInt(JOptionPane.showInputDialog(
                    "=== MENU CHAMADO ===\n" +
                    "1 - Nova senha comum\n" +
                    "2 - Nova senha prioritária\n" +
                    "3 - Chamar próximo\n" +
                    "9 - Fim"));

            switch (opc) {
                case 1:
                    String nomeC = JOptionPane.showInputDialog("Digite o nome do cliente:");
                    controller.inserir(filaComum, new Cliente(contadorComum++, nomeC));
                    JOptionPane.showMessageDialog(null, "Senha comum gerada com sucesso!");
                    break;

                case 2:
                    String nomeP = JOptionPane.showInputDialog("Digite o nome do cliente prioritário:");
                    controller.inserir(filaPrioritarios, new Cliente(contadorPrioritario++, nomeP));
                    JOptionPane.showMessageDialog(null, "Senha prioritária gerada com sucesso!");
                    break;

                case 3:
                    try {
                        controller.chamadaComMensagem(filaPrioritarios, filaComum);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                    }
                    break;

                case 9:
                    JOptionPane.showMessageDialog(null, "Fim do atendimento.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }
}


