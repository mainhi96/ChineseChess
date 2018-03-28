package com.example.sony.chinesechess;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by SONY on 3/28/2018.
 */



public class ChessBoard {


    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paint;
    private int[][] board;
    private int player;
    private Context context;
    private int bitmapWidth;
    private int bitmapHeight;
    private int colQty;
    private int rowQty;
    private List<Line> listLine;


    private Bitmap blackGeneral;
    private Bitmap blackHorse;
    private Bitmap blackChariot;
    private Bitmap blackAdvisor;
    private Bitmap blackElephant;
    private Bitmap blackCannon;
    private Bitmap blackSoldier;

    private Bitmap redGeneral;
    private Bitmap redHorse;
    private Bitmap redChariot;
    private Bitmap redAdvisor;
    private Bitmap redElephant;
    private Bitmap redCannon;
    private Bitmap redSoldier;



    public ChessBoard(Context context, int bitmapWidth, int bitmapHeight, int colQty, int rowQty) {
        this.context = context;
        this.bitmapWidth = bitmapWidth;
        this.bitmapHeight = bitmapHeight;
        this.colQty = colQty;
        this.rowQty = rowQty;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getBitmapWidth() {
        return bitmapWidth;
    }

    public void setBitmapWidth(int bitmapWidth) {
        this.bitmapWidth = bitmapWidth;
    }

    public int getBitmapHeight() {
        return bitmapHeight;
    }

    public void setBitmapHeight(int bitmapHeight) {
        this.bitmapHeight = bitmapHeight;
    }

    public int getColQty() {
        return colQty;
    }

    public void setColQty(int colQty) {
        this.colQty = colQty;
    }

    public int getRowQty() {
        return rowQty;
    }

    public void setRowQty(int rowQty) {
        this.rowQty = rowQty;
    }

    public void init(){
        bitmap= Bitmap.createBitmap(bitmapWidth,bitmapHeight, Bitmap.Config.ARGB_8888);
        canvas=new Canvas(bitmap);
        paint=new Paint();
        int storkeWidth=1;
        paint.setStrokeWidth(storkeWidth);
        board=new int[rowQty][colQty];
        player=0;
        listLine=new ArrayList<>();

        int cellWidth=bitmapWidth/colQty;
        int cellHeight=bitmapHeight/rowQty;

        for(int i=1;i<rowQty-1;i++){
            listLine.add(new Line(cellWidth,i*cellHeight,bitmapWidth-cellWidth,i*cellHeight));
        }

        listLine.add(new Line(cellWidth,10*cellHeight,9*cellWidth,10*cellHeight) );

        for (int j=1;j<colQty-1;j++){
            listLine.add(new Line(j*cellWidth,cellHeight,j*cellWidth,cellHeight*5));
            listLine.add(new Line(j*cellWidth,cellHeight*6,j*cellWidth,bitmapHeight-cellHeight));
        }

        listLine.add(new Line(cellWidth*9,cellHeight,cellWidth*9,10*cellHeight));
        listLine.add(new Line(cellWidth,cellHeight*5,cellWidth,cellHeight*6));
        listLine.add(new Line(cellWidth*4,cellHeight,cellWidth*6,cellHeight*3));
        listLine.add(new Line(cellWidth*6,cellHeight,cellWidth*4,cellHeight*3));
        listLine.add(new Line(cellWidth*4,cellHeight*10,cellWidth*6,cellHeight*8));
        listLine.add(new Line(cellWidth*6,cellHeight*10,cellWidth*4,cellHeight*8));


    }

    public Bitmap drawBoard(){
        Line line;
        int cellWidth=bitmapWidth/colQty;
        int cellHeight=bitmapHeight/rowQty;
        int halfWidth=cellWidth/2;
        int halfHeight=cellHeight/2;

        blackChariot =BitmapFactory.decodeResource(context.getResources(),R.drawable.xeden);
        for(int i=1;i<colQty;i=i+8){
            canvas.drawBitmap(blackChariot,new Rect(0,0, blackChariot.getWidth(), blackChariot.getHeight()),new Rect(i*cellWidth-halfWidth,halfHeight,i*cellWidth+halfWidth,cellHeight+halfHeight),paint);
        }

        blackHorse =BitmapFactory.decodeResource(context.getResources(),R.drawable.nguaden);
        for(int i=2;i<colQty;i=i+6){
            canvas.drawBitmap(blackHorse,new Rect(0,0, blackHorse.getWidth(), blackHorse.getHeight()),new Rect(i*cellWidth-halfWidth,cellHeight-halfHeight,i*cellWidth+halfWidth,cellHeight+halfHeight),paint);
        }


        blackAdvisor=BitmapFactory.decodeResource(context.getResources(),R.drawable.siden);
        canvas.drawBitmap(blackAdvisor,new Rect(0,0,blackAdvisor.getWidth(),blackAdvisor.getHeight()),new Rect(4*cellWidth-halfWidth,halfHeight,4*cellWidth+halfWidth,halfHeight+cellHeight),paint);
        canvas.drawBitmap(blackAdvisor,new Rect(0,0,blackAdvisor.getWidth(),blackAdvisor.getHeight()),new Rect(6*cellWidth-halfWidth,halfHeight,6*cellWidth+halfWidth,cellHeight+halfHeight),paint);

        blackElephant=BitmapFactory.decodeResource(context.getResources(),R.drawable.tuongjden);
        canvas.drawBitmap(blackElephant,new Rect(0,0,blackAdvisor.getWidth(),blackAdvisor.getHeight()),new Rect(3*cellWidth-halfWidth,halfHeight,3*cellWidth+halfWidth,halfHeight+cellHeight),paint);
        canvas.drawBitmap(blackElephant,new Rect(0,0,blackAdvisor.getWidth(),blackAdvisor.getHeight()),new Rect(7*cellWidth-halfWidth,halfHeight,7*cellWidth+halfWidth,halfHeight+cellHeight),paint);

        blackGeneral =BitmapFactory.decodeResource(context.getResources(),R.drawable.tuongden);
        canvas.drawBitmap(blackGeneral,new Rect(0,0, blackGeneral.getWidth(), blackGeneral.getHeight()),new Rect(5*cellWidth-halfWidth,halfHeight,5*cellWidth+halfWidth,halfHeight+cellHeight),paint);

        blackSoldier=BitmapFactory.decodeResource(context.getResources(),R.drawable.chotden);
        for(int i=1;i<colQty;i=i+2) {
            canvas.drawBitmap(blackSoldier,new Rect(0,0,blackSoldier.getWidth(),blackSoldier.getHeight()),new Rect(i*cellWidth-halfWidth,4*cellHeight-halfHeight,i*cellWidth+halfWidth,4*cellHeight+halfHeight),paint);
        }

        blackCannon=BitmapFactory.decodeResource(context.getResources(),R.drawable.phaoden);
        for(int j=2;j<colQty;j=j+6){
            canvas.drawBitmap(blackCannon,new Rect(0,0,blackCannon.getWidth(),blackCannon.getHeight()),new Rect(j*cellWidth-halfWidth,3*cellHeight-halfHeight,j*cellWidth+halfWidth,3*cellHeight+halfHeight),paint);
        }

        for(int i=0;i<listLine.size();i++){
            line=listLine.get(i);
            canvas.drawLine(line.getStartX(),line.getStartY(),line.getStopX(),line.getStopY(),paint);
        }

        redChariot =BitmapFactory.decodeResource(context.getResources(),R.drawable.xedo);
        for(int i=1;i<colQty;i=i+8){
            canvas.drawBitmap(redChariot,new Rect(0,0, redChariot.getWidth(), redChariot.getHeight()),new Rect(i*cellWidth-halfWidth,10*cellHeight-halfHeight,i*cellWidth+halfWidth,10*cellHeight+halfHeight),paint);
        }

        redHorse =BitmapFactory.decodeResource(context.getResources(),R.drawable.nguado);
        for(int i=2;i<colQty;i=i+6){
            canvas.drawBitmap(redHorse,new Rect(0,0, redHorse.getWidth(), redHorse.getHeight()),new Rect(i*cellWidth-halfWidth,10*cellHeight-halfHeight,i*cellWidth+halfWidth,10*cellHeight+halfHeight),paint);
        }

        redElephant =BitmapFactory.decodeResource(context.getResources(),R.drawable.tuongjdo);
        for(int i=3;i<colQty;i=i+4){
            canvas.drawBitmap(redElephant,new Rect(0,0, redElephant.getWidth(), redElephant.getHeight()),new Rect(i*cellWidth-halfWidth,10*cellHeight-halfHeight,i*cellWidth+halfWidth,10*cellHeight+halfHeight),paint);
        }

        redGeneral =BitmapFactory.decodeResource(context.getResources(),R.drawable.tuongdo);
        canvas.drawBitmap(redGeneral,new Rect(0,0, redGeneral.getWidth(), redGeneral.getHeight()),new Rect(5*cellWidth-halfWidth,10*cellHeight-halfHeight,5*cellWidth+halfWidth,10*cellHeight+halfHeight),paint);

        redAdvisor =BitmapFactory.decodeResource(context.getResources(),R.drawable.sido);
        canvas.drawBitmap(redAdvisor,new Rect(0,0, redAdvisor.getWidth(), redAdvisor.getHeight()),new Rect(4*cellWidth-halfWidth,10*cellHeight-halfHeight,4*cellWidth+halfWidth,10*cellHeight+halfHeight),paint);
        canvas.drawBitmap(redAdvisor,new Rect(0,0, redAdvisor.getWidth(), redAdvisor.getHeight()),new Rect(6*cellWidth-halfWidth,10*cellHeight-halfHeight,6*cellWidth+halfWidth,10*cellHeight+halfHeight),paint);

        redCannon =BitmapFactory.decodeResource(context.getResources(),R.drawable.phaodo);
        for(int j=2;j<colQty;j=j+6){
            canvas.drawBitmap(redCannon,new Rect(0,0, redCannon.getWidth(), redCannon.getHeight()),new Rect(j*cellWidth-halfWidth,8*cellHeight-halfHeight,j*cellWidth+halfWidth,8*cellHeight+halfHeight),paint);
        }

        redSoldier =BitmapFactory.decodeResource(context.getResources(),R.drawable.chotdo);
        for(int i=1;i<colQty;i=i+2) {
            canvas.drawBitmap(redSoldier,new Rect(0,0, redSoldier.getWidth(), redSoldier.getHeight()),new Rect(i*cellWidth-halfWidth,7*cellHeight-halfHeight,i*cellWidth+halfWidth,7*cellHeight+halfHeight),paint);
        }

        return bitmap;
    }


}
