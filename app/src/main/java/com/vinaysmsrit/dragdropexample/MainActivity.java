package com.vinaysmsrit.dragdropexample;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout target1,target2,target3,target4;
    Button btn1,btn2,btn3,btn4,test1,test2,test3,test4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_main);

        target1 = findViewById(R.id.target1);
        target2 = findViewById(R.id.target2);
        target3 = findViewById(R.id.target3);
        target4 = findViewById(R.id.target4);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        test1 = findViewById(R.id.test1);
        test2 = findViewById(R.id.test2);
        test3 = findViewById(R.id.test3);
        test4 = findViewById(R.id.test4);

        target1.setOnDragListener(dragListener);
        target2.setOnDragListener(dragListener);
        target3.setOnDragListener(dragListener);
        target4.setOnDragListener(dragListener);

        btn1.setOnLongClickListener(longClickListener);
        btn2.setOnLongClickListener(longClickListener);
        btn3.setOnLongClickListener(longClickListener);
        btn4.setOnLongClickListener(longClickListener);

    }

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data,myShadowBuilder,v,0);
            return true;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener() {

        @Override
        public boolean onDrag(View v, DragEvent event) {

            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();

            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    if (v.getId() == R.id.target1 && view.getId()== R.id.btn1) {
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        test1.setVisibility(View.GONE);
                        newParent.addView(view);
                    } else if (v.getId() == R.id.target2 && view.getId()== R.id.btn2) {
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        test2.setVisibility(View.GONE);
                        newParent.addView(view);
                    } else if (v.getId() == R.id.target3 && view.getId()== R.id.btn3) {
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        test3.setVisibility(View.GONE);
                        newParent.addView(view);
                    } else if (v.getId() == R.id.target4 && view.getId()== R.id.btn4) {
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        test4.setVisibility(View.GONE);
                        newParent.addView(view);
                    }
                    break;
            }
            return true;
        }
    };


}
