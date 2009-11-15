/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddRequestDialog.java
 *
 * Created on 4 janv. 2009, 14:29:24
 */

package modbuspal.master;

import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.JDialog;
import javax.swing.event.ListDataListener;
import modbuspal.toolkit.GUITools;
import modbuspal.main.ModbusConst;
import modbuspal.main.ModbusPal;
import modbuspal.slave.ModbusSlave;

/**
 *
 * @author nnovic
 */
public class AddRequestDialog
extends javax.swing.JDialog
implements ModbusConst
{
    class SlavesList
    implements ComboBoxModel
    {
        private Vector<ModbusSlave> knownSlaves = new Vector<ModbusSlave>();
        private Object selected = null;
        
        private SlavesList(ModbusSlave[] slaves) 
        {
            for( int i=0; i<slaves.length; i++ )
            {
                if( slaves[i]!=null )
                {
                    knownSlaves.add(slaves[i]);
                    if( selected == null )
                    {
                        selected = slaves[i];
                    }
                }
            }
        }
        public void setSelectedItem(Object anItem)
        {
            selected = anItem;
        }
        public Object getSelectedItem()
        {
            return selected;
        }
        public int getSize()
        {
            return knownSlaves.size();
        }
        public Object getElementAt(int index) 
        {
            String value = String.valueOf(index+1);
            return value+":"+knownSlaves.get(index).getName();
        }
        public void addListDataListener(ListDataListener l)
        {
            return;
        }
        public void removeListDataListener(ListDataListener l)
        {
            return;
        }
        public ModbusSlave getSlaveAt(int index)
        {
            return knownSlaves.get(index);
        }
    }


    private boolean added = false;
    private SlavesList slaves = null;

    /** Creates new form AddRequestDialog */
    public AddRequestDialog(Frame parentFrame, JDialog parentDialog)
    {
        super(parentFrame, true);
        slaves = new SlavesList( ModbusPal.getModbusSlaves() );
        initComponents();
        slaveComboBox.setSelectedIndex(0);
        //slaveHasBeenSelected(0);
        GUITools.align(parentDialog,this);
    }

    public int getSlaveId()
    {
        return slaveComboBox.getSelectedIndex()+1;
    }


    public boolean isAdded()
    {
        return added;
    }

    public int getFunctionCode()
    {
        return functionComboBox.getSelectedIndex()+1;
    }

    public int getAddress()
    {
        return Integer.parseInt( addressTextField.getText() );
    }

    public int getQuantity()
    {
        return Integer.parseInt( quantityTextField.getText() );
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        addButton = new javax.swing.JButton();
        functionComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        addressTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        quantityTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        slaveComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 3, 3, 3);
        getContentPane().add(addButton, gridBagConstraints);

        functionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "(0x03) Read holding registers" }));
        functionComboBox.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(functionComboBox, gridBagConstraints);

        jLabel1.setText("Select function:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel2.setText("Address:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jLabel2, gridBagConstraints);

        addressTextField.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(addressTextField, gridBagConstraints);

        jLabel3.setText("Quantity:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jLabel3, gridBagConstraints);

        quantityTextField.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(quantityTextField, gridBagConstraints);

        jLabel4.setText("Slave:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jLabel4, gridBagConstraints);

        slaveComboBox.setModel(slaves);
        slaveComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                slaveComboBoxItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(slaveComboBox, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        added = true;
        setVisible(false);
    }//GEN-LAST:event_addButtonActionPerformed

    private void slaveComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_slaveComboBoxItemStateChanged

        if( evt.getStateChange() == ItemEvent.SELECTED )
        {
            // get the index of the selected item
            int index = slaveComboBox.getSelectedIndex();
            // retrieve the associated modbus slave
            ModbusSlave modbusSlave = slaves.getSlaveAt(index);
            // retrieve the current implementation
            switch(modbusSlave.getImplementation())
            {
                default:
                case IMPLEMENTATION_MODBUS:
                    addressTextField.setText("1");
                    break;
                case IMPLEMENTATION_JBUS:
                    addressTextField.setText("0");
                    break;
            }
            quantityTextField.setText("1");
        }

    }//GEN-LAST:event_slaveComboBoxItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JComboBox functionComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JComboBox slaveComboBox;
    // End of variables declaration//GEN-END:variables

}
