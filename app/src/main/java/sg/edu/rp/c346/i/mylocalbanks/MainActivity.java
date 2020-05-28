package sg.edu.rp.c346.i.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);

    }


    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v.getId() == R.id.textViewDBS) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
        }else if(v.getId() == R.id.textViewOCBC){
            getMenuInflater().inflate(R.menu.menu_main1, menu);
        }else if(v.getId() == R.id.textViewUOB){
            getMenuInflater().inflate(R.menu.menu_main2, menu);
        }
    }

    public boolean onContextItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.wSite_DBS){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.wSiteDBS)));
            startActivity(intent);
        }else if(id == R.id.cBank_DBS){
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getResources().getString(R.string.contactDBS)));
            startActivity(intentCall);
        }else if(id == R.id.wSite_OCBC){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.wSiteOCBC)));
            startActivity(intent);
        }else if(id == R.id.cBank_OCBC) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getResources().getString(R.string.contactOCBC)));
            startActivity(intentCall);
        }else if(id == R.id.wSite_UOB){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.wSiteUOB)));
            startActivity(intent);
        }else if(id == R.id.cBank_UOB) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getResources().getString(R.string.contactUOB)));
            startActivity(intentCall);
        }


        return super.onContextItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate the menu: this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.language, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        // Handle action bar item clicks here
        int id = item.getItemId();

        if(id == R.id.langEnglish){
            tvDBS.setText(getResources().getString(R.string.dbs));
            tvOCBC.setText(getResources().getString(R.string.ocbc));
            tvUOB.setText(getResources().getString(R.string.uob));
        }else if(id == R.id.langChinese){
            tvDBS.setText(getResources().getString(R.string.cDBS));
            tvOCBC.setText(getResources().getString(R.string.cOCBC));
            tvUOB.setText(getResources().getString(R.string.cUOB));
        }

        return super.onOptionsItemSelected(item);
    }
}
