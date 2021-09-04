package com.Practise;

public class SapiensInterview {
    /**
     *

     readsFile(int n){
     ExecutorSrvice sr= new ThreadPol(3);


     ReadThread thread;
     for(int i=0;i<n;i++){
     thread = new ReadThread(i+" test.csv");
     thread.start();
     }

     }


     class ReadThread extends Thread{
     String fileName;

     ReadThread(String fileName){
     this.fileName=fileName;
     }

     @Override
     public void run(){
     File file= new File("C://Donwloads/"+fileName);
     byte []buff= new byte[256];
     InputStream str= new InputStream(file);

     while(str.read()!=-1){
     buff
     }
     }
     }

     l1->table1->1mln records
     ->l2 (oracledatabase)->

     Client cleint2=Class.forName("com.jdbc.oracle.")
     connection conn2 =cleint.getConection("tables");



     Client cleint=Class.forName("com.jdbc.sqlserver.")
     connection conn =cleint.getConection("tables");

     ResutlSet res=conn.exceuteQuery("selecte * from table1");

     while(res.getRows!=0){
     conn2.executeQuery("insert into tables values"+res[0], res[1], res[2]);

     }

     List<String> lstRecords;

     lstRecords.stream().filter(sr->sr.chartAt(0)=='R').Collect(Collector.toList());

     Map<String,String> map;

     Conduct a cricket tournment -- 5 teams, 10 Member team , each member has JerseyNo and name

     -- create teams, add team members and print out the team members

     TeamA, <Ronaldo,CR7">
     Map<String,List<Map<String,String>>> teams;
     List<Map<String,String>> memberList;
     <Map<String,String>> member;
     String arr[] = new String{"TeamA",TeamB,TeamC,TeamD,TeamE};
     for(String s: arr){

     for(int i=1;i<=10;i++){
     member= new HashMap<String,Stirng>
     member.put("A"+i,i);
     memberList.add(member);
     }
     teams.put(s,memberList);
     }
     I/P
     Transaction_details
     |-----------|-----------|-------|
     | Seller | Buyer | Value |
     |-----------|-----------|-------|
     | IN | UK | 10 |
     | US | UK | 10 |
     | UK | IN | 20 |
     | IN | US | 30 |
     | US | UK | 40 |
     | US | IN | 50 |
     | UK | US | 10 |
     | IN | US | 10 |
     | IN | UK | 20 |
     | UK | In | 30 |

     o/p

     |-----------|-------------|--------------|
     | Country |Total_export |Total_import |
     |-----------|-------------|--------------|
     | IN | 70 | 100 |
     | US | 100 | 50 |
     | UK | 60 | 80 |
     |-----------|-------------|--------------|


     Select td.seller, SUM(td.Value) AS totalExport, SUM(td1.Value) AS totalImport
     Transaction_details td ,td1 where td ,td1 GROUP BY COuntry

     *
     */

}
