import Connection.*;
import Commands.*;
import Controller.Commands;

import java.io.IOException;
import java.net.BindException;
import java.security.NoSuchAlgorithmException;


public class Main {//Client

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        int clientPort = 313;
        int serverPort = 1257;
//        if (args.length != 0) {
//            try {
//                clientPort = Integer.parseInt(args[0]);
//            } catch (Exception e) {
//                System.out.println("Неверно указан порт(целое положительное число, меньшее 65536).");
//            }
//            if (clientPort < 0) clientPort = Console.getClientPort();
        Commands commands = new Commands();
        commands.regist(new Help(), new Show(), new Remove_by_id(), new Remove_first(), new Remove_lower(), new Add(),
                new Exit(), new Clear(), new Info(), new Update(), new Count_less_than_impact_speed(), new History(),
                new Print_ascending(), new Execute_script());
        try {
            ClientReceiver receiver = new ClientReceiver(clientPort);
            ClientSender sender = new ClientSender(serverPort, clientPort);
            App app = new App(sender, receiver);
            app.begin();
            app.run();
        } catch (BindException e) {
            System.out.println("Этот порт уже занят=(");
        } catch (IllegalArgumentException e) {
            System.out.println("Этот порт слишком большой=(");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}


