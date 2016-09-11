package id.sch.smktelkom_mlg.tugas01.xirpl3025.form;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spProvinsi;
    EditText etNama, etNomor, etAlamat, etJam;
    Button bOk;
    RadioButton rbPR, rbLK;
    CheckBox cbSnn, cbSls, cbRb, cbKms, cbJmt;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spProvinsi = (Spinner) findViewById(R.id.spinnerProvinsi);
        etNama = (EditText) findViewById(R.id.editTextNama);
        etNomor = (EditText) findViewById(R.id.editTextTelpon);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);
        etJam = (EditText) findViewById(R.id.editTextWaktu);
        bOk = (Button) findViewById(R.id.buttonOK);
        rbPR = (RadioButton) findViewById(R.id.radioButtonPR);
        rbLK = (RadioButton) findViewById(R.id.radioButtonLK);
        cbSnn = (CheckBox) findViewById(R.id.checkBoxSnn);
        cbSls = (CheckBox) findViewById(R.id.checkBoxSls);
        cbRb = (CheckBox) findViewById(R.id.checkBoxRb);
        cbKms = (CheckBox) findViewById(R.id.checkBoxKms);
        cbJmt = (CheckBox) findViewById(R.id.checkBoxJmt);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
                doGender();
                doHari();
            }
        });

    }

    private void doHari() {
        String hasil = "Hari yang anda pilih : \n";
        int startlen = hasil.length();
        if (cbSnn.isChecked()) hasil += cbSnn.getText() + "\n";
        if (cbSls.isChecked()) hasil += cbSls.getText() + "\n";
        if (cbRb.isChecked()) hasil += cbRb.getText() + "\n";
        if (cbKms.isChecked()) hasil += cbKms.getText() + "\n";
        if (cbJmt.isChecked()) hasil += cbJmt.getText() + "\n";

        if (hasil.length() == startlen) hasil += "Tidak ada pada Pilihan";

        tvHasil.setText(hasil);
    }

    private void doGender() {
        String hasil = null;
        if (rbPR.isChecked()) {
            hasil = rbPR.getText().toString();
        } else if (rbLK.isChecked()) {
            hasil = rbLK.getText().toString();
        }
        if (hasil == null) {
            tvHasil.setText("Anda belum memilih Status");
        } else {
            tvHasil.setText("\nAnda Seorang : " + hasil);
        }
    }

    private void doClick() {
        tvHasil.setText("Anda Berada di Wilayah " + spProvinsi.getSelectedItem().toString());
        if (isValid()) {
            tvHasil.setText(" \nNama Anda : " + etNama.getText().toString() + " \nNomor Telpon anda : " + etNomor.getText().toString()
                    + " \nAlamat Rumah Anda : " + etAlamat.getText().toString());

        }
    }


    protected boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String nomor = etNomor.getText().toString();
        String alamat = etAlamat.getText().toString();
        String jam = etJam.getText().toString();


        if (nama.isEmpty()) {
            etNama.setError("Harap isikan Nama Anda!!!");
            valid = false;
        } else {
            etNama.setError(null);
        }
        if (nomor.isEmpty()) {
            etNomor.setError("Harap Masukkan Nomor Telpon!!!");
            valid = false;
        } else {
            etNomor.setError(null);
        }
        if (alamat.isEmpty()) {
            etAlamat.setError("Harap isikan Alamat Anda!!!");
            valid = false;
        } else {
            etAlamat.setError(null);
        }
        if (jam.isEmpty()) {
            etJam.setError("Harap isikan Alamat Anda!!!");
            valid = false;
        } else {
            etJam.setError(null);
        }
        return valid;
    }

}

