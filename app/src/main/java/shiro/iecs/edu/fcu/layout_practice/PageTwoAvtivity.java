package shiro.iecs.edu.fcu.layout_practice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PageTwoAvtivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        //設定 toolbar 上的字
        Toolbar page2_toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(page2_toolbar);

        //把東西(Bundle) 放在 交通工具上(Intent)一起帶去
        //Intent() 切換Activity 靠他，要回傳東東也是
        //Bundle() 放returnValue 的"包裹"

        //Check按鈕的執行
        final Button checkButton = (Button) findViewById(R.id.page2_CheckButton);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取得輸入資料
                //注意:findViewById 向下轉型 至所要 component 型態
                EditText et = (EditText) findViewById(R.id.page2_editText);
                String input = et.getText().toString();

                //新建包裹 Bundle()
                Bundle bundle = new Bundle();
                //塞資料給包裹
                bundle.putString("INPUT",input);

                //Intent() <- 交通工具
                Intent intent = new Intent();
                intent.setClass(PageTwoAvtivity.this, MainActivity.class);

                //裝入 包裹送上intent
                intent.putExtras(bundle);
                //設定回傳值, 給 onActivityResult 用的
                setResult(RESULT_OK,intent);

                // 結束自己(完全消失)
                // 回去 MainActivity
                finish();
            }
        });


        //返回按鈕的執行
        final Button backButton = (Button) findViewById(R.id.page2_backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backMain = new Intent();
                backMain.setClass(PageTwoAvtivity.this, MainActivity.class);
                Toast toast = Toast.makeText(PageTwoAvtivity.this
                        , R.string.press_page2BackBText, Toast.LENGTH_SHORT);
                toast.show();

                //返回 MainActivity
                startActivity(backMain);
            }
        });
    }

}
