package controller;

import model.Fila;

import javax.swing.JOptionPane;

import meumodel.Cliente;

public class FilaController {
	
	 public FilaController() {
		super();
	}
	
	// Inserir novo cliente na fila
     public void inserir(Fila<Cliente> fila, Cliente cliente) {
        fila.insert(cliente);
    }
    
 // Remover o próximo da fila
     public Cliente remover(Fila<Cliente> fila) throws Exception {
        if (fila.isEmpty()) {
            throw new Exception("Fila vazia");
        }
        return fila.remove();
    }
     
  // Chamada de atendimento (3 prioritários → 1 não prioritário)
     public void chamadaComMensagem(Fila<Cliente> filaPrioritarios, Fila<Cliente> filaComum) throws Exception {
    	    int chamadasPrioritarias = 0;
    	    StringBuilder output = new StringBuilder();

    	    while (chamadasPrioritarias < 3 && !filaPrioritarios.isEmpty()) {
    	        Cliente atendido = filaPrioritarios.remove();
    	        output.append("Atendido PRIORITÁRIO: ").append(atendido).append("\n");
    	        chamadasPrioritarias++;
    	    }

    	    if (!filaComum.isEmpty()) {
    	        Cliente atendido = filaComum.remove();
    	        output.append("Atendido COMUM: ").append(atendido).append("\n");
    	    }

    	    if (output.length() == 0) {
    	        output.append("Nenhum cliente na fila.");
    	    }

    	    JOptionPane.showMessageDialog(null, output.toString());
    	}

 }

