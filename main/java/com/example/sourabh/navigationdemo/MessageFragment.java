package com.example.sourabh.navigationdemo;


import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {

    Button button;
    ImageView imageView;
    static final int CAM_REQUEST=1;

    public MessageFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        button = (Button) view.findViewById(R.id.button);
        imageView = (ImageView) view.findViewById(R.id.image_view);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(camera_intent, CAM_REQUEST);

            }
        });
        return view;
    }
    private File getFile()
    {
        File folder=new File("sdcard/Camera");
        if(!folder.exists())
        {
            folder.mkdir();
        }
        File image_file=new File(folder,"cam_image.jpg");
        return image_file;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String path="sdcard/Camera/cam_image.jpg";
        imageView.setImageDrawable(Drawable.createFromPath(path));
    }



    }



