package UI;

import Elements.Element;
import Engine.Engine;
import Engine.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by chase on 10/11/14.
 */
public class CraftingFrame extends JPanel {

    JButton[] elementButtons;
    JButton craftButton;

    ActionListener removeItemListener;


    public CraftingFrame(ActionListener removeItemListener) {
        super();
        this.removeItemListener = removeItemListener;
        setSize((Engine.imageSize * 4) + (5 * 4), Engine.imageSize);
        setVisible(true);
        setLayout(null);
        setBackground(new Color(255, 255, 255, 0));
        elementButtons = new JButton[3];
        craftButton = new JButton(new ImageIcon(ImageLoader.getImage("ElementFusion.png", this)));
        craftButton.setLocation(3 * 32 + 3 * 5, 0);
        craftButton.setSize(Engine.imageSize, Engine.imageSize);
        craftButton.setBorder(BorderFactory.createEmptyBorder());
        craftButton.setToolTipText("Fuse Elements");
        craftButton.setEnabled(false);
        add(craftButton);
    }

    public void setCraftListner(ActionListener listener){
        craftButton.addActionListener(listener);
    }

    public boolean addElement(Element element) {
        boolean added = false;
        for (int z = 0; z < elementButtons.length; z++) {
            if (elementButtons[z] == null) {
                elementButtons[z] = new JButton(new ImageIcon(element.getImage()));
                elementButtons[z].setBorder(BorderFactory.createEmptyBorder());
                elementButtons[z].setLocation((Engine.imageSize * z) + (5 * z), 0);
                elementButtons[z].addActionListener(removeItemListener);
                elementButtons[z].setSize(Engine.imageSize, Engine.imageSize);
                elementButtons[z].setName(element.getElementType());
                elementButtons[z].setToolTipText(element.getName());
                add(elementButtons[z]);
                added = true;
                break;
            }
        }
        updateCraftButton();
        return added;
    }

    public void removeElement(ActionEvent e){
        for (int z = 0; z < elementButtons.length; z++) {
            if(elementButtons[z] != null && elementButtons[z] == e.getSource()){
                remove(elementButtons[z]);
                elementButtons[z] = null;
                break;
            }
        }
        updateCraftButton();
    }

    private void updateCraftButton(){
        int count = 0;
        for(int z=0; z< elementButtons.length; z++){
            if(elementButtons[z] != null){
                count ++;
            }
        }
        craftButton.setEnabled(count >= 2);
    }
}
