package Connection;


import Controller.CommandWithObject;
import Controller.Commands;
import Utilites.Serializator;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.ArrayList;
import java.util.HashMap;

public class ClientSender {
    boolean isCommandWithObject;
    private Serializator serializator = new Serializator();
    private DatagramChannel channel;
    private static InetSocketAddress serverAdress;
    private ByteBuffer buffer = ByteBuffer.allocate(100000);
    private int clientPort;
    private static int serverPort;
    HashMap portLoginAndPassword;

    public ClientSender(int serverPort, int clientPort) throws IOException {
        this.serverPort = serverPort;
        this.channel = DatagramChannel.open();
        channel.bind(null);
        this.serverAdress = new InetSocketAddress("localhost", serverPort);
        channel.configureBlocking(false);
        this.clientPort = clientPort;
    }

    public static InetSocketAddress getServerAdress() {
        return serverAdress;
    }

    public static int getServerPort() {
        return serverPort;
    }

    public void setPortLoginAndPassword(HashMap portLoginAndPassword) {
        this.portLoginAndPassword = portLoginAndPassword;
    }

    public boolean isCommandWithObject() {
        return isCommandWithObject;
    }

    public void sendPortLoginPassword() throws IOException {
        buffer.clear();
        buffer.put(serializator.toSerialize(portLoginAndPassword));
        buffer.flip();
        channel.send(buffer, serverAdress);
        buffer.flip();
    }

    public void send(String text) throws IOException {
        buffer.clear();
        buffer.put(text.getBytes());
        buffer.flip();
        channel.send(buffer, serverAdress);
        buffer.flip();
    }

    public void send(Object object) throws IOException {
        buffer.clear();
        buffer.put(serializator.toSerialize(object));
        buffer.flip();
        channel.send(buffer, serverAdress);
        buffer.flip();
    }

    public void sendCommand(Commands command) throws IOException, ClassNotFoundException {
        ArrayList commandAndArgument = this.toPackCommand(command);
        this.sendPortLoginPassword();
        buffer.clear();
        //thisCommand += invoker.getCommand().getName()+" "+ invoker.getArg() +"\n";
        buffer.put(serializator.toSerialize(commandAndArgument));
        buffer.flip();
        channel.send(buffer, serverAdress);
        buffer.flip();
        if (command.getCommand().getName().equals("exit"))
            command.getCommand().execute(null);
        try {
            CommandWithObject commandWithObject = (CommandWithObject) command.getCommand();
            isCommandWithObject = true;
        } catch (Exception e) {
            isCommandWithObject = false;
        }
    }

    public int getClientPort() {
        return clientPort;
    }

    public ArrayList toPackCommand(Commands command) {
        ArrayList commandAndArgument = new ArrayList();
        commandAndArgument.add(command.getCommand());
        commandAndArgument.add(command.getArg());
        return commandAndArgument;
    }
}

