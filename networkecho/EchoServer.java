package networkecho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoServer implements Runnable{
    private Socket socket;
    private String currentRoom;
    private String currentPerson;
    private PrintWriter w;

    public EchoServer(Socket s) {
        socket = s;
        try {
            w = new PrintWriter(s.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessageToClient(String msg, boolean printLn) {
        w.println(msg);
        w.flush();
    }

    private void getUserInfo(BufferedReader rd) {
        try {
            sendMessageToClient("이름: ", false);
            currentPerson = rd.readLine();
            boolean done = false;
            while (!done) {
                sendMessageToClient("1. 방 만들기\n2. 방 들어가기\n 선택: ", false);
                int op = Integer.parseInt(rd.readLine());
                switch (op) {
                    case 1:
                        sendMessageToClient("개설할 방 이름: ", false);
                        currentRoom = rd.readLine();
                        ChatSharedData.getInstance().createRoom(currentRoom);
                        ChatSharedData.getInstance().createPerson(currentPerson, socket, currentRoom);
                        sendMessageToClient("방이 만들어졌습니다." + "(" + currentRoom + ")", true);
                        done = true;
                        break;
                    case 2:
                        if (ChatSharedData.getInstance().getNumberOfRooms() == 0) {
                            sendMessageToClient("개설된 방이 없습니다.", true);
                            break;
                        } else {
                            sendMessageToClient(ChatSharedData.getInstance().getRoomList(), true);
                            sendMessageToClient("들어갈 방 번호 :", false);
                            currentRoom = ChatSharedData.getInstance().getRoomByIndex(Integer.parseInt(rd.readLine())).getName();
                            ChatSharedData.getInstance().createPerson(currentPerson, socket, currentRoom);
                            sendMessageToClient("방에 입장하였습니다." + "(" + currentRoom + ")", true);
                        }
                        done = true;
                        break;
                    default:
                        break;
                }
            }
//            w.close();
//            This code allows the client to proceed without waiting at the readLine(), which causes
//            a NULL pointer exception error. (One side of the blocking method is ended.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            getUserInfo(rd);
            String s;
            while (true) {
                s = rd.readLine();
                if (s.equals("/exit")) {
                    try {
                        sendMessageToClient(s, false);
                        Thread.sleep(500);
                        break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                ChatSharedData.getInstance().broadcast(w, s, currentRoom, currentPerson);
            }
            rd.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
