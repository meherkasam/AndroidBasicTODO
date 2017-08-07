package io.meherk.basictodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by meherk on 8/6/17.
 */

public class EditItemActivity extends AppCompatActivity {
    EditText editText;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String item = getIntent().getStringExtra("item");
        this.position = getIntent().getIntExtra("position", -1);
        this.editText = (EditText)findViewById(R.id.editText);
        this.editText.setText(item);
    }

    public void onSave(View view) {
        String item = this.editText.getText().toString();
        Intent data = new Intent();
        data.putExtra("item", item);
        data.putExtra("position", this.position);
        setResult(RESULT_OK, data);
        finish();
    }
}
