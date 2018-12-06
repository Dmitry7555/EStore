package  Basket;
import Main.Start;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyControl implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String NameButton = ((JButton) e.getSource()).getText();
        if (NameButton.equals("Buy else")) {

            Start.cardLayout.show(Start.panel, "DataCatalog");
        }


        if (NameButton.equals("CLOSE")) {
            System.exit(0);
        }
    }
}



