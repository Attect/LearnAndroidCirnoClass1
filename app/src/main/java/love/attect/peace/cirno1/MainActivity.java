package love.attect.peace.cirno1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int ANRGY = R.drawable.angry;
    private static final int HAPPY = R.drawable.happy;
    private static final int NORMAL = R.drawable.normal;
    private static final int NORMAL_2 = R.drawable.normal2;

    private TextView textView;
    private TextView sayView;
    private ImageView characterView;
    private RelativeLayout bottomPanel;

    int actionCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("琪露诺的安卓课堂1");

        textView = (TextView) findViewById(R.id.textView);
        sayView = (TextView) findViewById(R.id.say);
        characterView = (ImageView) findViewById(R.id.character);
        bottomPanel = (RelativeLayout) findViewById(R.id.bottomPanel);

        bottomPanel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                callAction();
                return true;
            }
        });
    }


    private void callAction(){
        switch (actionCount){
            case 0:
                TranslateAnimation animationIn = new TranslateAnimation(330,0,0,0);
                animationIn.setDuration(800);
                animationIn.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        characterView.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                characterView.startAnimation(animationIn);
                characterSay(NORMAL_2,"你好");
                break;
            case 1:
                characterSay(NORMAL,"我是琪露诺\n欢迎来到琪露诺的安卓课堂");
                break;
            case 2:
                characterSay(NORMAL,"上面就是现在的黑板\n请注意变化");
                textView.setText("这是黑板。\n本体是一个TextView");
                break;
            case 3:
                characterSay(NORMAL_2,"现在，我来给大家出一个数学题\n要求是使用程序进行计算");
                textView.setText("问题将出现在这里！");
                break;
            case 4:
                characterSay(NORMAL,"题目出现在黑板了\n注意要使用程序进行计算哦。");
                textView.setText("1+2+3+4=?");
                break;
            case 5:
                characterSay(NORMAL,"通过刚才学习编写的代码\n计算了1+2+3+4的结果为");
                textView.setText("1+2+3+4=10");
                break;
            case 6:
                characterSay(HAPPY,"嘿嘿\n我这种数学天才根本不用脑子解题");
                TranslateAnimation jumpAnimation = new TranslateAnimation(0,0,0,-50);
                jumpAnimation.setDuration(150);
                jumpAnimation.setRepeatCount(2);
                jumpAnimation.setRepeatMode(Animation.REVERSE);
                characterView.startAnimation(jumpAnimation);
                break;
            case 7:
                characterSay(HAPPY,"本节的主要内容\n就是先修炼会我这样的解题本领。");
                break;
            case 8:
                characterSay(NORMAL,"虽然简单\n但也是入门的第一步。");
                break;
            case 9:
                characterSay(NORMAL_2,"至于上面黑板这样的显示效果\n在后面我们再学习。");
                break;
            case 10:
                characterSay(NORMAL,"除了简单的数字计算，还有复杂的，我就先撤了，请继续认真听课。");
                break;
            case 11:
                characterSay(HAPPY,"Bye!");
                TranslateAnimation animationOut = new TranslateAnimation(0,330,0,0);
                animationOut.setDuration(500);
                animationOut.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        characterView.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                characterView.startAnimation(animationOut);
                break;

        }
        actionCount++;
    }

    private void characterSay(int imageId,String text){
        sayView.setText(text);
        characterView.setImageResource(imageId);
    }


}
