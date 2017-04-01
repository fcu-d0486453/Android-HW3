package shiro.iecs.edu.fcu.layout_practice;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final int EDIT_CONTENT = 87;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);

            Button btn_m = (Button) findViewById(R.id.up_but);//建立一個button(中間那顆), 並初始化
            Button btn_r = (Button) findViewById(R.id.r_but);
            Button btn_l = (Button) findViewById(R.id.l_but);
            Button btn_w = (Button) findViewById(R.id.web_but);

            btn_w.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri=Uri.parse("http://myweb.fcu.edu.tw/~d0486453/");
                    Intent i=new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(i);
                }
            });

            btn_m.setOnClickListener(new View.OnClickListener() {//按鈕傾聽者 中間那顆
            @Override
            public void onClick(View v) {
                //利用Toast的靜態函式makeText來建立Toast物件
                Toast toast = Toast.makeText(MainActivity.this,
                        R.string.press_up_but_text, Toast.LENGTH_SHORT);
                //顯示Toast
                toast.show();
                }
        });

                btn_l.setOnClickListener(new View.OnClickListener() {//按鈕傾聽者 左邊那顆
            @Override
            public void onClick(View v) {
                    //利用Toast的靜態函式makeText來建立Toast物件
                    Toast toast = Toast.makeText(MainActivity.this,
                    R.string.press_lf_but_text, Toast.LENGTH_SHORT);
                    //顯示Toast
                    toast.show();
                }
        });

            btn_r.setOnClickListener(new View.OnClickListener() {//按鈕傾聽者 右邊那顆
            @Override
            public void onClick(View v) {
                    //利用Toast的靜態函式makeText來建立Toast物件
                    Toast toast = Toast.makeText(MainActivity.this,
                            R.string.press_rt_but_text, Toast.LENGTH_SHORT);
                    //顯示Toast
                    toast.show();
                }
        });

        Button nextPageBut = (Button) findViewById(R.id.next_but);
        //生成一個button物件 先讓他指定在螢幕上要連結的物件ID

        nextPageBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent page2_intent = new Intent();
                //Intent物件 可開啟另一個 Activity

                page2_intent.setClass(MainActivity.this, PageTwoAvtivity.class);
                //針對 intent 物件初始化 (A.this,B.class) 從A跳到B

                startActivityForResult(page2_intent, EDIT_CONTENT);
                //ForResult 意旨此intent 希望 有東西可以得到(雙向溝通)
                //寫下 Require code 辨認 是哪一個Activity 的回傳
                //另外 有 startActivityForResult 就須覆寫 "onActivityResult"

                Toast.makeText(MainActivity.this, "請輸入資料"
                        , Toast.LENGTH_SHORT).show();
            }
        });
    }

               //因為 有 startActivityForResult 所以 要覆寫
               //這個 MainActivity利用 "onActivityResult"
               //來接收其他 Activity 的所有回傳
               //利用 requestCode 辨認 哪個 Activity的回傳
               //再利用 resultCode 辨認所處理結果
    @Override  //Intent 這個物件, 可能有 bundle(包裹),所包裹的資料
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == EDIT_CONTENT){
                Toast.makeText(MainActivity.this, data.getStringExtra("INPUT")
                        , Toast.LENGTH_SHORT).show();
            }
        }
    }
}
