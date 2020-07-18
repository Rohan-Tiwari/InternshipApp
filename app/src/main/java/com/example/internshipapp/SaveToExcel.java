package com.example.internshipapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class SaveToExcel extends AppCompatActivity {

    RecyclerView recyclerView;
    String[] Items = {"aman","bob","cindy","darry","egmanon","fifu","gify","higs","india","jack","kunal"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_to_excel);
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapter(this, Items));
        Log.d("mani", "mani");
    }

    public void submit(View view)
    {
        boolean s = saveExcelFile(this,"myExcel.xls");
        if(s)
            Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
    }
    public boolean saveExcelFile(Context context, String fileName) {

        Log.d("FileUtils", "Storage 1111");
        boolean success = false;
        //New Workbook
        Workbook wb = new HSSFWorkbook();
        Cell c = null;
        //Cell style for header row
        CellStyle cs = wb.createCellStyle();
        cs.setFillForegroundColor(HSSFColor.LIME.index);
       // cs.setCellType(HSSFCell.CELL_TYPE_STRING);
        //New Sheet
        Sheet sheet1 = wb.createSheet("myOrder");
        // Generate column headings
        Row row = sheet1.createRow(0);
        c = row.createCell(0);
        c.setCellValue("Name");
        c.setCellStyle(cs);
        sheet1.setColumnWidth(0, (15 * 500));
        // Create a path where we will place our List of objects on external storage
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        File file = new File(path, fileName);
        FileOutputStream os = null;

        for(int  i=0 ; i<Items.length;i++)
        {
            c.setCellValue(Items[0]);
        }

        try {
            os = new FileOutputStream(file);
            wb.write(os);
            Log.d("FileUtils", "Writing file" + file);
            success = true;
        } catch (IOException e) {
            Log.d("FileUtils", "Error writing " + file, e);
        } catch (Exception e) {
            Log.d("FileUtils", "Failed to save file", e);
        } finally {
            try {
                if (null != os)
                    os.close();
            } catch (Exception ex) {
            }
        }

        return success;
    }
    public static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    public static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }
}
