package Connection;

import Controller.HumanCollection;
import Human.HumanBeing;
import Utilites.Deserializator;
import Utilites.Serializator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;


public class ClientReceiver {
    HumanCollection collection = new HumanCollection();
    Deserializator deserializator = new Deserializator();
    static DatagramSocket clientSocket = null;
    byte[] data = new byte[2056];
    private int clientPort;

    public ClientReceiver(int clientPort) throws SocketException {
        this.clientSocket = new DatagramSocket(clientPort);
        this.clientPort = clientPort;
    }


    public int getClientPort() {
        return clientPort;
    }

    public String receive() throws IOException {
        DatagramPacket packet = new DatagramPacket(data, data.length);
        clientSocket.setSoTimeout(2000);
        clientSocket.receive(packet);
        clientSocket.setSoTimeout(0);
        String received = new String(packet.getData(), 0, packet.getLength());
        return received;
    }

    public void receiveCollection() throws IOException, ClassNotFoundException {
        DatagramPacket packet = new DatagramPacket(data, data.length);
        clientSocket.setSoTimeout(2000);
        clientSocket.receive(packet);
        clientSocket.setSoTimeout(0);
        collection.setArray((ArrayList<HumanBeing>) Deserializator.toDeserialize(packet.getData()));
    }
}
//    public void innerSend(HumanBeing humanBeing) throws IOException {
//        try {
//            Serializator serializator = new Serializator();
//            data = serializator.toSerialize(humanBeing);
//            DatagramPacket sendPacket = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), ClientSender.getServerPort());
//            clientSocket.send(sendPacket);
//        } catch (Exception e) {
//            e.printStackTrace();



