/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskresumption;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author satyam
 */
public class CustomTableModel extends AbstractTableModel {
    
    private String[] columns = {"Delete","Application","File","Start","End","Resume"};
    private ArrayList<TableData> data;
    
    public CustomTableModel (ArrayList<TableData> a) {
        super();
        this.data = a;
    }
    
    

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return (Boolean) data.get(rowIndex).getDelete();
            case 1:
                return data.get(rowIndex).getApplication();
            case 2:
                return data.get(rowIndex).getFile();
            case 3:
                return data.get(rowIndex).getStart();
            case 4:
                return data.get(rowIndex).getEnd();
            case 5:
                return (Boolean) data.get(rowIndex).getResume();
        }
        return null;
    }
    
    public String getColumnName (int col) {
        return columns[col];
    }
    
    public Class<?> getColumnClass (int col) {
        return getValueAt(0,col).getClass();
    }
    
    
    
    public boolean isCellEditable (int row, int col) {
        if (col == 0) {
            data.get (row).setDelete(!data.get(row).getDelete());
        } else if (col == 5) {
            data.get (row).setResume (!data.get(row).getResume());
        }
        
        fireTableCellUpdated (row,col);
        
        return false;
    }
}
