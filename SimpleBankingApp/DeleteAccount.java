package SimpleBankingApp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DeleteAccount{
    public DeleteAccount() {
        int selectedRow = MainMenu.accountTable.getSelectedRow();

        // If no row is selected, show an error message.
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        
        else {
            // Show a confirmation dialog.
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the selected row?", "Delete Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Remove the selected row.
                DefaultTableModel model = (DefaultTableModel) MainMenu.accountTable.getModel();
                model.removeRow(selectedRow);
            }
        }

    }
}