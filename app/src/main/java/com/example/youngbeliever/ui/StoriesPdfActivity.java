package com.example.youngbeliever.ui;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youngbeliever.R;
import com.example.youngbeliever.utils.SpaceManager;
import com.github.barteksc.pdfviewer.PDFView;

public class StoriesPdfActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stories_pdf_activity);

        PDFView storiesPdfView = findViewById(R.id.stories_pdf_view);
        FrameLayout scroll = findViewById(R.id.stories_scroll);

        String pdfPath = getIntent().getStringExtra("story_path");

        storiesPdfView.fromAsset(pdfPath)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .spacing(8)
                .load();

        SpaceManager spaceManager = new SpaceManager();
        spaceManager.setBottomPadding(scroll);
    }
}