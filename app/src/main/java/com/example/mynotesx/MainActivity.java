package com.example.mynotesx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.TintableCheckedTextView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbarAndDrawer();


        Button addNote = findViewById(R.id.add_note);
        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar tempSnackbar = Snackbar.make(findViewById(R.id.drawer_layout), R.string.warning, Snackbar.LENGTH_LONG)
                        .setAction(R.string.action_snackbar, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            }
                        });
                tempSnackbar.show();
            }
        });

    }

    private void initToolbarAndDrawer() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initDrawer(toolbar);
    }


    private void initDrawer(Toolbar toolbar) {
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.action_drawer_about:

                        getSupportFragmentManager()
                                .beginTransaction()
                                .addToBackStack("")
                                .add(R.id.list_fragment, new AboutAppFragment()).commit();
                        drawer.closeDrawers();
                        return true;
                    case R.id.action_drawer_exit:
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle(R.string.exit)
                                .setMessage(R.string.are_you_sure)
                                .setIcon(R.mipmap.ic_launcher_round)
                                .setCancelable(true)
                                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(getApplicationContext(), R.string.bye, Toast.LENGTH_SHORT).show();
                                        finish();
                                    }
                                })
                                .setNegativeButton(R.string.no, null)
                                .show();
                        return true;
                }
                return false;
            }
        });
    }


//    @Override
//    public void itemClicked(long id) {
//        View fragmentContainer = findViewById(R.id.list_fragment);
//        if (fragmentContainer != null) {
//            NoteFragment fragment = new NoteFragment();
//            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//            fragment.setNote(id);
//            transaction.replace(R.id.list_fragment, fragment);
//            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//            transaction.addToBackStack(null);
//            transaction.commit();
//        } else {
//            Intent intent = new Intent(this, NoteActivity.class);
//            intent.putExtra(NoteActivity.NOTES_ID, (int) id);
//            startActivity(intent);
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_find:
            case R.id.action_send:
                Snackbar tempSnackbar = Snackbar.make(findViewById(R.id.drawer_layout), R.string.warning, Snackbar.LENGTH_LONG)
                        .setAction(R.string.action_snackbar, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            }
                        });
                tempSnackbar.show();
                return true;
            case R.id.action_about:
                getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack("")
                        .add(R.id.list_fragment, new AboutAppFragment()).commit();
                return true;
            case R.id.action_exit:
                new AlertDialog.Builder(this)
                        .setTitle(R.string.exit)
                        .setMessage(R.string.are_you_sure)
                        .setIcon(R.mipmap.ic_launcher_round)
                        .setCancelable(true)
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), R.string.bye, Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        })
                        .setNegativeButton(R.string.no, null)
                        .show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}