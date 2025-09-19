import java.net.*;
import java.io.*;

public class Servidor {
    public static void main(String[] args) throws Exception {
        ServerSocket servidor = new ServerSocket(12345);
        System.out.println("Servidor aguardando 2 clientes...");

        // Conectar Cliente A
        Socket clienteA = servidor.accept();
        System.out.println("Cliente A conectado!");
        BufferedReader inA = new BufferedReader(new InputStreamReader(clienteA.getInputStream()));
        PrintWriter outA = new PrintWriter(clienteA.getOutputStream(), true);

        // Conectar Cliente B
        Socket clienteB = servidor.accept();
        System.out.println("Cliente B conectado!");
        BufferedReader inB = new BufferedReader(new InputStreamReader(clienteB.getInputStream()));
        PrintWriter outB = new PrintWriter(clienteB.getOutputStream(), true);

        String JogadorA,JogadorB;
        JogadorA = inA.readLine();
        JogadorB = inA.readLine();

        // Comparar e mandar resultado
        if (JogadorA.equals("Tesoura")&& JogadorB.equals("Papel")) {
            outA.println("Parabéns, você ganhou!");
            outB.println("Infelizmente você perdeu!");

        } else if (JogadorB.equals("tesouro")) {
            outB.println("Parabéns, você ganhou!");
            outA.println("Infelizmente você perdeu!");
        } else {
            outA.println("Empate!");
            outB.println("Empate!");
        }

        // Fechar conexões
        clienteA.close();
        clienteB.close();
        servidor.close();
    }
}

