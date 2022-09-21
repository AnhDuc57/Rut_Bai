package com.example.rut_bai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button rutbai;
    ImageView labai1;
    ImageView labai2;
    ImageView labai3;
    TextView thongbao;

    int sonut=0;//de xet xem duoc may nut
    int darut=0;//chi cho rut 3 la
    boolean batay=true;//de xet truong hop 3 tay
    String chuoithongbao="";
    ArrayList<String> cacladarut=new ArrayList<String>();//chua ten la da rut;
    //de de lam nen cho mang[][0] khong co y nghia (chi dung mang[][1]tro di
    int manghinhbai[][]={
            {R.drawable.m1,
                    R.drawable.t1,R.drawable.t2,R.drawable.t3,R.drawable.t4,R.drawable.t5,
                    R.drawable.t6,R.drawable.t7,R.drawable.t8,R.drawable.t9,R.drawable.t10,
                    R.drawable.j3,R.drawable.q2,R.drawable.k2},
            {R.drawable.m1,
                    R.drawable.r01,R.drawable.r02,R.drawable.r03,R.drawable.r04,R.drawable.r05,
                    R.drawable.r06,R.drawable.r07,R.drawable.r07,R.drawable.r09,R.drawable.r10,
                    R.drawable.j3,R.drawable.q3,R.drawable.k3},
            {R.drawable.m1,
                    R.drawable.c01,R.drawable.c02,R.drawable.c03,R.drawable.c04,R.drawable.c05,
                    R.drawable.c06,R.drawable.c07,R.drawable.c08,R.drawable.c09,R.drawable.c10,
                    R.drawable.j4,R.drawable.q4,R.drawable.k4},
            {R.drawable.m1,
                    R.drawable.b01,R.drawable.b02,R.drawable.b03,R.drawable.b04,R.drawable.b05,
                    R.drawable.b06,R.drawable.b07,R.drawable.b08,R.drawable.b09,R.drawable.b10,
                    R.drawable.j1,R.drawable.q1,R.drawable.k1}
    };
    String mangtenbai[][]={
            {"rong",
                    "ach chuon","hai chuon","ba chuon","bon chuon","nam chuon",
                    "sau chuon","bay chuon","tam chuon","chin chuon","muoi chuon",
                    "boi chuon","dam chuon","gia chuon"},
            {"rong",
                    "ach ro","hai ro","ba ro","bon ro","nam ro",
                    "sau ro","bay ro","tam ro","chin ro","muoi ro",
                    "boi ro","dam ro","gia ro"},
            {"rong",
                    "ach co","hai co","ba co","bon co","nam co",
                    "sau co","bay co","tam co","chin co","muoi co",
                    "boi co","dam co","gia co"},
            {"rong",
                    "ach bich","hai bich","ba bich","bon bich","nam bich",
                    "sau bich","bay bich","tam bich","chin bich","muoi bich",
                    "boi bich","dam bich","gia bich"}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rutbai=(Button)findViewById(R.id.buttonRut);
        labai1=(ImageView)findViewById(R.id.imageView1);
        labai2=(ImageView)findViewById(R.id.imageView2);
        labai3=(ImageView)findViewById(R.id.imageView3);
        thongbao=(TextView)findViewById(R.id.textViewThongBao);
        rutbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(darut==0)//lan dau hoac rut lai
                {darut=0;
                    sonut=0;
                    batay=true;
                    chuoithongbao="";
                    labai1.setImageResource(R.drawable.m1);
                    labai2.setImageResource(R.drawable.m1);
                    labai3.setImageResource(R.drawable.m1);
                    cacladarut.clear();
                }
                darut++; //dem so lan rut
//tao ngau nhien
                Random rd=new Random();
                int x,y;
//tao ngau nhien bao vao ArrayList de xet xem co bi trung khong
                while(true)
                {
                    x=rd.nextInt(4);//0->3 (b-a+1)+a;
                    y=rd.nextInt(13)+1;//1->13
                    if(cacladarut.contains(mangtenbai[x][y])==false)
                    {
                        cacladarut.add(mangtenbai[x][y]);
                        break;
                    }
                }
//chi can y<11 lap tuc khong con la batay nua
                if(y<11)
                    batay=false;
                if(darut==1)
                {
                    sonut+=(y<10)?y:0;
                    labai1.setImageResource(manghinhbai[x][y]);
                }
                else if(darut==2)
                {
                    sonut+=(y<10)?y:0;
                    labai2.setImageResource(manghinhbai[x][y]);
                }
                else if(darut==3)
                {
                    sonut+=(y<10)?y:0;
                    int kq=sonut%10;
                    darut=0;
                    labai3.setImageResource(manghinhbai[x][y]);
                    chuoithongbao+=" so nut la "+ kq;
//rutbai.setEnabled(false);
                }
                thongbao.setText("Cac la da rut "+cacladarut.toString()
                        +"\n"+chuoithongbao+ "\n" +"ba tay"+" "+batay);
            }
        });
    }
}
