package com.example.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public class MenuActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        menu.add(Menu.NONE,1,Menu.NONE,"文件");
        //创建子菜单
        SubMenu subMenu = menu.addSubMenu(Menu.NONE,100,Menu.NONE,"字号设置");
        subMenu.add(Menu.NONE,101,Menu.NONE,"8号");
        subMenu.add(Menu.NONE,101,Menu.NONE,"12号");
        return super.onCreateOptionsMenu(menu);
    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        switch (item.getItemId()){
//            case R.id.menu_search;
//                search();
//                break;
//        }
  //  }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
}
