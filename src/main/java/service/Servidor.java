package service;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            Registry registro = LocateRegistry.createRegistry(1099);
            registro.rebind("EstoqueService", new EstoqueServiceImpl());
            System.out.println("Servidor RMI ativo na porta 1099...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
