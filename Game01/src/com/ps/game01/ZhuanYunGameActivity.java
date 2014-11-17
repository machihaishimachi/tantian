package com.ps.game01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TimerTask;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class ZhuanYunGameActivity extends Activity {
	
	public static float screenWidth = 480;// 屏幕的宽度
	public static float screenHeight = 800;// 屏幕的高度度
	ArrayList<Integer>cards=new ArrayList<Integer>();

	private String TAG="zhuanyun";
	
	 ArrayList<ImageView> imagelist=new ArrayList<ImageView>();
		
	 
	private int image[] ={
R.drawable.z01,R.drawable.z02,R.drawable.z03,R.drawable.z04,R.drawable.z05,R.drawable.z06,R.drawable.z07,R.drawable.z08,R.drawable.z09,R.drawable.z10,
R.drawable.z11,R.drawable.z12,R.drawable.z13,R.drawable.z14,R.drawable.z15,R.drawable.z16,R.drawable.z17,R.drawable.z18,R.drawable.z19,R.drawable.z20,
R.drawable.z21,R.drawable.z22,R.drawable.z23,R.drawable.z24,R.drawable.z25,R.drawable.z26,R.drawable.z27,R.drawable.z28,R.drawable.z29,R.drawable.z30,
R.drawable.z31,R.drawable.z32,R.drawable.z33,R.drawable.z34,R.drawable.z35,R.drawable.z36,R.drawable.z37,R.drawable.z38,R.drawable.z39,R.drawable.z40,
R.drawable.z41,R.drawable.z42,R.drawable.z43,R.drawable.z44,R.drawable.z45,R.drawable.z46,R.drawable.z47,R.drawable.z48,R.drawable.z49,R.drawable.z50,

R.drawable.z51,R.drawable.z52,R.drawable.z53,R.drawable.z54,R.drawable.z55,R.drawable.z56,R.drawable.z57,R.drawable.z58,R.drawable.z59,R.drawable.z60,
R.drawable.z61,R.drawable.z62,R.drawable.z63,R.drawable.z64,R.drawable.z65,R.drawable.z66,R.drawable.z67,R.drawable.z68,R.drawable.z69,R.drawable.z70,
R.drawable.z71,R.drawable.z72,R.drawable.z73,R.drawable.z74,R.drawable.z75,R.drawable.z76,R.drawable.z77,R.drawable.z78,R.drawable.z79,R.drawable.z80,
R.drawable.z81,R.drawable.z82,R.drawable.z83,R.drawable.z84,R.drawable.z85,R.drawable.z86,R.drawable.z87,R.drawable.z88,R.drawable.z89,R.drawable.z90,
R.drawable.z91,R.drawable.z92,R.drawable.z93,R.drawable.z94,R.drawable.z95,R.drawable.z96,R.drawable.z97,R.drawable.z98,R.drawable.z99,R.drawable.z100,

R.drawable.z101,R.drawable.z102,R.drawable.z103,R.drawable.z104,R.drawable.z05,R.drawable.z106,R.drawable.z107,R.drawable.z108,R.drawable.z109,R.drawable.z110,
R.drawable.z111,R.drawable.z112,R.drawable.z113,R.drawable.z114,R.drawable.z115,R.drawable.z116,R.drawable.z117,R.drawable.z118,R.drawable.z119,R.drawable.z120,
R.drawable.z121,R.drawable.z122,R.drawable.z123,R.drawable.z124,R.drawable.z125,R.drawable.z126,R.drawable.z127,R.drawable.z128,R.drawable.z129,R.drawable.z130,
R.drawable.z131,R.drawable.z132,R.drawable.z133,R.drawable.z134,R.drawable.z135,R.drawable.z136,R.drawable.z137,R.drawable.z138,R.drawable.z139,R.drawable.z140,
R.drawable.z141,R.drawable.z142,R.drawable.z143,R.drawable.z144,R.drawable.z145,R.drawable.z146,R.drawable.z147,R.drawable.z148,R.drawable.z149,R.drawable.z150,

R.drawable.z151,R.drawable.z152,R.drawable.z153,R.drawable.z154,R.drawable.z155,R.drawable.z156,R.drawable.z157,R.drawable.z158,R.drawable.z159,R.drawable.z160,
R.drawable.z161,R.drawable.z162,R.drawable.z163,R.drawable.z164,R.drawable.z165,R.drawable.z166,R.drawable.z167,R.drawable.z168,R.drawable.z169,R.drawable.z170,
R.drawable.z171,R.drawable.z172,R.drawable.z173,R.drawable.z174,R.drawable.z175,R.drawable.z176,R.drawable.z177,R.drawable.z178,R.drawable.z179,R.drawable.z180,
R.drawable.z181,R.drawable.z182,R.drawable.z183,R.drawable.z184,R.drawable.z185,R.drawable.z186,R.drawable.z187,R.drawable.z188,R.drawable.z189,R.drawable.z190,
R.drawable.z191,R.drawable.z192,R.drawable.z193,R.drawable.z194,R.drawable.z195,R.drawable.z196,R.drawable.z197,R.drawable.z198
			
			
	};

	 private boolean run = false;  
	 private int count=0;
	 private int  time=100;
	 private boolean reset=false;
	    private Handler handler = new Handler();  
	  
	    private Runnable task = new Runnable() {  
	  
	        public void run() {  
	         
	        	
	        	if (run) {  
	                time--;
	                count++;
	                int cardnum=cards.get(count-1);
	                if(count<=54)
	                {
	                	handler.postDelayed(this, 500);  
	                	imagelist.get((count-1)%9).setImageResource(image[cardnum]);
	                }
	                else if(count>54&& count <=198)
	                {
	                	
	                	
	                	handler.postDelayed(this, 4000);
	                	cardchoose.setImageResource(image[cardnum]);
	                	
	                	
	                }
	                
	            } 
	        	
	        	
	        	if(count>100)
	        	{
	        		run=false;
	        		
	        		//判断最后剩余多少张牌
	        		int leftcardnum=cardnum1+cardnum2+cardnum3+cardnum4+cardnum5+cardnum6+cardnum7+cardnum8+cardnum9;
	        		showDialog("剩余排数：\n"+leftcardnum);
	        		int cardg1=0;
	        		int cardg2=0;
	        		int cardg3=0;
	        		int cardg4=0;
	        		int cardg5=0;
	        		int cardg6=0;
	        		int cardg7=0;
	        		int cardg8=0;
	        		int cardg9=0;
	        		for (int i = 0; i < cardnum1; i++) {
	        			int cardnum=Integer.parseInt(cardarray1[i]);
	        			cardg1=cardg1+cardnum%10;
					}
	        		for (int i = 0; i < cardnum2; i++) {
	        			int cardnum=Integer.parseInt(cardarray2[i]);
	        			cardg2=cardg2+cardnum%10;
					}
	        		for (int i = 0; i < cardnum3; i++) {
	        			int cardnum=Integer.parseInt(cardarray3[i]);
	        			cardg3=cardg3+cardnum%10;
					}
	        		for (int i = 0; i < cardnum4; i++) {
	        			int cardnum=Integer.parseInt(cardarray4[i]);
	        			cardg4=cardg4+cardnum%10;
					}
	        		
	        		for (int i = 0; i < cardnum5; i++) {
	        			int cardnum=Integer.parseInt(cardarray5[i]);
	        			cardg5=cardg5+cardnum%10;
					}
	        		for (int i = 0; i < cardnum6; i++) {
	        			int cardnum=Integer.parseInt(cardarray6[i]);
	        			cardg6=cardg6+cardnum%10;
					}
	        		
	        		for (int i = 0; i < cardnum7; i++) {
	        			int cardnum=Integer.parseInt(cardarray7[i]);
	        			cardg7=cardg7+cardnum%10;
					}
	        		for (int i = 0; i < cardnum8; i++) {
	        			int cardnum=Integer.parseInt(cardarray8[i]);
	        			cardg8=cardg8+cardnum%10;
					}
	        		for (int i = 0; i < cardnum9; i++) {
	        			int cardnum=Integer.parseInt(cardarray9[i]);
	        			cardg9=cardg9+cardnum%10;
					}
	        		
	        		int cardgnum=cardg1+cardg2+cardg3+cardg4+cardg5+cardg6+cardg7+cardg8+cardg9;
	        		showDialog("时间到\n"+cardgnum);
	        		
	        		String level="高手";
	        		showDialog("时间到\n"+level);
	        		time=100;
	        		
	        	}
	            tvCounter.setText("剩余时间: " + time);
	        	
	        }  
	    };  
	  
	
	private ImageView card1;
	private ImageView card2;
	private ImageView card3;
	private ImageView card4;
	private ImageView card5;
	private ImageView card6;
	private ImageView card7;
	private ImageView card8;
	private ImageView card9;
	
	 //String[] cardarray;
	private String[] cardarray1;
	private String[] cardarray2;
	private String[] cardarray3;
	private String[] cardarray4;
	private String[] cardarray5;
	private String[] cardarray6;
	private String[] cardarray7;
	private String[] cardarray8;
	private String[] cardarray9;
	private String[] cardarray10;
	
	private  int cardnum1=5;
	private int cardnum2=5;
	private int cardnum3=5;
	private int cardnum4=5;
	private int cardnum5=5;
	private int cardnum6=5;
	private int cardnum7=5;
	private int cardnum8=5;
	private int cardnum9=5;
	
	private ImageView cardchoose;
	private ImageView cardback;
	
	private Button startzhuanyun;
	private Button stopzhuanyun;
	
	private TextView tvCounter;
	
	 
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*** 设置去标题 ***/
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);

		/*** 设置全屏 ***/
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

		/*** 设置横屏 ***/
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		/*** 获取屏幕的宽高度 ***/
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		screenWidth = dm.widthPixels;
		screenHeight = dm.heightPixels;
		
        setContentView(R.layout.zhuanyun);
        
        
        
        card1=(ImageView)findViewById(R.id.card1);
		card2=(ImageView)findViewById(R.id.card2);
		card3=(ImageView)findViewById(R.id.card3);
		card4=(ImageView)findViewById(R.id.card4);
		card5=(ImageView)findViewById(R.id.card5);
		card6=(ImageView)findViewById(R.id.card6);
		card7=(ImageView)findViewById(R.id.card7);
		card8=(ImageView)findViewById(R.id.card8);
		card9=(ImageView)findViewById(R.id.card9);
		
		cardchoose=(ImageView)findViewById(R.id.cardchoose);
		cardback=(ImageView)findViewById(R.id.cardback);
		
		startzhuanyun=(Button)findViewById(R.id.startzhuanyun);
		stopzhuanyun=(Button)findViewById(R.id.startzhuanyun);
		
		tvCounter=(TextView)findViewById(R.id.tvCounter);
		RelativeLayout.LayoutParams tvCounterlp=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
		tvCounterlp.setMargins((int)(screenWidth*0.339), (int)(screenHeight*0.712),(int)(screenWidth*0.339), (int)(screenHeight*0.217));
    	tvCounter.setLayoutParams(tvCounterlp);
		
		
	/*	378  17     124    128    250     254     362
	     0.045  0.328  0.339  0.661   0.672   0.958
		630  16      148    152   302     306     436
	    0.0254   0.235  0.241 0.479   0.486   0.692
	    0.783    0.952
	    */
		
		
		card1=(ImageView)findViewById(R.id.card1);
    	RelativeLayout.LayoutParams cardlp1=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
    	cardlp1.setMargins((int)(screenWidth*0.045), (int)(screenHeight*0.0254),(int)(screenWidth*0.672), (int)(screenHeight*0.765));
    	card1.setLayoutParams(cardlp1);
    	
    	card2=(ImageView)findViewById(R.id.card2);
    	RelativeLayout.LayoutParams cardlp2=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
    	cardlp2.setMargins((int)(screenWidth*0.339), (int)(screenHeight*0.0254),(int)(screenWidth*0.339), (int)(screenHeight*0.765));
    	card2.setLayoutParams(cardlp2);
    	
    	card3=(ImageView)findViewById(R.id.card3);
    	RelativeLayout.LayoutParams cardlp3=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
    	cardlp3.setMargins((int)(screenWidth*0.672), (int)(screenHeight*0.0254),(int)(screenWidth*0.042), (int)(screenHeight*0.765));
    	card3.setLayoutParams(cardlp3);
    	
    	card4=(ImageView)findViewById(R.id.card4);
    	RelativeLayout.LayoutParams cardlp4=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
    	cardlp4.setMargins((int)(screenWidth*0.045), (int)(screenHeight*0.241),(int)(screenWidth*0.672), (int)(screenHeight*0.521));
    	card4.setLayoutParams(cardlp4);
    	
    	card5=(ImageView)findViewById(R.id.card5);
    	RelativeLayout.LayoutParams cardlp5=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
    	cardlp5.setMargins((int)(screenWidth*0.339), (int)(screenHeight*0.241),(int)(screenWidth*0.339), (int)(screenHeight*0.521));
    	card5.setLayoutParams(cardlp5);
    	
    	card6=(ImageView)findViewById(R.id.card6);
    	RelativeLayout.LayoutParams cardlp6=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
    	cardlp6.setMargins((int)(screenWidth*0.672), (int)(screenHeight*0.241),(int)(screenWidth*0.042), (int)(screenHeight*0.521));
    	card6.setLayoutParams(cardlp6);
    	
    	card7=(ImageView)findViewById(R.id.card7);
    	RelativeLayout.LayoutParams cardlp7=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
    	cardlp7.setMargins((int)(screenWidth*0.045), (int)(screenHeight*0.486),(int)(screenWidth*0.672), (int)(screenHeight*0.308));
    	card7.setLayoutParams(cardlp7);
    	
    	card8=(ImageView)findViewById(R.id.card8);
    	RelativeLayout.LayoutParams cardlp8=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
    	cardlp8.setMargins((int)(screenWidth*0.339), (int)(screenHeight*0.486),(int)(screenWidth*0.339), (int)(screenHeight*0.308));
    	card8.setLayoutParams(cardlp8);
    	
    	card9=(ImageView)findViewById(R.id.card9);
    	RelativeLayout.LayoutParams cardlp9=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
    	cardlp9.setMargins((int)(screenWidth*0.672), (int)(screenHeight*0.486),(int)(screenWidth*0.042), (int)(screenHeight*0.308));
    	card9.setLayoutParams(cardlp9);
    	
    	cardchoose=(ImageView)findViewById(R.id.cardchoose);
    	RelativeLayout.LayoutParams cardchooselp=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
    	cardchooselp.setMargins((int)(screenWidth*0.045), (int)(screenHeight*0.783),(int)(screenWidth*0.672), (int)(screenHeight*0.952));
    	cardchoose.setLayoutParams(cardchooselp);
    	
    	cardback=(ImageView)findViewById(R.id.cardback);
    	RelativeLayout.LayoutParams cardbacklp=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
    	cardbacklp.setMargins((int)(screenWidth*0.672), (int)(screenHeight*0.783),(int)(screenWidth*0.042), (int)(screenHeight*0.952));
    	cardback.setLayoutParams(cardbacklp);
    	cardback.setImageResource(R.drawable.card_back);
    	
    	startzhuanyun=(Button)findViewById(R.id.startzhuanyun);
    	RelativeLayout.LayoutParams cardstartlp=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
    	cardstartlp.setMargins((int)(screenWidth*0.389), (int)(screenHeight*0.803),(int)(screenWidth*0.389), (int)(screenHeight*0.147));
    	startzhuanyun.setLayoutParams(cardstartlp);
    	
    	
    	stopzhuanyun=(Button)findViewById(R.id.stopzhuanyun);
    	RelativeLayout.LayoutParams cardstoplp=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
    	cardstoplp.setMargins((int)(screenWidth*0.389), (int)(screenHeight*0.873),(int)(screenWidth*0.389), (int)(screenHeight*0.077));
    	stopzhuanyun.setLayoutParams(cardstoplp);
    	
    	
    	imagelist.add(card1);
       	imagelist.add(card2);
       	imagelist.add(card3);
       	imagelist.add(card4);
       	imagelist.add(card5);
       	imagelist.add(card6);
       	imagelist.add(card7);
       	imagelist.add(card8);
       	imagelist.add(card9);
       	
       	
    	startzhuanyun.setOnClickListener(new OnClickListener() {  
    		  
             public void onClick(View v) {  
            	  for(int i=0;i<198;i++)
               	{
                  	 cards.add(i);
               	}
                   Collections.shuffle(cards);
                  
                 /*  for (int j = 0; j < 9; j++) {
                	   cardarray[j]="c";
				}*/
                   
                   String[] cardarray=new String[]{"c","c","c","c","c","c","c","c","c"};
                   
                   for (int j = 0; j < 54; j++) {
					int k=j%9;
					cardarray[k]=cardarray[k]+cards.get(j).toString()+",";
					Log.i(TAG, "这里有问题");
				}
                   for(int i=0;i<9;i++)
           		{
                	   cardarray[i]=cardarray[i].substring(1,cardarray[i].length()-1);
           		}
                   
               	
                   cardarray1=cardarray[0].split("\\,");
                   cardarray2=cardarray[1].split("\\,");
                
                   cardarray3=cardarray[2].split("\\,");
                  
                   cardarray4=cardarray[3].split("\\,");
             
                   cardarray5=cardarray[4].split("\\,");
               
                   cardarray6=cardarray[5].split("\\,");
                 
                   cardarray7=cardarray[6].split("\\,");
   
                   cardarray8=cardarray[7].split("\\,");
        
                   cardarray9=cardarray[8].split("\\,");
             
                   
            	 run = true;  
                 updateButton();  
                 handler.postDelayed(task, 1000);  
                 
               
             }  
         });  
    	
    	 card1.setOnClickListener(new OnClickListener() {  
        	   
             public void onClick(View v) {  
                 // TODO Auto-generated method stub  
            	 int cardnum11=Integer.parseInt(cardarray1[cardnum1]);
            	 //cardarray1
            	 int cardnum12=cards.get(count-1);
                if((cardnum11%10)==cardnum12%10)
                {
                	cardarray1[cardnum1]=null;
                	cardnum1--;
                	int cardnum111=Integer.parseInt(cardarray1[cardnum1]);
                	imagelist.get(0).setImageResource(image[cardnum111]);
                	handler.postDelayed(task,0);
                	
                }
            	 
             }  
         });  
         card2.setOnClickListener(new OnClickListener() {  
      	   
             public void onClick(View v) {  
            	// TODO Auto-generated method stub  
            	 int cardnum11=Integer.parseInt(cardarray2[cardnum2]);
            	 //cardarray1
            	 int cardnum12=cards.get(count-1);
                if((cardnum11%10)==cardnum12%10)
                {
                	cardarray2[cardnum2]=null;
                	cardnum2--;
                	int cardnum111=Integer.parseInt(cardarray2[cardnum2]);
                	imagelist.get(1).setImageResource(image[cardnum111]);
                	handler.postDelayed(task,0);
                }
             }  
         });
         card3.setOnClickListener(new OnClickListener() {  
      	   
             public void onClick(View v) {  
            	// TODO Auto-generated method stub  
            	 int cardnum11=Integer.parseInt(cardarray3[cardnum3]);
            	 //cardarray1
            	 int cardnum12=cards.get(count-1);
                if((cardnum11%10)==cardnum12%10)
                {
                	cardarray3[cardnum3]=null;
                	cardnum3--;
                	 int cardnum111=Integer.parseInt(cardarray3[cardnum3]);
                	imagelist.get(2).setImageResource(image[cardnum111]);
                	handler.postDelayed(task,0);
                }
             }  
         });
         card4.setOnClickListener(new OnClickListener() {  
      	   
             public void onClick(View v) {  
            	// TODO Auto-generated method stub  
            	 int cardnum11=Integer.parseInt(cardarray4[cardnum4]);
            	 //cardarray1
            	 int cardnum12=cards.get(count-1);
                if((cardnum11%10)==cardnum12%10)
                {
                	cardarray4[cardnum4]=null;
                	cardnum4--;
                	 int cardnum111=Integer.parseInt(cardarray4[cardnum4]);
                	imagelist.get(3).setImageResource(image[cardnum111]);
                	handler.postDelayed(task,0);
                }
             }  
         });
         card5.setOnClickListener(new OnClickListener() {  
      	   
             public void onClick(View v) {  
            	// TODO Auto-generated method stub  
            	 int cardnum11=Integer.parseInt(cardarray5[cardnum5]);
            	 //cardarray1
            	 int cardnum12=cards.get(count-1);
                if((cardnum11%10)==cardnum12%10)
                {
                	cardarray5[cardnum5]=null;
                	cardnum5--;
                	 int cardnum111=Integer.parseInt(cardarray5[cardnum5]);
                	imagelist.get(4).setImageResource(image[cardnum111]);
                	handler.postDelayed(task,0);
                } 
             }  
         });
         card6.setOnClickListener(new OnClickListener() {  
      	   
             public void onClick(View v) {  
            	// TODO Auto-generated method stub  
            	 int cardnum11=Integer.parseInt(cardarray6[cardnum6]);
            	 //cardarray1
            	 int cardnum12=cards.get(count-1);
                if((cardnum11%10)==cardnum12%10)
                {
                	cardarray6[cardnum6]=null;
                	cardnum6--;
                	int cardnum111=Integer.parseInt(cardarray6[cardnum6]);
                	imagelist.get(5).setImageResource(image[cardnum111]);
                	handler.postDelayed(task,0);
                }
             }  
         });
         card7.setOnClickListener(new OnClickListener() {  
      	   
             public void onClick(View v) {  
            	// TODO Auto-generated method stub  
            	 int cardnum11=Integer.parseInt(cardarray7[cardnum7]);
            	 //cardarray1
            	 int cardnum12=cards.get(count-1);
                if((cardnum11%10)==cardnum12%10)
                {
                	cardarray7[cardnum7]=null;
                	cardnum7--;
                	int cardnum111=Integer.parseInt(cardarray7[cardnum7]);
                	imagelist.get(6).setImageResource(image[cardnum111]);
                	handler.postDelayed(task,0);
                }  
             }  
         });
         card8.setOnClickListener(new OnClickListener() {  
      	   
             public void onClick(View v) {  
            	// TODO Auto-generated method stub  
            	 int cardnum11=Integer.parseInt(cardarray8[cardnum8]);
            	 //cardarray1
            	 int cardnum12=cards.get(count-1);
                if((cardnum11%10)==cardnum12%10)
                {
                	cardarray8[cardnum8]=null;
                	cardnum8--;
                	 int cardnum111=Integer.parseInt(cardarray8[cardnum8]);
                	imagelist.get(7).setImageResource(image[cardnum111]);
                	handler.postDelayed(task,0);
                } 
             }  
         });
         card9.setOnClickListener(new OnClickListener() {  
      	   
             public void onClick(View v) {  
            	// TODO Auto-generated method stub  
            	 int cardnum11=Integer.parseInt(cardarray9[cardnum9]);
            	 //cardarray1
            	 int cardnum12=cards.get(count-1);
                if((cardnum11%10)==cardnum12%10)
                {
                	cardarray9[cardnum9]=null;
                	cardnum9--;
                	 int cardnum111=Integer.parseInt(cardarray9[cardnum9]);
                	imagelist.get(8).setImageResource(image[cardnum111]);
                	handler.postDelayed(task,0);
                }
                 
             }  
         });
   
    	/*stopzhuanyun.setOnClickListener(new OnClickListener() {  
   
             public void onClick(View v) {  
                 // TODO Auto-generated method stub  
                 run = false;  
                 updateButton();  
                 handler.post(task);  
             }  
         }); */ 
   
         stopzhuanyun.setOnClickListener(new OnClickListener() {  
   
             public void onClick(View v) {  
                 // TODO Auto-generated method stub  
            	 
            	 count = 0;
                 reset=true;
                 run = false; 
                 time=100;
                 for (int j = 0; j < 9; j++) {
					imagelist.get(j).setImageResource(R.id.cardback);
				}
                 cardchoose.setImageResource(R.id.cardback);
                 updateButton();  
                 handler.post(task);  
             }  
         }); 
         
        
         
     }  
   
     private void updateButton() {  
    	 startzhuanyun.setEnabled(!run);  
         stopzhuanyun.setEnabled(run);  
     } 
 	private void showDialog(String msg) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(msg).setCancelable(false)
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

					}
				});
		AlertDialog alert = builder.create();
		alert.show();
	}
 	
 	
 	 private int index = 0 ;
 	/**
	 * 定时器
	 */
	private TimerTask timetask = new TimerTask() {
		
		@Override
		public void run() {
			Message message = new Message();
			message.what = 2 ; 
			//index = pictureGallery.getSelectedItemPosition();
			index ++ ;
			handler.sendMessage(message);
		}
	};
	
	/**
	 * Handler
	 */
	private Handler timehandler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case 2:
				//pictureGallery.setSelection(index);
				break;

			default:
				break;
			}
		}
		
	};
}

