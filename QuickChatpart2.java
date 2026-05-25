/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quickchatpart2;

import java.util.Scanner;

public class QuickChatpart2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean loggedIn = true;

        if (loggedIn) {

            System.out.println("Welcome to QuickChat.");

            System.out.print("How many messages would you like to send? ");
            int numberOfMessages = input.nextInt();
            input.nextLine();

            int currentMessage = 0;

            while (true) {

                System.out.println("\nChoose an option:");
                System.out.println("1) Send Messages");
                System.out.println("2) Show recently sent messages");
                System.out.println("3) Quit");

                int menuChoice = input.nextInt();
                input.nextLine();

                switch (menuChoice) {

                    case 1:

                        if (currentMessage >= numberOfMessages) {
                            System.out.println("You have reached your message limit.");
                            break;
                        }

                        System.out.print("Enter recipient number: ");
                        String recipient = input.nextLine();

                        System.out.print("Enter your message: ");
                        String messageText = input.nextLine();

                        Message msg = new Message(currentMessage, recipient, messageText);

                        System.out.println(msg.checkRecipientCell());
                        System.out.println(msg.checkMessageLength());

                        if (msg.checkMessageID()) {
                            System.out.println("Message ID generated: " + msg.getMessageID());
                        }

                        System.out.println("Message Hash: " + msg.getMessageHash());

                        System.out.println("\nChoose message option:");
                        System.out.println("1) Send Message");
                        System.out.println("2) Disregard Message");
                        System.out.println("3) Store Message");

                        int option = input.nextInt();
                        input.nextLine();

                        System.out.println(msg.sentMessage(option));

                        if (option == 1) {

                            System.out.println("\nFULL MESSAGE DETAILS");
                            System.out.println("-------------------------");
                            System.out.println("Message ID: " + msg.getMessageID());
                            System.out.println("Message Hash: " + msg.getMessageHash());
                            System.out.println("Recipient: " + msg.getRecipient());
                            System.out.println("Message: " + msg.getMessage());
                        }

                        currentMessage++;
                        break;

                    case 2:
                        System.out.println("Coming Soon.");
                        break;

                    case 3:

                        System.out.println("\nTotal Messages Sent: " + Message.returnTotalMessages());

                        System.out.println(Message.printMessages());

                        System.out.println("Goodbye.");
                        System.exit(0);

                    default:
                        System.out.println("Invalid menu option.");
                }
            }
        }
        else {
            System.out.println("Please log in first.");
        }
    }
}
