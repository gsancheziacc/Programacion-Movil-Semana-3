package com.example.gabriel_sanchez_s3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnSubmit_OnClick(View view) {
        //Show event onClick on logcat
        Log.d("btnSubmit", "Onclick called!");

        //Controls to get
        final TextView txtRepairNumber = (TextView) findViewById(R.id.txtRepairNumber);
        final Spinner selectEquipmentType = (Spinner) findViewById(R.id.selectEquipmentType);
        final TextView txtDiagnostic = (TextView) findViewById(R.id.txtDiagnostic);

        //Values from controls
        String repairNumberValue = txtRepairNumber.getText().toString();
        String equipmentTypeValue = selectEquipmentType.getSelectedItem().toString();
        String diagnosticValue = txtDiagnostic.getText().toString();

        //Show values in logcat
        Log.d("txtRepairNumber", repairNumberValue);
        Log.d("txtEquipmentType", equipmentTypeValue);
        Log.d("txtDiagnostic", diagnosticValue);

        Toast toast1 = Toast.makeText(getApplicationContext(), "OT Generada correctamente", Toast.LENGTH_SHORT);
        toast1.show();

        String dialogText = "Número Reparación: " + repairNumberValue + "\r\n"
                + "Tipo de equipamiento: " + equipmentTypeValue + "\r\n"
                + "Diagnóstico: " + diagnosticValue;
        AlertDialog dialog = standarDialog("OT Creada", dialogText);
        dialog.show();
    }

    private AlertDialog standarDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setTitle(title);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        return dialog;
    }
}