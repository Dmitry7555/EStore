package Basket;
/**
 * В данном классе выводится сообщение об успешном овормлении покупки.
 * И з данного класса пользователь может выйти из сайта и осуществить возврат к списку товаров
 * для осуществления новой покупки.
 *
 * @author dmitri
 * @version 1.0
 */


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Buy extends JPanel {
    protected JButton backToProductList = new JButton("Buy else");
    protected JButton closeProgram = new JButton("CLOSE");
    protected JLabel purchaseMessage = new JLabel("The purchase is formalized");
    protected Image image;

    /*This is a JavaDoc method
     * создаёт форму на которой отображается сообщение о покупке
     * помещает заставку на форму
     */
    public Buy() {

        setLayout(null);
        int leftBackToProductList = 370;
        int topBackToProductList = 400;
        int widthBackToProductList = 100;
        int heightBackToProductList = 50;
        backToProductList.setBounds(leftBackToProductList, topBackToProductList, widthBackToProductList, heightBackToProductList);
        int leftCloseProgram = 370;
        int topCloseProgram = 500;
        int widthCloseProgram = 100;
        int heightCloseProgram = 50;
        closeProgram.setBounds(leftCloseProgram, topCloseProgram, widthCloseProgram, heightCloseProgram);
        int leftPurchaseMessage = 350;
        int topPurchaseMessage = 100;
        int widthPurchaseMessage = 200;
        int heightPurchaseMessage = 200;
        purchaseMessage.setBounds(leftPurchaseMessage, topPurchaseMessage, widthPurchaseMessage, heightPurchaseMessage);
        add(purchaseMessage);
        add(backToProductList);
        add(closeProgram);
        ActionListener actionListenerBackToProductList=new BuyControl();
        backToProductList.addActionListener(actionListenerBackToProductList);
        ActionListener actionListenerCloseProgram=new BuyControl();
        closeProgram.addActionListener(actionListenerCloseProgram);
    }
}