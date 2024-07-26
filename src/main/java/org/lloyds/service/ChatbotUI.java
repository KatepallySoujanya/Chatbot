package org.lloyds.service;

import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatbotUI extends JFrame {

    private JTextArea chatArea;
    private JButton[] questionButtons;

    public ChatbotUI() {
        setTitle("Simple Chatbot UI");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Text area for displaying chat history
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        // Panel for question buttons
        JPanel buttonPanel = new JPanel(new GridLayout(0, 1));

        // Define some example questions as buttons
        String[] questionTexts = {
                "How are you?",
                "What's the weather like?",
                "Tell me a joke",
                "Goodbye"
        };

        // Create buttons for each question
        questionButtons = new JButton[questionTexts.length];
        for (int i = 0; i < questionTexts.length; i++) {
            final int index = i;
            questionButtons[i] = new JButton(questionTexts[i]);
            questionButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String question = questionButtons[index].getText();
                    String response = getResponse(question);
                    displayChat("You: " + question + "\nChatbot: " + response);
                }
            });
            buttonPanel.add(questionButtons[i]);
        }

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Method to generate responses based on selected question
    private String getResponse(String question) {
        // Implement logic to generate responses based on the selected question
        switch (question.toLowerCase()) {
            case "how are you?":
                return "I'm just a chatbot, but thanks for asking!";
            case "what's the weather like?":
                return "You can check the weather at a weather website.";
            case "tell me a joke":
                return "Why don't scientists trust atoms? Because they make up everything!";
            case "goodbye":
                System.exit(0);
        }
        return "Sorry, I don't understand that question.";
    }

    // Method to display chat history in the text area
    private void displayChat(String message) {
        chatArea.append(message + "\n\n");
    }

    public static void main(String[] args) {
        // Run the chatbot UI in the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChatbotUI();
            }
        });
    }
}

