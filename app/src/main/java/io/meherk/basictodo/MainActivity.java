package io.meherk.basictodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;
    ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.lvItems = (ListView)findViewById(R.id.lvItems);
        this.items = new ArrayList<>();
        this.readItems();
        this.itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        this.lvItems.setAdapter(this.itemsAdapter);
        setupListViewListener();
    }

    public void onAddItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
        this.itemsAdapter.add(itemText);
        etNewItem.setText("");
        this.writeItems();
    }

    private void setupListViewListener() {
        this.lvItems.setOnItemLongClickListener(
            new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long id) {
                    items.remove(pos);
                    itemsAdapter.notifyDataSetChanged();
                    writeItems();
                    return true;
                }
            }
        );

        this.lvItems.setOnItemClickListener(
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                    Intent i = new Intent(MainActivity.this, EditItemActivity.class);
                    i.putExtra("item", items.get(pos));
                    i.putExtra("position", pos);
                    startActivityForResult(i, 20);
                }
            }
        );
    }

    private void readItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            this.items = new ArrayList<String>(FileUtils.readLines(todoFile));
        } catch (IOException e) {
            this.items = new ArrayList<>();
        }
    }

    private void writeItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            FileUtils.writeLines(todoFile, items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 20) {
            String item = data.getStringExtra("item");
            int position = data.getIntExtra("position", -1);
            if (position == -1) {
                return;
            }

            this.items.set(position, item);
            this.writeItems();
            this.itemsAdapter.notifyDataSetChanged();
        }
    }
}
