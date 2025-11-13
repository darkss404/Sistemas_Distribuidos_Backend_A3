package service;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Classe responsável por inicializar e publicar o servidor RMI do sistema de
 * estoque.
 *
 * Esta classe cria um registro RMI na porta 1099 e vincula uma instância de
 * {@link EstoqueServiceImpl} ao nome "EstoqueService", tornando os métodos
 * remotos disponíveis para os clientes que se conectarem.
 *
 * O servidor deve estar em execução antes que qualquer cliente tente acessar os
 * serviços de estoque via RMI.
 *
 * Exemplo de execução java service.Servidor
 *
 * Detalhes técnicos Porta utilizada: 1099 (padrão do RMI Registry) Serviço
 * registrado: "EstoqueService" Implementação: {@link EstoqueServiceImpl}
 *
 * @author Hector
 * @version 1.0
 * @see EstoqueServiceImpl
 */
public class Servidor {

    /**
     * Método principal que inicializa o servidor RMI.
     *
     * Cria o registro RMI na porta 1099 e vincula o serviço
     * {@link EstoqueServiceImpl} ao nome "EstoqueService". Caso ocorra algum
     * erro, a exceção será exibida no console.
     *
     * @param args argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        try {
            // Cria o registro RMI na porta 1099
            Registry registro = LocateRegistry.createRegistry(1099);
            // Publica o serviço de estoque para acesso remoto
            registro.rebind("EstoqueService", new EstoqueServiceImpl());
            System.out.println("Servidor RMI ativo na porta 1099...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
