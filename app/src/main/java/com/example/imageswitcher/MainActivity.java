package com.example.imageswitcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    ImageSwitcher imageSwitcher;
    Button button;


    int imageIds[] = {R.drawable.image1,R.drawable.images2,R.drawable.image3,R.drawable.images4,R.drawable.images5};
    int count = imageIds.length;
    int currentIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageSwitcher=findViewById(R.id.simpleImageSwitcher);
        button=findViewById(R.id.button);
      //set the view factor of the imageswitcher thet will create imageview object when asked
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                //create a new Imageview and set its properties
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                //set the height and width of imageview to fill parent
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
                ,LinearLayout.LayoutParams.MATCH_PARENT));
                return  imageView;
            }
        });
        //declare in and out animations and load them using Animationunits class
        Animation in = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right);
        //set the animation type to Imageswitcher
        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                if(currentIndex == count)
                    currentIndex = 0;
                imageSwitcher.setImageResource(imageIds[currentIndex]);

            }
        });

    }
}
