package com.example.internshipapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        else
            Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
    }
    public boolean saveExcelFile(Context context, String fileName) {

        /*Log.d("FileUtils", "Storage 1111");
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
*/
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions((Activity) context,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

            return false;
        }
        boolean success = false;
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sample sheet");
/*

        Map< String, Object[] > data = new HashMap< String, Object[] >();
        data.put("1", new Object[] {
                "Emp No.",
                "Name",
                "Salary"
        });
        data.put("2", new Object[] {
                1d , "John", 1500000d
        });
        data.put("3", new Object[] {
                2d , "Sam", 800000d
        });
        data.put("4", new Object[] {
                3d, "Dean", 700000d
        });

        Set< String > keyset = data.keySet();
        int rownum = 0;
        for (String key: keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj: objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof Date)
                    cell.setCellValue((Date) obj);
                else if (obj instanceof Boolean)
                    cell.setCellValue((Boolean) obj);
                else if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Double)
                    cell.setCellValue((Double) obj);
            }
        }
*/

        Row row1 = sheet.createRow(0);
        Cell c= row1.createCell(0);
        c.setCellValue("name");

        for(int  i=0 ; i<Items.length;i++)
        {
            c = row1.createCell(i++);
            c.setCellValue(Items[0]);
        }

        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        Toast.makeText(this, "this is success"+path, Toast.LENGTH_SHORT).show();

        try {
            FileOutputStream out =
                    new FileOutputStream(new File(path, fileName));
            workbook.write(out);
            success = true;
            out.close();
            Toast.makeText(this, "this is success in writing"+out, Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
