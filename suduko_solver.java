import java.io.*;
class suduko_solver
{
    static int a[][]=new int[10][10];/*{{6,0,0,0,5,0,9,0,0,0},{0,0,1,4,0,9,2,0,7,0},{0,0,9,0,0,0,0,0,0,0},{0,0,0,7,0,0,5,0,0,0},
                      {7,6,0,8,0,0,0,0,0,0},{4,0,0,0,9,2,0,0,0,0},{2,0,4,5,0,0,1,0,0,0},{0,9,0,0,0,8,0,0,0,0},
                      {0,0,7,9,0,6,0,3,2,0},{0,0,0,0,0,0,0,0,0,0}};*/
    static boolean info[][][]=new boolean[9][9][9];
    
    public static void main(String args[])throws Exception
    {       
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<=8;i++)
        {
            for(int j=0;j<=8;j++)
        {
            
            a[i][j]=Integer.parseInt(br.readLine());
            if(a[i][j]!=0)upd(i,j,a[i][j]);prnt(i,j);
        }
        }
        
        prnt();
         while(a[9][9]!=81)
        {
            //System.out.print("calling block loop");
           blk();
            row();
            col();
        }        prnt();
    }
    static void prnt(int m,int n)
    {
        System.out.print( "\u000c"+"\n\n\n\n\n\n\n\n\n");
        for(int i=0;i<=m;i++)
        {        System.out.print("\t\t\t\t\t\t\t\t");
            for(int j=0;j<=8;j++)
        {
            System.out.print(a[i][j]+"  ");if(j==2||j==5)System.out.print(" ");
            if(i==m && j==n) break;
        }System.out.println();if(i==2||i==5) System.out.println();}
       
    }
    static void blk()
    {
        for(int i=0;i<=8;i++)
        {
            if(a[i][9]<9)
            {
                for(int j=0;j<=8;j++)
                {
                    if(a[9][j]<9)
                    blk(i/3*3,j/3*3);
                }
            }
        }
    }
    static void blk(int m,int n)
    {
        int m1=m+2,n1=n+2;
        for(int val=1;val<=9;val++)
        {
            //System.out.println(val+","+m+","+n);
            int cnt=0,r=0,c=0;
            for(int i=m;i<=m1;i++)
            {
            for(int j=n;j<=n1;j++)
            {
                
                //System.out.println((int)(i*3)+","+((i*3)+2)+"\n"+(int)(j*3)+","+((j*3)+2));              
                if(!info[i][j][(val-1)])
                {cnt=cnt+1;r=i;c=j;}//System.out.println(i+","+j+","+info[i][j][(val-1)]);}           
            //System.out.println(cnt);
            }    
            }
            if(cnt==1)
            {a[r][c]=val;upd(r,c,val);prnt();}
            
        }
    }
    static void row()
    {
        for(int i=0;i<=8;i++)
        {
            if(a[i][9]<9)
            row(i);
        }
    }
    
    static void row(int m)
    {
        for(int val=0;val<=8;val++)
        { int cnt=0,r=m,c=0;
        for(int j=0;j<=8;j++)
        {
            if(!info[m][j][val])
            {cnt++;c=j;}
        }
        if(cnt==1)
            {a[r][c]=(val+1);upd(r,c,(val+1));prnt();}
    }
}

    static void col()
    {
        for(int i=0;i<=8;i++)
        {
            if(a[9][i]<9)
            col(i);
        }
    }
    
    static void col(int n)
    {
        for(int val=0;val<=8;val++)
        { int cnt=0,r=0,c=n;
        for(int i=0;i<=8;i++)
        {
            if(!info[i][n][val])
            {cnt++;r=i;}
        }
        if(cnt==1)
            {a[r][c]=(val+1);upd(r,c,(val+1));prnt();}
    }
    }
    static void prnt()
    {
        System.out.print("\u000c\n\n\n\n\n\n\n\n\n\n");
        //for(int val=0;val<=8;val++)
        {//System.out.println("\t\t\t\t\t\t\t\t"+(val+1));
        for(int i=0;i<=8;i++)
        {        System.out.print("\t\t\t\t\t\t\t\t");
            for(int j=0;j<=8;j++)
        {
            System.out.print(a[i][j]+"  ");if(j==2||j==5)System.out.print(" ");
        }System.out.println();if(i==2||i==5) System.out.println();}System.out.println();
    }}
    static void upd(int m,int n,int val)
    {
     for(int i=0;i<=8;i++)
        { info[m][n][i]=true;}
        for(int i=0;i<=8;i++)
        { info[i][n][(val-1)]=true;}
        for(int i=0;i<=8;i++)
        { info[m][i][(val-1)]=true;}
        for(int i=(int)((m/3)*3);i<=(int)((m/3)*3+2);i++)
        { 
            for(int j=(int)((n/3)*3);j<=(int)((n/3)*3+2);j++)
        { info[i][j][(val-1)]=true;}}
        ++a[m][9];++a[9][n];++a[9][9];
    }
}