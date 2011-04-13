/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * listOfSlavesCellRenderer.java
 *
 * Created on 16 déc. 2008, 15:17:40
 */

package modbuspal.slave;

import javax.swing.event.AncestorEvent;
import modbuspal.toolkit.GUITools;
import modbuspal.main.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.event.AncestorListener;

/**
 *
 * @author nnovic
 */
public class ModbusSlavePanel
extends javax.swing.JPanel
implements WindowListener, ModbusSlaveListener,AncestorListener
{

    private final ModbusSlave modbusSlave;
    private final ModbusSlaveDialog modbusSlaveDialog;
    private final ModbusPalProject modbusPalProject;
    private final ModbusPalPane modbusPalPane;

    /** Creates new form listOfSlavesCellRenderer */
    public ModbusSlavePanel(ModbusPalPane p, ModbusSlave s)
    {
        modbusSlave = s;
        modbusPalPane = p;
        modbusPalProject = modbusPalPane.getProject();
        modbusSlaveDialog = new ModbusSlaveDialog(modbusPalPane, modbusSlave);
        modbusSlaveDialog.addWindowListener(this);
        initComponents();
        setBackground();
        addAncestorListener(this);
    }


    public int getSlaveId()
    {
        return modbusSlave.getSlaveId();
    }

    public void delete()
    {
       if( modbusSlaveDialog != null )
       {
            modbusSlaveDialog.removeWindowListener(this);
            modbusSlaveDialog.setVisible(false);
            modbusSlaveDialog.dispose();
            //modbusSlaveDialog = null;
       }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        slaveIdLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        enableToggleButton = new javax.swing.JToggleButton();
        showToggleButton = new javax.swing.JToggleButton();
        duplicateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 3, 3));

        slaveIdLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        slaveIdLabel.setText(String.valueOf(modbusSlave.getSlaveId()));
        slaveIdLabel.setPreferredSize(new java.awt.Dimension(30, 14));
        add(slaveIdLabel);

        nameTextField.setText(modbusSlave.getName());
        nameTextField.setPreferredSize(new java.awt.Dimension(120, 20));
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });
        nameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameTextFieldFocusLost(evt);
            }
        });
        add(nameTextField);

        enableToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modbuspal/slave/img/disabled.png"))); // NOI18N
        enableToggleButton.setSelected(modbusSlave.isEnabled());
        enableToggleButton.setToolTipText("Enable or disable this slave");
        enableToggleButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/modbuspal/slave/img/enabled.png"))); // NOI18N
        enableToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableToggleButtonActionPerformed(evt);
            }
        });
        add(enableToggleButton);

        showToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modbuspal/slave/img/show.png"))); // NOI18N
        showToggleButton.setToolTipText("Show or hide the editor of this slave");
        showToggleButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        showToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showToggleButtonActionPerformed(evt);
            }
        });
        add(showToggleButton);

        duplicateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modbuspal/slave/img/duplicate.png"))); // NOI18N
        duplicateButton.setToolTipText("Duplicate this slave");
        duplicateButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        duplicateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duplicateButtonActionPerformed(evt);
            }
        });
        add(duplicateButton);

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modbuspal/slave/img/delete.png"))); // NOI18N
        deleteButton.setToolTipText("Delete this slave");
        deleteButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        add(deleteButton);
    }// </editor-fold>//GEN-END:initComponents

    private void enableToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableToggleButtonActionPerformed
        modbusSlave.setEnabled( enableToggleButton.isSelected() );
    }//GEN-LAST:event_enableToggleButtonActionPerformed

    private void showToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showToggleButtonActionPerformed
        if( showToggleButton.isSelected() == true )
        {
            modbusSlaveDialog.setVisible(true);
        }
        else
        {
            modbusSlaveDialog.setVisible(false);
        }
    }//GEN-LAST:event_showToggleButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        modbusPalProject.removeModbusSlave(modbusSlave);
    }//GEN-LAST:event_deleteButtonActionPerformed

    /**
     * This method will be triggered when the name text field looses the focus,
     * implicitely meaning that the content is validated by the user. report
     * the content of the text field into the modbus slave.
     * @param evt
     */
    private void nameTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameTextFieldFocusLost
        String name = nameTextField.getText();
        modbusSlave.setName(name);
    }//GEN-LAST:event_nameTextFieldFocusLost

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void duplicateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duplicateButtonActionPerformed

        AddSlaveDialog dialog = new AddSlaveDialog(modbusSlave.getName(), modbusPalProject.getModbusSlaves() );
        GUITools.align(this, dialog);
        dialog.setVisible(true);

        if( dialog.isAdded() )
        {
            int ids[] = dialog.getSlaveIds();
            String name = dialog.getSlaveName();
            for( int i=0; i<ids.length; i++ )
            {
                modbusPalProject.duplicateModbusSlave(modbusSlave.getSlaveId(), ids[i], name);
            }
        }

        
    }//GEN-LAST:event_duplicateButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton duplicateButton;
    private javax.swing.JToggleButton enableToggleButton;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JToggleButton showToggleButton;
    private javax.swing.JLabel slaveIdLabel;
    // End of variables declaration//GEN-END:variables

    public void windowOpened(WindowEvent e)
    {
    }

    public void windowClosing(WindowEvent e)
    {
    }

    public void windowClosed(WindowEvent e)
    {
        if( e.getSource() == modbusSlaveDialog )
        {
            //modbusSlaveDialog = null;
            showToggleButton.setSelected(false);
        }
    }

    public void windowIconified(WindowEvent e)
    {
    }

    public void windowDeiconified(WindowEvent e)
    {
    }

    public void windowActivated(WindowEvent e)
    {
    }

    public void windowDeactivated(WindowEvent e)
    {
    }

    @Override
    public void modbusSlaveEnabled(ModbusSlave slave, boolean enabled)
    {
        if(slave==modbusSlave)
        {
            enableToggleButton.setSelected(enabled);
            setBackground(enabled);
        }
    }


    private void setBackground()
    {
        setBackground( modbusSlave.isEnabled() );
    }

    private void setBackground(boolean enabled)
    {
        if( enabled )
        {
            setBackground( javax.swing.UIManager.getDefaults().getColor("Panel.background") );
        }
        else
        {
            setBackground( javax.swing.UIManager.getDefaults().getColor("List.background") );
        }
    }

    @Override
    public void modbusSlaveImplChanged(ModbusSlave slave, int impl)
    {
    }

    @Override
    public void modbusSlaveNameChanged(ModbusSlave slave, String newName)
    {
        nameTextField.setText(newName);
    }

    @Override
    public void modbusSlavePduProcessorChanged(ModbusSlave slave, byte functionCode, ModbusPduProcessor old, ModbusPduProcessor mspp)
    {
    }

    @Override
    public void ancestorAdded(AncestorEvent event) {
    }

    @Override
    public void ancestorRemoved(AncestorEvent event)
    {
        modbusSlaveDialog.removeWindowListener(this);
        modbusSlaveDialog.setVisible(false);
        modbusSlaveDialog.dispose();
    }

    @Override
    public void ancestorMoved(AncestorEvent event) {
    }



}
