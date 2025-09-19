import java.net.*;
import java.io.*;

public class Cliente {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("10.106.208.11", 12345);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        // Receber mensagem do servidor
        String msg = in.readLine();
        System.out.println("Servidor: " + msg);

        // Digitar número e enviar
        String numero = teclado.readLine();
        out.println(numero);

        // Receber respostas
        String resposta;
        while ((resposta = in.readLine()) != null) {
            System.out.println("Servidor: " + resposta);
        }

        socket.close();
    }
}
